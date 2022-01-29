package test.test11;

import java.lang.reflect.Type;

public class DispatcherDemo {

	public static void main(String[] args) {
		Book book = new Book();
		Store store = new Store(book);

		store.m("Jhon");

	}

}
