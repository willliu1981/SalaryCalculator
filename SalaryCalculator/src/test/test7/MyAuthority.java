package test.test7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.stream.Stream;

public class MyAuthority<E> extends AbsAuthority<User,E> {
	void m2() {
		Class<?> thisClass = this.getClass();
		System.out.println("MyAuthority getClass : " + thisClass);

		Type type = thisClass.getGenericSuperclass();
		System.out.println("MyAuthority type : " + type);

		ParameterizedType ParameterizedType = (ParameterizedType) type;
		System.out.println(
				"MyAuthority ParameterizedType : " + ParameterizedType);

		Type[] types = ParameterizedType.getActualTypeArguments();
		System.out.println("MyAuthority types : " + types.length);
		Stream.of(types)
				.forEach(x -> System.out.println("  AbsAuthority x : " + x));

		

	}
}
