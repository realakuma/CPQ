package hello_world;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bigmachines.soap.*;
import com.jcraft.jsch.ChannelSftp;
import com.maucc.models.UserInfo;
import com.maucc.util.Config;
import com.maucc.util.Convert;
import com.maucc.util.MySFTP;
import com.maucc.util.ZIP;
import com.maucc.ws.client.HttpSoapCallTranscation;
import com.maucc.xml.accounts.GenerateAccountsXml;
import com.maucc.xml.transcations.CreateTransactionResponse;

@RestController
@EnableAutoConfiguration
public class Example {

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
		String account_zipfile="";
		CreateTransactionResponse ctrp;
		try {

			if (userinfo.getSessionID().equals("")) {

				login.setUserInfo(loginUserInfo);
				logrp = sspt.login(login);
				System.out.println(logrp.getUserInfo().getSessionId());
				//gen zip file
				//account_zipfile=genAccountXmlFiles(userinfo);
				
				//upload to ftp
				//List<String> ftpServers=getFtpServers();
				//System.out.println(ftpServers.size());
				 //uploadToFTP(account_zipfile);
				
				//create transacation TEST
				
				 HttpSoapCallTranscation httpsoapcalltran= new HttpSoapCallTranscation("urn:soap.bigmachines.com",
						 "create",
						 "https://shanghaimanchi.bigmachines.com/v1_0/receiver",
						 logrp.getUserInfo().getSessionId(),
						 "https://shanghaimanchi.bigmachines.com/bmfsweb/shanghaimanchi/schema/v1_0/commerce/oraclecpqo.xsd"
						 );
				
				 ctrp=httpsoapcalltran.createTranscation();
				 CreateTransactionResponse.Transaction.DataXml dataxml=ctrp.getTransaction().getDataXml();
				 httpsoapcalltran.updateTranscation(String.valueOf(ctrp.getTransaction().getId()), ctrp.getTransaction().getProcessVarName(), ctrp.getTransaction().getSupplierCompanyName(),ctrp.getTransaction().getCurrencyPref(),ctrp.getTransaction().getBuyerUserName());
				  
			} else {
				try {
					System.out.println("SessionID: " + userinfo.getSessionID());
					getUserInfo = sspt.getUserInfo(userinfo.getSessionID());
					System.out.println("Logined User: " + getUserInfo.getUserInfo().getLogin());
					returnMessage = "{\"login\": \"" + getUserInfo.getUserInfo().getLogin() + "\"}";
					System.out.println(returnMessage);
					//gen zip file
					account_zipfile=genAccountXmlFiles(userinfo);
					
					//upload to ftp
					//List<String> ftpServers=getFtpServers();
					//System.out.println(ftpServers.size());
					uploadToFTP(account_zipfile);
					
					//insert into datatable
					
					
					//create transaction
					

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

	public String genAccountXmlFiles(UserInfo userinfo)
	{
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
	
	public void uploadToFTP(String FileName)
	{
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
		//sf.download(directory, downloadFile, saveFile, sftp);
		//sf.delete(directory, deleteFile, sftp);
		
	}
	
	public List<String> getFtpServers()
	{
		/*
		Config con=new Config();
		return con.getftpServers();
		*/
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}
}