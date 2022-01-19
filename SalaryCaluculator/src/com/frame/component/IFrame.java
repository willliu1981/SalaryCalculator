package com.frame.component;

public interface IFrame {
	default void initialize() {
		initMainComponent();
	}

	void initMainComponent();
}
