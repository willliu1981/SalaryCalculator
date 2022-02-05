package test.test18;

import java.util.ArrayList;
import java.util.List;

public class Book {
	String name;
	String description;
	Publisher publisher;
	List<Author> authors = new ArrayList<>();
	List<Chapter> chapters = new ArrayList<>();

	public void addAuthor(Author author) {
		this.authors.add(author);
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void addChapter(Chapter chapter) {
		this.chapters.add(chapter);
	}

	public List<Chapter> getChapters() {
		return this.chapters;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", description=" + description
				+ ", publisher=" + publisher + ", authores=" + authors
				+ ", chapteres=" + chapters + "]";
	}

}
