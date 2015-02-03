
// ------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//  
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
//     
//	   Copyright (c) 2015 Citrix ShareFile. All rights reserved.
// </auto-generated>
// ------------------------------------------------------------------------------

package com.sharefile.api.entities;

import com.sharefile.api.entities.*;
import com.sharefile.api.models.*;
import com.sharefile.api.models.internal.*;
import com.sharefile.api.SFApiQuery;
import com.sharefile.api.interfaces.ISFQuery;


import java.io.InputStream;
import java.util.ArrayList;
import java.net.URI;
import java.util.Date;
 
import com.google.gson.annotations.SerializedName;
import com.sharefile.api.enumerations.SFSafeEnum;
import com.sharefile.api.enumerations.SFSafeEnumFlags;

public class SFAccountsEntity extends SFODataEntityBase
{
    /**
	* Get current Account
	* Retrieves information about the Account defined in the call subdomain
	* @return The subdomain account information
    */
	public ISFQuery<SFAccount> get()
	{
		SFApiQuery<SFAccount> sfApiQuery = new SFApiQuery<SFAccount>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get current Account branding
	* Retrievs Branding information about the subdomain account.
	* This operation does not require authentication.
	* @return Branding information for a given sharefile account
    */
	public ISFQuery<SFAccount> getBranding()
	{
		SFApiQuery<SFAccount> sfApiQuery = new SFApiQuery<SFAccount>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("Branding");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Modify the Branding for this account
	* Modifies Branding information about the subdomain account.
	* This operation requires authentication.
	* @return Branding information for a given sharefile account
    */
	public ISFQuery<SFAccount> updateBranding(SFAccount account)
	{
		SFApiQuery<SFAccount> sfApiQuery = new SFApiQuery<SFAccount>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("Branding");
		sfApiQuery.setBody(account);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

    /**
	* Get List of current Account Employees
	* Retrives the list of Employees in the Account
	* Employees are named users in the Account.
	* @return A Feed containing all Employees Contacts in the account
    */
	public ISFQuery<SFODataFeed<SFContact>> getEmployees()
	{
		SFApiQuery<SFODataFeed<SFContact>> sfApiQuery = new SFApiQuery<SFODataFeed<SFContact>>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("Employees");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get List of current Account Clients
	* Retrieves the list of Clients in the Account.
	* Clients are restricted users of an Account, that can receive and send files
	* to Employees, but have no other permissions besides basic sharing with Employees.
	* @return A Feed containing all Clients in the account
    */
	public ISFQuery<SFODataFeed<SFContact>> getClients()
	{
		SFApiQuery<SFODataFeed<SFContact>> sfApiQuery = new SFApiQuery<SFODataFeed<SFContact>>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("Clients");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Account AddressBooks
	* Retrieves an address book from the account.
	* Address Books are the contacts of Eployees and Clients, maintained on a personal or
	* account-wide basis (shared).
	* @param type 	
	* @param searchTerm 	
	* @return A Feed of Contact objects representing the Address Book retrieved
    */
	public ISFQuery<SFODataFeed<SFContact>> getAddressBook(String type, String searchTerm)
	{
		SFApiQuery<SFODataFeed<SFContact>> sfApiQuery = new SFApiQuery<SFODataFeed<SFContact>>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("AddressBook");
		sfApiQuery.addQueryString("type", type);
		sfApiQuery.addQueryString("searchTerm", searchTerm);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Account Mobile Security Settings
	* Returns the Mobile device configuration settings for this account
	* @return The current mobile security configuration for this account
    */
	public ISFQuery<SFMobileSecuritySettings> getMobileSecuritySettings()
	{
		SFApiQuery<SFMobileSecuritySettings> sfApiQuery = new SFApiQuery<SFMobileSecuritySettings>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("MobileSecuritySettings");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Account Product Defaults
	* @return Account defaults
    */
	public ISFQuery<SFProductDefaults> getProductDefaults()
	{
		SFApiQuery<SFProductDefaults> sfApiQuery = new SFApiQuery<SFProductDefaults>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("ProductDefaults");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Account Preferences
	* @return Account preferences
    */
	public ISFQuery<SFAccountPreferences> getPreferences()
	{
		SFApiQuery<SFAccountPreferences> sfApiQuery = new SFApiQuery<SFAccountPreferences>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("Preferences");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Account Single Sign-On Configuration
	* Retrieve the Single Sign-on configuration for the Account
	* @param provider 	
    */
	public ISFQuery<SFSSOAccountProvider> getSSO(String provider)
	{
		SFApiQuery<SFSSOAccountProvider> sfApiQuery = new SFApiQuery<SFSSOAccountProvider>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("SSO");
		sfApiQuery.addQueryString("provider", provider);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Update Account Single Sign-On Configuration
    * {
    * "LogoutUrl":"",
    * "LoginUrl":"https://idp.com/signin",
    * "IPRestrictions":"+all",
    * "ForceSSO":true,
    * "EntityID":"http://account.sf-api.com/saml/info",
    * "SFEntityID":"http://idp.com/saml/info",
    * "SPInitatedAuthContext":"exact",
    * "SPInitatedAuthMethod":"urn:oasis:names:tc:SAML:2.0:ac:classes:PasswordProtectedTransport"
    * }
	* Modifies the Single Sign-on Configuration for this account.
	* @param sso 	
	* @param provider 	
    */
	public ISFQuery<SFSSOAccountProvider> updateSSO(SFSSOAccountProvider sso, String provider)
	{
		SFApiQuery<SFSSOAccountProvider> sfApiQuery = new SFApiQuery<SFSSOAccountProvider>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("SSO");
		sfApiQuery.addQueryString("provider", provider);
		sfApiQuery.setBody(sso);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

    /**
	* Get List of Accounts for User
    * {
    * "password":"password"
    * }
	* Retrieve the list of Accounts associated with a given user
	* All parameters to this call may be passed in the Post body as root JSON parameters, or in the URI -
	* with the exception of password that must be provided in the POST body.
	* This operation does not require authentication
	* @param username 	
	* @param password 	
	* @param employeesonly 	
	* @param requirehomefolders 	
	* @param singleplane 	
	* @return The list of Accounts associated with this username/password.
    */
	public ISFQuery<SFODataFeed<SFAccount>> getByUser(SFODataObject parameters, String username, Boolean employeesonly, Boolean requirehomefolders, Boolean singleplane)
	{
		SFApiQuery<SFODataFeed<SFAccount>> sfApiQuery = new SFApiQuery<SFODataFeed<SFAccount>>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("GetByUser");
		parameters.addProperty("username", username);
		parameters.addProperty("employeesonly", employeesonly);
		parameters.addProperty("requirehomefolders", requirehomefolders);
		parameters.addProperty("singleplane", singleplane);
		sfApiQuery.setBody(parameters);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Email List of Accounts to User
	* Sends the list of accounts to the specified email address
	* This operation does not require authentication
	* @param email 	
    */
	public ISFQuery sendToEmail(String email)
	{
		SFApiQuery sfApiQuery = new SFApiQuery();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("SendToEmail");
		sfApiQuery.addQueryString("email", email);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Get the Login Access Control List of domains
	* Retrieve the list of domains that are allowed or disallowed to login.
	* Whether the list is an allow or disallow list
	* is configured by the AccessControlType property. The domain names are checked against the domains of all the
	* email addresses of the user that attempts to log in to the Account.
	* @return The Login Access Control List of domains for the Account.
    */
	public ISFQuery<SFAccessControlDomains> getLoginAccessControlDomains()
	{
		SFApiQuery<SFAccessControlDomains> sfApiQuery = new SFApiQuery<SFAccessControlDomains>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("LoginAccessControlDomains");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get the Folder Access Control List of domains
	* Retrieve the list of domains that are allowed or disallowed to have access to folders. Whether the list is an allow or disallow list
	* is configured by the AccessControlType property.
	* 
	* The list blocks user access to folders by preventing adding a user to distribution groups or folders.
	* The domain names are checked against the domains of all the email addresses of the user.
	* This is an account-wide setting.
	* @return The Folder Access Control List of domains for the Account, e.g.  { "AccessControlType" : "AllowedDomains", "Domains": ["domainA", "domainB", ...] }
    */
	public ISFQuery<SFAccessControlDomains> getFolderAccessControlDomains()
	{
		SFApiQuery<SFAccessControlDomains> sfApiQuery = new SFApiQuery<SFAccessControlDomains>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("FolderAccessControlDomains");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Create or replace the Login Access Control List of domains
    * {
    * "AccessControlType" : "AllowedDomains",
    * "Domains": ["domainA", "domainB", ...]
    * }
	* @param AccessControlType 	
	* @param Domains 	
	* @return The new Login Access Control List of domains for the Account
    */
	public ISFQuery<SFAccessControlDomains> createLoginAccessControlDomains(SFAccessControlDomains accessControlDomains)
	{
		SFApiQuery<SFAccessControlDomains> sfApiQuery = new SFApiQuery<SFAccessControlDomains>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("LoginAccessControlDomains");
		sfApiQuery.setBody(accessControlDomains);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Create or replace the Folder Access Control List of domains
    * {
    * "AccessControlType" : "AllowedDomains",
    * "Domains": ["domainA", "domainB", ...]
    * }
	* @param AccessControlType 	
	* @param Domains 	
	* @return The new Folder Access Control List of domains for the Account
    */
	public ISFQuery<SFAccessControlDomains> createFolderAccessControlDomains(SFAccessControlDomains accessControlDomains)
	{
		SFApiQuery<SFAccessControlDomains> sfApiQuery = new SFApiQuery<SFAccessControlDomains>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("FolderAccessControlDomains");
		sfApiQuery.setBody(accessControlDomains);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Update the Login Access Control List of domains
    * {
    * "AccessControlType" : "AllowedDomains",
    * "Domains": ["domainA", "domainB", ...]
    * }
	* Merges the specified domains with existing domains in the list, and/or updates the AccessControlType. One of the parameters needs to be specified.
	* @param AccessControlType 	
	* @param Domains 	
	* @return The updated Login Access Control List of domains for the Account
    */
	public ISFQuery<SFAccessControlDomains> updateLoginAccessControlDomains(SFAccessControlDomains accessControlDomains)
	{
		SFApiQuery<SFAccessControlDomains> sfApiQuery = new SFApiQuery<SFAccessControlDomains>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("LoginAccessControlDomains");
		sfApiQuery.setBody(accessControlDomains);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

    /**
	* Update the Folder Access Control List of domains
    * {
    * "AccessControlType" : "AllowedDomains",
    * "Domains": ["domainA", "domainB", ...]
    * }
	* Merges the specified domains with existing domains in the list, and/or updates the AccessControlType. One of the parameters needs to be specified. It
	* allows to add new domains to the list.
	* @param AccessControlType 	
	* @param Domains 	
	* @return The updated Folder Access Control List of domains for the Account
    */
	public ISFQuery<SFAccessControlDomains> updateFolderAccessControlDomains(SFAccessControlDomains accessControlDomains)
	{
		SFApiQuery<SFAccessControlDomains> sfApiQuery = new SFApiQuery<SFAccessControlDomains>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("FolderAccessControlDomains");
		sfApiQuery.setBody(accessControlDomains);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

    /**
	* Delete domains from the Logins Access Control List of domains
    * {
    * "AccessControlType" : "AllowedDomains",
    * "Domains": ["domainA", "domainB", ...]
    * }
	* Deletes the specified domains from the list.
	* @param AccessControlType 	
	* @param Domains 	
	* @return No content
    */
	public ISFQuery deleteLoginAccessControlDomains(SFAccessControlDomains accessControlDomains)
	{
		SFApiQuery sfApiQuery = new SFApiQuery();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("LoginAccessControlDomains");
		sfApiQuery.setBody(accessControlDomains);
		sfApiQuery.setHttpMethod("DELETE");
		return sfApiQuery;
	}

    /**
	* Delete domains from the Folder Access Control List of domains
    * {
    * "AccessControlType" : "AllowedDomains",
    * "Domains": ["domainA", "domainB", ...]
    * }
	* Deletes the specified domains from the list.
	* @param AccessControlType 	
	* @param Domains 	
	* @return No content
    */
	public ISFQuery deleteFolderAccessControlDomains(SFAccessControlDomains accessControlDomains)
	{
		SFApiQuery sfApiQuery = new SFApiQuery();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("FolderAccessControlDomains");
		sfApiQuery.setBody(accessControlDomains);
		sfApiQuery.setHttpMethod("DELETE");
		return sfApiQuery;
	}

    /**
	* Check if WebPop is required
	* @param subdomain 	
	* @param username 	
	* @param singlePlane 	
	* @return RequireWebPopResult
    */
	public ISFQuery<SFRequireWebPopResult> requireWebPop(String subdomain, String username, Boolean singlePlane)
	{
		SFApiQuery<SFRequireWebPopResult> sfApiQuery = new SFApiQuery<SFRequireWebPopResult>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("RequireWebPop");
		sfApiQuery.addQueryString("subdomain", subdomain);
		sfApiQuery.addQueryString("username", username);
		sfApiQuery.addQueryString("singlePlane", singlePlane);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Check if subdomain is required
	* @param username 	
	* @param singlePlane 	
	* @return RequireSubdomainResult
    */
	public ISFQuery<SFRequireSubdomainResult> requireSubdomain(String username, Boolean singlePlane)
	{
		SFApiQuery<SFRequireSubdomainResult> sfApiQuery = new SFApiQuery<SFRequireSubdomainResult>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("RequireSubdomain");
		sfApiQuery.addQueryString("username", username);
		sfApiQuery.addQueryString("singlePlane", singlePlane);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Find Subdomain
    * {
    * "UsernameShort":"usernameShort",
    * "Password":"pass",
    * "EmployeeOnly":false
    * }
	* Find the user account information based on the short username
	* @param findSubdomainParams 	
	* @param singlePlane 	
	* @return FindSubdomainResult
    */
	public ISFQuery<SFFindSubdomainResult> findSubdomain(SFFindSubdomainParams findSubdomainParams, Boolean singlePlane)
	{
		SFApiQuery<SFFindSubdomainResult> sfApiQuery = new SFApiQuery<SFFindSubdomainResult>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("FindSubdomain");
		sfApiQuery.addQueryString("singlePlane", singlePlane);
		sfApiQuery.setBody(findSubdomainParams);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Get Outlook Information
	* @return OutlookInformation
    */
	public ISFQuery<SFOutlookInformation> getOutlookInformation()
	{
		SFApiQuery<SFOutlookInformation> sfApiQuery = new SFApiQuery<SFOutlookInformation>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("OutlookInformation");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get SSO Info
	* @param subdomain 	
	* @return SSOInfo
    */
	public ISFQuery<SFSSOInfo> getSSOInfo(String subdomain)
	{
		SFApiQuery<SFSSOInfo> sfApiQuery = new SFApiQuery<SFSSOInfo>();
		sfApiQuery.setFrom("Accounts");
		sfApiQuery.setAction("SSOInfo");
		sfApiQuery.addQueryString("subdomain", subdomain);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

}

