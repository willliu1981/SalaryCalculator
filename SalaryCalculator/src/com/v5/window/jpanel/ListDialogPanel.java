package com.v5.window.jpanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.v5.dispatcher.Dispatcher;
import com.v5.dispatcher.ListDialogDispatchable;
import com.v5.dispatcher.model.ListDialogResult;
import com.v5.model.AbsModelCell;
import com.v5.model.ListDialogModel;
import com.v5.window.interfaces.IListModelComponent;



public class ListDialogPanel<T extends AbsModelCell<?, ?>> extends JPanel
		implements IListModelComponent<ListDialogModel<T>>,
		ListDialogDispatchable<ListDialogResult> {

	protected List<Dispatcher<ListDialogResult>> dispatchers = new ArrayList<>();
	protected ListDialogModel<T> model;
	protected JList<?> list = new JList();
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
		list.getSelectionModel();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AbsModelCell cell = (AbsModelCell) list.getSelectedValue();
				ListDialogResult result = new ListDialogResult();
				result.add(cell);
				updateDispatcher(result);
			}
		});
	}

	@Override
	public ListDialogModel<T> getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}

	@Override
	public void addDispatcher(Dispatcher<ListDialogResult> dispatcher) {
		this.dispatchers.add(dispatcher);
	}

	@Override
	public List<Dispatcher<ListDialogResult>> getDispatchers() {
		// TODO Auto-generated method stub
		return this.dispatchers;
	}

}
