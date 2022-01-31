package test.test12;

public class Test12Demo2 {
	static class Book {

	}

	static class SubBook extends Book {

	}

	static class SubBook2 extends SubBook {

	}

	static class Car {

	}

	interface I1<T extends Book> {

	}

	static class C1 implements I1<SubBook> {

	}

	interface I2<T> extends I1<SubBook> {

	}

	static class C2 extends C1 implements I2<Car> {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
