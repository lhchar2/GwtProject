package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum HousingType {
	PRIVATE_HOUSE("Private House"), PUBLIC_HOUSE("Public House"), HOME_OWNERSHIP_SCHEME("Home Ownership Scheme"), VILLAGE("Village"), TARGETED_BUILDING("Targeted Building");
	
	private String val;
	
	private HousingType(String val) {
		this.val = val;
	}
	
	public String getValue() {
		return val;
	}
	
	public static HousingType getFromString(String val) {
		for (HousingType housingType : HousingType.values()) {
			if (val.equals(housingType.getValue())) {
				return housingType;
			}
		}
		return null;
	}
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (HousingType housingType : HousingType.values()) {
			list.add(housingType.getValue());
		}
		return list;
	}
	
	public static Map<String, String> getMap(boolean hasEmpty) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (hasEmpty) {
			map.put("", "");
		}
		for (HousingType housingType : HousingType.values()) {
			map.put(housingType.name(), housingType.getValue());
		}
		return map;
	}
}
