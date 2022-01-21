package com.frame.component.xcomponent;

public interface Dispatchable {
	void addDispatcher(Dispatcher dispatcher);
	void updateDispatcher();
	void foreachDispatch(Object o);
}
