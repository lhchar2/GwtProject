package com.jaosn.gwtproject.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jaosn.gwtproject.client.feature.IsReloadable;
import com.jaosn.gwtproject.shared.enums.SvcContent;

@Deprecated
public class SvcPanel2 extends FocusPanel {

	private static SvcPanel2UiBinder uiBinder = GWT
			.create(SvcPanel2UiBinder.class);

	interface SvcPanel2UiBinder extends UiBinder<Widget, SvcPanel2> {
	}
	
	@UiField FocusPanel headerPanel;
	@UiField HorizontalPanel headerHp;
	@UiField VerticalPanel mainPanel;
	@UiField ScrollPanel contentPanel;
	@UiField Label header;
	@UiField Label headerKey;
	
	@UiField Image reloadIcon;
	@UiField Image minimizeIcon;
	@UiField Image closeBtn;
	
	private SvcContent svcContentId;
	
	private Widget content;
	private boolean maximized = false;

	public SvcPanel2() {
		this(null, "headerSVC", "");
	}
	public SvcPanel2(Widget content) {
		this(content, "headerSVC", "");
	}
	
	public SvcPanel2(Widget content, String headerStyle) {
		this(content, headerStyle, "");
	}
	
	public SvcPanel2(Widget content, String headerStyle, String dataKey) {
		this(content, headerStyle, dataKey, true);
	}
	
	public SvcPanel2(Widget content, SafeHtml headerHtml) {
	}
	
	public SvcPanel2(Widget content, String headerStyle, String dataKey, boolean closable) {
		this.content = content;
		//initWidget(uiBinder.createAndBindUi(this));
		
		add(uiBinder.createAndBindUi(this));
		if ("headerPCD".equals(headerStyle)) {
			headerHp.addStyleName("headerPCD");
			mainPanel.setStyleName("panelPCD");
		} else if ("headerLTS".equals(headerStyle)) {
			headerHp.addStyleName("headerLTS");
			mainPanel.setStyleName("panelLTS");
		} else if ("headerTV".equals(headerStyle)) {
			headerHp.addStyleName("headerTV");
			mainPanel.setStyleName("panelTV");
		} else if ("headerMOB".equals(headerStyle)) {
			headerHp.addStyleName("headerMOB");
			mainPanel.setStyleName("panelMOB");
			header.addStyleName("headerTextMOB");
			headerKey.setStyleName("headerDataKeyMOB");
		} else if ("headerSLV".equals(headerStyle)) {
			headerHp.addStyleName("headerSLV");
			mainPanel.setStyleName("panelSLV");
			//header.addStyleName("headerTextMOB"); 
			//headerKey.setStyleName("headerDataKeyMOB");
		} else {
			headerHp.addStyleName(headerStyle);
			mainPanel.setStyleName("panelSVC");
		}
		//setTitle(content.getTitle());

		header.setText(content.getTitle());
		if (!"".equals(dataKey)) {
			headerKey.setText("[" + dataKey + "]");
		}
		
		contentPanel.add(content);

		if (content instanceof IsReloadable) {
			reloadIcon.setVisible(true);	
		} else {
			reloadIcon.setVisible(false);
		}
		
		if (!closable) {
			closeBtn.setVisible(false);
		}
		
	}

	public static SvcPanel2 getInstance(String frameId, String url, String headerStyle, String title, boolean closable) {
		
		NamedFrame frame = new NamedFrame(frameId);
		DOM.setElementAttribute(frame.getElement(), "id", 
				frame.getName());
		frame.setUrl(url);
		/*
		Frame frame = new Frame(url) {
		    @Override
		    protected void onLoad() {
		        super.onLoad();
		        
		    }
		};
		*/
		frame.setWidth("100%");
		frame.setHeight("100%");
		frame.setTitle(title);
		frame.getElement().getStyle().setBorderStyle(BorderStyle.NONE);
		
		SvcPanel2 result = new SvcPanel2(frame, headerStyle);
		result.setClosable(closable);
		
		return result;
	}
	
	public SvcContent getSvcContentId() {
		return svcContentId;
	}
	
	public void setSvcContentId(SvcContent svcContentId) {
		this.svcContentId = svcContentId;
	}

	public void setWidth(String width) {
		contentPanel.setWidth(width);
		//content.setWidth(width);
	}

	public void setClosable(boolean closable) {
		//lockIcon.setVisible(true);
		closeBtn.setVisible(closable);
	}

	public void setMinimumizable(boolean minimumizable) {
		minimizeIcon.setVisible(minimumizable);
	}
	
	public void setContent(Widget content) {
		this.content = content;
		contentPanel.add(content);
	}
	
	public void hideTitle() {
		header.setVisible(false);
	}

	public Widget getContent() {
		return content;
	}

	@UiHandler("reloadIcon")
	void reloadIconOnClick(ClickEvent event) {
		if (content instanceof IsReloadable) {
			((IsReloadable) content).reload();
		}
	}

	@UiHandler("minimizeIcon")
	void minimumizeBtnOnClick(ClickEvent event) {
		minimize();
	}

	public void minimize() {
		if (maximized) {
			closeBtn.setVisible(true);
			//maximizeIcon.setVisible(true);
			maximized = false;
		} else if (content.isVisible()) {
			content.setVisible(false);
		} else {
			content.setVisible(true);
		}
	}
	
	@UiHandler("headerPanel")
	void headerPanelOnDoubleClick(DoubleClickEvent event) {
		minimize();
	}
	
	@UiHandler("closeBtn")
	void closeBtnOnClick(ClickEvent event) {
		removeFromParent();
	}
	
	public enum SvcPanelStyle {
		SVC, LTS, MOB, IMS
	}
}
