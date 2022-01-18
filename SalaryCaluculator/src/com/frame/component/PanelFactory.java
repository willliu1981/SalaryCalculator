package com.frame.component;

import javax.swing.JPanel;

import com.frame.component.dailog.DateDailogPanel;

public class PanelFactory {

	public static JPanel getPanel(String name) {
		JPanel panel=null;
		switch (name) {
		case "register":
			panel=new RegisterPanel();
			break;
		case "view":
			panel=new ViewPanel();
			break;
		case "dateDailog":
			panel=new DateDailogPanel();
			break;
		default:
			break;
		}
		if(panel !=null) {
			panel.setName(name);
		}
		return panel;
	}
}
