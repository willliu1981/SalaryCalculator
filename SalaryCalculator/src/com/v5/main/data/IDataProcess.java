package com.v5.main.data;

public interface IDataProcess<T> {
	void load(String fileUrl, T t);

	void save(String fileUrl, T t);
}
