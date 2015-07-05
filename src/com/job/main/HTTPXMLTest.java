package com.job.main;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class HTTPXMLTest {

	public static void main(String args[]) {
		
		try {
			
			new HTTPXMLTest().start();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	} // end main
	
	
	private void start() throws Exception {
		
		URL url = new URL(
				"http://api.indeed.com/ads/apisearch?publisher=4639223378892690&q=java&l=austin%2C+tx&sort=&radius=&st=&jt=&start=&limit=2000&fromage=&filter=&latlong=1&co=us&chnl=&userip=1.2.3.4&useragent=Mozilla/%2F4.0%28Firefox%29&v=2");
		URLConnection connection = url.openConnection();
		
		Document doc = parseXML(connection.getInputStream());
		NodeList descNodes = doc.getElementsByTagName("jobtitle");
		NodeList resultNode = doc.getElementsByTagName("totalresults");
		
		int totalResults = Integer.parseInt(resultNode.item(0).getTextContent());
		System.out.println(totalResults);
		
		
		for (int i = 0; i < descNodes.getLength(); i++) {
			
			System.out.println(descNodes.item(i).getTextContent());
			
		}
		
		
	}
	
	
	private Document parseXML(InputStream stream) throws Exception {
		
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document doc = null;
		
		try {
			
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			doc = builder.parse(stream);
			
		}
		catch (Exception ex) {
			
			throw ex;
			
		}
		
		return doc;
		
	} // end parseXML()
	
}
