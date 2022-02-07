package com.v5.window.jframe;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.v5.main.Application;
import com.v5.window.fabricate.ComponentFabricator;
import com.v5.window.fabricate.TitleFabricator;
import com.v5.window.jframe.interfaces.IFrame;
import com.v5.window.jpanel.factory.JFramePanelFactory;

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

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		mnFile.setFont(new Font(Font.SERIF, Font.PLAIN, 30));

		JMenuItem mntmLoad = new JMenuItem("Load default File");
		mnFile.add(mntmLoad);
		mntmLoad.setFont(new Font(Font.SERIF, Font.PLAIN, 30));

		JMenuItem mntmSave = new JMenuItem("Save as default File");
		mnFile.add(mntmSave);
		mntmSave.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
		mntmSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Application.save();
			}
		});
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
		titleFabricator.add(TitleFabricator.REGISTER, btnRegister);

		JButton btnView = new JButton("View");
		btnView.setFont(new Font("新細明體", Font.PLAIN, 30));
		btnView.setFocusable(false);
		btnView.setBackground(SystemColor.control);
		panel_title.add(btnView);
		// 組件分離
		titleFabricator.add(TitleFabricator.VIEW, btnView);
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
