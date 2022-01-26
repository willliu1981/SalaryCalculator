package com.frame.component.xcomponent;

import java.awt.Window;

import javax.swing.JPanel;

import com.v4.frame.component.frame.DialogFactory;
import com.v4.frame.component.panel.DateDailogPanel;
import com.v4.frame.component.panel.DayDialogPanel;
import com.v4.frame.component.panel.IPanelFactory;
import com.v4.frame.component.panel.MonthDialogPanel;

public class DialogPanelFactory implements IPanelFactory {

	public DialogPanelFactory() {

	}

	public static final String MONTHDIALOG = DialogFactory.MONTHDIALOG;
	public static final String DATEDIALOG =DialogFactory.DATEDIALOG;
	public static final String DAYDIALOG =DialogFactory.DAYDIALOG;

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
