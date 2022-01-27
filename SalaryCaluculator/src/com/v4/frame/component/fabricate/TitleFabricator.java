package com.v4.frame.component.fabricate;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.v4.frame.component.panel.PanelFactory;
import com.v4.tools.Components;

public class TitleFabricator extends ComponentFabricator {
	public TitleFabricator(Window frameFather) {
		super(frameFather);
	}

	static public final String FATHERPANEL = "panelContent";
	static public final String REGISTERBTN = PanelFactory.REGISTER;
	static public final String VIEWBTN = PanelFactory.VIEW;
	private JPanel panelFather = null;
	private JButton btnRegister = null;
	private JButton btnView = null;

	private void switchCardPanel(String name) {
		CardLayout layout = (CardLayout) panelFather.getLayout();

		if (!Components.containPanel(new PanelFactory(), panelFather, name)) {
			panelFather.add(new PanelFactory().getPanel(name), name);
		}
		layout.show(panelFather, name);
		this.getFrameFather().setVisible(true);
		
	}

	@Override
	public void fabricate() {

		if (this.isExist(FATHERPANEL)) {
			panelFather = (JPanel) this.get(FATHERPANEL);
		} else {
			throw new RuntimeException("找不到重要 component");
		}

		if (this.isExist(REGISTERBTN)) {
			btnRegister = (JButton) this.get(REGISTERBTN);
			btnRegister.setFont(new Font("新細明體", Font.PLAIN, 36));
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchCardPanel(REGISTERBTN);
				}
			});
		}

		if (this.isExist(VIEWBTN)) {
			btnView = (JButton) this.get(VIEWBTN);
			btnView.setFont(new Font("新細明體", Font.PLAIN, 36));
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switchCardPanel(VIEWBTN);
				}
			});
		}
	}

}
