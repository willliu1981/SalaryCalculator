package com.frame.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.frame.component.IFrame;
import com.frame.component.PanelFactory;
import com.frame.component.behavior.ComponentBehavior;
import com.frame.component.behavior.TitleComponentBehavior;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements IFrame {

	private JPanel contentPane;

	private ComponentBehavior titleComponentBehavior = new TitleComponentBehavior();

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initialize();
	}

	public void initialize() {
		IFrame.super.initialize();

		initContentComponent();
		initTitleComponent();

		doBehavior();
	}

	public void initMainComponent() {
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
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRegister.setFocusable(false);
		btnRegister.setBackground(SystemColor.control);
		panel_title.add(btnRegister);
		titleComponentBehavior.add(PanelFactory.REGISTER, btnRegister);

		JButton btnView = new JButton("View");
		btnView.setFocusable(false);
		btnView.setBackground(SystemColor.control);
		panel_title.add(btnView);
		titleComponentBehavior.add(PanelFactory.VIEW, btnView);

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
