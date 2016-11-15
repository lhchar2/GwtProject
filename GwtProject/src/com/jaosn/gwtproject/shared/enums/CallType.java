package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum CallType {
	Inbound("Inbound"), Outbound("Outbound"), Referral("Referral"), 
	Call_Back("Call Back"), Walkin("Walk-in"), Written("Written");
	
	private String val;
	
	private CallType(String val) {
		this.val = val;
	}
	
	public String getValue() {
		return val;
	}
	
	public static CallType getFromString(String text) {
		for (CallType callType : CallType.values()) {
			if (text.equals(callType.getValue())) {
				return callType;
			}
		}
		return null;
	}
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (CallType callType : CallType.values()) {
			list.add(callType.getValue());
		}
		return list;
	}
	
	public static Map<String, String> getMap(boolean hasEmpty) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (hasEmpty) {
			map.put("", "");
		}
		for (CallType callType : CallType.values()) {
			map.put(callType.name(), callType.getValue());
		}
		return map;
	}
}
