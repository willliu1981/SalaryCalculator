package com.frame.component.dailog;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Insets;

public class DateDailogPanel extends JPanel {

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
		
		JButton btnNewButton = new JButton("Test");
		btnNewButton.setBounds(38, 31, 193, 53);
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(173, 131, 193, 53);
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(212, 271, 193, 53);
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton_2);

	}

}
