package com.v5.window.jpanel.factory;

import java.awt.BorderLayout;
import java.awt.Window;

import javax.swing.JPanel;

import com.v5.window.jpanel.RegisterPanel;


/*
 * 取得 JFrame 的 Panel 工廠
 */
public class JFramePanelFactory implements IPanelFactory {
	public static final String TESTJFRAME = "testjframe";
	public static final String REGISTER = "register";
	public static final String VIEW = "view";
	public static final String DATEDAILOG = "dateDailog";
	public static final String REGISTERTIMEDAILOG = "registerTimeDailog";

	public JPanel getPanel(String name) {
		return getPanel(name, null);
	}

	public JPanel getPanel(String name, Window father) {
		JPanel panel = null;
		switch (name) {
		case TESTJFRAME:
			//default null
			break;
		case REGISTER:
			panel = new RegisterPanel();
			break;
		case VIEW:
			//panel = new ViewPanel();
			break;
		case DATEDAILOG:
			//panel = new DateDialogPanel();
			break;
		case REGISTERTIMEDAILOG:
			//panel = new RegisterTimeDailogPanel();
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
