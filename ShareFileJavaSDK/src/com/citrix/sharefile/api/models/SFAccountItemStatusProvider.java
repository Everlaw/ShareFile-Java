
// ------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//  
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
//     
//	   Copyright (c) 2017 Citrix ShareFile. All rights reserved.
// </auto-generated>
// ------------------------------------------------------------------------------

package com.citrix.sharefile.api.models;

import java.io.InputStream;
import java.util.ArrayList;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;
import com.citrix.sharefile.api.*;
import com.citrix.sharefile.api.enumerations.*;
import com.citrix.sharefile.api.models.*;

public class SFAccountItemStatusProvider extends SFODataObject {

	@SerializedName("Active")
	private Boolean Active;

		/**
		* True if the current ShareFile account is enabled to use the specific
		*/
	public Boolean getActive() {
		return this.Active;
	}

		/**
		* True if the current ShareFile account is enabled to use the specific
		*/
	public void setActive(Boolean active) {
		this.Active = active;
	}

}