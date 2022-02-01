package com.v4.setting;

import com.v4.factory.listmodel.DayModelFactory;
import com.v4.factory.listmodel.HourModelFactory;
import com.v4.factory.listmodel.ListModelFactory;
import com.v4.factory.listmodel.MinuteModelFactory;
import com.v4.factory.listmodel.MonthModelFactory;
import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jframe.FrameAndDialogGenerator;
import com.v4.frame.component.jframe.JFrameFactory;

public class Setting {
	public static void initialize() {
		FrameAndDialogGenerator.setFactory(new DialogFrameFactory());
		FrameAndDialogGenerator.setFactory(new JFrameFactory());
		ListModelFactory
				.setFactory(ListModelFactory.MONTH, new MonthModelFactory())
				.setFactory(ListModelFactory.Day, new DayModelFactory())
				.setFactory(ListModelFactory.HOUR, new HourModelFactory())
				.setFactory(ListModelFactory.MINUTE, new MinuteModelFactory());

	}
}
