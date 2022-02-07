package test.test7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.stream.Stream;

public class SubMyAuthority<E,K> extends MyAuthority<E> {
	void m2() {
		Class<?> thisClass = this.getClass();
		System.out.println("SubMyAuthority getClass : " + thisClass);

		Type type = thisClass.getGenericSuperclass();
		System.out.println("SubMyAuthority type : " + type);

		ParameterizedType ParameterizedType = (ParameterizedType) type;
		System.out.println(
				"SubMyAuthority ParameterizedType : " + ParameterizedType);

		Type[] types = ParameterizedType.getActualTypeArguments();
		System.out.println("SubMyAuthority types : " + types.length);
		Stream.of(types)
				.forEach(x -> System.out.println("  AbsAuthority x : " + x));

		

	}
}
