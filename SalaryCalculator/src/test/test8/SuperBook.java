package test.test8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.stream.Stream;

import com.v4.exception.FindErrorException;

public class SuperBook<T> implements IBook<Authority>, IReadable<MyBook> {
	Authority au = null;

	public void m() {
		Class<?> thisClass = this.getClass();
		System.out.println("getClass = " + thisClass);

		Type[] genericInterfaces = thisClass.getGenericInterfaces();
		System.out.println("interfaceTypes : " + genericInterfaces.length);
		Stream.of(genericInterfaces)
				.forEach(x -> System.out.println("  interfaceTypes x : " + x));

		Type type = thisClass.getGenericSuperclass();
		System.out.println("getGenericSuperclass = " + type);

		boolean isParameterizedType = type instanceof ParameterizedType;
		System.out.println("is ParameterizedType? " + isParameterizedType);

		if (isParameterizedType) {
			ParameterizedType ParameterizedType = (ParameterizedType) type;
			System.out.println("ParameterizedType = " + ParameterizedType);

			Type[] types = ParameterizedType.getActualTypeArguments();
			System.out.println("typess : " + types.length);
			Stream.of(types).forEach(
					x -> System.out.println("  AbsAuthority x : " + x));

			Stream.of(types).filter(x -> {
				try {
					return (au = ((Class<Authority>) x).newInstance()) != null;
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}).findAny().orElseThrow(FindErrorException::new);

			System.out.println("au = "+au);
			/*
			T instance=null;
			try {
				instance=(T) ((Class<?>)types[0]).newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("newInstance =" + instance);
			//*/
		}
	}

	@Override
	public void read(MyBook t) {
		// TODO Auto-generated method stub

	}

}
