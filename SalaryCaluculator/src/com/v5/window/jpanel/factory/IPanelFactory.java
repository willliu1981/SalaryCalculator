package com.v5.window.jpanel.factory;

import java.awt.Window;

import javax.swing.JPanel;

public interface IPanelFactory {
	JPanel getPanel(String name);

	JPanel getPanel(String name, Window father);
}
