package com.frame.component.xcomponent;

import java.awt.Window;

import javax.swing.JPanel;

import com.frame.component.dailog.DateDailogPanel;
import com.frame.component.dailog.MonthDailogPanel;
import com.frame.component.dailog.RegisterTimeDailogPanel;
import com.frame.component.receiver.IResponse;
import com.frame.component.xcomponent.IPanelFactory;

public class DialogPanelFactory implements IPanelFactory{
	private DialogPanelFactory signleton=new DialogPanelFactory();
	
	public DialogPanelFactory() {
	
	}

	public static final String MONTHDAILOG = "monthDailog";

	public JPanel getPanel(String name) {
		return getPanel(name, null);
	}

	public JPanel getPanel(String name, Window father) {
		JPanel panel = null;
		switch (name) {
		case MONTHDAILOG:
			panel = new MonthDailogPanel((IResponse) father);
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
