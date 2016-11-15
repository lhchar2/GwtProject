package com.jaosn.gwtproject.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jaosn.gwtproject.client.feature.IsPopupable;

public class SvcPopupPanel extends PopupPanel {

	private static SvcPopupPanelUiBinder uiBinder = GWT.create(SvcPopupPanelUiBinder.class);
	interface SvcPopupPanelUiBinder extends UiBinder<Widget, SvcPopupPanel> {}
	
	@UiField FocusPanel basePanel;
	@UiField HorizontalPanel headerHp;
	@UiField HTMLPanel mainPanel;
	@UiField Label title;
	@UiField Label datakey;
	
	@UiField Image closeBtn;
	@UiField SvcScrollPanel scrollArea;
	
	@UiField Label counter;
	
	HandlerRegistration keyDownHandler;
	HandlerRegistration resizeHandler;
	
	private int secondToHold = 0;
	private boolean closeLock = false;
	
	private Widget content;
	
	private Integer Width = null;
	private Integer Height = null;
	
	public SvcPopupPanel() {
		this("", "SVC", true);
	}
	
	public SvcPopupPanel(String title, String style) {
		this(title, style, true);
	}
	
	public SvcPopupPanel(String title, String style, boolean autoHide) {
		super(autoHide);
		add(uiBinder.createAndBindUi(this));

		setGlassEnabled(true);
		setGlassStyleName("glass");
		
		//protect auto-hide effect in pop-up from pop-up
		setPreviewingAllNativeEvents(false);
		setModal(true); //The modal flag basically makes the dialog take the focus of the UI. So nothing else can be clicked or interacted with except for what is in the dialog.
		
		this.title.setText(title);

		if (!"".equals(style)) {
			// TODO minor - align the code
			if (style.startsWith("header")) {
				style = style.substring("header".length());
			}
			headerHp.addStyleName("header" + style);
			mainPanel.setStyleName("panel" + style);		
		} else {
			headerHp.addStyleName("headerSVC");
			mainPanel.setStyleName("panelSVC");		
		}
		if ("MOB".equals(style)) {
			this.title.addStyleName("headerTextMOB");
			datakey.addStyleName("headerDataKeyMOB");
		} else if ("CLUB".equals(style)) {
			this.title.addStyleName("headerTextCLUB");
		}
		
		keyDownHandler = basePanel.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ESCAPE) {
					hide();
				}
			}
		});

		resizeHandler = Window.addResizeHandler(new ResizeHandler() {
			Timer resizeTimer = new Timer() {
				@Override
				public void run() {
					resize();
				}
			};
			@Override
			public void onResize(ResizeEvent event) {
				if (isShowing()) {
					resizeTimer.cancel();
					resizeTimer.schedule(250);
				}
			}
		});
	}
	
	public void setContent(Widget content) {
		this.content = content;
		if (content instanceof IsPopupable) {
			((IsPopupable) content).setSvcPopupPanel(this);
		}
		scrollArea.add(content);
	}
	
	@UiHandler("closeBtn")
	public void closeBtnOnClick(ClickEvent event) {
		hide();
	}

	@Override
	public void setWidth(String width) {
		scrollArea.setWidth(width);
	}
	
	@Override
	public void setHeight(String height) {
		if (height != null && (height.endsWith("PX") || height.endsWith("px"))) {
			String text = height.substring(0, height.length() -2);
			try {
				int h = Integer.parseInt(text);
				scrollArea.setHeight(Math.max(h - headerHp.getOffsetHeight(), 0) + "PX");
			} catch (Exception e) {
				scrollArea.setHeight(height);
			}
		} else {
			scrollArea.setHeight(height);
		}
	}
	
	@Override
	public void setPixelSize(int width, int height) {
		super.setPixelSize(width, height);
		scrollArea.setPixelSize(width, height - headerHp.getOffsetHeight());
	}
	
	public void setBackgroundColor(String color) {
		scrollArea.getElement().getStyle().setBackgroundColor(color);
	}
	
	public void setTitle(SafeHtml safeHtml) {
		//TODO enhancement - set popup panel heading
	}
	
	public void setTitle(String text) {
		super.setTitle(text);
		this.title.setText(text);
	}
	
	public void resize() {
		int width =  getElement().getClientWidth();
		if (Width == null){
			Width = width;
		}
		
		if (width > (int) (Window.getClientWidth() * 0.9)) {
			width = (int) (Window.getClientWidth() * 0.9);
			if (width <= 0){
				width = 1;
			}
			setWidth(width+"PX");
		}
		if (Window.getClientWidth() > Width){
			width = Width;
			setWidth(width+"PX");
		}
		
		int height = getElement().getClientHeight();
		if (Height == null){
			Height = height;
		}
		if (height > (int) (Window.getClientHeight() * 0.9)) {
			height = (int) (Window.getClientHeight() * 0.9);
			if (height <= 0){
				height = 1;
			}
			setHeight(height+"PX");
		}
		if (Window.getClientHeight() > Height){
			height = Height;
			setHeight(height+"PX");
		}
		center();		
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		if (content != null && content instanceof IsPopupable) {
			((IsPopupable) content).setSvcPopupPanel(this);
		}
		resizeHandler.removeHandler();
		// keyDownHandler.removeHandler();
	}

	public void setFocus(boolean value) {
		basePanel.setFocus(value);
	}
	
	@Override
	public void center() {
		super.center();
		basePanel.setFocus(true);
	}
	
	public void setSecondToHold(int secondToHold) {
		this.secondToHold = secondToHold;
	}
	
	@Override
	public void show() {
		if (secondToHold > 0) {
			closeLock = true;
			closeBtn.setVisible(false);
			counter.setVisible(true);
			counter.setText("" + secondToHold);
			setModal(false);
			Timer timer = new Timer() {
				@Override
				public void run() {
					countDown();
				}
			};
			timer.schedule(1000);
		}
		super.show();
	}
	
	private void countDown() {
		secondToHold--;
		if (secondToHold > 0) {
			counter.setText("" + secondToHold);
			Timer timer = new Timer() {
				@Override
				public void run() {
					countDown();
				}
			};
			timer.schedule(1000);
		} else {
			closeLock = false;
			closeBtn.setVisible(true);
			counter.setVisible(false);
			setModal(true);
		}
	}
	
	@Override
	public void hide(boolean autoClosed) {
		if (!closeLock) {
			super.hide(autoClosed);
		}
	}

}