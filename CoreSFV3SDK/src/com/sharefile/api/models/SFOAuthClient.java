
// ------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//  
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
//     
//	   Copyright (c) 2014 Citrix ShareFile. All rights reserved.
// </auto-generated>
// ------------------------------------------------------------------------------

package com.sharefile.api.models;

import java.io.InputStream;
import java.util.ArrayList;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;
import com.sharefile.api.enumerations.SFSafeEnum;
import com.sharefile.api.models.*;

public class SFOAuthClient extends SFODataObject {

	@SerializedName("ClientSecret")
	private String ClientSecret;
	@SerializedName("AccountID")
	private String AccountID;
	@SerializedName("Image")
	private String Image;
	@SerializedName("ImageSmall")
	private String ImageSmall;
	@SerializedName("State")
	private SFSafeEnum<SFOAuthState> State;
	@SerializedName("Name")
	private String Name;
	@SerializedName("CompanyName")
	private String CompanyName;
	@SerializedName("ToolUrl")
	private String ToolUrl;
	@SerializedName("CreationDate")
	private Date CreationDate;
	@SerializedName("LastModifiedDate")
	private Date LastModifiedDate;
	@SerializedName("ServerFlow")
	private Boolean ServerFlow;
	@SerializedName("ClientFlow")
	private Boolean ClientFlow;
	@SerializedName("UsernamePasswordFlow")
	private Boolean UsernamePasswordFlow;
	@SerializedName("SamlFlow")
	private Boolean SamlFlow;
	@SerializedName("IsQA")
	private Boolean IsQA;
	@SerializedName("Impersonation")
	private Boolean Impersonation;
	@SerializedName("DeviceRegistration")
	private Boolean DeviceRegistration;
	@SerializedName("AccessFilesFolders")
	private SFSafeEnum<SFOAuthClientPermissions> AccessFilesFolders;
	@SerializedName("ModifyFilesFolders")
	private SFSafeEnum<SFOAuthClientPermissions> ModifyFilesFolders;
	@SerializedName("AdminUsers")
	private SFSafeEnum<SFOAuthClientPermissions> AdminUsers;
	@SerializedName("AdminAccounts")
	private SFSafeEnum<SFOAuthClientPermissions> AdminAccounts;
	@SerializedName("ChangeMySettings")
	private SFSafeEnum<SFOAuthClientPermissions> ChangeMySettings;
	@SerializedName("WebAppLogin")
	private SFSafeEnum<SFOAuthClientPermissions> WebAppLogin;
	@SerializedName("AppCode")
	private SFSafeEnum<SFAppCodes> AppCode;
	@SerializedName("RedirectUrls")
	private ArrayList<String> RedirectUrls;

	public String getClientSecret() {
		return ClientSecret;
	}

	public void setClientSecret(String clientsecret) {
		ClientSecret = clientsecret;
	}
	public String getAccountID() {
		return AccountID;
	}

	public void setAccountID(String accountid) {
		AccountID = accountid;
	}
	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}
	public String getImageSmall() {
		return ImageSmall;
	}

	public void setImageSmall(String imagesmall) {
		ImageSmall = imagesmall;
	}
	public SFSafeEnum<SFOAuthState> getState() {
		return State;
	}

	public void setState(SFSafeEnum<SFOAuthState> state) {
		State = state;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyname) {
		CompanyName = companyname;
	}
	public String getToolUrl() {
		return ToolUrl;
	}

	public void setToolUrl(String toolurl) {
		ToolUrl = toolurl;
	}
	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationdate) {
		CreationDate = creationdate;
	}
	public Date getLastModifiedDate() {
		return LastModifiedDate;
	}

	public void setLastModifiedDate(Date lastmodifieddate) {
		LastModifiedDate = lastmodifieddate;
	}
	public Boolean getServerFlow() {
		return ServerFlow;
	}

	public void setServerFlow(Boolean serverflow) {
		ServerFlow = serverflow;
	}
	public Boolean getClientFlow() {
		return ClientFlow;
	}

	public void setClientFlow(Boolean clientflow) {
		ClientFlow = clientflow;
	}
	public Boolean getUsernamePasswordFlow() {
		return UsernamePasswordFlow;
	}

	public void setUsernamePasswordFlow(Boolean usernamepasswordflow) {
		UsernamePasswordFlow = usernamepasswordflow;
	}
	public Boolean getSamlFlow() {
		return SamlFlow;
	}

	public void setSamlFlow(Boolean samlflow) {
		SamlFlow = samlflow;
	}
	public Boolean getIsQA() {
		return IsQA;
	}

	public void setIsQA(Boolean isqa) {
		IsQA = isqa;
	}
	public Boolean getImpersonation() {
		return Impersonation;
	}

	public void setImpersonation(Boolean impersonation) {
		Impersonation = impersonation;
	}
	public Boolean getDeviceRegistration() {
		return DeviceRegistration;
	}

	public void setDeviceRegistration(Boolean deviceregistration) {
		DeviceRegistration = deviceregistration;
	}
	public SFSafeEnum<SFOAuthClientPermissions> getAccessFilesFolders() {
		return AccessFilesFolders;
	}

	public void setAccessFilesFolders(SFSafeEnum<SFOAuthClientPermissions> accessfilesfolders) {
		AccessFilesFolders = accessfilesfolders;
	}
	public SFSafeEnum<SFOAuthClientPermissions> getModifyFilesFolders() {
		return ModifyFilesFolders;
	}

	public void setModifyFilesFolders(SFSafeEnum<SFOAuthClientPermissions> modifyfilesfolders) {
		ModifyFilesFolders = modifyfilesfolders;
	}
	public SFSafeEnum<SFOAuthClientPermissions> getAdminUsers() {
		return AdminUsers;
	}

	public void setAdminUsers(SFSafeEnum<SFOAuthClientPermissions> adminusers) {
		AdminUsers = adminusers;
	}
	public SFSafeEnum<SFOAuthClientPermissions> getAdminAccounts() {
		return AdminAccounts;
	}

	public void setAdminAccounts(SFSafeEnum<SFOAuthClientPermissions> adminaccounts) {
		AdminAccounts = adminaccounts;
	}
	public SFSafeEnum<SFOAuthClientPermissions> getChangeMySettings() {
		return ChangeMySettings;
	}

	public void setChangeMySettings(SFSafeEnum<SFOAuthClientPermissions> changemysettings) {
		ChangeMySettings = changemysettings;
	}
	public SFSafeEnum<SFOAuthClientPermissions> getWebAppLogin() {
		return WebAppLogin;
	}

	public void setWebAppLogin(SFSafeEnum<SFOAuthClientPermissions> webapplogin) {
		WebAppLogin = webapplogin;
	}
	public SFSafeEnum<SFAppCodes> getAppCode() {
		return AppCode;
	}

	public void setAppCode(SFSafeEnum<SFAppCodes> appcode) {
		AppCode = appcode;
	}
	public ArrayList<String> getRedirectUrls() {
		return RedirectUrls;
	}

	public void setRedirectUrls(ArrayList<String> redirecturls) {
		RedirectUrls = redirecturls;
	}

}