package com.v5.dispatcher;

import com.v5.dispatcher.model.Result;

public interface Dispatcher<T extends Result> {
	default void receive(T result) {

	}

	void receive(Object o);

}
