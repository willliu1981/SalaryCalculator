package com.v4.frame.component.frame;

import java.awt.Window;

public abstract class AbsFrameFactory {
	abstract Window getFrameInstance(String contentPanelName);
}
