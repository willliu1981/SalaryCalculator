package com.v5.window.interfaces;

import javax.swing.ListModel;

public interface IListModelComponent<T> {
	void setModel(T model);

	T getModel();
}
