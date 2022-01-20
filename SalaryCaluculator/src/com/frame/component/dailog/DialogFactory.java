package com.frame.component.dailog;

public class DialogFactory {
	public static DialogFrame getFrameInstance(String contentPanelName) {
		DialogFrame frame = new DialogFrame();
		frame.setContentPanel(contentPanelName);
		frame.setVisible(true);
		return frame;
	}

}
