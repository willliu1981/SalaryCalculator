package com.frame.component.dailog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.frame.component.PanelFactory;

public class DailogFrame extends JFrame {
	private static DailogFrame thisFrame = new DailogFrame();

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	private DailogFrame() {
		initialize();
	}

	private void initialize() {
		initMainComponent();
	}

	private void initMainComponent() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1019, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

	private void initContent(String name) {
		contentPane.removeAll();
		contentPane.add(PanelFactory.getPanel(name), BorderLayout.CENTER);
	}

	public static JFrame getFrameInstance(String name) {
		thisFrame.initContent(name);
		thisFrame.setVisible(true);
		return thisFrame;
	}

}
