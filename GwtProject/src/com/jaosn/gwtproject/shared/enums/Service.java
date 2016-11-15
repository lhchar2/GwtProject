package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public enum Service {
	MOB("Mobile"), Broadband("Broadband"), NowTV("NowTV"), FixedLine("Fixed Line"), IDD("IDD"), EYE("Eye"), SLV("Smart Living");
	
	private String val;
	
	private Service(String val) {
		this.val = val;
	}
	
	public String getValue() {
		return val;
	}
	
	public static Service getFromString(String text) {
		for (Service service : Service.values()) {
			if (text.equals(service.getValue())) {
				return service;
			}
		}
		return null;
	}
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (Service service : Service.values()) {
			list.add(service.getValue());
		}
		return list;
	}
}
