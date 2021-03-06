package com.v5.dispatcher;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.v5.dispatcher.model.Result;




public interface Dispatchable<T extends Result> {
	void addDispatcher(Dispatcher<T> dispatcher);

	List<Dispatcher<T>> getDispatchers();

	default void updateDispatcher(Object o) {
		this.foreachDispatch(o);
	}

	default void updateDispatcher(T res) {
		this.foreachDispatch(res);
	}

	default void foreachDispatch(Object o) {

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

		if (finalInstance == null) {
			try {
				finalInstance = (T) Result.class.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		finalInstance.add(o);
		foreachDispatch(finalInstance);
	}

	default void foreachDispatch(T res) {
		this.getDispatchers().forEach(x -> x.receive(res));
		this.getDispatchers().forEach(x -> x.receive(res.get()));
	}
}
