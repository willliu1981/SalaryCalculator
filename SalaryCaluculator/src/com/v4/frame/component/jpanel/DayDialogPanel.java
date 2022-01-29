package com.v4.frame.component.jpanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.v4.listener.Dispatcher;

public class DayDialogPanel extends DialogPanel {
	private JList list;

	/**
	 * Create the panel.
	 */
	public DayDialogPanel() {

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 37, 110, 330);
		panel.add(scrollPane);

		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				updateDispatcher(Integer.valueOf(list.getSelectedIndex() + 1));
			}
		});
		list.setFont(new Font("新細明體", Font.PLAIN, 30));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "1", "2", "3", "4", "5", "6", "7",
					"8", "9", "10" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(228, 252, 1, 1);
		scrollPane.setViewportView(list);

	}

	@Override
	public List<Dispatcher> getDispatchers() {
		return this.dispatchers;
	}
}
