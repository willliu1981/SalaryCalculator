package com.v4.frame.component.jpanel;

import java.awt.Window;

import javax.swing.JPanel;

import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.model.ListDialogModel;

public class DialogPanelFactory implements IPanelFactory {

	public DialogPanelFactory() {

	}

	public static final String MONTHDIALOG = DialogFrameFactory.MONTHDIALOG;
	public static final String DATEDIALOG = DialogFrameFactory.DATEDIALOG;
	public static final String DAYDIALOG = DialogFrameFactory.DAYDIALOG;
	public static final String LISTDIALOG = DialogFrameFactory.LISTDIALOG;

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
