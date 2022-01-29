package com.v4.listener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.v4.model.Result;

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
		Optional<Type> ResultOp = Stream.of(interfaceTypes)
				.filter(x -> x instanceof Result).findAny();

		
		Class<T> clazz =null;
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		foreachDispatch(t);
	}

	default void foreachDispatch(T res) {
		this.getDispatchers().forEach(x -> x.receive(res));
	}
}
