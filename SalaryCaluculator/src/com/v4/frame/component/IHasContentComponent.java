package com.v4.frame.component;

import com.v4.frame.component.panel.IPanelFactory;

public interface IHasContentComponent {
	void setContentComponent(String compName,IPanelFactory factory);
}
