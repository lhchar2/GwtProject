package com.jaosn.gwtproject.client.feature;

public interface IsSvcPanelContent {

	void setSvcPanel(IsSvcPanel svcPanel);
	
	void refreshHeader();
	
	/** Preferred width used in CustomerProfilePage for resizing
	 * 
	 *  If the widget wants to have the width as longer as the screen, return 0
	 *  
	 * @return max. width in resizing
	 */
	int getMaxWidth();

}
