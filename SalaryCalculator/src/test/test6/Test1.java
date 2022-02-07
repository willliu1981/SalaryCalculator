package test.test6;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import test.test6.Test1.Book;

public class Test1 {
	static abstract class BookFactory<T extends Book, V> {

		abstract Publisher<T> getPublisher();

		T creat() {
			System.out.println("getClass: " + getClass());
			System.out.println("getGenericSuperclass: "
					+ getClass().getGenericSuperclass());

			ParameterizedType superClass = (ParameterizedType) getClass()
					.getGenericSuperclass();

			System.out.println("getActualTypeArguments length: "
					+ superClass.getActualTypeArguments().length);
			System.out.println("getActualTypeArguments: "
					+ superClass.getActualTypeArguments()[0]);

			Class<T> clazz = (Class<T>) superClass.getActualTypeArguments()[0];

			T protoBook = null;
			try {
				protoBook = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

			T newBook = getPublisher().set(protoBook);
			return newBook;
		}

		T creat(Class<T> clazz) {

			T protoBook = null;
			try {
				protoBook = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

			T newBook = getPublisher().set(protoBook);

			return newBook;
		}

	}

	static interface Publisher<T extends Book> {
		String getName();

		T set(T b);
	}

	static class Book {
		String publisher;

		void read() {

		}

		public String toString() {
			return String.format("%s,%s", publisher,
					this.getClass().getSimpleName());
		}
	}

	static class Textbook extends Book {
		void read2() {

		}
	}

	static class Magazine extends Book {
		void read3() {

		}
	}

	public static void main(String[] args) {
		Publisher<Magazine> publisher = new Publisher<Magazine>() {
			@Override
			public String getName() {
				return "My Store";
			}

			@Override
			public Magazine set(Magazine b) {
				b.publisher = this.getName();
				return b;
			}

		};

		BookFactory<Magazine,Book> factory = new BookFactory<Magazine, Book>() {

			@Override
			Publisher<Magazine> getPublisher() {
				return publisher;
			}

		};

		// *
		Magazine e1 = factory.creat();
		System.out.println(e1);
		// */

		/*
		 * Textbook e2 = factory.creat(Textbook.class); System.out.println(e2);
		 * //
		 */

	}

}
