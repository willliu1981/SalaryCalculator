package test.test18;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookHandler extends DefaultHandler {
	private final String BOOKLIST = "booklist";
	private final String BOOK = "book";
	private final String DESCRIPTION = "description";
	private final String AUTHORS = "authors";
	private final String CHAPTERS = "chapters";
	private final String CHAPTER = "chapter";

	private final String NAME = "name";
	private final String PUBLISHER = "publisher";
	private final String ID = "id";
	private final String TITLE = "title";

	private final String AUTHORS_SEPARATOR = ",";

	private List<Book> books;
	private Book book;
	private List<Author> authors;
	private List<Chapter> chapters;
	private Chapter chapter;
	private String qName;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		this.qName = qName;
		switch (qName.toLowerCase()) {
		case BOOKLIST:
			books = new ArrayList<>();
			break;
		case BOOK:
			book = new Book();
			String name = attributes.getValue(NAME);
			book.setName(name);
			Publisher publisher = new Publisher();
			publisher.setName(attributes.getValue(PUBLISHER));
			book.setPublisher(publisher);
			break;
		case DESCRIPTION:
			break;
		case AUTHORS:
			// authors = new ArrayList<Author>();
			break;
		case CHAPTERS:
			chapters = new ArrayList<>();
			break;
		case CHAPTER:
			chapter = new Chapter();
			chapter.setId(Integer.valueOf(attributes.getValue(ID)));
			chapter.setTitle(attributes.getValue(TITLE));
			break;
		default:
			break;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		switch (qName.toLowerCase()) {
		case BOOKLIST:
			break;
		case BOOK:
			this.books.add(book);
			break;
		case DESCRIPTION:
			break;
		case AUTHORS:
			this.authors.forEach(x -> this.book.addAuthor(x));
			break;
		case CHAPTERS:
			this.chapters.forEach(x -> this.book.addChapter(x));
			break;
		case CHAPTER:
			this.chapters.add(chapter);
			break;
		default:
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		switch (qName.toLowerCase()) {
		case BOOKLIST:
			break;
		case BOOK:
			break;
		case DESCRIPTION:
			book.setDescription(new String(ch, start, length));
			break;
		case AUTHORS:
			authors = Stream
					.of(new String(ch, start, length).split(AUTHORS_SEPARATOR))
					.map(x -> {
						Author author = new Author();
						author.setName(x);
						return author;
					}).collect(Collectors.toList());
			break;
		case CHAPTERS:
			break;
		case CHAPTER:
			chapter.setDescription(new String(ch, start, length));
			break;
		default:
			break;
		}
	}

	public List<Book> getBooks() {
		return this.books;
	}

}
