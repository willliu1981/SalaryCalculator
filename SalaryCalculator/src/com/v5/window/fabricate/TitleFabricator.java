package com.v5.window.fabricate;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.v5.tools.Components;
import com.v5.window.jpanel.factory.IPanelFactory;

public class TitleFabricator extends ComponentFabricator {

	public TitleFabricator(Window frameFather) {
		super(frameFather);
	}

	static public final String FATHERPANEL = "fatherpanel";
	static public final String REGISTER = "register";
	static public final String VIEW = "view";
	private JPanel panelFather = null;
	private JButton btnRegister = null;
	private JButton btnView = null;

	private void switchCardPanel(String name, IPanelFactory factory) {
		CardLayout layout = (CardLayout) panelFather.getLayout();

		if (!Components.containPanel(factory, panelFather, name)) {
			panelFather.add(factory.getPanel(name), name);
		}
		layout.show(panelFather, name);
		this.getFrameFather().setVisible(true);

	}

	@Override
	public void fabricate(IPanelFactory factory) {

		if (this.isExist(FATHERPANEL)) {
			panelFather = (JPanel) this.get(FATHERPANEL);
		} else {
			throw new RuntimeException("找不到重要 component");
		}

		if (this.isExist(REGISTER)) {
			btnRegister = (JButton) this.get(REGISTER);
			btnRegister.setFont(new Font("新細明體", Font.PLAIN, 36));
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchCardPanel(REGISTER, factory);
				}
			});
		}

		if (this.isExist(VIEW)) {
			btnView = (JButton) this.get(VIEW);
			btnView.setFont(new Font("新細明體", Font.PLAIN, 36));
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchCardPanel(VIEW, factory);
				}
			});
		}
	}

}
