package com.v5.main;

import com.v5.main.data.DataProcessFactory;
import com.v5.main.data.IDataProcess;
import com.v5.main.data.XMLRecordDataProcess;
import com.v5.model.Wage;
import com.v5.window.jpanel.RegisterPanel;

public class Application {
	private static final String DEFAULT_FILE_URL = "data/save/xml/wage.xml";
	private static final Object fileObject = RegisterPanel.defaultWageForTest;

	private static final IDataProcess process = DataProcessFactory
			.getDefaultProcess();

	public static void load() {
		process.load(DEFAULT_FILE_URL, fileObject);

	}

	public static void save() {
		process.save(DEFAULT_FILE_URL, fileObject);
	}
}
