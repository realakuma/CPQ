package com.maucc.documents;
import org.glassfish.jersey.client.*;
import org.glassfish.jersey.client.authentication.*;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import java.io.File;
import java.util.Map;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.maucc.util.JSONtoMap;

public class Docs {

  static String m_user = "akuma.zhang@gmail.com";
  static String m_pass = "Akuma7v8yps@";
  public static String m_docs_base_link_url="https://documents-a403830.documents.us2.oraclecloud.com/documents";
  static String m_docs_base_url = "https://documents-a403830.documents.us2.oraclecloud.com/documents/api/1.1";

  public static void main(String[] args) {
    try {
    	Docs docs1=new Docs();
    	String json="";
    	Map<String,Object> map;
    	
    	json=docs1.createFloder("self","TEST2","TEST2");
    	 
    	map=JSONtoMap.toMap(json);
    	
    	/*
    	for (String key : map.keySet()) {
    		   System.out.println("key= "+ key + " and value= " + map.get(key));
         }
    	*/
    	
    	String folderId=map.get("id").toString().replace("\"", "");
    	json=docs1.fileUpload("crm_20160513142200.zip",folderId);
    	map=JSONtoMap.toMap(json);
    	
    	String fileId=map.get("id").toString().replace("\"", "");

    	
    	json=docs1.createPublicLinkFile(fileId,"Mylink","abcd1234");
    	map=JSONtoMap.toMap(json);
    	
    	String fileLinkID=map.get("linkID").toString().replace("\"", "");
    	
    	
    	
    	
    	String linkURL=m_docs_base_link_url+"/link/"+fileLinkID+"/fileview/"+fileId;
    	
    	System.out.println(linkURL);
    	
    	
    	
      /*
      ClientConfig clientConfig = new ClientConfig();

      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(m_user, m_pass);
      clientConfig.register(feature) ;

      Client client = ClientBuilder.newClient(clientConfig);

      WebTarget target = client.target(m_docs_base_url + "/users/items?info=smith");

      Invocation.Builder builder = target.request("text/plain");
      Invocation invocation = builder.buildGet();

      String responseData = invocation.invoke(String.class);

      System.out.println(responseData);
      */

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public String fileUpload(String fileName,String parentID)
  {
	  final String TARGET_URL = m_docs_base_url+"/files/data";
	  
	  HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(m_user, m_pass);
	  Client client = ClientBuilder.newBuilder()
	            .register(MultiPartFeature.class).build();
	  client.register(feature) ;
	  
	  WebTarget webTarget = client.target(TARGET_URL);

	  //String parentID = "self"; //self is the top level folder. Use a folder GUID to uplaod to a specific subfolder.
	  String jsonPayload = "{\"parentID\":\"" + parentID + "\"}";
	   
	  //Add the jsonInputParameters to the multi part form
	  FormDataMultiPart multipart = new FormDataMultiPart();
	  FormDataBodyPart fdpjson = new FormDataBodyPart("jsonInputParameters", jsonPayload);
	  multipart.bodyPart(fdpjson);
	       
	    
	        FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file",
	            new File(fileName),
	            MediaType.APPLICATION_OCTET_STREAM_TYPE);
	        fileDataBodyPart.setName("primaryFile");
	        multipart.bodyPart(fileDataBodyPart);
	        

	        Response response= webTarget.request(MediaType.APPLICATION_JSON_TYPE)
	            .post(Entity.entity(multipart, multipart.getMediaType()));
	        
	        // get json response
	        String responseString = response.readEntity(String.class);
	        System.out.println(responseString);
	        
	        response.close();
	        
	        return responseString;

	        /*
	        System.out.println(response.getStatus() + " "
	            + response.getStatusInfo() + " " + response);
	            */
	    }
  
  public String createFloder(String parentID,String floderName,String folderDescription)
  {
	  
	  
	  String floder_str="{\"name\": \""+floderName+"\",\"description\": \""+folderDescription+"\"}";
	  
	  ClientConfig clientConfig = new ClientConfig();

      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(m_user, m_pass);
      clientConfig.register(feature) ;

      Client client = ClientBuilder.newClient(clientConfig);

      WebTarget target = client.target(m_docs_base_url + "/folders/"+parentID);

      Invocation.Builder builder = target.request();
      
      Response response = builder.post(Entity.json(floder_str));
      
      String responseString = response.readEntity(String.class);
      
      response.close();

      System.out.println(responseString);
      
      return  responseString;
  }

  public String createPublicLinkFile(String fileID,String linkName,String linkPassword)
  {
	  ClientConfig clientConfig = new ClientConfig();
	  
	  String link_str="{\"assignedUsers\": \"@everybody\",\"password\": \""+linkPassword+"\",\"linkName\": \""+linkName+"\",\"role\": \"downloader\"}";

      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(m_user, m_pass);
      clientConfig.register(feature) ;

      Client client = ClientBuilder.newClient(clientConfig);

      WebTarget target = client.target(m_docs_base_url + "/publiclinks/file/"+fileID);

      Invocation.Builder builder = target.request();
      
      Response response = builder.post(Entity.json(link_str));
      
      String responseString = response.readEntity(String.class);
      
      response.close();

      System.out.println(responseString);
      
      return  responseString;
      
	  
  }
  public String createPublicLinkFolder(String folderID,String linkName,String linkPassword)
  {
	  ClientConfig clientConfig = new ClientConfig();
	  
	  String link_str="{\"assignedUsers\": \"@everybody\",\"password\": \""+linkPassword+"\",\"linkName\": \""+linkName+"\",\"role\": \"downloader\"}";

      HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(m_user, m_pass);
      clientConfig.register(feature) ;

      Client client = ClientBuilder.newClient(clientConfig);

      WebTarget target = client.target(m_docs_base_url + "/publiclinks/folder/"+folderID);

      Invocation.Builder builder = target.request();
      
      Response response = builder.post(Entity.json(link_str));
      
      String responseString = response.readEntity(String.class);
      
      response.close();

      System.out.println(responseString);
      
      return  responseString;
      
	  
  }
  }
  