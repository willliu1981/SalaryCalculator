package com.v4.frame.component.panel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.v4.frame.component.listener.Dispatchable;
import com.v4.frame.component.listener.Dispatcher;

/*
	用於擴展各種類型的Dialog
*/
public abstract class DialogPanel extends JPanel implements Dispatchable {
	protected final List<Dispatcher> dispatchers = new ArrayList<>();

	@Override
	public void addDispatcher(Dispatcher dispatcher) {
		this.dispatchers.add(dispatcher);

	}

	@Override
	public void foreachDispatch(Object o) {
		this.dispatchers.forEach(x -> x.receive(o));
	}


	
}
