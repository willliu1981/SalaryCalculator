package com.frame.component.xcomponent;

import java.awt.Window;

public abstract class FrameFactory {
	abstract Window getFrameInstance(String contentPanelName);
}
