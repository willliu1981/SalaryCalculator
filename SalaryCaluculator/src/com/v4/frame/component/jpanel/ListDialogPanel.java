package com.v4.frame.component.jpanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import com.v4.frame.component.IListModelComponent;
import com.v4.listener.Dispatcher;
import com.v4.model.ListDialogModel;
import com.v4.model.Result;

public class ListDialogPanel extends AbsDialogPanel
		implements IListModelComponent<ListDialogModel> {

	protected ListDialogModel model;
	protected JList list = new JList();
	protected JScrollPane scrollPane = new JScrollPane();

	public ListDialogPanel() {

	}

	/**
	 * Create the panel.
	 */
	public ListDialogPanel(ListDialogModel model) {
		setLayout(new BorderLayout(0, 0));

		add(scrollPane, BorderLayout.CENTER);

	}

	@Override
	public void setModel(ListDialogModel model) {
		// TODO Auto-generated method stub
		this.model = model;
		
		DefaultListModel m=new DefaultListModel();
		this.list = new JList(model);
		scrollPane.setViewportView(list);
		;
	}

	@Override
	public ListDialogModel getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}

}
