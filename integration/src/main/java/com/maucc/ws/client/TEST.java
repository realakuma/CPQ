package com.maucc.ws.client;

import java.util.HashMap;

import com.bigmachines.soap.*;
import com.maucc.xml.transcations.CreateTransactionResponse;


public class TEST {
	
	   public static void main(String[] args) throws Exception 
	   {
		   SecurityServicePortTypeProxy sspt =new SecurityServicePortTypeProxy();
	    	 Login login=new Login();
	    	 LoginRequestUserInfoType userinfo =new LoginRequestUserInfoType();
			 LoginResponse logrp;
			 LogoutResponse logoutrp;
			 GetUserInfoResponse getUserInfo;
			 userinfo.setUsername("Shawn.jiao");
			 userinfo.setPassword("Sxj@1234");
			 
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
					 "https://shanghaimanchi.bigmachines.com/v1_0/receiver",
					 logrp.getUserInfo().getSessionId(),
					 "https://shanghaimanchi.bigmachines.com/bmfsweb/shanghaimanchi/schema/v1_0/commerce/oraclecpqo.xsd",
					 "oraclecpqo","transaction");
	    	 CreateTransactionResponse ctrp=httpsoapcalltran.createTranscation();
	    	 CreateTransactionResponse.Transaction.DataXml dataxml=ctrp.getTransaction().getDataXml();
	    	 System.out.println(String.valueOf(ctrp.getTransaction().getId()));
	    	 System.out.println(ctrp.getTransaction().getProcessVarName());
	    	 System.out.println(ctrp.getTransaction().getDataXml().getQuoteProcess().getTransactionIDT());
	    	 //System.out.println(ctrp.getTransaction().getDataXml().getQuoteProcess().getCurrencyPref());
	    	 
	    	 
			 httpsoapcalltran.updateTranscation(String.valueOf(ctrp.getTransaction().getId()), ctrp.getTransaction().getProcessVarName(), ctrp.getTransaction().getSupplierCompanyName(),ctrp.getTransaction().getCurrencyPref(),ctrp.getTransaction().getBuyerUserName());
			 
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
