package com.v5.window.interfaces;

import javax.swing.JPanel;

import com.v5.window.jpanel.factory.IPanelFactory;


public interface IHasContentComponent {
	void setContentComponent(String compName,IPanelFactory factory);
	JPanel getContentComponent();
}
