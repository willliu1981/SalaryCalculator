package com.frame.component.dailog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.frame.component.xcomponent.XPanel;

public class MonthDailogPanel extends XPanel {

	public MonthDailogPanel() {
		this(null);
	}

	/**
	 * Create the panel.
	 */
	public MonthDailogPanel(DailogFrameFactory father) {
		super(father);

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 37, 110, 330);
		panel_1.add(scrollPane);

		JList list = new JList();
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

		JButton btnNewButton_2 = new JButton("Ok");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setResult((String) list.getSelectedValue());
				dispose();
			}
		});
		btnNewButton_2.setMargin(new Insets(12, 14, 2, 14));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setBounds(184, 187, 110, 53);
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton_2);

	}
}
