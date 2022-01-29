package com.v4.frame.component.jframe;

import java.awt.Window;

import javax.swing.JDialog;

import com.v4.frame.component.jpanel.IPanelFactory;
import com.v4.frame.component.jpanel.MonthDialogPanel;

public class DialogFactory extends AbsFrameFactory {
	public static final String MONTHDIALOG = "monthdialog";
	public static final String DAYDIALOG = "daydialog";
	public static final String DATEDIALOG = "datedialog";

	public Window getFrameInstance(String contentPanelName,
			IPanelFactory factory) {
		JDialog frame = null;
		frame = new DialogFrame();
		if (frame != null) {
			((IDialog) frame).setContentComponent(contentPanelName, factory);
		}
		return frame;
	}

}
