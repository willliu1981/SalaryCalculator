package com.frame.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.frame.component.behavior.ComponentBehavior;
import com.frame.component.behavior.TitleComponentBehavior;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	private ComponentBehavior titleComponentBehavior = new TitleComponentBehavior();

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initialize();
	}

	private void initialize() {
		initMainComponent();

		initContentComponent();
		initTitleComponent();

		doBehavior();
	}

	private void initMainComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private void initTitleComponent() {
		JPanel panel_title = new JPanel();
		contentPane.add(panel_title, BorderLayout.NORTH);

		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_title.add(btnRegister);

		JButton btnView = new JButton("View");
		btnView.setFont(new Font("新細明體", Font.PLAIN, 36));
		panel_title.add(btnView);

		titleComponentBehavior.add("register", btnRegister);
		titleComponentBehavior.add("view", btnView);
	}

	private void initContentComponent() {
		JPanel panel_content = new JPanel();
		contentPane.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new CardLayout(0, 0));
		titleComponentBehavior.add("panelContent", panel_content);
	}

	private void doBehavior() {
		titleComponentBehavior.doBehavior();
	}

}
