package com.v4.listener;

import com.v4.model.Result;

public interface Dispatcher<T extends Result> {
	default void receive(T o) {
	
	}

	void receive(Object o);

}
