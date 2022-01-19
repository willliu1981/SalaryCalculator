package com.frame.component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.frame.component.dailog.DateDailogPanel;
import com.frame.component.dailog.MonthDailogPanel;
import com.frame.component.dailog.RegisterTimeDailogPanel;

public class PanelFactory {
	public static final String REGISTER = "register";
	public static final String VIEW = "view";
	public static final String DATEDAILOG = "dateDailog";
	public static final String REGISTERTIMEDAILOG = "registerTimeDailog";
	public static final String MONTHDAILOG = "monthDailog";

	public static JPanel getPanel(String name) {
		return getPanel(name, null);
	}

	public static JPanel getPanel(String name, JFrame father) {
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
			panel = new MonthDailogPanel(father);
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
