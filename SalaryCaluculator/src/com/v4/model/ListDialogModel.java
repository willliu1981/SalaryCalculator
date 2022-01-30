package com.v4.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ListDialogModel implements ListModel<ModelCell> {
	private List<ModelCell> list=new ArrayList<>();
	private List<ListDataListener> listeners=new ArrayList<>();

	
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public void addElement(ModelCell cell) {
		this.list.add(cell);
	}
	
	@Override
	public ModelCell getElementAt(int index) {
		// TODO Auto-generated method stub
		return this.list.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		listeners.add(l);
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		listeners.remove(l);
	}

}
