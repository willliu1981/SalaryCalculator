package test.test8;

import java.lang.reflect.Type;
import java.util.stream.Stream;

public interface IBook<T> {
	void m();

	default void m2() {
		Class<?> thisClass = this.getClass();
		System.out.println("IB getClass = " + thisClass);

		Type[] genericInterfaces = thisClass.getGenericInterfaces();
		System.out.println("interfaceTypes : " + genericInterfaces.length);
		Stream.of(genericInterfaces)
				.forEach(x -> System.out.println("  interfaceTypes x : " + x));
		
		Type giType= genericInterfaces[0];
		
		
		System.out.println(genericInterfaces[0]  instanceof MyBook);
	}

}
