package com.jaosn.gwtproject.client.widget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ScrollPanel;

public class SvcScrollPanel extends ScrollPanel {
	
	//GWT's ScrollPanel use 2 div element but only set the height of outer one
	//If we need 100% height

	@Override
	public void setHeight(String height) {
		super.setHeight(height);
		DOM.setStyleAttribute(getContainerElement(), "height", height);
	}

}
