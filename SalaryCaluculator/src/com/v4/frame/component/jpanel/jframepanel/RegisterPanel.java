package com.v4.frame.component.jpanel.jframepanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.v4.frame.component.jframe.DialogFrame;
import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jframe.FrameAndDialogGenerator;
import com.v4.frame.component.jpanel.factory.DialogPanelFactory;
import com.v4.listener.Dispatcher;
import com.v4.model.DefaultModelCell;
import com.v4.model.Result;
import com.v4.tools.Wages;

import test.test4.Wage;

public class RegisterPanel extends JPanel {
	private final static String DefaultYearForTest = "2022";
	private String date;
	private String time;
	private final static Wage defaultWageForTest=new Wage();

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

		JButton btnDate = new JButton("Date");
		btnDate.setFocusable(false);
		btnDate.setBackground(SystemColor.control);
		btnDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogFrame frame = (DialogFrame) FrameAndDialogGenerator
						.getFrame(DialogFrameFactory.DATEDIALOG,
								new DialogPanelFactory());
				frame.addDispatcher(new Dispatcher<Result>() {
					@Override
					public void receive(Object o) {
					}

					@Override
					public void receive(Result result) {
						DefaultModelCell monthCell = (DefaultModelCell) result
								.get(DialogFrameFactory.MONTHDIALOG);
						int m = (int) monthCell.getValue();
						DefaultModelCell dayCell = (DefaultModelCell) result
								.get(DialogFrameFactory.DAYDIALOG);
						int d = (int) dayCell.getValue();

						date = String.format(DefaultYearForTest + "-%s-%s", m, d);
						btnDate.setText(date);
					}
				});
			}
		});
		btnDate.setBounds(38, 31, 193, 53);
		btnDate.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnDate);

		JButton btnTime = new JButton("Time");
		btnTime.setFocusable(false);
		btnTime.setBackground(SystemColor.control);
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogFrame frame = (DialogFrame) FrameAndDialogGenerator
						.getFrame(DialogFrameFactory.TIMEDIALOG,
								new DialogPanelFactory());
				frame.addDispatcher(new Dispatcher<Result>() {
					@Override
					public void receive(Object o) {
					}

					@Override
					public void receive(Result result) {
						DefaultModelCell hourCell = (DefaultModelCell) result
								.get(DialogFrameFactory.HOURDIALOG);
						int h = (int) hourCell.getValue();
						DefaultModelCell minuteCell = (DefaultModelCell) result
								.get(DialogFrameFactory.MINUTEDIALOG);
						int m = (int) minuteCell.getValue();

						time = String.format("%s:%s:0", h, m);
						btnTime.setText(time);
					}

				});
			}
		});
		btnTime.setBounds(291, 31, 193, 53);
		btnTime.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnTime);

		JButton btnNewButton_2 = new JButton("punch");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timestamp d=Timestamp.valueOf(date);
				Timestamp t=Timestamp.valueOf(time);
				
				//Wages.punchIn(defaultWageForTest, );
				
			}
		});
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
