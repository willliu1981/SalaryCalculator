package com.v4.frame.component.frame;

import java.awt.Window;

import javax.swing.JFrame;

public class JFrameFactory extends AbsFrameFactory {
	public static final String TESTJFRAME = "testjframe";

	public Window getFrameInstance(String contentPanelName) {
		JFrame frame = null;
		switch (contentPanelName) {
		case TESTJFRAME:
			frame = new JFrame();
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
