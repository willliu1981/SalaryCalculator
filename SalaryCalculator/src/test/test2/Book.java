package test.test2;

public class Book implements IBook {

	@Override
	public void method1() {
		
		System.out.println("test book");
		
	}

	@Override
	public void method2() {
		IBook.super.method2();
		System.out.println("xxxx");
	}
	
	

}
