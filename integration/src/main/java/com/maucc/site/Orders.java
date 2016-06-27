package com.maucc.site;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;


public class Orders {
	
	static String m_user = "johan@tmogroup.asia";
	  static String m_pass = "johan";
	  public static String m_site_order_base_link_url="https://maucc.com.alpha.tmogroup.asia/orderinfo";
	  //static String m_salse_base_url = "https://edda.crm.ap1.oraclecloud.com/";
	  static String m_salse_base_url = "https://edda-test.crm.ap1.oraclecloud.com/";
	  static String m_sales_crmCommonApi="crmCommonApi/";
	  static String m_sales_salesApi="salesApi/";
	  static String m_sales_resources="resources/";
	  static String m_sales_version="11.1.11/";
	  static String m_sales_mediaType="application/vnd.oracle.adf.resourceitem+json";
	  static String m_site_order_mediaType="application/json";
	  //accounts
	  

	
	
	public String createOrder(String token,String subtotal,String customer_id,String reservation_number,String order_number,String order_type,String document_url,String comment)
	  {
		  

		
		  
		  String order_str="{"+
			  "\"subtotal\": \""+ subtotal+"\","+
			  "\"customer_id\": \""+ customer_id+"\","+
			  "\"reservation_number\": \""+ reservation_number+"\","+
			  "\"order_number\": \""+ order_number+"\","+
			  "\"order_type\": \""+ order_type+"\","+
			  "\"document_url\": \""+ document_url+"\","+
			  "\"comment\": \""+comment+"\""+
			"}";
		  

		Client client = ClientBuilder.newClient();
		//OAUTH2认证方式
		client.register(OAuth2ClientSupport.feature(token));

		WebTarget target = client.target(m_site_order_base_link_url);

		Invocation.Builder builder = target.request();

		Response response = builder.post(Entity.entity(order_str, m_site_order_mediaType));

		String responseString = response.readEntity(String.class);

		response.close();

		System.out.println(responseString);

		return responseString;
	  }
	
	 public static void main(String[] args) {
		    try {
		    	Orders orders=new Orders();
		    	
		    	util util = new util();
				util.setRequestTokenURL("https://maucc.com.alpha.tmogroup.asia/auth");
				String token=util.getRequestToken(m_user, m_pass);
				
		    	String json="";
		    	Map<String,Object> Connect;
		    	
		    	orders.createOrder(token,"1500.00", "123", "1", "123", "3", "http://abc.com", "test");
		    	
		    	
		    	
		    	
		    	
		 

		    } catch (Exception e) {
		      e.printStackTrace();
		    }

		  }
}