package com.v4.frame.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.v4.frame.IFrame;
import com.v4.frame.component.fabricate.ComponentFabricator;
import com.v4.frame.component.fabricate.TitleFabricator;
import com.v4.frame.component.jpanel.JFramePanelFactory;

public class MainFrame extends JFrame implements IFrame {

	private JPanel contentPane;

	private ComponentFabricator titleFabricator = new TitleFabricator(this);

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

		fabricate();
	}

	@Override
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
		btnRegister.setFont(new Font("新細明體", Font.PLAIN, 30));
		btnRegister.setFocusable(false);
		btnRegister.setBackground(SystemColor.control);
		panel_title.add(btnRegister);
		// 組件分離
		titleFabricator.add(TitleFabricator.REGISTERBTN, btnRegister);

		JButton btnView = new JButton("View");
		btnView.setFont(new Font("新細明體", Font.PLAIN, 30));
		btnView.setFocusable(false);
		btnView.setBackground(SystemColor.control);
		panel_title.add(btnView);
		// 組件分離
		titleFabricator.add(TitleFabricator.VIEWBTN, btnView);
	}

	// card panel
	private void initContentComponent() {
		JPanel panel_content = new JPanel();
		contentPane.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new CardLayout(0, 0));
		titleFabricator.add(TitleFabricator.FATHERPANEL, panel_content);
	}

	private void fabricate() {
		titleFabricator.fabricate(new JFramePanelFactory());
	}

}
