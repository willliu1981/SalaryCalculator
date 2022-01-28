package test.test6;

import java.util.Set;

public class Test2 {

	static abstract class Factory<T> {
		abstract T creat();

		void creat(T t) {

		}

	}

	static class BookFactory<T> extends Factory<T>{

		@Override
		T creat() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	static class Book {
		Book(String n, Integer i) {

		}
	}

	public static void main(String[] args) {
		BookFactory factory = new BookFactory();

	}

}
