package com.v4.frame.component.jframe;

import java.awt.Window;

import com.v4.frame.component.jpanel.IPanelFactory;

public abstract class AbsFrameFactory {
	abstract Window getFrameInstance(String contentPanelName,IPanelFactory factory);
}
