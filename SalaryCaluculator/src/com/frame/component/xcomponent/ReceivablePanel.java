package com.frame.component.xcomponent;

import javax.swing.JPanel;

import com.frame.component.dailog.DailogFrameFactory;

public class ReceivablePanel extends JPanel {
	private Object result;
	private DailogFrameFactory father;

	public ReceivablePanel() {

	}

	public ReceivablePanel(DailogFrameFactory father) {
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
