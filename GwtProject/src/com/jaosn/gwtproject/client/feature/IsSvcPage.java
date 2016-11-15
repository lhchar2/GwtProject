package com.jaosn.gwtproject.client.feature;

import com.pccw.springboard.svc.shared.enums.SvcContent;
import com.pccw.springboard.svc.shared.enums.SvcView;

public interface IsSvcPage {
	
	void showInfo(SvcContent svcContent);
	void showInfo(SvcContent svcContent, String dataKey);
	void showInfo(SvcContent svcContent, String dataKey,
			boolean clearPrevContent);
	void showView(SvcView viewId);
	void showView(SvcView viewId, String dataKey);
}
