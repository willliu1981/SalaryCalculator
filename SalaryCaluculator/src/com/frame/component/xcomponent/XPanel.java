package com.frame.component.xcomponent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class XPanel extends JPanel {
	private Object result;
	private JFrame father;

	public XPanel() {

	}

	public XPanel(JFrame father) {
		this.father = father;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Object getReslut() {
		return this.result;
	}

	public void dispose() {
		this.father.dispose();
	}

}
