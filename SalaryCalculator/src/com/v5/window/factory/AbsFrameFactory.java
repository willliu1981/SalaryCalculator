package com.v5.window.factory;

import java.awt.Window;

import com.v5.window.jpanel.factory.IPanelFactory;



public abstract class AbsFrameFactory {
	abstract Window getFrameInstance(String contentPanelName,IPanelFactory factory);
}
