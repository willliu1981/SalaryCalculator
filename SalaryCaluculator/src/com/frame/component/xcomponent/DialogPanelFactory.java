package com.frame.component.xcomponent;

import java.awt.Window;

import javax.swing.JPanel;

import com.frame.component.dailog.DateDailogPanel;

public class DialogPanelFactory implements IPanelFactory {

	public DialogPanelFactory() {

	}

	public static final String MONTHDIALOG = "monthdialog";
	public static final String DATEDIALOG = "datedialog";

	public JPanel getPanel(String name) {
		return getPanel(name, null);
	}

	public JPanel getPanel(String name, Window father) {
		JPanel panel = null;
		switch (name) {
		case MONTHDIALOG:
			panel = new MonthDialogPanel();
			break;
		case DATEDIALOG:
			panel = new DateDailogPanel();
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
