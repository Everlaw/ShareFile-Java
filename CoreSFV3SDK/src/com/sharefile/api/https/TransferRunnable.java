package com.sharefile.api.https;

import javax.net.ssl.HttpsURLConnection;

import com.sharefile.api.SFApiClient;
import com.sharefile.api.SFSDKDefaultAccessScope;
import com.sharefile.api.SFV3Error;
import com.sharefile.api.constants.SFSDK;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class TransferRunnable implements Runnable {

    protected AtomicBoolean cancelRequested = new AtomicBoolean(false);
    protected final SFApiClient mApiClient;
    protected final IProgress mProgressListener;
    protected final SFCookieManager mCookieManager;

    //credentials for connectors
    protected final String mUsername;
    protected final String mPassword;

    TransferRunnable(SFApiClient client,IProgress progressListener, SFCookieManager cookieManager,
                     String userName,String password)
    {
        mApiClient = client;
        mProgressListener = progressListener;
        mCookieManager = cookieManager;
        mUsername = userName;
        mPassword = password;
    }

	public interface IProgress {
		public void bytesTransfered(long byteCount);
	};
	
	/**
	 *   This object will get filled with an errorCoode and the V3Error or valid SFOBject after the response 
	 */
	public static class Result
	{
		private int mHttpErrorCode = 0; /* not sure why we need this...it probably always match the v3error.errorcode */
		private SFV3Error mV3Error = null;			
		private long bytesTransfered = 0;
		
		public void setFields(int errorCode, SFV3Error v3Error, long downloaded)
		{
			mHttpErrorCode = errorCode;
			mV3Error = v3Error;			
			bytesTransfered = downloaded;
		}

		public SFV3Error getError() {
			return mV3Error;
		}

		public long getBytesTransfered() {
			return bytesTransfered;
		}

		public boolean isSuccess() {
			return mHttpErrorCode==HttpsURLConnection.HTTP_OK;
		}

	};
	
	protected Result createCancelResult(long bytesTransfered) {
		Result ret = new Result();
		SFV3Error v3Error = new SFV3Error(SFSDK.HTTP_ERROR_CANCELED, "Canceled");
		ret.setFields(SFSDK.HTTP_ERROR_CANCELED, v3Error, bytesTransfered);
		return ret;
	}

    protected abstract Result runInThisThread();

    /**
     * execute Transfer in this thread overriding the cancel signal
     * @param cancel
     * @return
     */
    public Result runInThisThread(AtomicBoolean cancel)
    {
        cancelRequested = cancel;
        return runInThisThread();
    }

    @Override
    public void run()
    {
        runInThisThread();
    }


    public void cancel()
    {
        cancelRequested.set(true);
    }
}
