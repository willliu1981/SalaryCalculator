package test.test18;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class Test18SaxWriteDemo {

	public static void main(String[] args) {
		List<Book> booklist = new ArrayList<>();

		Author author1 = new Author();
		author1.setName("Wu");
		Author author2 = new Author();
		author2.setName("Lin");

		Publisher publisher = new Publisher();
		publisher.setName("SunRaise");

		Chapter ch1 = new Chapter();
		ch1.setId(1);
		ch1.setTitle("First programming");
		ch1.setDescription("print hello world!");

		Chapter ch3 = new Chapter();
		ch3.setId(3);
		ch3.setTitle("Collection");
		ch3.setDescription("List,Set,Map");

		Chapter ch2 = new Chapter();
		ch2.setId(2);
		ch2.setTitle("Type");
		ch2.setDescription("byte,int,float,double");

		Book book = new Book();
		book.setName("Java");
		book.setPublisher(publisher);
		book.addAuthor(author1);
		book.addAuthor(author2);
		book.setDescription("Java is a good programming language");
		book.addChapter(ch1);
		book.addChapter(ch2);
		book.addChapter(ch3);

		booklist.add(book);

		System.out.println(booklist);

		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		try {
			TransformerHandler handler = tff.newTransformerHandler();
			File file = new File("src/test/test18/book.xml");
			if (!file.exists()) {
				file.createNewFile();
			}

			Result res = new StreamResult(new FileOutputStream(file));
			handler.setResult(res);
			handler.startDocument();
			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", "booklist", attr);

			for (Book b : booklist) {
				attr.clear();
				attr.addAttribute("", "", "name", "", b.getName());
				attr.addAttribute("", "", "publisher", "",
						b.getPublisher().getName());
				handler.startElement("", "", "book", attr);

				attr.clear();
				handler.startElement("", "", "description", attr);
				handler.characters(b.getDescription().toCharArray(), 0,
						b.getDescription().length());
				handler.endElement("", "", "description");

				handler.startElement("", "", "authors", attr);
				String chars = b.getAuthors().stream().reduce((a1, a2) -> {
					a1.setName(a1.getName() + "," + a2.getName());
					return a1;
				}).get().getName();
				handler.characters(chars.toCharArray(), 0, chars.length());
				handler.endElement("", "", "authors");

				attr.clear();
				handler.startElement("", "", "chapters", attr);

				book.getChapters().stream()
						.sorted((x1, x2) -> x1.getId() - x2.getId())
						.forEach(m -> {
							attr.clear();
							attr.addAttribute("", "", "id", "", "" + m.getId());
							attr.addAttribute("", "", "title", "",
									"" + m.getTitle());
							try {
								handler.startElement("", "", "chapter", attr);
								handler.characters(
										m.getDescription().toCharArray(), 0,
										m.getDescription().length());
								handler.endElement("", "", "chapter");
							} catch (SAXException e) {
								e.printStackTrace();
							}
						});

				handler.endElement("", "", "chapters");

				handler.endElement("", "", "book");
			}

			handler.endElement("", "", "booklist");
			handler.endDocument();

		} catch (TransformerConfigurationException | IOException
				| SAXException e) {
			e.printStackTrace();
		}

	}

}
