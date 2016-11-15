package com.jaosn.gwtproject.client.widget;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jaosn.gwtproject.client.feature.IsSvcPanel;
import com.jaosn.gwtproject.client.feature.IsSvcPanelContent;
import com.jaosn.gwtproject.client.widget.SvcPanel.Style;

public class SimpleSvcPanel extends Composite implements HasWidgets, IsSvcPanel, ProvidesResize, RequiresResize {
	
	private static SimpleSvcPanelUiBinder uiBinder = GWT.create(SimpleSvcPanelUiBinder.class);
	interface SimpleSvcPanelUiBinder extends UiBinder<Widget, SimpleSvcPanel> {}

	@UiField FocusPanel headerPanel;
	@UiField HorizontalPanel headerHp;
	@UiField Label header;
	@UiField Label headerKey;
	@UiField VerticalPanel mainPanel;
	@UiField ScrollPanel contentPanel;
	
	private Widget content;

	public SimpleSvcPanel() {
		this(null, Style.SVC);
	}

	@Deprecated
	public SimpleSvcPanel(Widget content, String headerStyle) {
		initWidget(uiBinder.createAndBindUi(this));
		setWidth("100%");
		setContent(content);

		setHeaderStyle(headerStyle);

	}

	public SimpleSvcPanel(Widget content, Style style) {
		initWidget(uiBinder.createAndBindUi(this));
		setWidth("100%");
		setContent(content);

		setStyle(style);

	}

	public void setStyle(Style style) {
		switch (style) {
		case IMS:
			headerHp.addStyleName("headerPCD");
			mainPanel.setStyleName("panelPCD");
			break;
		case LTS:
			headerHp.addStyleName("headerLTS");
			mainPanel.setStyleName("panelLTS");
			break;
		case MOB:
			headerHp.addStyleName("headerMOB");
			mainPanel.setStyleName("panelMOB");
			header.addStyleName("headerTextMOB");
			headerKey.setStyleName("headerDataKeyMOB");
			break;
		case TV:
			headerHp.addStyleName("headerTV");
			mainPanel.setStyleName("panelTV");
			break;
		case SLV:
			headerHp.addStyleName("headerSLV");
			mainPanel.setStyleName("panelSLV");
			break;
		case CSL:
			headerHp.addStyleName("headerCSL");
			mainPanel.setStyleName("panelCSL");
			break;
		case CLUB:
			headerHp.addStyleName("headerCLUB");
			mainPanel.setStyleName("panelCLUB");
			break;			
		default:
			headerHp.addStyleName("headerSVC");
			mainPanel.setStyleName("panelSVC");
		}
	}

	public void setContent(Widget content) {
		this.content = content;
		if (content != null) {
			contentPanel.add(content);
			if (content instanceof IsSvcPanelContent) {
				((IsSvcPanelContent) content).setSvcPanel(this);
				((IsSvcPanelContent) content).refreshHeader();
			} else {
				setHeaderText(content.getTitle());
			}
		}
	}

	public void setHeaderText(String titleText) {
		SafeHtmlBuilder sb = new SafeHtmlBuilder();
		//sb.appendHtmlConstant("<b>");
		sb.appendEscapedLines(titleText);
		//sb.appendHtmlConstant("</b>");
		setTitleHtml(sb.toSafeHtml());
	}

	public void setHeaderStyle(String headerStyle) {
		if ("headerPCD".equals(headerStyle)) {
			setStyle(Style.IMS);
		} else if ("headerLTS".equals(headerStyle)) {
			setStyle(Style.LTS);
		} else if ("headerTV".equals(headerStyle)) {
			setStyle(Style.TV);
		} else if ("headerMOB".equals(headerStyle)) {
			setStyle(Style.MOB);
		} else if ("headerCSL".equals(headerStyle)) {
			setStyle(Style.CSL);
		} else {
			setStyle(Style.SVC);
		}
	}

	@Override
	public void add(Widget w) {
		contentPanel.add(w);

	}

	@Override
	public void clear() {
		contentPanel.clear();
	}

	@Override
	public Iterator<Widget> iterator() {
		return contentPanel.iterator();
	}

	@Override
	public boolean remove(Widget w) {
		return contentPanel.remove(w);
	}

	@Override
	public void setTitleHtml(String text) {
		setTitleHtml(new SafeHtmlBuilder().appendEscapedLines(text).toSafeHtml());
	}

	public void setTitleHtml(SafeHtml titleHtml) {
		header.setText(titleHtml.asString());
	}
	
	@Override
	public void close() {
		removeFromParent();
	}

	@Override
	public void onResize() {
		if (content != null && content instanceof RequiresResize) {
			((RequiresResize) content).onResize();
		}
	}
	public Widget getContent(){
		return this.content;
	}

	public void setContentPanelWidth(String width) {
		contentPanel.setWidth(width);
	}
	
}
