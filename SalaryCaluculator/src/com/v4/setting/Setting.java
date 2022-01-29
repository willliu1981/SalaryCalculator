package com.v4.setting;

import com.v4.frame.component.jframe.DialogFactory;
import com.v4.frame.component.jframe.FrameGenerator;
import com.v4.frame.component.jframe.JFrameFactory;

public class Setting {
	public static void initialize() {
		FrameGenerator.setFactory(new DialogFactory());
		FrameGenerator.setFactory(new JFrameFactory());
	}
}
