package com.frame.component.fabricate;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.frame.component.PanelFactory;
import com.frame.component.tool.XComponents;

public class TitleFabricator extends ComponentFabricator {
	private JPanel panelFather = null;
	private JButton btnRegister = null;
	private JButton btnView = null;

	private void switchCardPanel(String name) {
		CardLayout layout = (CardLayout) panelFather.getLayout();

		if (!XComponents.containPanel(panelFather, name)) {
			panelFather.add(new PanelFactory().getPanel(name), name);
		}
		layout.show(panelFather, name);
	}

	@Override
	public void fabricate() {
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
			btnRegister.setFont(new Font("新細明體", Font.PLAIN, 36));
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchCardPanel(strRegister);
				}
			});
		}

		if (this.isExist(strView)) {
			btnView = (JButton) this.get(strView);
			btnView.setFont(new Font("新細明體", Font.PLAIN, 36));
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchCardPanel(strView);
				}
			});
		}
	}

}
