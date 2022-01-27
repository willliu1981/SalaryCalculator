package com.frame.component.xcomponent;

import com.v4.frame.component.panel.IPanelFactory;

public interface IHasContentComponent {
	void setContentComponent(String compName,IPanelFactory factory);
}
