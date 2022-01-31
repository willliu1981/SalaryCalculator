package com.v4.frame.component.jpanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.v4.frame.component.IListModelComponent;
import com.v4.frame.component.jframe.DialogFrame;
import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jframe.FrameAndDialogGenerator;
import com.v4.frame.component.jframe.IDialog;
import com.v4.listener.Dispatcher;
import com.v4.model.DefaultModelCell;
import com.v4.model.ListDialogModel;
import com.v4.model.Result;

//dispatcherResult 的清空問題
/*
 * 
 */
public class DateDialogPanel extends AbsDialogPanel {
	private int month;
	private int day;
	private Result dispatcherResult = new Result();

	/**
	 * Create the panel.
	 */
	public DateDialogPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		JButton btnMonth = new JButton("Month");
		btnMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DialogFrame dialog = (DialogFrame) FrameAndDialogGenerator
						.getFrame(DialogFrameFactory.LISTDIALOG,
								new DialogPanelFactory());

				IListModelComponent<ListDialogModel<DefaultModelCell>> comp = (IListModelComponent<ListDialogModel<DefaultModelCell>>) dialog
						.getContentComponent();
				ListDialogModel<DefaultModelCell> model = new ListDialogModel<>();
				DefaultModelCell cell = new DefaultModelCell("一月");
				cell.setValue(1);
				model.addElement(cell);
				DefaultModelCell cell2 = new DefaultModelCell("二月");
				cell2.setValue(2);
				model.addElement(cell2);
				DefaultModelCell cell3 = new DefaultModelCell("三月");
				cell3.setValue(3);
				model.addElement(cell3);
				comp.setModel(model);

				dialog.addDispatcher(new Dispatcher() {

					@Override
					public void receive(Object o) {
						// TODO Auto-generated method stub

					}

					@Override
					public void receive(Result result) {
						DefaultModelCell cell = (DefaultModelCell) result.get();

						int m = (int) cell.getValue();

						month = m;
						btnMonth.setText("月份:" + month);
						dispatcherResult.add(DialogFrameFactory.MONTHDIALOG,
								cell);

						updateDispatcher(dispatcherResult);

					}

				}

				);
			}

		});

		btnMonth.setFocusable(false);
		btnMonth.setBackground(SystemColor.control);
		btnMonth.setBounds(38, 31, 193, 53);
		btnMonth.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnMonth);

		JButton btnDay = new JButton("Day");
		btnDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDialog dialog = (IDialog) FrameAndDialogGenerator.getFrame(
						DialogFrameFactory.DAYDIALOG, new DialogPanelFactory());
				dialog.addDispatcher(new Dispatcher<Result>() {
					@Override
					public void receive(Object o) {
						if (o instanceof Integer) {
							day = ((Integer) o).intValue();
							btnDay.setText("日期:" + day);
							dispatcherResult.add(DialogFrameFactory.DAYDIALOG,
									day);
							updateDispatcher(dispatcherResult);
						}
					}
				});
			}

		});
		btnDay.setFocusable(false);
		btnDay.setBackground(SystemColor.control);
		btnDay.setBounds(302, 31, 193, 53);
		btnDay.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnDay);

	}

}
