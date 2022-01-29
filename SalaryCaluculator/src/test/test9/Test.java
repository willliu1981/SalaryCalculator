package test.test9;

import java.lang.reflect.Type;

import test.test8.Authority;

public class Test {

	interface HasName {

	}

	interface CanRun {

	}

	interface CanRead {

	}

	static class Book implements HasName, CanRead {

	}

	static class Car implements HasName, CanRun {

	}

	public static void main(String[] args) {
		Type type = Book.class;
		Class<?> clazz = Book.class;

		HasName car = new Car();
		Car car2 = new Car();
		Book book = null;
		CanRun run = new Car();
		CanRead read = new Book();

		try {
			book = ((Class<Book>) type).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.printf(" %s\n", book);

		/*
		System.out.printf(" %s\n",type.getTypeName().equals(Book.class.getName()));
		System.out.printf(" %s\n",type.getTypeName());
		System.out.printf(" %s\n",Book.class.getName());
		//*/

		/*
		System.out.printf("type is Class? %s\n", type instanceof Class);
		System.out.printf("clazz is Type? %s\n", clazz instanceof Type);
		System.out.printf("type is Book? %s\n", type instanceof Book);
		// System.out.printf("clazz is Book? %s\n",clazz instanceof Book);
		
		System.out.printf("clazz is Book? %s\n", car instanceof Car);
		System.out.printf("clazz is Book? %s\n", car2 instanceof HasName);
		System.out.printf("clazz is Book? %s\n", book instanceof HasName);
		System.out.printf("clazz is Book? %s\n", run instanceof Car);
		//*/
	}

}
