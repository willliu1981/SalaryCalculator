package com.v4.listener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.v4.model.Result;

import test.test10.User;

public interface Dispatchable<T extends Result> {
	void addDispatcher(Dispatcher<T> dispatcher);

	List<Dispatcher<T>> getDispatchers();

	default void updateDispatcher(Object o) {
		this.foreachDispatch(o);
	}

	default void updateDispatcher(Result res) {
		this.foreachDispatch(res);
	}

	default void foreachDispatch(Object o) {
		this.getDispatchers().forEach(x -> x.receive(o));

		Type[] interfaceTypes = this.getClass().getGenericInterfaces();
		T instanceT = null;

		System.out.println("x:" + x.getClass());
		instanceT = Stream.of(interfaceTypes).map(x -> {
			T user = null;
			if (x instanceof ParameterizedType) {
				ParameterizedType pt = (ParameterizedType) x;
				Type[] types = pt.getActualTypeArguments();
				user = Stream.of(types).map(m -> {
					T u = null;
					try {
						// System.out
						// .println("x instanceof Class:" + (x instanceof
						// Class));
						if (x instanceof Class) {
							u = ((Class<T>) x).newInstance();
						}
					} catch (InstantiationException
							| IllegalAccessException e) {
						e.printStackTrace();
					}
					return u;
				}).filter(n -> n instanceof Result).findAny().orElse(null);
			}
			return user;
		}).filter(y -> y instanceof Result).findAny().orElse(null);

		instanceT.add(o);
		foreachDispatch(instanceT);
	}

	default void foreachDispatch(T res) {
		this.getDispatchers().forEach(x -> x.receive(res));
	}
}
