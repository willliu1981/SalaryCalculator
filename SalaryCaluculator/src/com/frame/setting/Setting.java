package com.frame.setting;

import com.frame.component.xcomponent.DialogFactory;
import com.frame.component.xcomponent.FrameGenerator;
import com.frame.component.xcomponent.JFrameFactory;

public class Setting {
	public static void initialize() {
		FrameGenerator.setFactory(new DialogFactory());
		FrameGenerator.setFactory(new JFrameFactory());
	}
}
