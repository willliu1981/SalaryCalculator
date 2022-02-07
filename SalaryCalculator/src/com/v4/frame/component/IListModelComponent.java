package com.v4.frame.component;

import javax.swing.ListModel;

public interface IListModelComponent<T> {
	void setModel(T model);

	T getModel();
}
