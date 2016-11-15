package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceLineType {
	MRT, TEL, FSA;
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (ServiceLineType serviceLineType : ServiceLineType.values()) {
			list.add(serviceLineType.name());
		}
		return list;
	}
}
