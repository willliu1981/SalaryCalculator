package test.test7;

import java.lang.reflect.Type;

public class User<T> {
	
	String name="x1";

	void m() {
		Class<?> thisClass = this.getClass();
		System.out.println("AbsAuthority getClass : " + thisClass);

		Type type = thisClass.getGenericSuperclass();
		System.out.println("AbsAuthority types : "+ type);

		/*
		 ParameterizedType ParameterizedType ...
		*/
	}
	
	String getSuperName() {
		return name;
	}
		

}
