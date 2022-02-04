package com.v4.frame.component.jpanel.dialogpanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.v4.factory.listmodel.ListModelFactory;
import com.v4.frame.component.IListModelComponent;
import com.v4.frame.component.jframe.DialogFrame;
import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jframe.FrameAndDialogGenerator;
import com.v4.frame.component.jframe.IDialog;
import com.v4.frame.component.jpanel.AbsDialogPanel;
import com.v4.frame.component.jpanel.factory.DialogPanelFactory;
import com.v4.listener.Dispatcher;
import com.v4.model.DefaultModelCell;
import com.v4.model.ListDialogModel;
import com.v4.model.Result;
import com.v4.xml.XMLFactory;

//dispatcherResult 的清空問題
/*
 * 
 */
public class TimeDialogPanel extends AbsDialogPanel {
	private int hour;
	private int miniute;
	private Result dispatcherResult = new Result();

	/**
	 * Create the panel.
	 */
	public TimeDialogPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JButton btnMonth = new JButton("Hour");
		btnMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// *
				DialogFrame dialog = (DialogFrame) FrameAndDialogGenerator
						.getFrame(DialogFrameFactory.LISTDIALOG,
								new DialogPanelFactory());
				// */

				ListModelFactory.setModel(
						(IListModelComponent) dialog.getContentComponent(),
						ListModelFactory.HOUR);

				dialog.addDispatcher(new Dispatcher() {

					@Override
					public void receive(Object o) {
						// TODO Auto-generated method stub

					}

					@Override
					public void receive(Result result) {
						DefaultModelCell cell = (DefaultModelCell) result.get();

						int m = (int) cell.getValue();

						hour = m;
						btnMonth.setText("時:" + hour);
						dispatcherResult.add(DialogFrameFactory.HOURDIALOG,
								cell);

						updateDispatcher(dispatcherResult);
					}
				});
			}
		});

		btnMonth.setFocusable(false);
		btnMonth.setBackground(SystemColor.control);
		btnMonth.setBounds(38, 31, 193, 53);
		btnMonth.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnMonth);

		JButton btnDay = new JButton("Minute");
		btnDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogFrame dialog = (DialogFrame) FrameAndDialogGenerator
						.getFrame(DialogFrameFactory.LISTDIALOG,
								new DialogPanelFactory());
				ListModelFactory.setModel(
						(IListModelComponent) dialog.getContentComponent(),
						ListModelFactory.MINUTE);
				dialog.addDispatcher(new Dispatcher() {

					@Override
					public void receive(Object o) {
						// TODO Auto-generated method stub

					}

					@Override
					public void receive(Result result) {
						DefaultModelCell cell = (DefaultModelCell) result.get();

						int m = (int) cell.getValue();

						miniute = m;
						btnDay.setText("分:" + miniute);
						dispatcherResult.add(DialogFrameFactory.MINUTEDIALOG,
								cell);

						updateDispatcher(dispatcherResult);
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
