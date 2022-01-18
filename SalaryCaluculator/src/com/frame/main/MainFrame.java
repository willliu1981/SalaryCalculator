package com.frame.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.frame.component.PanelFactory;
import com.frame.component.tool.Components;

public class MainFrame extends JFrame {
	private JFrame thisFrame = this;

	private JPanel contentPane;
	private JPanel panel_content;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel_content = new JPanel();
		contentPane.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new CardLayout(0, 0));

		JPanel panel_title = new JPanel();
		contentPane.add(panel_title, BorderLayout.NORTH);
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchCardPanel("register");
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_title.add(btnNewButton);

		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchCardPanel("view");
			}
		});
		btnView.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_title.add(btnView);
	}

	private void switchCardPanel(String name) {
		CardLayout layout = (CardLayout) panel_content.getLayout();

		if (!Components.containPanel(panel_content, name)) {
			panel_content.add(PanelFactory.getPanel(name), name);
		}
		layout.show(panel_content, name);
	}

}
