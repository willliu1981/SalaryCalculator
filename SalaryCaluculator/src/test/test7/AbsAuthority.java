package test.test7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.stream.Stream;

public class AbsAuthority<T, E> implements IAuthority<User>{

	void m() {
		Class<?> thisClass = this.getClass();
		System.out.println("AbsAuthority getClass : " + thisClass);

		Type type = thisClass.getGenericSuperclass();
		System.out.println("AbsAuthority type : " + type);

		ParameterizedType ParameterizedType = (ParameterizedType) type;
		System.out.println(
				"AbsAuthority ParameterizedType : " + ParameterizedType);

		Type[] types = ParameterizedType.getActualTypeArguments();
		System.out.println("AbsAuthority types : " + types.length);
		Stream.of(types)
				.forEach(x -> System.out.println("  AbsAuthority x : " + x));

		/*
		Class<T> clazz = (Class<T>) types[0];
		System.out.println("AbsAuthority clazz : " + clazz);
		//*/
	}

}
