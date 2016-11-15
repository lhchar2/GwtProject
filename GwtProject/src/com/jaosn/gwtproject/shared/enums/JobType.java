package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum JobType {
	IB("IB"), CALL_LIST("Call List"), CALL_BACK("Call Back"), SPECIAL_PROJECT("Special Project"), FOLLOW_UP("Follow Up");
	
	private String val;
	
	private JobType(String val) {
		this.val = val;
	}
	

	public String getValue() {
		return val;
	}
	
	public static JobType getFromString(String val) {
		for (JobType jobType : JobType.values()) {
			if (val.equals(jobType.getValue())) {
				return jobType;
			}
		}
		return null;
	}
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (JobType jobType : JobType.values()) {
			list.add(jobType.getValue());
		}
		return list;
	}
	
	public static Map<String, String> getMap(boolean hasEmpty) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (hasEmpty) {
			map.put("", "");
		}
		for (JobType jobType : JobType.values()) {
			map.put(jobType.name(), jobType.getValue());
		}
		return map;
	}
}
