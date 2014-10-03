
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

package com.sharefile.api.entities.internal;

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

public class SFBillingEntityInternal extends SFODataEntityBase
{
    /**
	* Get Billing
	* @return Billing
    */
	public ISFQuery<SFBilling> get()
	{
		SFApiQuery<SFBilling> sfApiQuery = new SFApiQuery<SFBilling>();
		sfApiQuery.setFrom("Billing");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

}

