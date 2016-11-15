package com.jaosn.gwtproject.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jaosn.gwtproject.client.feature.HasMinWidgetWidth;
import com.jaosn.gwtproject.client.feature.IsReloadable;
import com.jaosn.gwtproject.client.feature.IsSvcPanel;
import com.jaosn.gwtproject.client.feature.IsSvcPanelContent;
import com.pccw.springboard.svc.shared.enums.SvcContent;

public class SvcPanel extends FocusPanel implements IsSvcPanel, ProvidesResize, RequiresResize {
	
	public enum Style {
		SVC, IMS, LTS, MOB, SLV, TV, CSL, CLUB
	}
	
	/*
	public static class Builder {
		private final Widget content;
		
		private Style style = Style.SVC;
		private boolean minimizable = true;
		private boolean closeable = true;
		
		public Builder (Widget content) {
			this.content = content;
		}
		public Builder style(Style style) {
			this.style = style;
			return this;
		}
		public Builder minimizable(boolean value) {
			this.minimizable = value;
			return this;
		}
		public Builder closeable(boolean value) {
			this.closeable = value;
			return this;
		}
		public SvcPanel build() {
			return new SvcPanel(this);
		}
	}
	*/

	private static SvcPanelUiBinder uiBinder = GWT.create(SvcPanelUiBinder.class);

	interface SvcPanelUiBinder extends UiBinder<Widget, SvcPanel> {
	}

	@UiField FocusPanel headerPanel;
	@UiField HorizontalPanel headerHp;
	@UiField VerticalPanel mainPanel;
	@UiField ScrollPanel contentPanel;
	@UiField Label header;
	@UiField Label headerKey;

	@UiField Image reloadIcon;
	@UiField Image minimizeIcon;
	@UiField Image closeIcon;

	private SvcContent svcContentId;
	private String dataKey;

	private Widget content;
	/*
	private Style style;
	private boolean minimizable;
	private boolean closeable;
	
	private SvcPanel(Builder builder) {
		this.content = builder.content;
		this.style = builder.style;
		this.minimizable = builder.minimizable;
		this.closeable = builder.closeable;
		
		add(uiBinder.createAndBindUi(this));
		
		setContent(content);
		setStyle(style);
		if (content instanceof IsReloadable) {
			reloadIcon.setVisible(true);
		} else {
			reloadIcon.setVisible(false);
		}
		minimizeIcon.setVisible(minimizable);
		closeIcon.setVisible(closeable);
	}
	*/

	public SvcPanel() {
		this(null, Style.SVC, true);
	}

	public SvcPanel(Widget content) {
		this(content, Style.SVC, true);
	}

	public SvcPanel(Widget content, Style style) {
		this(content, style, true);
	}

	public SvcPanel(Widget content, Style style, boolean closable) {
		add(uiBinder.createAndBindUi(this));

		setContent(content);

		setStyle(style);

		if (content instanceof IsReloadable) {
			reloadIcon.setVisible(true);
		} else {
			reloadIcon.setVisible(false);
		}

		if (!closable) {
			closeIcon.setVisible(false);
		}

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
			header.addStyleName("headerTextCLUB");
			break;
		default:
			headerHp.addStyleName("headerSVC");
			mainPanel.setStyleName("panelSVC");
		}
	}

	public void setWidth(String width) {
		contentPanel.setWidth(width);
	}
	
	public int getContentWidth(int screenWidth) {
		if (content != null) {
			if (content instanceof IsSvcPanelContent) {
				int maxWidth = ((IsSvcPanelContent) content).getMaxWidth();
				if (maxWidth != 0 && screenWidth > maxWidth) {
					return maxWidth;
				}
				if (content instanceof HasMinWidgetWidth) {
					int minPageWidth = ((HasMinWidgetWidth)content).getMinWidth();
					if (minPageWidth > 0 && screenWidth < minPageWidth) {
						return minPageWidth;
					} else if (minPageWidth == -1) {
						return minPageWidth;
					}
				}
				return screenWidth;
			} else {
				int contentWidth = content.getOffsetWidth();
				if (contentWidth < screenWidth) {
					return contentWidth;
				}
			}
		} else {
			int contentPanelWidth = contentPanel.getOffsetWidth();
			if (contentPanelWidth < screenWidth) {
				return contentPanelWidth;
			}
		}
		return screenWidth;
	}

	public void setClosable(boolean closable) {
		closeIcon.setVisible(closable);
	}

	public void setMinimumizable(boolean minimumizable) {
		minimizeIcon.setVisible(minimumizable);
	}

	public final void setContent(Widget content) {
		this.content = content;
		if (content != null) {
			contentPanel.add(content);
			if (content instanceof IsSvcPanelContent) {
				((IsSvcPanelContent) content).setSvcPanel(this);
				((IsSvcPanelContent) content).refreshHeader();
			} else {
				setTitleHtml(content.getTitle());
			}
		}
	}

	public Widget getContent() {
		return content;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public String getDataKey() {
		return dataKey;
	}

	@UiHandler("reloadIcon")
	void reloadIconOnClick(ClickEvent event) {
		if (content instanceof IsReloadable) {
			((IsReloadable) content).reload();
		}
	}

	@UiHandler("minimizeIcon")
	void minimumizeBtnOnClick(ClickEvent event) {
		toggle();
	}

	public void toggle() {
		if (content.isVisible()) {
			content.setVisible(false);
		} else {
			content.setVisible(true);
		}
	}

	@UiHandler("headerPanel")
	void headerPanelOnDoubleClick(DoubleClickEvent event) {
		toggle();
	}

	@UiHandler("closeIcon")
	void closeBtnOnClick(ClickEvent event) {
		close();
	}

	public SvcContent getSvcContentId() {
		return svcContentId;
	}

	public void setSvcContentId(SvcContent svcContentId) {
		this.svcContentId = svcContentId;
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
	
	@Override
	public void onDetach() {
		super.onDetach();
		if (content != null && content instanceof IsSvcPanelContent) {
			((IsSvcPanelContent) content).setSvcPanel(null);
		}
	}

}