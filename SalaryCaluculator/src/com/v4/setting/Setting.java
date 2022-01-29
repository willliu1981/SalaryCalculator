package com.v4.setting;

import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jframe.FrameAndDialogGenerator;
import com.v4.frame.component.jframe.JFrameFactory;

public class Setting {
	public static void initialize() {
		FrameAndDialogGenerator.setFactory(new DialogFrameFactory());
		FrameAndDialogGenerator.setFactory(new JFrameFactory());
	}
}
