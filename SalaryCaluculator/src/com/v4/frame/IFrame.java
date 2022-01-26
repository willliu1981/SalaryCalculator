package com.v4.frame;

public interface IFrame {
	default void initialize() {
		initMainComponent();
	}

	void initMainComponent();
}
