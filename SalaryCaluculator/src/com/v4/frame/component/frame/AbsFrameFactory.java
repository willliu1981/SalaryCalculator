package com.v4.frame.component.frame;

import java.awt.Window;

import com.v4.frame.component.panel.IPanelFactory;

public abstract class AbsFrameFactory {
	abstract Window getFrameInstance(String contentPanelName,IPanelFactory factory);
}
