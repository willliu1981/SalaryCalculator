package com.frame.component.dailog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.frame.component.receiver.IResponse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MonthDailogPanel extends DialogPanel {

	public MonthDailogPanel() {
		this(null);
	}

	/**
	 * Create the panel.
	 */
	public MonthDailogPanel( IResponse father) {
		super(father);

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 37, 110, 330);
		panel.add(scrollPane);

		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setResult(list.getSelectedValue());
				dispatch();
			}
		});
		list.setFont(new Font("新細明體", Font.PLAIN, 30));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "一月", "二月", "三月", "四月", "五月", "六月",
					"七月", "八月", "九月", "十月", "十一月", "十二月" };

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
}
