package com.v5.window.factory;

import java.awt.Window;

import javax.swing.JFrame;

import com.v5.window.jpanel.factory.IPanelFactory;



public class JFrameFactory extends AbsFrameFactory {
	public static final String TESTJFRAME = "testjframe";

	public Window getFrameInstance(String contentPanelName,
			IPanelFactory factory) {
		JFrame frame = null;
		switch (contentPanelName) {
		case TESTJFRAME:
			frame = new JFrame();
			frame.setBounds(100, 100, 600, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			break;
		default:
			break;
		}

		if (frame != null) {
			frame.setVisible(true);
		}
		return frame;
	}

}
