package test.test7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface IBook<T> {

	default void m() {
		Class<?> thisClass = this.getClass();
		System.out.println("IBook getClass : " + thisClass);

		Type type = thisClass.getGenericSuperclass();
		System.out.println("IBook type : " + type);

		/*
		 ParameterizedType ParameterizedType ...
		*/

	}
}
