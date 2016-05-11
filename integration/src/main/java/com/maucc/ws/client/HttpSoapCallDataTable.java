package com.maucc.ws.client;

 import java.io.ByteArrayInputStream;
 import java.io.InputStream;
 import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.httpclient.HttpClient;
 import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
 import org.apache.commons.httpclient.methods.PostMethod;
 import org.apache.commons.httpclient.methods.RequestEntity;
 import com.bigmachines.soap.*;
 import com.maucc.util.*;
 
import com.maucc.xml.datatables.AddResponse;
 
 // 动态构造调用串，灵活性更大
 public class HttpSoapCallDataTable {
 
     private String namespace;
     private String methodName;
     private String wsdlLocation;
     private String soapResponseData;
     private String sessionID;
     private String tableName;
     private String xsdLocation;
 
     public HttpSoapCallDataTable(String namespace, String methodName, String wsdlLocation,String sessionID,String tableName,String xsdLocation) {
 
         this.namespace = namespace;
         this.methodName = methodName;
         this.wsdlLocation = wsdlLocation;
         this.sessionID=sessionID;
         this.tableName=tableName;
         this.xsdLocation=xsdLocation;
     }
 
     private int invoke(HashMap []  patameterMap) throws Exception {
         PostMethod postMethod = new PostMethod(wsdlLocation);
         String soapRequestData = buildRequestData(patameterMap);
 
         byte[] bytes = soapRequestData.getBytes("utf-8");
         InputStream inputStream = new ByteArrayInputStream(bytes, 0,
                 bytes.length);
         RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
                 bytes.length, "application/soap+xml; charset=utf-8");
         postMethod.setRequestEntity(requestEntity);
 
         HttpClient httpClient = new HttpClient();
         int statusCode = httpClient.executeMethod(postMethod);
         soapResponseData = postMethod.getResponseBodyAsString();
 
         return statusCode;
     }
 
     private String buildRequestData(HashMap [] patameterMap) {
         StringBuffer soapRequestData = new StringBuffer();
         soapRequestData.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
         soapRequestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">");
         soapRequestData.append("<soapenv:Header>");
         soapRequestData.append("<bm:userInfo xmlns:bm=\""+this.namespace+"\">");
         soapRequestData.append("<bm:sessionId>"+this.sessionID+"</bm:sessionId>");
         soapRequestData.append("</bm:userInfo>");
         soapRequestData.append("<bm:category xmlns:bm=\"urn:soap.bigmachines.com\">Data Tables</bm:category>");
        
         soapRequestData.append("<bm:xsdInfo xmlns:bm=\"urn:soap.bigmachines.com\">");
         soapRequestData.append("<bm:schemaLocation>"+this.xsdLocation+"</bm:schemaLocation></bm:xsdInfo>");
         soapRequestData.append("</soapenv:Header>");
         soapRequestData.append("<soapenv:Body>");
         soapRequestData.append("<bm:"+this.methodName+" xmlns:bm=\""+this.namespace+"\">");
         soapRequestData.append("<bm:DataTables bm:table_name=\""+this.tableName+"\">");
 
         if (patameterMap!=null){
        
	         for (HashMap patameter : patameterMap) {
	        	 soapRequestData.append("<bm:each_record>");
	        	 
	        	 Set set=patameter.entrySet();
	             Iterator it=set.iterator();
	             while(it.hasNext()){
	                 Map.Entry me=(Map.Entry)it.next();
	                 System.out.println(me.getKey()+":"+me.getValue());
	                 soapRequestData.append("<bm:"+me.getKey()+">"+me.getValue()+"</bm:"+me.getKey()+">");
	             }
	             
	             soapRequestData.append("</bm:each_record>");
	         }
         }
         soapRequestData.append("</bm:DataTables>");
         soapRequestData.append("</bm:"+this.methodName+">");
         soapRequestData.append("</soapenv:Body>");
         soapRequestData.append("</soapenv:Envelope>");
         return soapRequestData.toString();
     }
 
     /**
      * @param args
      * @throws Exception
      */
     public static void main(String[] args) throws Exception {
         // TODO Auto-generated method stub
    	
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
 
    	 HttpSoapCallDataTable dynamicHttpclientCall = new HttpSoapCallDataTable("urn:soap.bigmachines.com", 
    			 "add",
    			 "https://partnertrn-osc-022.bigmachines.com/v1_0/receiver",logrp.getUserInfo().getSessionId(),
    			 "ZB_CUSTOMERS",
    			 "");
 
    	 HashMap  [] patameterMap=new HashMap[1]; 
    	 patameterMap[0]=new HashMap();
         patameterMap[0].put("customer_id", "778");
         patameterMap[0].put("customer_name", "cpuabc");
         patameterMap[0].put("customer_address", "fmale");

 
         String soapRequestData = dynamicHttpclientCall.buildRequestData(patameterMap);
         System.out.println(soapRequestData);
 
         /*
         int statusCode = dynamicHttpclientCall.invoke(patameterMap);
        
         
         if(statusCode == 200) {
             System.out.println("调用成功！");
             XMLStreamReader xsr=Convert.GetSOAPResult(new ByteArrayInputStream(dynamicHttpclientCall.soapResponseData.getBytes()));
             JAXBContext jaxbContext = JAXBContext.newInstance("com.maucc.xml.datatables");  
             Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
             JAXBElement<AddResponse>  je = unmarshaller.unmarshal(xsr, AddResponse.class);
             AddResponse addresponse=je.getValue();
             System.out.println(addresponse.getStatus().getSuccess());
         }
         else {
             System.out.println("调用失败！错误码：" + dynamicHttpclientCall.soapResponseData);
         }
         
		 logoutrp=sspt.logout(logrp.getUserInfo().getSessionId());
		 System.out.println(logoutrp.getStatus().getMessage());
*/
     }
		 catch (Exception ex)
		 {
			 
		 }
		 finally
		 {
			 
			 
		 }
		 
		 }
     
     
     @SuppressWarnings("finally")
	public String add(HashMap [] record)
     {
    	 String result="";
    	 int statusCode=0;
    	 try
    	 {
    		 
    		 
    		 HttpSoapCallDataTable dynamicHttpclientCall = new HttpSoapCallDataTable(this.namespace, 
        			 "add",
        			 this.wsdlLocation,this.sessionID,
        			 this.tableName,
        			 this.xsdLocation);
    		 
    		 statusCode = dynamicHttpclientCall.invoke(record);
    		 
    		 if(statusCode == 200) {
    	             System.out.println("调用成功！");
    	             XMLStreamReader xsr=Convert.GetSOAPResult(new ByteArrayInputStream(dynamicHttpclientCall.soapResponseData.getBytes()));
    	             JAXBContext jaxbContext = JAXBContext.newInstance("com.maucc.xml.datatables");  
    	             Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    	             JAXBElement<AddResponse>  je = unmarshaller.unmarshal(xsr, AddResponse.class);
    	             AddResponse addresponse=je.getValue();
    	             System.out.println(addresponse.getStatus().getSuccess());
    	             result=addresponse.getStatus().getSuccess();
    	         }
    	         else {
    	             System.out.println("调用失败！错误码：" + dynamicHttpclientCall.soapResponseData);
    	         }
    	         
    		 
    		 
    	 }
    	 catch (Exception ex)
    	 {
    		 
    		 result=ex.getMessage();
    		  
    		 
    	 }
    	 
    	 finally
    	 {
    		 return result;
    	 }
    	 
     }
     
     
     @SuppressWarnings("finally")
	public String deploy()
     {
    	 String result="";
    	 int statusCode=0;
    	 try
    	 {

    		 
    		 HttpSoapCallDataTable dynamicHttpclientCall = new HttpSoapCallDataTable(this.namespace, 
        			 "deploy",
        			 this.wsdlLocation,this.sessionID,
        			 this.tableName,
        			 this.xsdLocation);
    		 statusCode = dynamicHttpclientCall.invoke(null);
    		 
    		 if(statusCode == 200) {
    	             System.out.println("调用成功！");
    	             XMLStreamReader xsr=Convert.GetSOAPResult(new ByteArrayInputStream(dynamicHttpclientCall.soapResponseData.getBytes()));
    	             JAXBContext jaxbContext = JAXBContext.newInstance("com.maucc.xml.datatables");  
    	             Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    	             JAXBElement<AddResponse>  je = unmarshaller.unmarshal(xsr, AddResponse.class);
    	             AddResponse addresponse=je.getValue();
    	             System.out.println(addresponse.getStatus().getSuccess());
    	             result=addresponse.getStatus().getSuccess();
    	         }
    	         else {
    	             System.out.println("调用失败！错误码：" + dynamicHttpclientCall.soapResponseData);
    	         }
    	         
    		 
    		 
    	 }
    	 catch (Exception ex)
    	 {
    		 
    		 result=ex.getMessage();
    		  
    		 
    	 }
    	 
    	 finally
    	 {
    		 return result;
    	 }
    	 
     }

 }