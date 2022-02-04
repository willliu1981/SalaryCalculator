package com.v5.window.jpanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.v5.dispatcher.Dispatcher;
import com.v5.dispatcher.model.Result;
import com.v5.window.factory.IDialog;


/*
	用於擴展各種類型的Dialog
*/
public abstract class AbsDialogPanel extends JPanel implements IDialog {
	protected final List<Dispatcher<Result>> dispatchers = new ArrayList<>();

	@Override
	public void addDispatcher(Dispatcher<Result> dispatcher) {
		this.dispatchers.add(dispatcher);

	}

	@Override
	public List<Dispatcher<Result>> getDispatchers() {
		return this.dispatchers;
	}

}
