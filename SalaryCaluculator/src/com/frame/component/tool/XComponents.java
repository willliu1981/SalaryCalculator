package com.frame.component.tool;

import java.awt.Component;

import javax.swing.JComponent;

import com.frame.component.PanelFactory;

public class XComponents {

	public static boolean containPanel(JComponent father, String comp) {
		Component[] comps = father.getComponents();
		for (int i = 0; i < comps.length; i++) {
			if (comps[i].getName()
					.equals(new PanelFactory().getPanel(comp).getName())) {
				return true;
			}
		}
		return false;
	}
}
