package hello_world;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bigmachines.soap.*;
import com.jcraft.jsch.ChannelSftp;
import com.maucc.models.UserInfo;
import com.maucc.util.Config;
import com.maucc.util.Convert;
import com.maucc.util.JSONtoMap;
import com.maucc.util.MySFTP;
import com.maucc.util.ZIP;
import com.maucc.ws.client.HttpSoapCallConfigure;
import com.maucc.ws.client.HttpSoapCallDataTable;
import com.maucc.ws.client.HttpSoapCallTranscation;
import com.maucc.models.MeasureInfo;
import com.maucc.xml.accounts.GenerateAccountsXml;
import com.maucc.xml.transcations.CreateTransactionResponse;
import com.maucc.documents.*;

@RestController
@EnableAutoConfiguration
@SpringBootApplication

public class Example extends SpringBootServletInitializer{
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Example.class);
	    }
	 
	
	 @RequestMapping(value="/upload", method=RequestMethod.GET)  
	    public @ResponseBody String provideUploadInfo() {  
	        return "You can upload a file by posting to this same URL.";  
	    }  
	   
	    @RequestMapping(value="/upload", method=RequestMethod.POST)  
	    public @ResponseBody String handleFileUpload(  @RequestParam("username") String username,
	            @RequestParam("file") MultipartFile file){  
	        if (!file.isEmpty()) {  
	            try {  
	                byte[] bytes = file.getBytes(); 
	            	String json="";
	            	Map<String,Object> map;

	                BufferedOutputStream stream = null;
	                File f = new File(file.getOriginalFilename());
	          
	                stream=new BufferedOutputStream(new FileOutputStream(f));	                
	                stream.write(bytes);  
	                stream.close();
	                
	                // upload to document cloud
	                Docs docs=new Docs();
	                json=docs.createFloder("self",username,username);
	           	 
	            	map=JSONtoMap.toMap(json);
	            	

	            	
	            	String folderId=map.get("id").toString().replace("\"", "");
	            	json=docs.fileUpload(file.getOriginalFilename(),folderId);
	            	map=JSONtoMap.toMap(json);
	            	
	            	String fileId=map.get("id").toString().replace("\"", "");

	            	/*
	            	json=docs.createPublicLinkFile(fileId,"Mylink","abcd1234");
	            	map=JSONtoMap.toMap(json);
	            	
	            	String fileLinkID=map.get("linkID").toString().replace("\"", "");
	            	*/
	            	
	            	json=docs.createPublicLinkFolder(folderId,"Mylink","abcd1234");
	            	map=JSONtoMap.toMap(json);
	            	
	            	String folderLinkID=map.get("linkID").toString().replace("\"", "");
	            	
	            	//String linkURL=docs.m_docs_base_link_url+"/link/"+fileLinkID+"/fileview/"+fileId;
	            	String linkURL=docs.m_docs_base_link_url+"/link/"+folderLinkID+"/folder/"+folderId;
	            	System.out.println(linkURL);
	               
	                return  "{\"result\": \"" +linkURL+ "\"}";  
	            } catch (Exception e) {  
	               return e.getMessage();
	            }  
	        } else {  
	            return "You failed to upload  because the file was empty.";  
	        }  
	    }  
	    

	    
	    @RequestMapping(value="/imgsupload", method=RequestMethod.POST)  
	    public @ResponseBody String handleImgsUpload(@RequestParam("file") MultipartFile file){  
	        if (!file.isEmpty()) {  
	            try {  
	                byte[] bytes = file.getBytes(); 
	            	String json="";
	            	Map<String,Object> map;

	                BufferedOutputStream stream = null;
	                File f = new File(file.getOriginalFilename());
	          
	                stream=new BufferedOutputStream(new FileOutputStream(f));	                
	                stream.write(bytes);  
	                stream.close();
	                

	            	System.out.println(file.getName());
	               
	                return  "{\"result\": \"" +file.getName()+ "\"}";  
	            } catch (Exception e) {  
	               return e.getMessage();
	            }  
	        } else {  
	            return "You failed to upload  because the file was empty.";  
	        }  
	    }  

	@SuppressWarnings("finally")
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String userFillInfo(@RequestBody @Valid UserInfo userinfo) {

		SecurityServicePortTypeProxy sspt = new SecurityServicePortTypeProxy();
		Login login = new Login();
		LoginRequestUserInfoType loginUserInfo = new LoginRequestUserInfoType();
		LoginResponse logrp;
		LogoutResponse logoutrp;
		GetUserInfoResponse getUserInfo;
		loginUserInfo.setUsername("Shawn.jiao");
		loginUserInfo.setPassword("Sxj@1234");
		String returnMessage = "";
		String account_zipfile = "";
		CreateTransactionResponse ctrp;
		try {

			if (userinfo.getSessionID().equals("")) {

				login.setUserInfo(loginUserInfo);
				logrp = sspt.login(login);
				System.out.println(logrp.getUserInfo().getSessionId());
				// gen zip file
				account_zipfile = genAccountXmlFiles(userinfo);

				// upload to ftp
				// List<String> ftpServers=getFtpServers();
				// System.out.println(ftpServers.size());
				uploadToFTP(account_zipfile);

				// create transacation TEST
				HttpSoapCallTranscation httpsoapcalltran = new HttpSoapCallTranscation("urn:soap.bigmachines.com",
						"create", "https://shanghaimanchi.bigmachines.com/v1_0/receiver",
						logrp.getUserInfo().getSessionId(),
						"https://shanghaimanchi.bigmachines.com/bmfsweb/shanghaimanchi/schema/v1_0/commerce/oraclecpqo.xsd",
						"oraclecpqo", "transaction");
				ctrp = httpsoapcalltran.createTranscation();
				CreateTransactionResponse.Transaction.DataXml dataxml = ctrp.getTransaction().getDataXml();
				System.out.println(String.valueOf(ctrp.getTransaction().getId()));
				System.out.println(ctrp.getTransaction().getProcessVarName());
				// System.out.println(ctrp.getTransaction().getDataXml().getQuoteProcess().getCurrencyPref());

				httpsoapcalltran.updateTranscation(String.valueOf(ctrp.getTransaction().getId()),
						ctrp.getTransaction().getProcessVarName(), ctrp.getTransaction().getSupplierCompanyName(),
						ctrp.getTransaction().getCurrencyPref(), ctrp.getTransaction().getBuyerUserName());

				// add configure model to transaction
				MeasureInfo measureinfo = new MeasureInfo();
				measureinfo.setNamespace("urn:soap.bigmachines.com");
				measureinfo.setMethodName("create");
				measureinfo.setWsdlLocation("https://shanghaimanchi.bigmachines.com/v1_0/receiver");
				measureinfo.setSessionID(logrp.getUserInfo().getSessionId());
				measureinfo.setXsdLocation(
						"https://shanghaimanchi.bigmachines.com/bmfsweb/shanghaimanchi/schema/v1_0/config/test/DesignQuotations_DesignQuotations.xsd");
				measureinfo.setProcess_var_name("oraclecpqo");
				measureinfo.setVar_name("transaction");
				measureinfo.setSegment("test");
				measureinfo.setProduct_line("DesignQuotations");
				measureinfo.setModel("DesignQuotations");
				measureinfo.setFloors(userinfo.getFloor());
				measureinfo.setCellar(userinfo.getBasement());
				measureinfo.setGarage(userinfo.getGarage());
				measureinfo.setBedroom(userinfo.getBedroom());
				measureinfo.setHalls(userinfo.getLivingroom());
				measureinfo.setWashroom(userinfo.getBathroom());
				measureinfo.setStudy(userinfo.getStudy());
				measureinfo.setKitchen(userinfo.getKitchen());
				measureinfo.setTransactionId(String.valueOf(ctrp.getTransaction().getId()));

				HttpSoapCallConfigure dynamicHttpclientCallConfig = new HttpSoapCallConfigure(measureinfo);
				dynamicHttpclientCallConfig.createConfigure();

				// update datatable

				HashMap[] patameterMap = new HashMap[1];
				patameterMap[0] = new HashMap();
				patameterMap[0].put("Transaction_id", String.valueOf(ctrp.getTransaction().getId()));
				patameterMap[0].put("Transaction_Name",
						ctrp.getTransaction().getDataXml().getQuoteProcess().getTransactionIDT());
				patameterMap[0].put("Floors", userinfo.getFloor());
				patameterMap[0].put("Cellar", userinfo.getBasement());
				patameterMap[0].put("Garage", userinfo.getGarage());
				patameterMap[0].put("Bedroom", userinfo.getBedroom());
				patameterMap[0].put("Halls", userinfo.getLivingroom());
				patameterMap[0].put("Washroom", userinfo.getBathroom());
				patameterMap[0].put("Study", userinfo.getStudy());

				HttpSoapCallDataTable dynamicHttpclientCall = new HttpSoapCallDataTable("urn:soap.bigmachines.com",
						"add", "https://shanghaimanchi.bigmachines.com/v1_0/receiver",
						logrp.getUserInfo().getSessionId(), "HouseBasicInfo",
						"https://shanghaimanchi.bigmachines.com/bmfsweb/shanghaimanchi/schema/v1_0/datatables/HouseBasicInfo.xsd");
				dynamicHttpclientCall.add(patameterMap);

				dynamicHttpclientCall.deploy();

			} else {
				try {
					System.out.println("SessionID: " + userinfo.getSessionID());
					getUserInfo = sspt.getUserInfo(userinfo.getSessionID());
					System.out.println("Logined User: " + getUserInfo.getUserInfo().getLogin());
					returnMessage = "{\"login\": \"" + getUserInfo.getUserInfo().getLogin() + "\"}";
					System.out.println(returnMessage);
					// gen zip file
					account_zipfile = genAccountXmlFiles(userinfo);

					// upload to ftp
					// List<String> ftpServers=getFtpServers();
					// System.out.println(ftpServers.size());
					uploadToFTP(account_zipfile);

					// insert into datatable

					// create transaction

				} catch (Exception ex) {
					returnMessage = "{\"login\":\"Invalid Session ID\"}";
				}
			}
			// get userinfo by sessionId;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return returnMessage;
		}

	}
	/*
	 * @RequestMapping(value="/{sessionID}", method=RequestMethod.GET)
	 * 
	 * public String checkSessionValid(@PathVariable String
	 * sessionID,HttpServletRequest request) { System.out.println(sessionID);
	 * return "index.html"; }
	 */
	/*
	 * Map<String, Object> home() {
	 * 
	 * SecurityServicePortTypeProxy sspt =new SecurityServicePortTypeProxy();
	 * Login login=new Login(); LoginRequestUserInfoType userinfo =new
	 * LoginRequestUserInfoType(); LoginResponse logrp; LogoutResponse logoutrp;
	 * GetUserInfoResponse getUserInfo; userinfo.setUsername("admin");
	 * userinfo.setPassword("o8d3aynD"); Map<String, Object> model = new
	 * HashMap<String, Object>(); System.out.println(""); try {
	 * 
	 * login.setUserInfo(userinfo); logrp=sspt.login(login);
	 * System.out.println(logrp.getUserInfo().getSessionId()); //get userinfo by
	 * sessionId;
	 * getUserInfo=sspt.getUserInfo(logrp.getUserInfo().getSessionId());
	 * 
	 * model.put("id", logrp.getUserInfo().getSessionId()); model.put("content",
	 * getUserInfo.getUserInfo().getLogin());
	 * 
	 * } catch(Exception ex) { ex.printStackTrace(); } finally { return model; }
	 * 
	 * 
	 * 
	 * }
	 */

	// @RequestMapping("/resource/font")
	/*
	 * @RequestMapping(value="/resource/{sessionID}", method=RequestMethod.GET)
	 * public String findOwner(@PathVariable String sessionID) {
	 * System.out.println(sessionID); return "displayOwner"; }
	 */

	public String genAccountXmlFiles(UserInfo userinfo) {
		HashMap<String, String>[] patameterMap = new HashMap[1];
		patameterMap[0] = new HashMap<String, String>();
		patameterMap[0].put("CustomerId", userinfo.getCustID());
		patameterMap[0].put("CompanyName", userinfo.getCustName());
		GenerateAccountsXml gax = new GenerateAccountsXml();
		String xmlfilename = gax.genXmlFile("add", patameterMap);
		System.out.println(xmlfilename);
		// 压缩zip
		ZIP zip = new ZIP(xmlfilename.substring(0, xmlfilename.length() - 4) + ".zip");
		zip.compress(xmlfilename);
		// 生成upload_list.xml
		xmlfilename = Convert.getFileNameByFullPath(xmlfilename);
		String uploadfilepath = gax.genUploadListFile(xmlfilename.replace(".xml", ".zip"));
		return xmlfilename.substring(0, xmlfilename.length() - 4) + ".zip";
	}

	public void uploadToFTP(String FileName) {
		MySFTP sf = new MySFTP();
		String host = "ftp2.bigmachines.com";
		int port = 22;
		String username = "shanghaimanchi";
		String password = "shan8171";
		String directory = "/home/shanghaimanchi/upload_zip/automated/";
		String uploadFile = FileName;
		ChannelSftp sftp = sf.connect(host, port, username, password);
		sf.upload(directory, uploadFile, sftp);
		sf.upload(directory, "upload_list.xml", sftp);
		// sf.download(directory, downloadFile, saveFile, sftp);
		// sf.delete(directory, deleteFile, sftp);

	}

	public List<String> getFtpServers() {
		/*
		 * Config con=new Config(); return con.getftpServers();
		 */
		return null;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}
}