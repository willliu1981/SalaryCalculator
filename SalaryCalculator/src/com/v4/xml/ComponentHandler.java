package com.v4.xml;

import javax.swing.text.html.HTML.Attribute;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ComponentHandler extends DefaultHandler {

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("const")) {
			String id = attributes.getValue("id");
			XMLFactory.creatNew(id);
			XMLFactory.creating(XMLFactory.ID, id);
			XMLFactory.creating(XMLFactory.CLASS, attributes.getValue("class"));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase("const")) {
			XMLFactory.creatFinish();
		}
	}

}
