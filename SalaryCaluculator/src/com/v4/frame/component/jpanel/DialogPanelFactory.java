package com.v4.frame.component.jpanel;

import java.awt.Window;

import javax.swing.JPanel;

import com.v4.frame.component.jframe.DialogFrameFactory;

public class DialogPanelFactory implements IPanelFactory {

	public DialogPanelFactory() {

	}

	public static final String MONTHDIALOG = DialogFrameFactory.MONTHDIALOG;
	public static final String DATEDIALOG =DialogFrameFactory.DATEDIALOG;
	public static final String DAYDIALOG =DialogFrameFactory.DAYDIALOG;

	public JPanel getPanel(String name) {
		return getPanel(name, null);
	}

	public JPanel getPanel(String name, Window father) {
		JPanel panel = null;
		switch (name) {
		case MONTHDIALOG:
			panel = new MonthDialogPanel();
			break;
		case DAYDIALOG:
			panel = new DayDialogPanel();
			break;
		case DATEDIALOG:
			panel = new DateDialogPanel();
			break;
		default:
			break;
		}
		if (panel != null) {
			panel.setName(name);
		}
		return panel;
	}
}
