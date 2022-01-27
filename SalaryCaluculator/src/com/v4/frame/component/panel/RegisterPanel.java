package com.v4.frame.component.panel;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.v4.frame.component.frame.DialogFactory;
import com.v4.frame.component.frame.DialogFrame;
import com.v4.frame.component.frame.FrameGenerator;
import com.v4.frame.component.listener.Dispatchable;
import com.v4.frame.component.listener.Dispatcher;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Window;

public class RegisterPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RegisterPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Date");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogFrame frame = (DialogFrame) FrameGenerator.getFrame(
						DialogFactory.DATEDIALOG, new DialogPanelFactory());
				frame.addDispatcher(new Dispatcher() {
					@Override
					public void receive(Object o) {
						btnNewButton.setText((String) o);
					}
				});
			}
		});
		btnNewButton.setBounds(38, 31, 193, 53);
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DialogFactory.getFrameInstance(PanelFactory.REGISTERTIMEDAILOG);
			}
		});
		btnNewButton_1.setBounds(291, 31, 193, 53);
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setBounds(682, 112, 193, 53);
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton_2);

		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "RRR", "CCC", "ssss", "dfdf", "",
					"dfsf", "", "dsf" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("新細明體", Font.PLAIN, 30));
		list.setBounds(0, 0, 412, 114);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 133, 610, 165);
		panel_1.add(scrollPane);
		scrollPane.setViewportView(list);

	}

}
