package com.v5.main.setting;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.v4.xml.ComponentHandler;
import com.v4.xml.XMLFactory;

public class XMLCreator {
	public static void createXMLData() {
		File file = new File("src/com/v4/xml/component_config.xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			ComponentHandler handler = new ComponentHandler();
			parser.parse(file, handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("xml creator:"+XMLCreator.class);
		XMLFactory.print();
	}
}
