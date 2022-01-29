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
		T finalInstance = null;

		finalInstance = Stream.of(interfaceTypes).map(x -> {
			T result = null;
			if (x instanceof ParameterizedType) {
				ParameterizedType pt = (ParameterizedType) x;
				Type[] types = pt.getActualTypeArguments();
				result = Stream.of(types).map(type -> {
					T instance = null;
					try {
						if (type instanceof Class) {
							instance = ((Class<T>) type).newInstance();
						}
					} catch (InstantiationException
							| IllegalAccessException e) {
						e.printStackTrace();
					}
					return instance;
				}).filter(i -> i instanceof Result).findAny().orElse(null);
			}
			return result;
		}).filter(y -> y instanceof Result).findAny().orElse(null);

		finalInstance.add(o);
		foreachDispatch(finalInstance);
	}

	default void foreachDispatch(T res) {
		this.getDispatchers().forEach(x -> x.receive(res));
	}
}
