package com.frame.component.behavior;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.frame.component.PanelFactory;
import com.frame.component.tool.Components;

public class TitleComponentBehavior extends ComponentBehavior {
	private JPanel panelFather = null;
	private JButton btnRegister = null;

	private void switchCardPanel(String name) {
		CardLayout layout = (CardLayout) panelFather.getLayout();

		if (!Components.containPanel(panelFather, name)) {
			panelFather.add(PanelFactory.getPanel(name), name);
		}
		layout.show(panelFather, name);
	}

	@Override
	public void doBehavior() {
		String strPanelFather = "panelContent";
		String strRegister = "register";
		String strView = "view";

		if (this.isExist(strPanelFather)) {
			panelFather = (JPanel) this.get(strPanelFather);
		} else {
			throw new RuntimeException("找不到重要 component");
		}

		if (this.isExist(strRegister)) {
			btnRegister = (JButton) this.get(strRegister);
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchCardPanel(strRegister);
				}
			});
		}

		if (this.isExist(strView)) {
			btnRegister = (JButton) this.get(strView);
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchCardPanel(strView);
				}
			});
		}
	}

}
