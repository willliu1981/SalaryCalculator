package com.frame.setting;

import com.v4.frame.component.frame.DialogFactory;
import com.v4.frame.component.frame.FrameGenerator;
import com.v4.frame.component.frame.JFrameFactory;

public class Setting {
	public static void initialize() {
		FrameGenerator.setFactory(new DialogFactory());
		FrameGenerator.setFactory(new JFrameFactory());
	}
}
