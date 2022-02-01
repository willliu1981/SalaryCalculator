package test.test13;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Test13Demo2 {
	public static void main(String[] args) {

		try {
			File inputFile = new File("src/test/test13/testxml.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			UserHandler2 userhandler = new UserHandler2();
			saxParser.parse(inputFile, userhandler);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelFactory.users.forEach(x -> System.out.println(x));
	}
}

class UserHandler2 extends DefaultHandler {

	boolean bFirstName = false;
	boolean bLastName = false;
	boolean bNickName = false;
	boolean bMarks = false;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("student")) {
			ModelFactory.creatNewModel();
			String rollNo = attributes.getValue("rollno");
			ModelFactory.creatingModel("id", rollNo);
			System.out.println("Roll No : " + rollNo);
		} else if (qName.equalsIgnoreCase("firstname")) {
			bFirstName = true;
		} else if (qName.equalsIgnoreCase("lastname")) {
			bLastName = true;
		} else if (qName.equalsIgnoreCase("nickname")) {
			bNickName = true;
		} else if (qName.equalsIgnoreCase("marks")) {
			bMarks = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase("student")) {
			System.out.println("End Element :" + qName);
			ModelFactory.creatFinishModel();
		}
	}

	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException {
		if (bFirstName) {
			String value = null;
			System.out.println(
					"First Name: " + (value = new String(ch, start, length)));
			ModelFactory.creatingModel("fn", value);
			bFirstName = false;
		} else if (bLastName) {
			String value = null;
			System.out.println(
					"Last Name: " + (value = new String(ch, start, length)));
			ModelFactory.creatingModel("ln", value);
			bLastName = false;
		} else if (bNickName) {
			String value = null;
			System.out.println(
					"Nick Name: " + (value = new String(ch, start, length)));
			ModelFactory.creatingModel("nn", value);
			bNickName = false;
		} else if (bMarks) {
			String value = null;
			System.out.println(
					"Marks: " + (value = new String(ch, start, length)));
			ModelFactory.creatingModel("mk", value);
			bMarks = false;
		}
	}
}
