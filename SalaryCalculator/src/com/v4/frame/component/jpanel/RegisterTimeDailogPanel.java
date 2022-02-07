package com.v4.frame.component.jpanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;

public class RegisterTimeDailogPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RegisterTimeDailogPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Start Time");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBounds(38, 31, 193, 53);
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("End Time");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setBounds(326, 31, 193, 53);
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ok");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setBounds(638, 31, 193, 53);
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_1.add(btnNewButton_2);

	}

}
