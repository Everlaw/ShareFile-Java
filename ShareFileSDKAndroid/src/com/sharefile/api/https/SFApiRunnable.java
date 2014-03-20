package com.sharefile.api.https;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sharefile.api.SFApiQuery;
import com.sharefile.api.V3Error;
import com.sharefile.api.android.utils.SFLog;
import com.sharefile.api.authentication.SFOAuth2Token;
import com.sharefile.api.constants.SFKeywords;
import com.sharefile.api.constants.SFSDK;
import com.sharefile.api.enumerations.SFHttpMethod;
import com.sharefile.api.enumerations.SFProvider;
import com.sharefile.api.exceptions.SFInvalidStateException;
import com.sharefile.api.gson.auto.SFDefaultGsonParser;
import com.sharefile.api.interfaces.SFApiResponseListener;
import com.sharefile.api.models.SFODataObject;

public class SFApiRunnable<T extends SFODataObject> implements Runnable 
{
	private static final String TAG = "-SFApiThread";
	
	private final Class<T> mInnerType ;	
	private final SFApiQuery<T> mQuery; 
	private final SFApiResponseListener<T> mResponseListener;
	private final SFOAuth2Token mOauthToken;
	
	private int mHttpErrorCode = 0;
	private V3Error mV3Error = null;
	private String mResponseString = null;
		
	public SFApiRunnable(Class<T> innerType, SFApiQuery<T> query, SFApiResponseListener<T> responseListener,SFOAuth2Token token) throws SFInvalidStateException
	{	
		mInnerType = innerType;
		mQuery = query;
		mResponseListener = responseListener;
		mOauthToken = token;		
	}
	
	@Override
	public void run() 
	{
		executeQuery();
	}
	
	private void handleHttPost(URLConnection conn) throws IOException
	{
		if(mQuery.getHttpMethod().equalsIgnoreCase(SFHttpMethod.POST.toString()))
		{
			String body = mQuery.getBody(); 
			
			if(body!=null)
			{
				conn.setRequestProperty(SFKeywords.CONTENT_LENGTH, ""+body.getBytes().length);
				conn.setRequestProperty(SFKeywords.CONTENT_TYPE, "application/json");
				
				SFHttpsCaller.postBody(conn, body);				
			}
		}
	}
	
	private void addAuthenticationHeader(URLConnection connection)
	{
		String path = connection.getURL().getPath();
		
		switch(SFProvider.getProviderTypeFromString(path))
		{
			case PROVIDER_TYPE_SF:
				SFHttpsCaller.addBearerAuthorizationHeader(connection, mOauthToken);
			break;
			
			default:
				SFHttpsCaller.setBasicAuth(connection, "sfonprem\\nilesh.pawar", "****");
			break;	
		}
		
	}
	
	public void executeQuery() 
	{								
		String server = mOauthToken.getApiServer();		
		String urlstr = mQuery.buildQueryUrlString(server);
				
		try
		{
			URL url = new URL(urlstr);
			URLConnection connection = SFHttpsCaller.getURLConnection(url);		
			SFHttpsCaller.setMethod(connection, mQuery.getHttpMethod());
			SFHttpsCaller.setAcceptLanguage(connection);
			//TODO: This needs a major revamp. We need User specific cookies to be set and CIFS/SharePoint specific authentication to be handled
			//We need a separate auth manager here to handle the setting of correct auth header based on the provider type and well as the user.
			addAuthenticationHeader(connection);
			
			handleHttPost(connection);
			
			SFLog.d2(TAG, mQuery.getHttpMethod() + " " + urlstr);
			
			connection.connect();
			
			mHttpErrorCode = SFHttpsCaller.safeGetResponseCode(connection);
			
			//Use the bearer token currently. ignore the cookies untill we have a good cookie mgr. might impact sharepoint testing without cookies. 
			//v3Error = SFHttpsCaller.handleErrorAndCookies(connection, httpErrorCode, url);
		    
			if(mHttpErrorCode == HttpsURLConnection.HTTP_OK)
			{											
				mResponseString = SFHttpsCaller.readResponse(connection);								
			}
			else if(mHttpErrorCode == HttpsURLConnection.HTTP_NO_CONTENT)
			{
				//no content. might be valid. let the listeners handle this.
			}
			else
			{
				mResponseString = SFHttpsCaller.readErrorResponse(connection);
			}
				    
			SFHttpsCaller.disconnect(connection);
		}
		catch(Exception ex)
		{
			//Copy the original httpErrorCode from server and the stack trace of exception
			mResponseString = "OrignalHttpCode = " + mHttpErrorCode + "\nExceptionStack = " +Log.getStackTraceString(ex);
			
			//set the mHttpErrorCode to internal error so that we call the error-response callbacks of the caller
			//this is needed since its possible that the server returned 200 but there was problem in reading the response/error stream
			mHttpErrorCode = SFSDK.INTERNAL_HTTP_ERROR;
						
			SFLog.d2(TAG, "%s",mResponseString);
		}		
		
		processResponse();				
	}		 
		
	/**
	 * 	the mHttpErrorCode and mResponseString are expected to be filled appropriately by this stage.
	 */
	private void processResponse()
	{
		switch(mHttpErrorCode)
		{
			case HttpsURLConnection.HTTP_OK:				
				callSuccessResponseHandler();
			break;	
			
			case HttpsURLConnection.HTTP_NO_CONTENT:
				callEmptyResponseHandler();
			break;
			
			default:
				callFailureResponseHandler();
			break;				
		}
	}
	
	@SuppressWarnings("unchecked")
	private void callSuccessResponseHandler()
	{
		if(mResponseListener!=null)
		{						
			//T object = createInstanceForSuccessResponse();			
			try 
			{
				JsonParser jsonParser = new JsonParser();
				JsonElement jsonElement =jsonParser.parse(mResponseString);
				SFODataObject object = SFDefaultGsonParser.parse(mInnerType, jsonElement);
				mResponseListener.sfapiSuccess((T) object);
			} 
			catch (Exception e) 
			{					
				e.printStackTrace();
			}			
		}
	}
	
	private void callFailureResponseHandler()
	{
		if(mResponseListener!=null)
		{												
			try 
			{
				JsonParser jsonParser = new JsonParser();
				JsonElement jsonElement =jsonParser.parse(mResponseString);
				
				mV3Error = SFDefaultGsonParser.parse(jsonElement);
				mV3Error.httpResponseCode = mHttpErrorCode;
				
				mResponseListener.sfApiError(mV3Error, mQuery);
			} 
			catch (Exception e)  
			{					
				e.printStackTrace();
				// some error happened during parsing of the error response. 
				//lets pass-on the original http-error code and response string from the server or the error that happened during err-response  reading.				
				mV3Error = new V3Error(mHttpErrorCode,mResponseString);
				mResponseListener.sfApiError(mV3Error, mQuery);
			}			
		}
	}
	
	private void callEmptyResponseHandler()
	{
		if(mResponseListener!=null)
		{
			mResponseListener.sfapiSuccess(null);
		}		
	}
	
	public Thread startNewThread()
	{
		Thread sfApithread = new Thread(this);		
		sfApithread.start();
		return sfApithread;
	}		
	
	public T createInstanceForSuccessResponse()
	{		
		T object =	null;
		
		try 
		{
			object = mInnerType.newInstance();	
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		} 		
						
		return object;
	}
}