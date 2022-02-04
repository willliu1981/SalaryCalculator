package com.v4.setting;

import com.v4.factory.listmodel.ListModelFactory;
import com.v4.frame.component.jframe.DialogFrameFactory;
import com.v4.frame.component.jframe.FrameAndDialogGenerator;
import com.v4.frame.component.jframe.JFrameFactory;
import com.v4.frame.component.jpanel.dialogpanel.jlist.factory.DayModelFactory;
import com.v4.frame.component.jpanel.dialogpanel.jlist.factory.HourModelFactory;
import com.v4.frame.component.jpanel.dialogpanel.jlist.factory.MinuteModelFactory;
import com.v4.frame.component.jpanel.dialogpanel.jlist.factory.MonthModelFactory;

public class Setting {
	public static void initialize() {
		XMLCreator.createXMLData();
		FrameAndDialogGenerator.setFactory(new DialogFrameFactory());
		FrameAndDialogGenerator.setFactory(new JFrameFactory());
		ListModelFactory
				.setFactory(ListModelFactory.MONTH, new MonthModelFactory())
				.setFactory(ListModelFactory.Day, new DayModelFactory())
				.setFactory(ListModelFactory.HOUR, new HourModelFactory())
				.setFactory(ListModelFactory.MINUTE, new MinuteModelFactory());

	}
}
