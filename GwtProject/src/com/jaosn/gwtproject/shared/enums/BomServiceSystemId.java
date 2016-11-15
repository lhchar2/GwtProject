package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.List;

public enum BomServiceSystemId {
	MOB, IMS, LTS;
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (BomServiceSystemId bomServiceSystemId : BomServiceSystemId.values()) {
			list.add(bomServiceSystemId.name());
		}
		return list;
	}
}
