package com.maucc.xml.accounts;

import java.awt.List;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.maucc.util.Convert;
import com.maucc.util.ZIP;
import com.maucc.util.MySFTP;
import com.maucc.xml.accounts.RecordList.EachRecord;

public class GenerateAccountsXml {

	public static void main(String[] args) throws JAXBException {

		HashMap<String, String>[] patameterMap = new HashMap[2];
		patameterMap[0] = new HashMap<String, String>();
		patameterMap[0].put("CustomerId", "778");
		patameterMap[0].put("CompanyName", "cpuabc");
		patameterMap[1] = new HashMap<String, String>();
		patameterMap[1].put("CustomerId", "779");
		patameterMap[1].put("CompanyName", "cpuabc");

		GenerateAccountsXml gax = new GenerateAccountsXml();
		String xmlfilename = gax.genXmlFile("add", patameterMap);
		// 压缩zip
		ZIP zip = new ZIP(xmlfilename.substring(0, xmlfilename.length() - 4) + ".zip");
		zip.compress(xmlfilename);
		// 生成upload_list.xml
		xmlfilename = Convert.getFileNameByFullPath(xmlfilename);
		String uploadfilepath = gax.genUploadListFile(xmlfilename);

		/*
		 * JAXBContext con = JAXBContext.newInstance("com.maucc.xml.accounts");
		 * ObjectFactory factory = new ObjectFactory();
		 * 
		 * RecordList recordlist=factory.createRecordList();
		 * 
		 * 
		 * 
		 * ArrayList<EachRecord> listeachrecords=new ArrayList<EachRecord>();
		 * 
		 * 
		 * recordlist.setSiteVersion("15.2.4");
		 * 
		 * for (int i=1;i<=3;i++) { RecordList.EachRecord eachrecord= new
		 * RecordList.EachRecord(); eachrecord.setCustomerId("abc");
		 * eachrecord.setCompanyName("xman");
		 * 
		 * eachrecord.setCategory("bm_crm"); eachrecord.setAction("add");
		 * 
		 * eachrecord.setCustomerRep(""); listeachrecords.add(eachrecord); }
		 * 
		 * 
		 * 
		 * 
		 * recordlist.eachRecord=listeachrecords;
		 * 
		 * Marshaller marshaller = con.createMarshaller();
		 * marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 * marshaller.marshal(recordlist, new File("a.xml"));
		 */
	}

	@SuppressWarnings("finally")
	public String genXmlFile(String action, HashMap[] patameterMap) {
		String FilePath = "";
		Date date = new Date();
		DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");

		try {
			JAXBContext con = JAXBContext.newInstance("com.maucc.xml.accounts");
			ObjectFactory factory = new ObjectFactory();
			RecordList recordlist = factory.createRecordList();
			ArrayList<EachRecord> listeachrecords = new ArrayList<EachRecord>();
			recordlist.setSiteVersion("15.2.4");

			if (patameterMap != null) {

				for (HashMap patameter : patameterMap) {

					RecordList.EachRecord eachrecord = new RecordList.EachRecord();
					eachrecord.setCustomerId(patameter.get("CustomerId").toString());
					eachrecord.setCompanyName(patameter.get("CompanyName").toString());
					listeachrecords.add(eachrecord);
				}

			}

			recordlist.eachRecord = listeachrecords;
			Marshaller marshaller = con.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			System.out.println(new File("crm_" + format2.format(date).toString() + ".xml").getAbsolutePath());
			FilePath = new File("crm_" + format2.format(date).toString() + ".xml").getAbsolutePath();
			marshaller.marshal(recordlist, new File("crm_" + format2.format(date).toString() + ".xml"));

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			FilePath = e.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FilePath = e.getMessage();
		} finally {
			return FilePath;
		}

	}

	public String genUploadListFile(String FilePath) {
		String uploadFilePath = "";

		try {
			JAXBContext con = JAXBContext.newInstance("com.maucc.xml.accounts.uploadfilelist");
			com.maucc.xml.accounts.uploadfilelist.ObjectFactory factory = new com.maucc.xml.accounts.uploadfilelist.ObjectFactory();
			com.maucc.xml.accounts.uploadfilelist.Files files = factory.createFiles();
			com.maucc.xml.accounts.uploadfilelist.Files.File file = new com.maucc.xml.accounts.uploadfilelist.Files.File();
			file.setName(FilePath);
			file.setType("REGULAR");
			files.setFile(file);
			Marshaller marshaller = con.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			uploadFilePath = new File("upload_list.xml").getAbsolutePath();
			marshaller.marshal(files, new File("upload_list.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			uploadFilePath = e.getMessage();
		}

		return uploadFilePath;

	}

}
