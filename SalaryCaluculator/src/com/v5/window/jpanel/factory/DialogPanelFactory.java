package com.v5.window.jpanel.factory;

import java.awt.Window;

import javax.swing.JPanel;

import com.v5.window.jpanel.ListDialogPanel;




//棄用?
public class DialogPanelFactory implements IPanelFactory {

	public DialogPanelFactory() {

	}

	//public static final String MONTHDIALOG = DialogFrameFactory.MONTHDIALOG;
	//public static final String DATEDIALOG = DialogFrameFactory.DATEDIALOG;
	//public static final String TIMEDIALOG = DialogFrameFactory.TIMEDIALOG;
	//public static final String DAYDIALOG = DialogFrameFactory.DAYDIALOG;
	public static final String LISTDIALOG = "listdialog";

	public JPanel getPanel(String name) {
		return getPanel(name, null);
	}

	public JPanel getPanel(String name, Window father) {
		JPanel panel = null;

		switch (name) {
		/*
		case MONTHDIALOG:
			//panel = new MonthDialogPanel();//棄用?
			break;
		case DAYDIALOG:
			//panel = new DayDialogPanel();//棄用?
			break;
		case DATEDIALOG:
			//panel = new DateDialogPanel();
			break;
		case TIMEDIALOG:
			//panel = new TimeDialogPanel();
			break;
			//*/
		case LISTDIALOG:
			panel = new ListDialogPanel();
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
