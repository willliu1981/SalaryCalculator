package com.v4.tools;

import java.awt.Component;

import javax.swing.JComponent;

import com.v4.frame.component.jpanel.IPanelFactory;
import com.v4.frame.component.jpanel.JFramePanelFactory;

public class Components {

	public static boolean containPanel(IPanelFactory factory,JComponent father, String comp) {
		Component[] comps = father.getComponents();
		for (int i = 0; i < comps.length; i++) {
			if (comps[i].getName()
					.equals(factory.getPanel(comp).getName())) {
				return true;
			}
		}
		return false;
	}
}
