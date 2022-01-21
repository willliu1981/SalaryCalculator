package com.frame.component.dailog;

import javax.swing.JFrame;

public class DialogFactory {
	public static final String MONTHDAILOG = "monthDailog";//**與 PanelFactory 的常數耦合,需整理

	public static IDialog getFrameInstance(String contentPanelName) {
		IDialog frame = null;
		switch (contentPanelName) {
		case MONTHDAILOG:
			frame = new DialogFrame();
			break;
		default:
			break;
		}

		if (frame != null) {
			frame.setContentComponent(contentPanelName);
			JFrame jf = (JFrame) frame;
			jf.setVisible(true);
		}
		return frame;
	}

}
