package com.frame.component.xcomponent;

import java.awt.Window;

import javax.swing.JDialog;

public class DialogFactory extends FrameFactory {
	public static final String MONTHDIALOG = "monthdialog";
	public static final String DATEDIALOG = "datedialog";

	public Window getFrameInstance(String contentPanelName) {
		JDialog frame = new DialogFrame();

		if (frame != null) {
			((IDialog) frame).setContentComponent(contentPanelName);
			frame.setVisible(true);
		}
		return frame;
	}

}
