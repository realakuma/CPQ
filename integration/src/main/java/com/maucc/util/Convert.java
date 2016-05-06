package com.maucc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

import javax.xml.bind.*;
import javax.xml.stream.*;

public class Convert {
	
	
	public static XMLStreamReader GetSOAPResult(InputStream is)
	{
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
	
	public static XMLStreamReader GetSOAPResult(String FileName)
	{
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
        catch(FileNotFoundException e)
        {
        	e.printStackTrace();
			return null;
        }
	}
	
	public static String getFileNameByFullPath(String FileName)
	{
		 String fileName ="";
		try{
        
			File tempFile =new File(FileName.trim());  
        
			fileName=tempFile.getName();  
          
        //System.out.println("方法一：fileName = " + fileName);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
        
        return fileName;
		
	}

}
