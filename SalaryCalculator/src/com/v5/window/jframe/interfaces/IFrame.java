package com.v5.window.jframe.interfaces;

public interface IFrame {
	default void initialize() {
		initMainComponent();
	}

	void initMainComponent();
}
