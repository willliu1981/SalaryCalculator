package test.test18;

import java.io.File;
import java.io.IOException;
import java.util.logging.Handler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Test18SaxReadDemo {

	public static void main(String[] args) {
		File file = new File("src/test/test18/book.xml");

		SAXParserFactory factory = SAXParserFactory.newInstance();
		BookHandler handler = null;
		try {
			SAXParser parser = factory.newSAXParser();
			handler = new BookHandler();
			parser.parse(file, handler);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		System.out.println(handler.getBooks());
	}

}
