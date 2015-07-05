package com.job.main;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
//import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
//import org.xml.sax.InputSource;

public class URLConnectionReader {

	public static void main(String args[]) throws Exception{
		
		StringBuilder responseBuilder = new StringBuilder();
		
		URL indeed = new URL
				("http://api.indeed.com/ads/apisearch?publisher=4639223378892690&q=java&l=austin%2C+tx&sort=&radius=&st=&jt=&start=&limit=2000&fromage=&filter=&latlong=1&co=us&chnl=&userip=1.2.3.4&useragent=Mozilla/%2F4.0%28Firefox%29&v=2");
		URLConnection ic = indeed.openConnection();
		BufferedReader in = new BufferedReader(
							new InputStreamReader(
									ic.getInputStream()));
	
		String line;
		String xml;
		
		while((line = in.readLine()) != null) {
			
			responseBuilder.append(line + '\n');
			
		}
		
		xml = responseBuilder.toString();
		System.out.println(xml);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document jobXML = builder.parse(new ByteArrayInputStream(xml.getBytes()));
		
		System.out.print(jobXML);
		
		
	}
	
/*	
	public static Document loadXMLFromString(String xml) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return builder.parse(is);
		
	}
*/
	
}
