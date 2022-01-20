package com.frame.component.dailog;

import java.awt.Window;

import javax.swing.JPanel;

import com.frame.component.receiver.IResponse;

/*
	用於擴展各種類型的Dialog
*/
public class DialogPanel extends JPanel implements IResponse {
	private Object result;
	private Window father;

	public DialogPanel() {

	}

	public DialogPanel(Window father) {
		this.father = father;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public void dispose() {
		this.father.dispose();
	}

	@Override
	public Object getResult() {
		return this.result;
	}

	@Override
	public void response() {
		IResponse fa = (IResponse) father;
		fa.setResult(this.getResult());
	}

}
