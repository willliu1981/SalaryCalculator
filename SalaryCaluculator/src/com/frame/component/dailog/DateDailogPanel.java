package com.frame.component.dailog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.frame.component.PanelFactory;
import com.frame.component.receiver.IResponse;
import com.frame.component.xcomponent.DialogFactory;
import com.frame.component.xcomponent.FrameGenerator;
import com.frame.component.xcomponent.IDialog;
import com.frame.component.xcomponent.ReceiverListener;

public class DateDailogPanel extends DialogPanel {
	private int month;
	private int day;
	private DateDailogPanel thisPanel = this;

	public DateDailogPanel() {
		this(null);
	}

	/**
	 * Create the panel.
	 */
	public DateDailogPanel(IResponse father) {
		super(father);
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
				IDialog dialog = (IDialog) FrameGenerator
						.getFrame(DialogFactory.MONTHDIALOG);
				dialog.addReceivableListener(new ReceiverListener() {
					@Override
					public void receive(Object o) {
						btnMonth.setText((String) o);
					}
				});
			}

		});

		btnMonth.setFocusable(false);
		btnMonth.setBackground(SystemColor.control);
		btnMonth.setBounds(38, 31, 193, 53);
		btnMonth.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnMonth);

		JButton btnDay = new JButton("Day");
		btnDay.setFocusable(false);
		btnDay.setBackground(SystemColor.control);
		btnDay.setBounds(302, 31, 193, 53);
		btnDay.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnDay);

		JButton btnOK = new JButton("Ok");
		btnOK.setFocusable(false);
		btnOK.setBackground(SystemColor.control);
		btnOK.setBounds(212, 271, 193, 53);
		btnOK.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnOK);

	}

}
