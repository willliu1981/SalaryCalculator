package com.frame.component.receiver;

import com.frame.component.xcomponent.ReceivableListener;

public interface IReceivable {
	public void addReceivableListener(ReceivableListener listener) ;
	public void update();
}
