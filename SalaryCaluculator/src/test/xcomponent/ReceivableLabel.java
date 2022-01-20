package test.xcomponent;

import javax.swing.JLabel;

public class ReceivableLabel extends JLabel implements ReceivableListener {
	public ReceivableLabel() {

	}

	public ReceivableLabel(String name) {
		super(name);
	}

	@Override
	public void update(Object o) {
		
	}
}
