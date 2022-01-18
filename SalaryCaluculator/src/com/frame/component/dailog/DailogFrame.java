package com.frame.component.dailog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DailogFrame extends JFrame {
	private static JFrame thisFrame = new DailogFrame();

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	private DailogFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public static JFrame getFrameInstance(JPanel panel) {
		
		return thisFrame;
	}

}
