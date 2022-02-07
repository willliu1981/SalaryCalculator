package test.test15;

import java.util.HashMap;
import java.util.Map;

public class Test15VisitDemo {

	interface IFactory {

	}

	static class BookFactory implements IFactory {

	}

	static class NameFactory implements IFactory {

	}

	static abstract class AbsGenerator {
		static Map<String, IFactory> factories = new HashMap<>();

		static void setFactoryMap(String name, IFactory factory) {
			factories.put(name, factory);
		}

		abstract Book getBook(String name);
	}

	static class AGenerator extends AbsGenerator {

		@Override
		Book getBook(String name) {
			IFactory f = factories.get(name);
			return null;
		}

	}

	static class BGenerator extends AbsGenerator {

		@Override
		Book getBook(String name) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	static class Book {

	}

	public static void main(String[] args) {
		// init
		BookFactory bf = new BookFactory();
		NameFactory nf = new NameFactory();
		AbsGenerator.setFactoryMap("book1", bf);
		AbsGenerator.setFactoryMap("book2", bf);
		AbsGenerator.setFactoryMap("name1", nf);
		AbsGenerator.setFactoryMap("name2", nf);

		AGenerator g1 = new AGenerator();
		// BGenerator g2 = new BGenerator();

	}

}
