package test.test10;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.stream.Stream;

import com.v4.exception.FindErrorException;

public class Book<T extends User> {

	void m() {
		Type type = this.getClass().getGenericSuperclass();

		T user = null;
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			Type[] types = pt.getActualTypeArguments();
			Stream.of(types).forEach(x -> System.out.println("x:" + x));
			user = Stream.of(types).map(x -> {
				T u = null;
				try {
					System.out.println("typeName="+x.getClass());
					System.out.println("instanceof= "+(x instanceof Class));
					if(x instanceof Class) {
						
						u = ((Class<T>) x).newInstance();
					}
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				return u;
			}).filter(y -> y instanceof User).findAny()
					.orElse(null);
		}

		System.out.println("result: " + user);
	}
}
