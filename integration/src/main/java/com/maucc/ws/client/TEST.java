package com.maucc.ws.client;

import java.util.HashMap;

import com.bigmachines.soap.*;


public class TEST {
	
	   public static void main(String[] args) throws Exception 
	   {
		   SecurityServicePortTypeProxy sspt =new SecurityServicePortTypeProxy();
	    	 Login login=new Login();
	    	 LoginRequestUserInfoType userinfo =new LoginRequestUserInfoType();
			 LoginResponse logrp;
			 LogoutResponse logoutrp;
			 GetUserInfoResponse getUserInfo;
			 userinfo.setUsername("admin");
			 userinfo.setPassword("o8d3aynD");
			 
			 try
			 {
			 login.setUserInfo(userinfo);
			 logrp=sspt.login(login);
			 System.out.println(logrp.getUserInfo().getSessionId());
			 //get userinfo by sessionId;
			 getUserInfo=sspt.getUserInfo(logrp.getUserInfo().getSessionId());
			 System.out.println(getUserInfo.getUserInfo().getLogin());
	 
			 HashMap  [] patameterMap=new HashMap[1]; 
	    	 patameterMap[0]=new HashMap();
	         patameterMap[0].put("customer_id", "7799");
	         patameterMap[0].put("customer_name", "cpuabc");
	         patameterMap[0].put("customer_address", "fmale");
	         
	         
			 HttpSoapCallTranscation httpsoapcalltran= new HttpSoapCallTranscation("urn:soap.bigmachines.com",
					 "create",
					 "https://partnertrn-osc-022.bigmachines.com/v1_0/receiver",
					 logrp.getUserInfo().getSessionId(),
					 "https://partnertrn-osc-022.bigmachines.com/bmfsweb/partnertrn-osc-022/schema/v1_0/commerce/quickstart_commerce_process_bmClone_4.xsd"
					 );
			 
			 httpsoapcalltran.updateTranscation("9438954", "quickstart_commerce_process_bmClone_4", "partnertrn-osc-022", "USD");
			 
			 /*
	    	 HttpSoapCallDataTable dynamicHttpclientCall = new HttpSoapCallDataTable("urn:soap.bigmachines.com", 
	    			 "add",
	    			 "https://partnertrn-osc-022.bigmachines.com/v1_0/receiver",logrp.getUserInfo().getSessionId(),
	    			 "ZB_CUSTOMERS");
	    	 //dynamicHttpclientCall.add(patameterMap);
	    	 
	    	 dynamicHttpclientCall.deploy();
	    	 */
	    	 
	    	 
	    	
			 }
			 catch(Exception ex)
			 {
				 ex.printStackTrace();
			 }
			 
		   
	   }

}
