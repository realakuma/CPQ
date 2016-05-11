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
import com.maucc.util.Convert;
import com.maucc.xml.transcations.CreateTransactionResponse;

public class HttpSoapCallTranscation {

	private String namespace;
	private String methodName;
	private String wsdlLocation;
	private String soapResponseData;
	private String sessionID;
	private String xsdLocation;
	private String transactionId;
	private String process_var_name;
	private String company_name;
	private String currency_pref;
	private String var_name;
	private String buyer_user_name;

	public HttpSoapCallTranscation(String namespace, String methodName, String wsdlLocation, String sessionID,
			String xsdLocation) {

		this.namespace = namespace;
		this.methodName = methodName;
		this.wsdlLocation = wsdlLocation;
		this.sessionID = sessionID;
		this.xsdLocation = xsdLocation;
	}

	public HttpSoapCallTranscation(String namespace, String methodName, String wsdlLocation, String sessionID,
			String xsdLocation, String process_var_name, String var_name) {

		this.namespace = namespace;
		this.methodName = methodName;
		this.wsdlLocation = wsdlLocation;
		this.sessionID = sessionID;
		this.xsdLocation = xsdLocation;
		this.process_var_name = process_var_name;
		this.var_name = var_name;
	}

	private int invoke(HashMap[] patameterMap) throws Exception {
		PostMethod postMethod = new PostMethod(wsdlLocation);
		String soapRequestData = buildRequestData(patameterMap);

		byte[] bytes = soapRequestData.getBytes("utf-8");
		InputStream inputStream = new ByteArrayInputStream(bytes, 0, bytes.length);
		RequestEntity requestEntity = new InputStreamRequestEntity(inputStream, bytes.length,
				"application/soap+xml; charset=utf-8");
		postMethod.setRequestEntity(requestEntity);

		HttpClient httpClient = new HttpClient();
		int statusCode = httpClient.executeMethod(postMethod);
		soapResponseData = postMethod.getResponseBodyAsString();

		return statusCode;
	}

	private int updateTranscationinvoke(HashMap[] patameterMap) throws Exception {
		PostMethod postMethod = new PostMethod(wsdlLocation);
		String soapRequestData = buildUpdateTranscationRequestData(patameterMap);
		System.out.println(soapRequestData);

		byte[] bytes = soapRequestData.getBytes("utf-8");
		InputStream inputStream = new ByteArrayInputStream(bytes, 0, bytes.length);
		RequestEntity requestEntity = new InputStreamRequestEntity(inputStream, bytes.length,
				"application/soap+xml; charset=utf-8");
		postMethod.setRequestEntity(requestEntity);

		HttpClient httpClient = new HttpClient();
		int statusCode = httpClient.executeMethod(postMethod);
		soapResponseData = postMethod.getResponseBodyAsString();

		return statusCode;
	}

	private String buildRequestData(HashMap[] patameterMap) {
		StringBuffer soapRequestData = new StringBuffer();
		soapRequestData.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		soapRequestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		soapRequestData.append("<soapenv:Header>");
		soapRequestData.append("<bm:userInfo xmlns:bm=\"" + this.namespace + "\">");
		soapRequestData.append("<bm:sessionId>" + this.sessionID + "</bm:sessionId>");
		soapRequestData.append("</bm:userInfo>");
		soapRequestData.append("<bm:category xmlns:bm=\"urn:soap.bigmachines.com\">Commerce</bm:category>");

		soapRequestData.append("<bm:xsdInfo xmlns:bm=\"urn:soap.bigmachines.com\">");
		// soapRequestData.append("<bm:schemaLocation>https://partnertrn-osc-022.bigmachines.com/bmfsweb/partnertrn-osc-022/schema/v1_0/commerce/quickstart_commerce_process_bmClone_4.xsd</bm:schemaLocation></bm:xsdInfo>");
		soapRequestData.append("<bm:schemaLocation>" + this.xsdLocation + "</bm:schemaLocation></bm:xsdInfo>");
		soapRequestData.append("</soapenv:Header>");
		soapRequestData.append("<soapenv:Body>");
		soapRequestData.append("<bm:createTransaction xmlns:bm=\"" + this.namespace
				+ "\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");

		soapRequestData.append("<bm:items>");
		soapRequestData.append("<bm:catalogItem>");
		soapRequestData.append("<bm:segment/>");
		soapRequestData.append("<bm:product_line/>");
		soapRequestData.append("<bm:model/>");
		soapRequestData.append("</bm:catalogItem>");
		soapRequestData.append("<bm:partItem>");
		soapRequestData.append("<bm:part/>");
		soapRequestData.append("<bm:quantity>1</bm:quantity>");
		soapRequestData.append("<bm:price_book_var_name/>");
		soapRequestData.append("</bm:partItem>");
		soapRequestData.append("</bm:items>");
		soapRequestData.append("<bm:transaction>");
		// soapRequestData.append("<bm:process_var_name>quickstart_commerce_process_bmClone_4</bm:process_var_name>");
		soapRequestData.append("<bm:process_var_name>" + this.process_var_name + "</bm:process_var_name>");
		soapRequestData.append("<bm:_bm_cm_new_transaction_currency/>");
		/*
		soapRequestData.append("<bm:return_specific_attributes>");
		soapRequestData.append("<bm:documents>");
		soapRequestData.append("<bm:document>");
		// soapRequestData.append("<bm:var_name>quote_process</bm:var_name>");
		soapRequestData.append("<bm:var_name>" + this.var_name + "</bm:var_name>");
		soapRequestData.append("<bm:attributes>");
		soapRequestData.append("<bm:attribute>_document_number</bm:attribute>");
		soapRequestData.append("</bm:attributes>");
		soapRequestData.append("</bm:document>");
		soapRequestData.append("</bm:documents>");
		soapRequestData.append("</bm:return_specific_attributes>");
		*/
		soapRequestData.append("</bm:transaction>");
		soapRequestData.append("</bm:createTransaction>");
		/*
		 * for (HashMap patameter : patameterMap) {
		 * soapRequestData.append("<bm:each_record>");
		 * 
		 * Set set=patameter.entrySet(); Iterator it=set.iterator();
		 * while(it.hasNext()){ Map.Entry me=(Map.Entry)it.next();
		 * System.out.println(me.getKey()+":"+me.getValue());
		 * soapRequestData.append("<bm:"+me.getKey()+">"+me.getValue()+"</bm:"+
		 * me.getKey()+">"); }
		 * 
		 * soapRequestData.append("</bm:each_record>"); }
		 */
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
		SecurityServicePortTypeProxy sspt = new SecurityServicePortTypeProxy();
		Login login = new Login();
		LoginRequestUserInfoType userinfo = new LoginRequestUserInfoType();
		LoginResponse logrp;
		LogoutResponse logoutrp;
		GetUserInfoResponse getUserInfo;
		userinfo.setUsername("admin");
		userinfo.setPassword("o8d3aynD");
		try {
			login.setUserInfo(userinfo);
			logrp = sspt.login(login);
			System.out.println(logrp.getUserInfo().getSessionId());
			// get userinfo by sessionId;
			getUserInfo = sspt.getUserInfo(logrp.getUserInfo().getSessionId());
			System.out.println(getUserInfo.getUserInfo().getLogin());

			HttpSoapCallTranscation dynamicHttpclientCall = new HttpSoapCallTranscation("urn:soap.bigmachines.com",
					"add", "https://partnertrn-osc-022.bigmachines.com/v1_0/receiver",
					logrp.getUserInfo().getSessionId(), "ZBTestTable");

			HashMap[] patameterMap = new HashMap[1];
			patameterMap[0] = new HashMap();
			patameterMap[0].put("personID", "789");
			patameterMap[0].put("Name", "xman");
			patameterMap[0].put("Gender", "male");

			String soapRequestData = dynamicHttpclientCall.buildRequestData(patameterMap);
			System.out.println(soapRequestData);

			int statusCode = dynamicHttpclientCall.invoke(patameterMap);
			if (statusCode == 200) {
				System.out.println("调用成功！");
				System.out.println(dynamicHttpclientCall.soapResponseData);
			} else {
				System.out.println("调用失败！错误码：" + statusCode);
			}

			logoutrp = sspt.logout(logrp.getUserInfo().getSessionId());
			System.out.println(logoutrp.getStatus().getMessage());

		} catch (Exception ex) {

		} finally {

		}

	}

	@SuppressWarnings("finally")
	public CreateTransactionResponse createTranscation() {
		String result = "";
		int statusCode = 0;
		CreateTransactionResponse createTransactionresponse=null;
		try {

			HttpSoapCallTranscation dynamicHttpclientCall = new HttpSoapCallTranscation(this.namespace, "create",
					this.wsdlLocation, this.sessionID, this.xsdLocation, this.process_var_name, this.var_name);
			statusCode = dynamicHttpclientCall.invoke(null);
			if (statusCode == 200 || statusCode == 0) {
				System.out.println("调用成功！");
				XMLStreamReader xsr = Convert
						.GetSOAPResult(new ByteArrayInputStream(dynamicHttpclientCall.soapResponseData.getBytes()));
				JAXBContext jaxbContext = JAXBContext.newInstance("com.maucc.xml.transcations");
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				JAXBElement<CreateTransactionResponse> je = unmarshaller.unmarshal(xsr,
						CreateTransactionResponse.class);
				createTransactionresponse = je.getValue();
				System.out.println(createTransactionresponse.getStatus().getSuccess());
				System.out.println(createTransactionresponse.getTransaction().getId());
				return createTransactionresponse;

			} else {
				System.out.println("调用失败！错误码：" + dynamicHttpclientCall.soapResponseData);
			}

		} catch (Exception ex) {

			result = ex.getMessage();

		}

		finally {
			return createTransactionresponse;
		}

	}

