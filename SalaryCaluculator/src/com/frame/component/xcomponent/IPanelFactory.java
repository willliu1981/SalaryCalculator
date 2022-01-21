package com.frame.component.xcomponent;

import java.awt.Window;

import javax.swing.JPanel;

public interface IPanelFactory {
	JPanel getPanel(String name);

	JPanel getPanel(String name, Window father);
}
