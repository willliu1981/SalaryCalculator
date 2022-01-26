package com.v4.frame.component.panel;

import java.awt.Window;

import javax.swing.JPanel;

import com.frame.component.ViewPanel;
import com.frame.component.dailog.RegisterTimeDailogPanel;

public class PanelFactory implements IPanelFactory{
	public static final String REGISTER = "register";
	public static final String VIEW = "view";
	public static final String DATEDAILOG = "dateDailog";
	public static final String REGISTERTIMEDAILOG = "registerTimeDailog";
	public static final String MONTHDAILOG = "monthDailog";

	public JPanel getPanel(String name) {
		return getPanel(name, null);
	}

	public JPanel getPanel(String name, Window father) {
		JPanel panel = null;
		switch (name) {
		case REGISTER:
			panel = new RegisterPanel();
			break;
		case VIEW:
			panel = new ViewPanel();
			break;
		case DATEDAILOG:
			panel = new DateDailogPanel();
			break;
		case REGISTERTIMEDAILOG:
			panel = new RegisterTimeDailogPanel();
			break;
		case MONTHDAILOG:
			panel = new MonthDialogPanel();
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
