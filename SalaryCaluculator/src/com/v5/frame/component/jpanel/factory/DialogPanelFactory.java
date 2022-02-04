package com.v5.frame.component.jpanel.factory;

import java.awt.Window;

import javax.swing.JPanel;

import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jpanel.DayDialogPanel;
import com.v4.frame.component.jpanel.IPanelFactory;
import com.v4.frame.component.jpanel.ListDialogPanel;
import com.v4.frame.component.jpanel.MonthDialogPanel;
import com.v4.frame.component.jpanel.dialogpanel.DateDialogPanel;
import com.v4.frame.component.jpanel.dialogpanel.TimeDialogPanel;


//棄用?
public class DialogPanelFactory implements IPanelFactory {

	public DialogPanelFactory() {

	}

	public static final String MONTHDIALOG = DialogFrameFactory.MONTHDIALOG;
	public static final String DATEDIALOG = DialogFrameFactory.DATEDIALOG;
	public static final String TIMEDIALOG = DialogFrameFactory.TIMEDIALOG;
	public static final String DAYDIALOG = DialogFrameFactory.DAYDIALOG;
	public static final String LISTDIALOG = DialogFrameFactory.LISTDIALOG;

	public JPanel getPanel(String name) {
		return getPanel(name, null);
	}

	public JPanel getPanel(String name, Window father) {
		JPanel panel = null;

		switch (name) {
		case MONTHDIALOG:
			panel = new MonthDialogPanel();//棄用?
			break;
		case DAYDIALOG:
			panel = new DayDialogPanel();//棄用?
			break;
		case DATEDIALOG:
			panel = new DateDialogPanel();
			break;
		case TIMEDIALOG:
			panel = new TimeDialogPanel();
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