	@SuppressWarnings("finally")
	public String updateTranscation(String transcationId, String process_var_name, String company_name,
			String currency_pref,String buyer_user_name)

	{
		String result = "";
		int statusCode = 0;
		try {

			HttpSoapCallTranscation dynamicHttpclientCall = new HttpSoapCallTranscation(this.namespace, "update",
					this.wsdlLocation, this.sessionID, this.xsdLocation);
			dynamicHttpclientCall.transactionId = transcationId;
			dynamicHttpclientCall.process_var_name = process_var_name;
			dynamicHttpclientCall.company_name = company_name;
			dynamicHttpclientCall.currency_pref = currency_pref;
			dynamicHttpclientCall.buyer_user_name=buyer_user_name;

			statusCode = dynamicHttpclientCall.updateTranscationinvoke(null);

			if (statusCode == 200 || statusCode == 0) {
				System.out.println("调用成功！");
				System.out.println(dynamicHttpclientCall.soapResponseData);

				result = "True";
			} else {
				System.out.println("调用失败！错误码：" + dynamicHttpclientCall.soapResponseData);
			}

		} catch (Exception ex) {

			result = ex.getMessage();

		}

		finally {
			return result;
		}

	}

	private String buildUpdateTranscationRequestData(HashMap[] patameterMap) {

		StringBuffer soapRequestData = new StringBuffer();
		soapRequestData.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		soapRequestData.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		soapRequestData.append("<soapenv:Header>");
		soapRequestData.append("<bm:userInfo xmlns:bm=\"" + this.namespace + "\">");
		soapRequestData.append("<bm:sessionId>" + this.sessionID + "</bm:sessionId>");
		soapRequestData.append("</bm:userInfo>");
		soapRequestData.append("<bm:category xmlns:bm=\"urn:soap.bigmachines.com\">Commerce</bm:category>");

		soapRequestData.append("<bm:xsdInfo xmlns:bm=\"urn:soap.bigmachines.com\">");
		soapRequestData.append(
				"<bm:schemaLocation>"+this.xsdLocation+"</bm:schemaLocation></bm:xsdInfo>");
		soapRequestData.append("</soapenv:Header>");
		soapRequestData.append("<soapenv:Body>");
		soapRequestData.append("<bm:updateTransaction xmlns:bm=\"" + this.namespace
				+ "\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		soapRequestData.append("<bm:transaction>");
		soapRequestData.append("<bm:id>" + this.transactionId + "</bm:id>");
		// soapRequestData.append("<bm:process_var_name>"+quickstart_commerce_process_bmClone_4+"</bm:process_var_name>");
		soapRequestData.append("<bm:process_var_name>" + this.process_var_name + "</bm:process_var_name>");
		// soapRequestData.append("<bm:buyer_company_name>partnertrn-osc-022</bm:buyer_company_name>");
		// soapRequestData.append("<bm:supplier_company_name>partnertrn-osc-022</bm:supplier_company_name>");
		soapRequestData.append("<bm:buyer_company_name>" + this.company_name + "</bm:buyer_company_name>");
		soapRequestData.append("<bm:supplier_company_name>" + this.company_name + "</bm:supplier_company_name>");
		soapRequestData.append("<bm:step_var_name/>");
		soapRequestData.append("<bm:last_document_number>1</bm:last_document_number>");
		// soapRequestData.append("<bm:date_added>2016-04-27
		// 07:19:28</bm:date_added>");
		// soapRequestData.append("<bm:date_modified>2016-04-27
		// 07:19:28</bm:date_modified>");
		soapRequestData.append("<bm:data_xml>");
		soapRequestData.append("<bm:transaction  bm:bs_id=\"" + this.transactionId + "\" bm:buyer_company_name=\""
				+ this.company_name + "\" bm:buyer_user_name=\""+this.buyer_user_name+"\" bm:currency_pref=\"" + this.currency_pref
				+ "\" bm:data_type=\"0\" bm:document_name=\"Transaction\" bm:document_number=\"1\" bm:document_var_name=\"Transaction\" bm:process_var_name=\""
				+ this.process_var_name + "\" bm:supplier_company_name=\"" + this.company_name + "\">");
		soapRequestData.append("<bm:applicationMode_quote>online</bm:applicationMode_quote>");
		soapRequestData.append("<bm:_document_number>1</bm:_document_number>");
		// soapRequestData.append("<bm:adminNumDayRefreshPartDB_quote>-1</bm:adminNumDayRefreshPartDB_quote>");
		// soapRequestData.append("<bm:adminVolumePricing_quote>Aggregate</bm:adminVolumePricing_quote>");
		// soapRequestData.append("<bm:adminExpirationTime_quote>30</bm:adminExpirationTime_quote>");
		// soapRequestData.append("<bm:contractValueType_quote>TCV</bm:contractValueType_quote>");
		// soapRequestData.append("<bm:nondiscountableCategories_quote/>");
		// soapRequestData.append("<bm:adminCRMIntegration_quote>oSC</bm:adminCRMIntegration_quote>");
		// soapRequestData.append("<bm:adminFAPEnvironment_quote>fap0000</bm:adminFAPEnvironment_quote>");
		// soapRequestData.append("<bm:adminFAPEnvironmentPassword_quote>XXXXXXXX</bm:adminFAPEnvironmentPassword_quote>");
		// soapRequestData.append("<bm:adminEBSEnvironment_quote/>");
		// soapRequestData.append("<bm:adminIncludeDOOIntegration_quote>false</bm:adminIncludeDOOIntegration_quote>");
		// soapRequestData.append("<bm:adminFAPEnvironmentDOOUser_quote>scm_impl</bm:adminFAPEnvironmentDOOUser_quote>");
		// soapRequestData.append("<bm:fAPCredentialsBase64_quote/>");
		soapRequestData.append("<bm:_customer_id/>");
		soapRequestData.append("<bm:crmOpportunityId_quote/>");
		soapRequestData.append("<bm:crmUserId_quote/>");
		soapRequestData.append("<bm:crmQuoteId_quote/>");
		soapRequestData.append("<bm:crmProduct200Ids_quote/>");
		soapRequestData.append("<bm:crmProduct400Ids_quote/>");
		soapRequestData.append("<bm:crmProduct600Ids_quote/>");
		soapRequestData.append("<bm:crmProduct800Ids_quote/>");
		soapRequestData.append("<bm:crmProduct1000Ids_quote/>");
		soapRequestData.append("<bm:crmisPrimary_quote>false</bm:crmisPrimary_quote>");
		soapRequestData.append("<bm:crmQuoteIds_quote/>");
		soapRequestData.append("<bm:crmPrimaryQuote_quote/>");
		soapRequestData.append("<bm:crmURL_quote>secure-ausomx[nnn]</bm:crmURL_quote>");
		soapRequestData.append("<bm:_partner_price_book_id/>");
		soapRequestData.append("<bm:_price_book_custom_field_text/>");
		soapRequestData.append("<bm:_price_book_custom_fields/>");
		soapRequestData.append("<bm:_price_book_desc/>");
		soapRequestData.append("<bm:_price_book_name/>");
		soapRequestData.append("<bm:preparedByName_quote></bm:preparedByName_quote>");
		soapRequestData.append("<bm:preparedByTitle_quote/>");
		soapRequestData.append("<bm:preparedByPhone_quote/>");
		soapRequestData.append("<bm:preparedByCell_quote/>");
		soapRequestData.append("<bm:preparedByEmail_quote></bm:preparedByEmail_quote>");
		soapRequestData.append("<bm:_shipTo_first_name/>");
		soapRequestData.append("<bm:_shipTo_last_name/>");
		soapRequestData.append("<bm:_shipTo_company_name/>");
		soapRequestData.append("<bm:_shipTo_company_name_2/>");
		soapRequestData.append("<bm:_shipTo_address/>");
		soapRequestData.append("<bm:_shipTo_address_2/>");
		soapRequestData.append("<bm:_shipTo_city/>");
		soapRequestData.append("<bm:_shipTo_state/>");
		soapRequestData.append("<bm:_shipTo_zip/>");
		soapRequestData.append("<bm:_shipTo_country/>");
		soapRequestData.append("<bm:_shipTo_phone/>");
		soapRequestData.append("<bm:_shipTo_fax/>");
		soapRequestData.append("<bm:_shipTo_email/>");
		soapRequestData.append("<bm:_billTo_first_name/>");
		soapRequestData.append("<bm:_billTo_last_name/>");
		soapRequestData.append("<bm:_billTo_company_name/>");
		soapRequestData.append("<bm:_billTo_company_name_2/>");
		soapRequestData.append("<bm:_billTo_address/>");
		soapRequestData.append("<bm:_billTo_address_2/>");
		soapRequestData.append("<bm:_billTo_city/>");
		soapRequestData.append("<bm:_billTo_state/>");
		soapRequestData.append("<bm:_billTo_zip/>");
		soapRequestData.append("<bm:_price_book_var_name/>");
		soapRequestData.append("<bm:_billTo_country/>");
		soapRequestData.append("<bm:_billTo_phone/>");
		soapRequestData.append("<bm:_billTo_fax/>");
		soapRequestData.append("<bm:_billTo_email/>");
		soapRequestData.append("<bm:opportunityName_quote/>");
		soapRequestData.append("<bm:quoteNumber_quote></bm:quoteNumber_quote>");
		soapRequestData.append("<bm:revisionNumber_quote>1</bm:revisionNumber_quote>");
		soapRequestData.append("<bm:quoteType_quote></bm:quoteType_quote>");
		soapRequestData.append("<bm:quoteDescription_quote/>");
		soapRequestData.append("<bm:createdDate_quote></bm:createdDate_quote>");
		soapRequestData.append("<bm:submittedDate_quote/>");
		soapRequestData.append("<bm:expirationDate_quote></bm:expirationDate_quote>");
		soapRequestData.append("<bm:currentDate_quote></bm:currentDate_quote>");
		soapRequestData.append("<bm:includeCoverLetter_quote>false</bm:includeCoverLetter_quote>");
		soapRequestData.append("<bm:includeTC_quote>false</bm:includeTC_quote>");
		soapRequestData.append("<bm:additionalDocumentationPDF_quote/>");
		soapRequestData.append("<bm:descriptionType_quote>Short</bm:descriptionType_quote>");
		soapRequestData.append("<bm:showLinePrice_quote>false</bm:showLinePrice_quote>");
		soapRequestData.append("<bm:showDiscount_quote>false</bm:showDiscount_quote>");
		soapRequestData.append("<bm:terms_quote>Net 30</bm:terms_quote>");
		soapRequestData.append("<bm:specialTerms/>");
		soapRequestData.append("<bm:miscChargePostDiscount1_quote/>");
		soapRequestData.append("<bm:miscChargePostDiscount2_quote/>");
		soapRequestData.append("<bm:miscChargePostDiscount3_quote/>");
		soapRequestData.append("<bm:reasonForDiscountAdjustment_quote/>");
		soapRequestData.append("<bm:miscChargePostDiscountDesc1_quote/>");
		soapRequestData.append("<bm:miscChargePostDiscountDesc2_quote/>");
		soapRequestData.append("<bm:miscChargePostDiscountDesc3_quote/>");
		soapRequestData.append("<bm:dateOfApproval1_quote/>");
		soapRequestData.append("<bm:status_quote>Pending</bm:status_quote>");
		soapRequestData.append("<bm:emailSender>quickstart@bigmachines.com</bm:emailSender>");
		soapRequestData
				.append("<bm:proposalAttachmentLabel_quote></bm:proposalAttachmentLabel_quote>");
		soapRequestData.append("<bm:conversionRate_quote/>");
		soapRequestData.append("<bm:outputCurrency_quote>USD</bm:outputCurrency_quote>");
		soapRequestData.append("<bm:currentUserGroup_quote>approvalGroup1</bm:currentUserGroup_quote>");
		soapRequestData.append("<bm:currentUser_quote>"+this.buyer_user_name+"</bm:currentUser_quote>");
		soapRequestData.append(
				"<bm:linkToDocument_quote></bm:linkToDocument_quote>");
		soapRequestData.append("<bm:customGroup1Name_quote/>");
		soapRequestData.append("<bm:customGroup2Name_quote/>");
		soapRequestData.append("<bm:customGroup3Name_quote/>");
		soapRequestData.append("<bm:customGroup4Name_quote/>");
		soapRequestData.append("<bm:customGroup5Name_quote/>");
		soapRequestData.append("<bm:customGroup6Name_quote/>");
		soapRequestData.append("<bm:customGroup1Desc_quote/>");
		soapRequestData.append("<bm:customGroup2Desc_quote/>");
		soapRequestData.append("<bm:customGroup3Desc_quote/>");
		soapRequestData.append("<bm:customGroup4Desc_quote/>");
		soapRequestData.append("<bm:customGroup5Desc_quote/>");
		soapRequestData.append("<bm:customGroup6Desc_quote/>");
		soapRequestData.append("<bm:customGroup1Discount_quote>0.0</bm:customGroup1Discount_quote>");
		soapRequestData.append("<bm:customGroup2Discount_quote>0.0</bm:customGroup2Discount_quote>");
		soapRequestData.append("<bm:customGroup3Discount_quote>0.0</bm:customGroup3Discount_quote>");
		soapRequestData.append("<bm:customGroup4Discount_quote>0.0</bm:customGroup4Discount_quote>");
		soapRequestData.append("<bm:customGroup5Discount_quote>0.0</bm:customGroup5Discount_quote>");
		soapRequestData.append("<bm:customGroup6Discount_quote>0.0</bm:customGroup6Discount_quote>");
		soapRequestData.append("<bm:emailSender_quote/>");
		soapRequestData.append("<bm:emailRecipients_quote/>");
		soapRequestData.append("<bm:transactionID_quote>\"" + this.transactionId + "\"</bm:transactionID_quote>");
		soapRequestData.append("<bm:showListPrice_quote>false</bm:showListPrice_quote>");
		soapRequestData.append("<bm:showSubtotal_quote>false</bm:showSubtotal_quote>");
		soapRequestData.append("<bm:adHocFlag_quote>false</bm:adHocFlag_quote>");
		soapRequestData.append("<bm:creator_quote>Admin</bm:creator_quote>");
		soapRequestData.append("<bm:creatorUserGroup_quote></bm:creatorUserGroup_quote>");
		soapRequestData.append("<bm:creatorCompany_quote>"+this.company_name+"</bm:creatorCompany_quote>");
		soapRequestData.append("<bm:orderedDate_quote/>");
		// soapRequestData.append("<bm:orderedDateNoTime_quote>2016-04-27
		// 00:00:00</bm:orderedDateNoTime_quote>");
		soapRequestData.append("<bm:outputLanguage_quote>en</bm:outputLanguage_quote>");
		soapRequestData.append("<bm:approvalDate_quote/>");
		soapRequestData.append("<bm:numberOfDaysForApproval_quote/>");
		soapRequestData.append("<bm:includeCoverPage_quote>true</bm:includeCoverPage_quote>");
		soapRequestData.append("<bm:webID_quote>\"" + this.transactionId + "\"</bm:webID_quote>");
		soapRequestData.append("<bm:desiredTotal_quote/>");
		soapRequestData.append("<bm:customerLogo_quote/>");
		soapRequestData.append("<bm:groupItemsBy_quote>Category</bm:groupItemsBy_quote>");
		soapRequestData.append("<bm:optionalSubtotal_quote/>");
		soapRequestData.append("<bm:errors_quote/>");
		soapRequestData.append("<bm:miscCharge1_quote>0</bm:miscCharge1_quote>");
		soapRequestData.append("<bm:miscCharge2_quote/>");
		soapRequestData.append("<bm:miscCharge3_quote/>");
		soapRequestData.append("<bm:miscCharge4_quote/>");
		soapRequestData.append("<bm:miscCharge5_quote/>");
		soapRequestData.append("<bm:miscCharge6_quote/>");
		soapRequestData.append("<bm:miscOptional1_quote>false</bm:miscOptional1_quote>");
		soapRequestData.append("<bm:miscOptional2_quote>false</bm:miscOptional2_quote>");
		soapRequestData.append("<bm:miscOptional3_quote>false</bm:miscOptional3_quote>");
		soapRequestData.append("<bm:miscOptional4_quote>false</bm:miscOptional4_quote>");
		soapRequestData.append("<bm:miscOptional5_quote>false</bm:miscOptional5_quote>");
		soapRequestData.append("<bm:miscOptional6_quote>false</bm:miscOptional6_quote>");
		soapRequestData.append("<bm:miscCateogry1_quote>Uncategorized</bm:miscCateogry1_quote>");
		soapRequestData.append("<bm:miscCateogry2_quote>Uncategorized</bm:miscCateogry2_quote>");
		soapRequestData.append("<bm:miscCateogry3_quote>Uncategorized</bm:miscCateogry3_quote>");
		soapRequestData.append("<bm:miscCateogry4_quote>Uncategorized</bm:miscCateogry4_quote>");
		soapRequestData.append("<bm:miscCateogry5_quote>Uncategorized</bm:miscCateogry5_quote>");
		soapRequestData.append("<bm:miscCateogry6_quote>Uncategorized</bm:miscCateogry6_quote>");
		soapRequestData.append("<bm:miscChargeQty1_quote>1.0</bm:miscChargeQty1_quote>");
		soapRequestData.append("<bm:miscChargeQty2_quote>1.0</bm:miscChargeQty2_quote>");
		soapRequestData.append("<bm:miscChargeQty3_quote>1.0</bm:miscChargeQty3_quote>");
		soapRequestData.append("<bm:miscChargeQty4_quote>1.0</bm:miscChargeQty4_quote>");
		soapRequestData.append("<bm:miscChargeQty5_quote>1.0</bm:miscChargeQty5_quote>");
		soapRequestData.append("<bm:miscChargeQty6_quote>1.0</bm:miscChargeQty6_quote>");
		soapRequestData.append("<bm:miscChargeDesc1_quote/>");
		soapRequestData.append("<bm:miscChargeDesc2_quote/>");
		soapRequestData.append("<bm:miscChargeDesc3_quote/>");
		soapRequestData.append("<bm:miscChargeDesc4_quote/>");
		soapRequestData.append("<bm:miscChargeDesc5_quote/>");
		soapRequestData.append("<bm:miscChargeDesc6_quote/>");
		soapRequestData.append("<bm:miscExtCharge1_quote/>");
		soapRequestData.append("<bm:miscExtCharge2_quote/>");
		soapRequestData.append("<bm:miscExtCharge3_quote/>");
		soapRequestData.append("<bm:miscExtCharge4_quote/>");
		soapRequestData.append("<bm:miscExtCharge5_quote/>");
		soapRequestData.append("<bm:miscExtCharge6_quote/>");
		soapRequestData.append("<bm:miscChargeProd1_quote/>");
		soapRequestData.append("<bm:miscChargeProd2_quote/>");
		soapRequestData.append("<bm:miscChargeProd3_quote/>");
		soapRequestData.append("<bm:miscChargeProd4_quote/>");
		soapRequestData.append("<bm:miscChargeProd5_quote/>");
		soapRequestData.append("<bm:miscChargeProd6_quote/>");
		soapRequestData.append("<bm:miscChargeGroup1_quote/>");
		soapRequestData.append("<bm:miscChargeGroup2_quote/>");
		soapRequestData.append("<bm:miscChargeGroup3_quote/>");
		soapRequestData.append("<bm:miscChargeGroup4_quote/>");
		soapRequestData.append("<bm:miscChargeGroup5_quote/>");
		soapRequestData.append("<bm:miscChargeGroup6_quote/>");
		soapRequestData.append("<bm:miscChargeList1_quote/>");
		soapRequestData.append("<bm:miscChargeList2_quote/>");
		soapRequestData.append("<bm:miscChargeList3_quote/>");
		soapRequestData.append("<bm:miscChargeList4_quote/>");
		soapRequestData.append("<bm:miscChargeList5_quote/>");
		soapRequestData.append("<bm:miscChargeList6_quote/>");
		soapRequestData.append("<bm:miscChargeDiscount1_quote/>");
		soapRequestData.append("<bm:miscChargeDiscount2_quote/>");
		soapRequestData.append("<bm:miscChargeDiscount3_quote/>");
		soapRequestData.append("<bm:miscChargeDiscount4_quote/>");
		soapRequestData.append("<bm:miscChargeDiscount5_quote/>");
		soapRequestData.append("<bm:miscChargeDiscount6_quote/>");
		soapRequestData.append("<bm:miscChargeDiscountPercent1_quote/>");
		soapRequestData.append("<bm:miscChargeDiscountPercent2_quote/>");
		soapRequestData.append("<bm:miscChargeDiscountPercent3_quote/>");
		soapRequestData.append("<bm:miscChargeDiscountPercent4_quote/>");
		soapRequestData.append("<bm:miscChargeDiscountPercent5_quote/>");
		soapRequestData.append("<bm:miscChargeDiscountPercent6_quote/>");
		soapRequestData.append("<bm:miscChargeDiscountType2_quote>%</bm:miscChargeDiscountType2_quote>");
		soapRequestData.append("<bm:miscChargeDiscountType1_quote>%</bm:miscChargeDiscountType1_quote>");
		soapRequestData.append("<bm:miscChargeDiscountType3_quote>%</bm:miscChargeDiscountType3_quote>");
		soapRequestData.append("<bm:miscChargeDiscountType4_quote>%</bm:miscChargeDiscountType4_quote>");
		soapRequestData.append("<bm:miscChargeDiscountType5_quote>%</bm:miscChargeDiscountType5_quote>");
		soapRequestData.append("<bm:miscChargeDiscountType6_quote>%</bm:miscChargeDiscountType6_quote>");
		soapRequestData.append("<bm:miscStartDate1_quote></bm:miscStartDate1_quote>");
		soapRequestData.append("<bm:miscStartDate2_quote></bm:miscStartDate2_quote>");
		soapRequestData.append("<bm:miscStartDate3_quote></bm:miscStartDate3_quote>");
		soapRequestData.append("<bm:miscStartDate4_quote></bm:miscStartDate4_quote>");
		soapRequestData.append("<bm:miscStartDate5_quote></bm:miscStartDate5_quote>");
		soapRequestData.append("<bm:miscStartDate6_quote></bm:miscStartDate6_quote>");
		soapRequestData.append("<bm:miscEndDate1_quote/>");
		soapRequestData.append("<bm:miscEndDate2_quote/>");
		soapRequestData.append("<bm:miscEndDate3_quote/>");
		soapRequestData.append("<bm:miscEndDate4_quote/>");
		soapRequestData.append("<bm:miscEndDate5_quote/>");
		soapRequestData.append("<bm:miscEndDate6_quote/>");
		soapRequestData.append("<bm:customGroup1DiscRecurring_quote>0.0</bm:customGroup1DiscRecurring_quote>");
		soapRequestData.append("<bm:customGroup2DiscRecurring_quote>0.0</bm:customGroup2DiscRecurring_quote>");
		soapRequestData.append("<bm:customGroup3DiscRecurring_quote>0.0</bm:customGroup3DiscRecurring_quote>");
		soapRequestData.append("<bm:customGroup4DiscRecurring_quote>0.0</bm:customGroup4DiscRecurring_quote>");
		soapRequestData.append("<bm:customGroup5DiscRecurring_quote>0.0</bm:customGroup5DiscRecurring_quote>");
		soapRequestData.append("<bm:customGroup6DiscRecurring_quote>0.0</bm:customGroup6DiscRecurring_quote>");
		soapRequestData.append("<bm:miscChargeFeeType1_quote>One-Time</bm:miscChargeFeeType1_quote>");
		soapRequestData.append("<bm:miscChargeFeeType2_quote>One-Time</bm:miscChargeFeeType2_quote>");
		soapRequestData.append("<bm:miscChargeFeeType3_quote>One-Time</bm:miscChargeFeeType3_quote>");
		soapRequestData.append("<bm:miscChargeFeeType4_quote>One-Time</bm:miscChargeFeeType4_quote>");
		soapRequestData.append("<bm:miscChargeFeeType5_quote>One-Time</bm:miscChargeFeeType5_quote>");
		soapRequestData.append("<bm:miscChargeFeeType6_quote>One-Time</bm:miscChargeFeeType6_quote>");
		soapRequestData.append("<bm:miscContractValueUnit1_quote/>");
		soapRequestData.append("<bm:miscContractValueUnit2_quote/>");
		soapRequestData.append("<bm:miscContractValueUnit3_quote/>");
		soapRequestData.append("<bm:miscContractValueUnit4_quote/>");
		soapRequestData.append("<bm:miscContractValueUnit5_quote/>");
		soapRequestData.append("<bm:miscContractValueUnit6_quote/>");
		soapRequestData.append("<bm:minimumTotal_quote/>");
		soapRequestData.append("<bm:maximumTotal_quote/>");
		soapRequestData.append("<bm:contractTermMenu_quote>36</bm:contractTermMenu_quote>");
		soapRequestData.append("<bm:showLineGridColumns_quote/>");
		soapRequestData.append("<bm:totalAdHocItemsRecurring_quote/>");
		soapRequestData.append("<bm:optionalSubtotalRecurring_quote/>");
		soapRequestData.append("<bm:optionalItemsOneTime_quote/>");
		soapRequestData.append("<bm:optionalItemsMonthly_quote/>");
		soapRequestData.append("<bm:totalMiscDiscount_quote>0</bm:totalMiscDiscount_quote>");
		soapRequestData.append("<bm:totalMiscDiscountRecurring_quote>0</bm:totalMiscDiscountRecurring_quote>");
		soapRequestData.append("<bm:totalMiscListPrice_quote>0</bm:totalMiscListPrice_quote>");
		soapRequestData.append("<bm:totalMiscListPriceRecurring_quote>0</bm:totalMiscListPriceRecurring_quote>");
		soapRequestData.append("<bm:totalMiscNetPrice_quote>0</bm:totalMiscNetPrice_quote>");
		soapRequestData.append("<bm:totalMiscNetPriceRecurring_quote>0</bm:totalMiscNetPriceRecurring_quote>");
		soapRequestData.append("<bm:bottomLineDiscount_quote>0.0</bm:bottomLineDiscount_quote>");
		soapRequestData.append("<bm:bottomLineDiscount2_quote/>");
		soapRequestData.append("<bm:bottomLineDiscountType_quote>%</bm:bottomLineDiscountType_quote>");
		soapRequestData.append("<bm:totalMarginDollar_quote/>");
		soapRequestData.append("<bm:totalMiscCharges_quote/>");
		soapRequestData.append("<bm:totalMarginPercent_quote>0.0</bm:totalMarginPercent_quote>");
		soapRequestData.append("<bm:customUngrouped_quote>99</bm:customUngrouped_quote>");
		soapRequestData.append("<bm:renewalsHolderString_quote/>");
		soapRequestData.append("<bm:coTermDate_quote></bm:coTermDate_quote>");
		soapRequestData.append("<bm:marginSeekPct_quote></bm:marginSeekPct_quote>");
		soapRequestData.append("<bm:marginSeek_quote/>");
		soapRequestData.append("<bm:paymentType_quote></bm:paymentType_quote>");
		soapRequestData.append("<bm:pONumber_quote></bm:pONumber_quote>");
		soapRequestData.append("<bm:pODate_quote></bm:pODate_quote>");
		soapRequestData.append("<bm:attachPO_quote/>");
		soapRequestData.append("<bm:orderNotes_quote/>");
		soapRequestData.append("<bm:orderStatus_quote>Pending Submission</bm:orderStatus_quote>");
		soapRequestData.append("<bm:eRPOrderNumber_quote>Not Yet Created</bm:eRPOrderNumber_quote>");
		soapRequestData.append("<bm:processingOptions_quote/>");
		soapRequestData.append("<bm:shipmentTerms_quote/>");
		soapRequestData.append("<bm:shipmentCourier_quote/>");
		soapRequestData.append("<bm:requestedShipmentDate_quote/>");
		soapRequestData.append("<bm:targetInstallationDate_quote/>");
		soapRequestData.append("<bm:cRMContractId_quote/>");
		soapRequestData.append("<bm:partUpload_quote/>");
		soapRequestData.append("<bm:partUploadID_quote/>");
		soapRequestData.append("<bm:partUploadConfirm_quote/>");
		soapRequestData.append("<bm:crmContractIds_quote/>");
		soapRequestData.append("<bm:crmContractStartDates_quote/>");
		soapRequestData.append("<bm:crmContractEndDates_quote/>");
		soapRequestData.append("<bm:crmContractTerms_quote/>");
		soapRequestData.append("<bm:crmContractDaysTilExpirations_quote/>");
		soapRequestData.append("<bm:crmAssetIds_quote/>");
		soapRequestData.append("<bm:crmAssetParentContractIds_quote/>");
		soapRequestData.append("<bm:crmAssetQuantities_quote/>");
		soapRequestData.append("<bm:crmAssetPartNumbers_quote/>");
		soapRequestData.append("<bm:commissionHardware_quote>8.0</bm:commissionHardware_quote>");
		soapRequestData.append("<bm:commissionServices_quote>10.0</bm:commissionServices_quote>");
		soapRequestData.append("<bm:group1Total_quote>0</bm:group1Total_quote>");
		soapRequestData.append("<bm:group1HardwareTotal_quote>0</bm:group1HardwareTotal_quote>");
		soapRequestData.append("<bm:group1SoftwareTotal_quote>0</bm:group1SoftwareTotal_quote>");
		soapRequestData.append("<bm:group1ServicesTotal_quote>0</bm:group1ServicesTotal_quote>");
		soapRequestData.append("<bm:group2Total_quote>0</bm:group2Total_quote>");
		soapRequestData.append("<bm:group2HardwareTotal_quote>0</bm:group2HardwareTotal_quote>");
		soapRequestData.append("<bm:group2ServicesTotal_quote>0</bm:group2ServicesTotal_quote>");
		soapRequestData.append("<bm:group2SoftwareTotal_quote>0</bm:group2SoftwareTotal_quote>");
		soapRequestData.append("<bm:group3Total_quote>0</bm:group3Total_quote>");
		soapRequestData.append("<bm:group3HardwareTotal_quote>0</bm:group3HardwareTotal_quote>");
		soapRequestData.append("<bm:group3ServicesTotal_quote>0</bm:group3ServicesTotal_quote>");
		soapRequestData.append("<bm:group3SoftwareTotal_quote>0</bm:group3SoftwareTotal_quote>");
		soapRequestData.append("<bm:group4Total_quote>0</bm:group4Total_quote>");
		soapRequestData.append("<bm:group4HardwareTotal_quote>0</bm:group4HardwareTotal_quote>");
		soapRequestData.append("<bm:group4ServicesTotal_quote>0</bm:group4ServicesTotal_quote>");
		soapRequestData.append("<bm:group4SoftwareTotal_quote>0</bm:group4SoftwareTotal_quote>");
		soapRequestData.append("<bm:group5Total_quote>0</bm:group5Total_quote>");
		soapRequestData.append("<bm:group5HardwareTotal_quote>0</bm:group5HardwareTotal_quote>");
		soapRequestData.append("<bm:group5ServicesTotal_quote>0</bm:group5ServicesTotal_quote>");
		soapRequestData.append("<bm:group5SoftwareTotal_quote>0</bm:group5SoftwareTotal_quote>");
		soapRequestData.append("<bm:group6Total_quote>0</bm:group6Total_quote>");
		soapRequestData.append("<bm:group6HardwareTotal>0</bm:group6HardwareTotal>");
		soapRequestData.append("<bm:group6ServicesTotal_quote>0</bm:group6ServicesTotal_quote>");
		soapRequestData.append("<bm:group6SoftwareTotal_quote>0</bm:group6SoftwareTotal_quote>");
		soapRequestData.append("<bm:contractStartDate_quote>2016-04-27 00:00:00</bm:contractStartDate_quote>");
		soapRequestData.append("<bm:financeType_quote>Lease</bm:financeType_quote>");
		soapRequestData.append("<bm:paymentFrequency_quote>Monthly</bm:paymentFrequency_quote>");
		soapRequestData.append("<bm:paymentTypeFin_quote/>");
		soapRequestData.append("<bm:paymentMethod_quote>Arrears</bm:paymentMethod_quote>");
		soapRequestData.append("<bm:advancedPayment_quote>0</bm:advancedPayment_quote>");
		soapRequestData.append("<bm:paymentTerm_quote>36</bm:paymentTerm_quote>");
		soapRequestData.append("<bm:payment_quote>0</bm:payment_quote>");
		soapRequestData.append("<bm:yield_quote/>");
		soapRequestData.append("<bm:contractNumber_quote>1000-100423709</bm:contractNumber_quote>");
		soapRequestData.append("<bm:step_quote/>");
		soapRequestData.append("<bm:contractEffectiveDate_quote>2016-04-27 00:00:00</bm:contractEffectiveDate_quote>");
		soapRequestData.append("<bm:confidentialInformation_quote>true</bm:confidentialInformation_quote>");
		soapRequestData.append("<bm:endUsers_quote>true</bm:endUsers_quote>");
		soapRequestData.append("<bm:additionalContractNotes_quote/>");
		soapRequestData.append("<bm:endUserData_quote>true</bm:endUserData_quote>");
		soapRequestData.append("<bm:techSolutionsServiceGuide_quote>true</bm:techSolutionsServiceGuide_quote>");
		soapRequestData.append("<bm:service_quote>true</bm:service_quote>");
		soapRequestData.append("<bm:serviceOrder_quote>true</bm:serviceOrder_quote>");
		soapRequestData.append("<bm:serviceSchedule_quote>true</bm:serviceSchedule_quote>");
		soapRequestData.append("<bm:sLAAttachment_quote>true</bm:sLAAttachment_quote>");
		soapRequestData.append("<bm:taxes_quote>true</bm:taxes_quote>");
		soapRequestData.append("<bm:projectDuration_quote/>");
		soapRequestData.append("<bm:projectCost_quote/>");
		soapRequestData.append("<bm:servicesRate_quote/>");
		soapRequestData
				.append("<bm:proposedProjectInitiation_quote></bm:proposedProjectInitiation_quote>");
		soapRequestData.append("<bm:contractOption_quote>Standard Contract</bm:contractOption_quote>");
		soapRequestData.append("<bm:partnerURL_quote/>");
		soapRequestData.append("<bm:opportunityCurrencyCode_quote>"+this.currency_pref+"</bm:opportunityCurrencyCode_quote>");
		soapRequestData.append("<bm:crmProductPartNumners_quote/>");
		soapRequestData.append("<bm:crmProductIds/>");
		soapRequestData.append("<bm:signatureExists_quote>false</bm:signatureExists_quote>");
		soapRequestData.append(
				"<bm:signatureURL_quote></bm:signatureURL_quote>");
		soapRequestData.append("<bm:start_pl_html/>");
		soapRequestData.append("<bm:discountRate_pl_quote>7.5</bm:discountRate_pl_quote>");
		soapRequestData.append("<bm:year1NominalCost_quote>0</bm:year1NominalCost_quote>");
		soapRequestData.append("<bm:year2NominalCost_quote/>");
		soapRequestData.append("<bm:year3NominalCost_quote>0</bm:year3NominalCost_quote>");
		soapRequestData.append("<bm:year4NominalCost_quote>0</bm:year4NominalCost_quote>");
		soapRequestData.append("<bm:year5NominalCost_quote>0</bm:year5NominalCost_quote>");
		soapRequestData.append("<bm:year1NPVCost_quote>0</bm:year1NPVCost_quote>");
		soapRequestData.append("<bm:year2NPVCost_quote>0</bm:year2NPVCost_quote>");
		soapRequestData.append("<bm:year3NPVCost_quote>0</bm:year3NPVCost_quote>");
		soapRequestData.append("<bm:termsComplete_quote>false</bm:termsComplete_quote>");
		soapRequestData.append("<bm:year4NPVCost_quote>0</bm:year4NPVCost_quote>");
		soapRequestData.append("<bm:year5NPVCost_quote>0</bm:year5NPVCost_quote>");
		soapRequestData.append("<bm:creditCheckComplete_quote>false</bm:creditCheckComplete_quote>");
		soapRequestData.append("<bm:billToAddressComplete_quote>false</bm:billToAddressComplete_quote>");
		soapRequestData.append("<bm:year1NominalRevenue_quote>0</bm:year1NominalRevenue_quote>");
		soapRequestData.append("<bm:quoteToAddressComplete_quote>false</bm:quoteToAddressComplete_quote>");
		soapRequestData.append("<bm:year2NominalRevenue_quote>0</bm:year2NominalRevenue_quote>");
		soapRequestData.append("<bm:year3NominalRevenue_quote>0</bm:year3NominalRevenue_quote>");
		soapRequestData.append("<bm:pricingFinalized_quote>false</bm:pricingFinalized_quote>");
		soapRequestData.append("<bm:year4NominalRevenue_quote>0</bm:year4NominalRevenue_quote>");
		soapRequestData.append("<bm:contractFinalized_quote>false</bm:contractFinalized_quote>");
		soapRequestData.append("<bm:year5NominalRevenue_quote>0</bm:year5NominalRevenue_quote>");
		soapRequestData.append("<bm:year1NPVRevenue_quote>0</bm:year1NPVRevenue_quote>");
		soapRequestData.append("<bm:year2NPVRevenue_quote>0</bm:year2NPVRevenue_quote>");
		soapRequestData.append("<bm:year3NPVRevenue_quote>0</bm:year3NPVRevenue_quote>");
		soapRequestData.append("<bm:year4NPVRevenue_quote>0</bm:year4NPVRevenue_quote>");
		soapRequestData.append("<bm:year5NPVRevenue_quote>0</bm:year5NPVRevenue_quote>");
		soapRequestData.append("<bm:year1NominalPL_quote>0</bm:year1NominalPL_quote>");
		soapRequestData.append("<bm:year2NominalPL_quote>0</bm:year2NominalPL_quote>");
		soapRequestData.append("<bm:year3NominalPL_quote>0</bm:year3NominalPL_quote>");
		soapRequestData.append("<bm:year4NominalPL_quote>0</bm:year4NominalPL_quote>");
		soapRequestData.append("<bm:year5NominalPL_quote>0</bm:year5NominalPL_quote>");
		soapRequestData.append("<bm:year1NPVPL_quote>0</bm:year1NPVPL_quote>");
		soapRequestData.append("<bm:year2NPVPL_quote>0</bm:year2NPVPL_quote>");
		soapRequestData.append("<bm:year3NPVPL_quote>0</bm:year3NPVPL_quote>");
		soapRequestData.append("<bm:year4NPVPL_quote>0</bm:year4NPVPL_quote>");
		soapRequestData.append("<bm:year5NPVPL_quote>0</bm:year5NPVPL_quote>");
		soapRequestData.append("<bm:year1NominalReturn_quote>0.0</bm:year1NominalReturn_quote>");
		soapRequestData.append("<bm:year2NominalReturn_quote>0.0</bm:year2NominalReturn_quote>");
		soapRequestData.append("<bm:year3NominalReturn_quote>0.0</bm:year3NominalReturn_quote>");
		soapRequestData.append("<bm:year4NominalReturn_quote>0.0</bm:year4NominalReturn_quote>");
		soapRequestData.append("<bm:year5NominalReturn_quote>0.0</bm:year5NominalReturn_quote>");
		soapRequestData.append("<bm:year1NPVReturn_quote>0.0</bm:year1NPVReturn_quote>");
		soapRequestData.append("<bm:year2NPVReturn_quote>0.0</bm:year2NPVReturn_quote>");
		soapRequestData.append("<bm:year3NPVReturn_quote>0.0</bm:year3NPVReturn_quote>");
		soapRequestData.append("<bm:year4NPVReturn_quote>0.0</bm:year4NPVReturn_quote>");
		soapRequestData.append("<bm:year5NPVReturn_quote>0.0</bm:year5NPVReturn_quote>");
		soapRequestData.append("<bm:nominalRevenue_quote>0</bm:nominalRevenue_quote>");
		soapRequestData.append("<bm:nPVRevenue_quote>0</bm:nPVRevenue_quote>");
		soapRequestData.append("<bm:nominalCost_quote>0</bm:nominalCost_quote>");
		soapRequestData.append("<bm:nPVCost_quote>0</bm:nPVCost_quote>");
		soapRequestData.append("<bm:nominalPL_quote>0</bm:nominalPL_quote>");
		soapRequestData.append("<bm:nPVPL_quote>0</bm:nPVPL_quote>");
		soapRequestData.append("<bm:nominalReturn_quote>0.0</bm:nominalReturn_quote>");
		soapRequestData.append("<bm:nPVReturn_quote>0.0</bm:nPVReturn_quote>");
		soapRequestData.append("<bm:coverPageOption_quote>Blue</bm:coverPageOption_quote>");
		soapRequestData.append("<bm:amortizationInterestRate_quote>5.5</bm:amortizationInterestRate_quote>");
		soapRequestData.append("<bm:crmAssetPrices_quote/>");
		soapRequestData.append("<bm:subtotalPostQuoteDiscountsConverted_quote/>");
		soapRequestData.append("<bm:conversionCurrency_quote>USD</bm:conversionCurrency_quote>");
		soapRequestData.append("<bm:manualConversionRate_quote>1.0</bm:manualConversionRate_quote>");
		soapRequestData.append("<bm:billingMethod_quote>E-Mail</bm:billingMethod_quote>");
		soapRequestData.append("<bm:paymentMethod2_quote>Check</bm:paymentMethod2_quote>");
		soapRequestData.append("<bm:financingOptions_quote>First Financials</bm:financingOptions_quote>");
		soapRequestData.append("<bm:paymentOptions_quote>Monthly</bm:paymentOptions_quote>");
		soapRequestData.append("<bm:downPayment_quote>0</bm:downPayment_quote>");
		soapRequestData.append("<bm:paymentTermCalc_quote>36</bm:paymentTermCalc_quote>");
		soapRequestData.append("<bm:paymentAmountFinance_quote/>");
		soapRequestData.append("<bm:leaseFactor_quote>0</bm:leaseFactor_quote>");
		soapRequestData.append("<bm:financeFactor_quote>0</bm:financeFactor_quote>");
		soapRequestData.append("<bm:hardwareCheck_quote>false</bm:hardwareCheck_quote>");
		soapRequestData.append("<bm:softwareCheck_quote>false</bm:softwareCheck_quote>");
		soapRequestData.append("<bm:serviceCheck_quote>false</bm:serviceCheck_quote>");
		soapRequestData.append("<bm:group1Check_quote>false</bm:group1Check_quote>");
		soapRequestData.append("<bm:group2Check_quote>false</bm:group2Check_quote>");
		soapRequestData.append("<bm:group3Check_quote>false</bm:group3Check_quote>");
		soapRequestData.append("<bm:group4Check_quote>false</bm:group4Check_quote>");
		soapRequestData.append("<bm:group5Check_quote>false</bm:group5Check_quote>");
		soapRequestData.append("<bm:group6Check_quote>false</bm:group6Check_quote>");
		soapRequestData.append("<bm:hardware1Check_quote>false</bm:hardware1Check_quote>");
		soapRequestData.append("<bm:software1Check_quote>false</bm:software1Check_quote>");
		soapRequestData.append("<bm:service1Check_quote>false</bm:service1Check_quote>");
		soapRequestData.append("<bm:hardware2Check_quote>false</bm:hardware2Check_quote>");
		soapRequestData.append("<bm:software2Check_quote>false</bm:software2Check_quote>");
		soapRequestData.append("<bm:service2Check_quote>false</bm:service2Check_quote>");
		soapRequestData.append("<bm:hardware3Check_quote>false</bm:hardware3Check_quote>");
		soapRequestData.append("<bm:software3Check_quote>false</bm:software3Check_quote>");
		soapRequestData.append("<bm:service3Check_quote>false</bm:service3Check_quote>");
		soapRequestData.append("<bm:hardware4Check_quote>false</bm:hardware4Check_quote>");
		soapRequestData.append("<bm:software4Check_quote>false</bm:software4Check_quote>");
		soapRequestData.append("<bm:service4Check_quote>false</bm:service4Check_quote>");
		soapRequestData.append("<bm:hardware5Check_quote>false</bm:hardware5Check_quote>");
		soapRequestData.append("<bm:software5Check_quote>false</bm:software5Check_quote>");
		soapRequestData.append("<bm:service5Check_quote>false</bm:service5Check_quote>");
		soapRequestData.append("<bm:hardware6Check_quote>false</bm:hardware6Check_quote>");
		soapRequestData.append("<bm:software6Check_quote>false</bm:software6Check_quote>");
		soapRequestData.append("<bm:service6Check_quote>false</bm:service6Check_quote>");
		soapRequestData.append("<bm:aS89095Check_quote>false</bm:aS89095Check_quote>");
		soapRequestData.append("<bm:aS25104Check_quote>false</bm:aS25104Check_quote>");
		soapRequestData.append("<bm:aS85025Check_quote>false</bm:aS85025Check_quote>");
		soapRequestData.append("<bm:aS86009Check_quote>false</bm:aS86009Check_quote>");
		soapRequestData.append("<bm:productDataSheet_quote>false</bm:productDataSheet_quote>");
		soapRequestData.append("<bm:opportunityProbability_quote>0.0</bm:opportunityProbability_quote>");
		soapRequestData.append("<bm:previousDiscount1_quote/>");
		soapRequestData.append("<bm:previousDiscount2_quote/>");
		soapRequestData.append("<bm:previousDiscount3_quote/>");
		soapRequestData.append("<bm:averagePreviousDiscount_quote/>");
		soapRequestData.append("<bm:previousMargin1_quote/>");
		soapRequestData.append("<bm:previousMargin2_quote/>");
		soapRequestData.append("<bm:previousMargin3_quote/>");
		soapRequestData.append("<bm:averagePreviousMargin_quote/>");
		soapRequestData.append("<bm:previousMargin3percent_quote/>");
		soapRequestData.append("<bm:previousMargin2percent_quote/>");
		soapRequestData.append("<bm:previousMargin1percent_quote/>");
		soapRequestData.append("<bm:previousDiscount1percent_quote/>");
		soapRequestData.append("<bm:previousDiscount2percent_quote/>");
		soapRequestData.append("<bm:previousDiscount3percent_quote/>");
		soapRequestData.append("<bm:financedAmount_quote>0</bm:financedAmount_quote>");
		soapRequestData.append("<bm:thetotalCost_quote>0</bm:thetotalCost_quote>");
		soapRequestData.append("<bm:rateFactor_quote>3.51</bm:rateFactor_quote>");
		soapRequestData.append("<bm:commissionSoftware_quote>6.0</bm:commissionSoftware_quote>");
		soapRequestData.append("<bm:calculatedMaxMargin_quote>0</bm:calculatedMaxMargin_quote>");
		soapRequestData.append("<bm:calculatedMaxMarginPercent_quote>0.0</bm:calculatedMaxMarginPercent_quote>");
		soapRequestData.append("<bm:lineItemDiscounts_annual>0</bm:lineItemDiscounts_annual>");
		soapRequestData.append("<bm:sumOfExtendedNetPrice_quote>0</bm:sumOfExtendedNetPrice_quote>");
		soapRequestData.append("<bm:monthly_pl_html>0</bm:monthly_pl_html>");
		soapRequestData.append("<bm:upfront_pl_quote>0</bm:upfront_pl_quote>");
		soapRequestData.append("<bm:eligibleFinancing_quote>0</bm:eligibleFinancing_quote>");
		soapRequestData.append("<bm:totalHardwareCost_quote>0</bm:totalHardwareCost_quote>");
		soapRequestData.append("<bm:hardwareMargin_quote>0</bm:hardwareMargin_quote>");
		soapRequestData.append("<bm:hardwareMarginPercent_quote>0.0</bm:hardwareMarginPercent_quote>");
		soapRequestData.append("<bm:totalSoftwareCost_quote>0</bm:totalSoftwareCost_quote>");
		soapRequestData.append("<bm:softwareMargin_quote>0</bm:softwareMargin_quote>");
		soapRequestData.append("<bm:softwareMarginPercent_quote>0.0</bm:softwareMarginPercent_quote>");
		soapRequestData.append("<bm:totalServicesCost_quote>0</bm:totalServicesCost_quote>");
		soapRequestData.append("<bm:servicesMargin_quote>0</bm:servicesMargin_quote>");
		soapRequestData.append("<bm:servicesMarginPercent_quote>0.0</bm:servicesMarginPercent_quote>");
		soapRequestData.append("<bm:commissionServicesval_quote/>");
		soapRequestData.append("<bm:commissionHardwareval_quote/>");
		soapRequestData.append("<bm:commissionSoftwareval_quote/>");
		soapRequestData.append("<bm:interestRate_quote>0.029</bm:interestRate_quote>");
		soapRequestData.append("<bm:promotionalDiscounts>0</bm:promotionalDiscounts>");
		soapRequestData.append("<bm:listPriceAnnual_quote>0</bm:listPriceAnnual_quote>");
		soapRequestData.append("<bm:subtotalAnnual_quote>0</bm:subtotalAnnual_quote>");
		soapRequestData.append("<bm:customGroup1Subtotal_quote>0</bm:customGroup1Subtotal_quote>");
		soapRequestData.append("<bm:customGroup2Subtotal_quote>0</bm:customGroup2Subtotal_quote>");
		soapRequestData.append("<bm:customGroup3Subtotal_quote/>");
		soapRequestData.append("<bm:customGroup4Subtotal_quote>0</bm:customGroup4Subtotal_quote>");
		soapRequestData.append("<bm:customGroup5Subtotal_quote>0</bm:customGroup5Subtotal_quote>");
		soapRequestData.append("<bm:customGroup6Subtotal_quote>0</bm:customGroup6Subtotal_quote>");
		soapRequestData.append("<bm:customGroup1SubtotalRecurring_quote>0</bm:customGroup1SubtotalRecurring_quote>");
		soapRequestData.append("<bm:customGroup2SubtotalRecurring_quote>0</bm:customGroup2SubtotalRecurring_quote>");
		soapRequestData.append("<bm:customGroup3SubtotalRecurring_quote>0</bm:customGroup3SubtotalRecurring_quote>");
		soapRequestData.append("<bm:customGroup4SubtotalRecurring_quote>0</bm:customGroup4SubtotalRecurring_quote>");
		soapRequestData.append("<bm:customGroup5SubtotalRecurring_quote>0</bm:customGroup5SubtotalRecurring_quote>");
		soapRequestData.append("<bm:customGroup6SubtotalRecurring_quote>0</bm:customGroup6SubtotalRecurring_quote>");
		soapRequestData.append("<bm:ungroupedSubtotalRecurring_quote>0</bm:ungroupedSubtotalRecurring_quote>");
		soapRequestData.append("<bm:ungroupSubtotal_quote>0</bm:ungroupSubtotal_quote>");
		soapRequestData.append("<bm:subtotalPreQuoteDiscounts_quote>0</bm:subtotalPreQuoteDiscounts_quote>");
		soapRequestData.append("<bm:bottomLineDiscountPercent_quote>0.0</bm:bottomLineDiscountPercent_quote>");
		soapRequestData.append("<bm:bottomLineDiscountAmt_quote>0</bm:bottomLineDiscountAmt_quote>");
		soapRequestData.append("<bm:subtotalPostQuoteDiscounts_quote/>");
		soapRequestData.append("<bm:totalListPriceRecurring_quote/>");
		soapRequestData.append("<bm:annualNetPrice_quote>0</bm:annualNetPrice_quote>");
		soapRequestData.append("<bm:capex_pl_quote>0</bm:capex_pl_quote>");
		soapRequestData.append("<bm:totalCommission_quote/>");
		soapRequestData.append("<bm:totalMarginPercentEDD_quote>0.0</bm:totalMarginPercentEDD_quote>");
		soapRequestData.append("<bm:totalDiscountPercent_quote>0.0</bm:totalDiscountPercent_quote>");
		soapRequestData.append("<bm:totalLineItemDiscountsRecurring_quote/>");
		soapRequestData.append("<bm:totalLineItemDiscounts_quote/>");
		soapRequestData.append("<bm:totalMargin_quote>0</bm:totalMargin_quote>");
		soapRequestData.append("<bm:oneTimeTotal_quote/>");
		soapRequestData.append("<bm:recurringTotal_quote/>");
		soapRequestData.append("<bm:totalNetPriceRecurring_quote/>");
		soapRequestData.append("<bm:totalMarginDollRecurring_quote/>");
		soapRequestData.append("<bm:totalNetPrice_quote/>");
		soapRequestData.append("<bm:totalMarginPercentRecurring_quote/>");
		soapRequestData.append("<bm:totalMarginDollOneTime_quote/>");
		soapRequestData.append("<bm:softwareTotal_quote/>");
		soapRequestData.append("<bm:servicesTotal_quote/>");
		soapRequestData.append("<bm:hardwareTotal_quote/>");
		soapRequestData.append("<bm:totalMarginPercentOneTime_quote/>");
		soapRequestData.append("<bm:totalCost_quote/>");
		soapRequestData.append("<bm:totalListPrice_quote/>");
		soapRequestData.append("<bm:totalCostRecurring_quote/>");
		soapRequestData.append("<bm:monthly_cost_pl_quote>0</bm:monthly_cost_pl_quote>");
		soapRequestData.append("<bm:costAnnual_quote>0</bm:costAnnual_quote>");
		soapRequestData.append("<bm:totalDiscount_quote>0</bm:totalDiscount_quote>");
		soapRequestData.append("<bm:totalContractValueSum_quote>0</bm:totalContractValueSum_quote>");
		soapRequestData.append("<bm:total_quote>0</bm:total_quote>");
		soapRequestData.append("<bm:originalHardwareCommission_quote>0</bm:originalHardwareCommission_quote>");
		soapRequestData.append("<bm:originalSoftwareCommission_quote/>");
		soapRequestData.append("<bm:originalServicesCommission_quote/>");
		soapRequestData.append("<bm:originalTotalCommission_quote>0</bm:originalTotalCommission_quote>");
		soapRequestData.append("<bm:sumOfExtendedPrice_quote/>");
		soapRequestData.append("<bm:originalHardwareTotal_quote>0</bm:originalHardwareTotal_quote>");
		soapRequestData.append("<bm:originalSoftwareTotal_quote>0</bm:originalSoftwareTotal_quote>");
		soapRequestData.append("<bm:originalServicesTotal_quote>0</bm:originalServicesTotal_quote>");
		soapRequestData.append("<bm:originalContractValue_quote/>");
		soapRequestData.append("<bm:commissionLost_quote>0</bm:commissionLost_quote>");
		soapRequestData.append("<bm:includeTableOfContents_quote>false</bm:includeTableOfContents_quote>");
		soapRequestData.append("<bm:previousQuoteFlag_quote>false</bm:previousQuoteFlag_quote>");
		soapRequestData.append("<bm:contractTermDuplicate_quote>36</bm:contractTermDuplicate_quote>");
		soapRequestData.append("<bm:showDiscountsAs_quote>true</bm:showDiscountsAs_quote>");
		soapRequestData.append("<bm:draft_quote>false</bm:draft_quote>");
		soapRequestData.append("<bm:sumOfExtendedCost_quote/>");
		soapRequestData.append("<bm:selectPromotion_quote>Choose a promotion</bm:selectPromotion_quote>");
		soapRequestData.append("<bm:shippingTotal_quote>0</bm:shippingTotal_quote>");
		soapRequestData.append("<bm:includeShipping_quote>false</bm:includeShipping_quote>");
		soapRequestData.append("<bm:promotionRequirementsMet_quote>false</bm:promotionRequirementsMet_quote>");
		soapRequestData.append("<bm:promotionEligble>false</bm:promotionEligble>");
		soapRequestData.append("<bm:technicalReview_quote>False</bm:technicalReview_quote>");
		soapRequestData.append("<bm:attachLeaseAddendum_quote>false</bm:attachLeaseAddendum_quote>");
		soapRequestData.append("<bm:sendOrderTo_quote>EBS</bm:sendOrderTo_quote>");
		soapRequestData.append("<bm:dOOCounter_quote>1</bm:dOOCounter_quote>");
		soapRequestData
				.append("<bm:version_number_createNewVersion_quote>1</bm:version_number_createNewVersion_quote>");
		soapRequestData.append("<bm:parent_transaction_id_createNewVersion_quote/>");
		soapRequestData.append("<bm:oSCCurrentTime_quote/>");
		soapRequestData.append("<bm:oSCFileAttachment/>");
		soapRequestData.append("<bm:_docuSignSignatureSet_quote_esig_file_attachment/>");
		soapRequestData.append("<bm:_docuSignSignatureSet_quote_esig_recipients/>");
		soapRequestData.append("<bm:_docuSignSignatureSet_quote_esig_date_modified/>");
		soapRequestData.append("<bm:_docuSignSignatureSet_quote_esig_envelope_id/>");
		soapRequestData.append(
				"<bm:_docuSignSignatureSet_quote_esig_status>Not Sent</bm:_docuSignSignatureSet_quote_esig_status>");
		soapRequestData.append("<bm:review/>");
		soapRequestData.append("<bm:commentsToTechnical/>");
		soapRequestData.append("<bm:engineeringOptionContainerHidden/>");
		soapRequestData.append("<bm:engineeringCommentsContainerHidden/>");
		soapRequestData.append("<bm:engineeringPriceContainerHidden/>");
		soapRequestData.append("<bm:engineeringReviewflag>false</bm:engineeringReviewflag>");
		soapRequestData.append("<bm:firstName_quote/>");
		soapRequestData.append("<bm:lastName_quote/>");
		soapRequestData.append("<bm:emailAddress_quote/>");
		soapRequestData.append("<bm:_transaction_total>0</bm:_transaction_total>");
		soapRequestData.append("<bm:totalContractValueLabel>Total Contract Value</bm:totalContractValueLabel>");
		soapRequestData.append("<bm:opportunityStage_quote/>");
		soapRequestData.append("<bm:partnerLevel_quote/>");
		soapRequestData.append("<bm:userType_quote>FullAccess</bm:userType_quote>");
		soapRequestData.append("<bm:showColumnsPRM/>");
		soapRequestData.append("<bm:obsolete_attributes>");
		soapRequestData.append("<bm:__cm_bs_service_unsaved_data>false</bm:__cm_bs_service_unsaved_data>");
		soapRequestData.append("<bm:__cm_bs_service_new_data>false</bm:__cm_bs_service_new_data>");
		soapRequestData.append("<bm:_price_quantity>1</bm:_price_quantity>");
		soapRequestData.append("<bm:__cm_bs_service_ignore_override>false</bm:__cm_bs_service_ignore_override>");
		soapRequestData.append("</bm:obsolete_attributes>");
		soapRequestData.append("<bm:approval_history/>");
		soapRequestData.append("<bm:approval_status/>");
		soapRequestData.append("<bm:sub_documents/>");
		soapRequestData.append("<bm:rule_data>");
		/*
		 * soapRequestData.append(
		 * "<bm:bottomLineDiscountPercent_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:contracSection62GeneralLOL_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:taxes_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append(
		 * "<bm:group6ServicesTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group4HardwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:goodDeal_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append("<bm:group4Total_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:contractDirectionsHTML_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:contractSection4Termination_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:group5HardwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:promoCodesPromotion5_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group5ServicesTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:promoCodesPromotion3_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:previousDealData_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:promoDetailFreeShipping_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:promoDetailPromotion3_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:contractSection5DisclaimerOfWarrantiesHeader_quote bm:constrained="
		 * false" bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:endUsers_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append(
		 * "<bm:confidentialInformation_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group2Total_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append(
		 * "<bm:promoCodesPromotion1_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group4ServicesTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:promoCodesPromotion4_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:serviceSchedule_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:previousDeals_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append(
		 * "<bm:contractSection1ServicesHeader_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:group3SoftwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group6SoftwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:contractSection8Confidentiality_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:contractSection31WhenDueBCD_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:group5SoftwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:endUserData_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append("<bm:maximumTotal_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:group6HardwareTotal bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append("<bm:sowSection1Header_quote bm:constrained="
		 * false" bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:group6Total_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append(
		 * "<bm:contractSection7IndemnificationHeader_quote bm:constrained="
		 * false" bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:group3HardwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group2SoftwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:sLAAttachment_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append("<bm:fairDeal_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:contractSection3PaymentHeader_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:commissionLost_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:contractSection2TermHeader_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:promotionalDiscounts bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:promoDetailPromotion2_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group4SoftwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:contractSection1Services bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append("<bm:service_quote bm:constrained="
		 * false" bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:group2ServicesTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group1Total_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append("<bm:minimumTotal_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:additionalContractNotes_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:promoDetailPromotion1_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:contractSection20DefinitionsHeader_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:excellentDeal_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append(
		 * "<bm:promoCodesPromotion2_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group5Total_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append(
		 * "<bm:group1ServicesTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:contractSection4TerminationHeader_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:group3Total_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append(
		 * "<bm:contractSection7Indemnification_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:contractSection8ConfidentialityHeader_quote bm:constrained="
		 * false" bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:promoDetailPromotion5_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:promoCodesFreeShipping_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group1HardwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:partUploadConfirm_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group2HardwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:contractSection5DisclaimerOfWarranties_quote bm:constrained="
		 * false" bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:techSolutionsServiceGuide_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:contractSection32Dispute_quote bm:constrained="false
		 * " bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:contractSection6LimitationOnLiabilityHeader_quote bm:constrained="
		 * false" bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:contractSection2Term_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:promoDetailPromotion4_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:contractSection61WaiverConsequentialDamages_quote bm:constrained="
		 * false" bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:serviceOrder_quote bm:constrained="false" bm:hidden="true"/>");
		 * soapRequestData.append(
		 * "<bm:whiteCoverPagePreview_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:scontractSection63SubcapForCustomerData_quote bm:constrained="
		 * false" bm:hidden="true"/>"); soapRequestData.append(
		 * "<bm:group1SoftwareTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>"); soapRequestData.append(
		 * "<bm:group3ServicesTotal_quote bm:constrained="false" bm:hidden="
		 * true"/>");
		 */
		soapRequestData.append("</bm:rule_data>");
		soapRequestData.append("</bm:transaction>");
		soapRequestData.append("</bm:data_xml>");
		soapRequestData.append("<bm:action_data>");
		soapRequestData.append("<bm:action_var_name>cleanSave_t</bm:action_var_name>");
		soapRequestData.append("<bm:_bm_cm_new_transaction_currency/>");
		soapRequestData.append("<bm:performer_comment/>");
		soapRequestData.append("<bm:reason_var_name/>");
		soapRequestData.append("<bm:performer_name/>");
		soapRequestData.append("<bm:performer_type/>");
		soapRequestData.append("<bm:performer_company_name/>");
		soapRequestData.append("</bm:action_data>");
		soapRequestData.append("<bm:sub_step_name/>");
		soapRequestData.append("<bm:buyer_user_name>"+this.buyer_user_name+"</bm:buyer_user_name>");
		soapRequestData.append("<bm:currency_pref>\"" + this.currency_pref + "</bm:currency_pref>");
		soapRequestData.append("<bm:status>0</bm:status>");
		soapRequestData.append("<bm:update_count>2</bm:update_count>");
		soapRequestData.append("<bm:language_pref>English</bm:language_pref>");
		soapRequestData.append("<bm:offline_user_id>-1</bm:offline_user_id>");
		soapRequestData.append("<bm:num_transitions>0</bm:num_transitions>");
		soapRequestData.append("</bm:transaction>");
		soapRequestData.append("</bm:updateTransaction>");

		/*
		 * for (HashMap patameter : patameterMap) {
		 * soapRequestData.append("<bm:each_record>");
		 * 
		 * Set set=patameter.entrySet(); Iterator it=set.iterator();
		 * while(it.hasNext()){ Map.Entry me=(Map.Entry)it.next();
		 * System.out.println(me.getKey()+":"+me.getValue());
		 * soapRequestData.append("<bm:"+me.getKey()+">"+me.getValue()+"</bm:"+
		 * me.getKey()+">"); }
		 * 
		 * soapRequestData.append("</bm:each_record>"); }
		 */
		soapRequestData.append("</soapenv:Body>");
		soapRequestData.append("</soapenv:Envelope>");
		return soapRequestData.toString();
	}

}
