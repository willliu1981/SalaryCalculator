package com.v4.frame.component.listener;

import java.util.List;

public interface Dispatchable {
	void addDispatcher(Dispatcher dispatcher);

	List<Dispatcher> getDispatchers();

	default void updateDispatcher(Object o) {
		this.foreachDispatch(o);
	}

	default void foreachDispatch(Object o) {
		this.getDispatchers().forEach(x -> x.receive(o));
	}
}