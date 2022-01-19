package com.frame.component.dailog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.frame.component.PanelFactory;
import com.frame.component.xcomponent.XButton;
import com.frame.component.xcomponent.XPanel;

public class DateDailogPanel extends XPanel {
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

		XButton btnNewButton = new XButton("Month") {
			@Override
			public void update(Object o) {
				System.out.println("date d p **" + o);
				this.setText((String) o);
			}
		};
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DailogFrameFactory frame = DailogFrameFactory
						.getFrameInstance(PanelFactory.MONTHDAILOG);
				frame.setListener(btnNewButton);
			}

		});

		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBounds(38, 31, 193, 53);
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Date");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setBounds(302, 31, 193, 53);
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Ok");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setBounds(212, 271, 193, 53);
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton_2);

	}

}
