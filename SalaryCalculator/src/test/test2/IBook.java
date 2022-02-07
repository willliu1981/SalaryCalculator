package test.test2;

public interface IBook {
	void method1();
	
	default void method2() {
		method1();
	}
	
}
