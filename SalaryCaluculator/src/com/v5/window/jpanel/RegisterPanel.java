package com.v5.window.jpanel;

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
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import com.v5.dispatcher.Dispatcher;
import com.v5.dispatcher.model.Result;
import com.v5.dispatcher.model.Wage;
import com.v5.frame.component.jpanel.factory.DialogPanelFactory;
import com.v5.model.DefaultModelCell;
import com.v5.model.punch.HalfHourPunchStrategy;
import com.v5.tools.Dialogs;
import com.v5.tools.Wages;
import com.v5.window.factory.DialogFrameFactory;
import com.v5.window.factory.FrameAndDialogGenerator;
import com.v5.window.jframe.DialogFrame;



public class RegisterPanel extends JPanel {
	private final static String DefaultYearForTest = "2022";
	private final static String DefaultMonthForTest = "1";
	private String date;
	private String time;
	private final static Wage defaultWageForTest = new Wage();
	private JList list;


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
				DialogFrame frame = (DialogFrame)  FrameAndDialogGenerator
						.getFrame(DialogFrameFactory.LISTDIALOG,
								new DialogPanelFactory());
 
				Dialogs.getDialogListTool()
						.setListModel(frame.getContentComponent(), "day");

				frame.addDispatcher(new Dispatcher<Result>() {
					@Override
					public void receive(Object o) {
					}

					@Override
					public void receive(Result result) {
						DefaultModelCell dayCell = (DefaultModelCell) result
								.get(DialogFrameFactory.DAYDIALOG);
						int d = (int) dayCell.getValue();

						date = String.format("%s-%s-%s", DefaultYearForTest,
								DefaultMonthForTest, d);
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

		JButton btnPunchIn = new JButton("punch in");
		btnPunchIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timestamp ts = Timestamp
						.valueOf(String.format("%s %s", date, time));
				defaultWageForTest.setPunchIn(ts);
				  Wages .punchIn(defaultWageForTest, new HalfHourPunchStrategy());
				refreshListModel();
			}
		});
		btnPunchIn.setFocusable(false);
		btnPunchIn.setBackground(SystemColor.control);
		btnPunchIn.setBounds(737, 115, 193, 53);
		btnPunchIn.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnPunchIn);

		list = new JList();
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
		scrollPane.setBounds(38, 133, 667, 165);
		panel_1.add(scrollPane);
		scrollPane.setViewportView(list);

		JButton btnPunchOut = new JButton("punch out");
		btnPunchOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timestamp ts = Timestamp
						.valueOf(String.format("%s %s", date, time));
				defaultWageForTest.setPunchOut(ts);
				Wages.punchOut(defaultWageForTest, new HalfHourPunchStrategy());
				refreshListModel();
			}
		});
		btnPunchOut.setFont(new Font("新細明體", Font.PLAIN, 36));
		btnPunchOut.setFocusable(false);
		btnPunchOut.setBackground(SystemColor.menu);
		btnPunchOut.setBounds(737, 213, 193, 53);
		panel_1.add(btnPunchOut);

		JButton btnTestPrint = new JButton("test print");
		btnTestPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultWageForTest.printListForTest();
			}
		});
		btnTestPrint.setFont(new Font("新細明體", Font.PLAIN, 36));
		btnTestPrint.setFocusable(false);
		btnTestPrint.setBackground(SystemColor.menu);
		btnTestPrint.setBounds(709, 10, 193, 53);
		panel_1.add(btnTestPrint);

		JButton btnNew = new JButton("new");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultWageForTest.newHoldingPunch();
			}
		});
		btnNew.setFont(new Font("新細明體", Font.PLAIN, 36));
		btnNew.setFocusable(false);
		btnNew.setBackground(SystemColor.menu);
		btnNew.setBounds(737, 309, 193, 53);
		panel_1.add(btnNew);

	}

	private void refreshListModel() {
		ListModel model = Wages.getListModelForMonth(defaultWageForTest, 1);
		this.list.setModel(model);
	}
}
