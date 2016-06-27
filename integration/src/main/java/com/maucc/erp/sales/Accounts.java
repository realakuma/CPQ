package com.maucc.erp.sales;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.maucc.documents.Docs;
import com.maucc.util.JSONtoMap;

public class Accounts {
	
	static String m_user = "zhu@artgreenhomes.com";
	  static String m_pass = "Zhu@42266";
	  public static String m_salse_base_link_url="https://documents-a403830.documents.us2.oraclecloud.com/documents";
	  //static String m_salse_base_url = "https://edda.crm.ap1.oraclecloud.com/";
	  static String m_salse_base_url = "https://edda-test.crm.ap1.oraclecloud.com/";
	  static String m_sales_crmCommonApi="crmCommonApi/";
	  static String m_sales_salesApi="salesApi/";
	  static String m_sales_resources="resources/";
	  static String m_sales_version="11.1.11/";
	  static String m_sales_mediaType="application/vnd.oracle.adf.resourceitem+json";
	  //accounts
	  

	
	
	public String createAccount(String Name,String floderName,String folderDescription)
	  {
		  
		  
		  String account_str="{\"OrganizationName\": \""+Name+"\"}";
		  
		  ClientConfig clientConfig = new ClientConfig();

	      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(m_user, m_pass);
	      clientConfig.register(feature) ;

	      Client client = ClientBuilder.newClient(clientConfig);

	      WebTarget target = client.target(m_salse_base_url + m_sales_crmCommonApi+m_sales_resources+m_sales_version+"accounts");

	      Invocation.Builder builder = target.request();
	       
	      Response response = builder.post(Entity.entity(account_str, m_sales_mediaType));
	      
	      String responseString = response.readEntity(String.class);
	      
	      response.close();

	      System.out.println(responseString);
	      
	      return  responseString;
	  }
	
	 public static void main(String[] args) {
		    try {
		    	Accounts accounts=new Accounts();
		    	String json="";
		    	Map<String,Object> Connect;
		    	
		    	accounts.createAccount("zhangbin3", "", "");
		    	
		    	
		    	
		 

		    } catch (Exception e) {
		      e.printStackTrace();
		    }

		  }

}
