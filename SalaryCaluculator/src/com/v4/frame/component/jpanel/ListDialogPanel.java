package com.v4.frame.component.jpanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import com.v4.frame.component.IListModelComponent;
import com.v4.listener.Dispatcher;
import com.v4.model.AbsModelCell;
import com.v4.model.ListDialogModel;
import com.v4.model.Result;

import test.test11.MyResult;

import javax.swing.JLabel;
import java.awt.Font;

public class ListDialogPanel<T extends AbsModelCell> extends AbsDialogPanel
		implements IListModelComponent<ListDialogModel<T>> {

	protected ListDialogModel model;
	protected JList list = new JList();
	protected JScrollPane scrollPane = new JScrollPane();

	public ListDialogPanel() {
		setLayout(new BorderLayout(0, 0));

		JLabel lblListName = new JLabel("Name");
		lblListName.setFont(new Font("新細明體", Font.PLAIN, 30));
		add(lblListName, BorderLayout.NORTH);

		add(scrollPane, BorderLayout.CENTER);

	}

	/**
	 * Create the panel.
	 */
	public ListDialogPanel(ListDialogModel<T> model) {
		this();

	}

	@Override
	public void setModel(ListDialogModel<T> model) {
		// TODO Auto-generated method stub
		this.model = model;
		this.list = new JList(model);
		this.list.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
		scrollPane.setViewportView(list);

	}

	@Override
	public ListDialogModel getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}

}
