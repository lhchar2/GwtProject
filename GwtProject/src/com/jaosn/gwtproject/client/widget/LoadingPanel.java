package com.jaosn.gwtproject.client.widget;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;

public class LoadingPanel {
	private static LoadingPanel instance;
	
	public static PopupPanel popup;	
	private static Image loadingImage;
	
	public static LoadingPanel get() {
		if (instance == null) {
			instance = new LoadingPanel();
		}
		return instance;
	}
	
    private LoadingPanel() {
    	popup = new PopupPanel(false);
    	popup.setGlassEnabled(true);
    	popup.setGlassStyleName("glass");    
    	
    	loadingImage = new Image("images/large-loading.gif");
    	/*
    	VerticalPanel popupContents = new VerticalPanel();
    	popupContents.setSize("400px", "200px");
    	popupContents.getElement().getStyle().setBackgroundColor("white");
    	
    	//large-loading.gif
    	popupContents.add(new Label("Now Loading"));
    	*/
        popup.clear();    	
    	popup.add(loadingImage);
    }

    public void open() {
        popup.show();
		int left = Window.getClientWidth() / 2 - popup.getOffsetWidth() / 2;
		int top = Window.getClientHeight() / 2 - popup.getOffsetHeight() / 2;
		popup.setPopupPosition(left, top);
    }

    public void close() {
    	popup.hide();	
    }
    
}
