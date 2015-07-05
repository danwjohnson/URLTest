package com.job.xml;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLFunctions {

	public final static Document XMLFromString(String xml) {
		
		Document doc = null;
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc = db.parse(is);
			
		}
		catch(ParserConfigurationException pe){
			
			System.out.println("XML parser error: " + pe.getMessage());
			return null;
			
		}
		catch(SAXException se) {
			
			System.out.println("Wrong XML File Structure: " + se.getMessage());
			return null;
			
		}
		
		catch(IOException ie) {
			
			System.out.println("IO error: " + ie.getMessage());
			return null;
			
		}
		
		return doc;
		
	} // end XMLFromString()
	
}
