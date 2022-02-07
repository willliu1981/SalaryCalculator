package com.v5.main.setting;

import com.v5.window.factory.DialogFrameFactory;
import com.v5.window.factory.FrameAndDialogGenerator;
import com.v5.window.factory.JFrameFactory;
import com.v5.window.factory.jlist.DayModelFactory;
import com.v5.window.factory.jlist.HourModelFactory;
import com.v5.window.factory.jlist.ListModelFactory;
import com.v5.window.factory.jlist.MinuteModelFactory;
import com.v5.window.factory.jlist.MonthModelFactory;
import com.v5.xml.factory.XMLCreator;

public class Setting {
	public static void initialize() {
		XMLCreator.createXMLData("data/xml/component_config.xml");
		FrameAndDialogGenerator.setFactory(new DialogFrameFactory());
		FrameAndDialogGenerator.setFactory(new JFrameFactory());
		ListModelFactory
				.setFactory(ListModelFactory.MONTH, new MonthModelFactory())
				.setFactory(ListModelFactory.Day, new DayModelFactory())
				.setFactory(ListModelFactory.HOUR, new HourModelFactory())
				.setFactory(ListModelFactory.MINUTE, new MinuteModelFactory());
	}
}
