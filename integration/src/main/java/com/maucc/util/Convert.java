package com.maucc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.*;
import javax.xml.stream.*;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.InputSource;

public class Convert {

	public static XMLStreamReader GetSOAPResult(InputStream is) {
		try {
			XMLInputFactory xif = XMLInputFactory.newFactory();
			XMLStreamReader xsr = xif.createXMLStreamReader(is);
			xsr.nextTag();
			xsr.nextTag(); // Advance to Body tag
			xsr.nextTag(); // Advance to getNumberResponse tag
			return xsr;
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} // Advance to Envelope tag
	}

	public static XMLStreamReader GetSOAPResult(String FileName) {
		try {
			XMLInputFactory xif = XMLInputFactory.newFactory();
			XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("FileName"));
			xsr.nextTag();
			xsr.nextTag(); // Advance to Body tag
			xsr.nextTag(); // Advance to getNumberResponse tag
			return xsr;
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} // Advance to Envelope tag
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getFileNameByFullPath(String FileName) {
		String fileName = "";
		try {

			File tempFile = new File(FileName.trim());

			fileName = tempFile.getName();

			// System.out.println("方法一：fileName = " + fileName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return fileName;

	}

	public static String changeXmlNodeforTransaction(InputStream is)
	{
		Document doc =null;
		SAXBuilder builder= new SAXBuilder();
		Element response=null;
		String newXml="";
		
		try{
			
			doc=builder.build(is);
			response=doc.getRootElement();
			Namespace soapenv = Namespace.getNamespace("soapenv","http://schemas.xmlsoap.org/soap/envelope/");
			Namespace bm = Namespace.getNamespace("bm","urn:soap.bigmachines.com");


			Element body=response.getChild("Body",soapenv);
			Element ctrp=body.getChild("createTransactionResponse",bm);
			Element trans1=ctrp.getChild("transaction",bm);
			Element dataXml=trans1.getChild("data_xml",bm);
			Element trans2=dataXml.getChild("transaction",bm);
			trans2.setName("quote_process");
			XMLOutputter xmlopt = new XMLOutputter();
			newXml=xmlopt.outputString(doc);
			System.out.println("----" + xmlopt.outputString(doc));
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
        
        return newXml;
		
	}
	
	
	public static void main(String[] args) throws Exception 
	   {
		InputStream in = new FileInputStream("trans.xml");
		changeXmlNodeforTransaction(in);
		
	   }
	
	

}
