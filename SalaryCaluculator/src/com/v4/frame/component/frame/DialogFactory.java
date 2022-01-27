package com.v4.frame.component.frame;

import java.awt.Window;

import javax.swing.JDialog;

import com.frame.component.xcomponent.IDialog;
import com.v4.frame.component.panel.MonthDialogPanel;

public class DialogFactory extends AbsFrameFactory {
	public static final String MONTHDIALOG = "monthdialog";
	public static final String DAYDIALOG = "daydialog";
	public static final String DATEDIALOG = "datedialog";

	public Window getFrameInstance(String contentPanelName) {
		JDialog frame = null;
		frame = new DialogFrame();
		if (frame != null) {
			((IDialog) frame).setContentComponent(contentPanelName);
		}
		return frame;
	}

}
