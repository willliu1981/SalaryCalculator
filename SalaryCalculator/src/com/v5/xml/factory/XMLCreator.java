package com.v5.xml.factory;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.v5.exception.FindErrorException;
import com.v5.xml.ComponentHandler;
import com.v5.xml.XMLFactory;

public class XMLCreator {
	public static void createXMLData(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			throw new FindErrorException(
					XMLCreator.class + " : " + fileName + " 不存在");
		}

		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			ComponentHandler handler = new ComponentHandler();
			parser.parse(file, handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("xml creator:" + XMLCreator.class);
		XMLFactory.print();
	}
}
