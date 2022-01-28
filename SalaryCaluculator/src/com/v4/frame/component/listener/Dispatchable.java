package com.v4.frame.component.listener;

import java.lang.reflect.ParameterizedType;
import java.util.List;

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
		ParameterizedType superClass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		Class<T> clazz = (Class<T>) superClass.getActualTypeArguments()[0];
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
