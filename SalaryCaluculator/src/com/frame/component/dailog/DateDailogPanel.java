package com.frame.component.dailog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.frame.component.PanelFactory;
import com.frame.component.xcomponent.ReceivableListener;

public class DateDailogPanel extends DialogPanel {
	private int month;
	private int day;
	private DateDailogPanel thisPanel = this;

	/**
	 * Create the panel.
	 */
	public DateDailogPanel() {
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
				DialogFrame dailog = DialogFactory
						.getFrameInstance(PanelFactory.MONTHDAILOG);
				dailog.addReceivableListener(new ReceivableListener() {
					@Override
					public void update(Object o) {
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
