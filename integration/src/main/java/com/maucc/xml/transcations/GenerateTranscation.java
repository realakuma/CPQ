package com.maucc.xml.transcations;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.maucc.xml.transcations.CreateTransactionResponse;

import java.io.FileReader;
import javax.xml.bind.*;
import javax.xml.stream.*;

public class GenerateTranscation {
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException, XMLStreamException
	{
	/*
	JAXBContext con = JAXBContext.newInstance("com.maucc.xml.transcations");
	ObjectFactory factory = new ObjectFactory();
	CreateTransactionResponse ctresponse;
	*/
		
		XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("transcation.xml"));
        xsr.nextTag(); // Advance to Envelope tag
        xsr.nextTag(); // Advance to Body tag
        xsr.nextTag(); // Advance to getNumberResponse tag
        System.out.println(xsr);
        JAXBContext jaxbContext = JAXBContext.newInstance("com.maucc.xml.transcations");  
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<CreateTransactionResponse>  je = unmarshaller.unmarshal(xsr, CreateTransactionResponse.class);
        CreateTransactionResponse ctresponse=je.getValue();
        System.out.println(ctresponse.getStatus().getMessage());
        /*
     JAXBContext jaxbContext = JAXBContext.newInstance("com.maucc.xml.transcations");  
     Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
     CreateTransactionResponse ctresponse= (CreateTransactionResponse) jaxbUnmarshaller.unmarshal(file);  
     //System.out.println(ctresponse.getCreateTransactionResponse().getStatus().getMessage()); 
     */

	}

}
