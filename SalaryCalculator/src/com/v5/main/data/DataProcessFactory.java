package com.v5.main.data;

public class DataProcessFactory {
	private static final IDataProcess defaultProcess = new XMLRecordDataProcess();

	public static IDataProcess getDefaultProcess() {
		return defaultProcess;
	}
}
