package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum CallNatureType {
	//Type name must equal with call nature DB "type" value
	PRODUCT_TYPE, PRODUCT_TYPE_SUB, SERVICE_TYPE, SERVICE_TYPE_SUB, CALL_NATURE, CALL_NATURE_SUB,
	CALL_RESULT, CALL_RESULT_SUB,
	CALL_LIST_TYPE, 
	MEDIA_SOURCE, MEDIA_SOURCE_SUB;
	
	public static List<String> getList(boolean hasEmpty) {
		List<String> list = new ArrayList<String>();
		if (hasEmpty) {
			list.add("");
		}
		for (CallNatureType callNatureType : CallNatureType.values()) {
			list.add(callNatureType.name());
		}
		return list;
	}
	
	public static Map<String, String> getMap(boolean hasEmpty) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (hasEmpty) {
			map.put("", "");
		}
		for (CallNatureType obj : CallNatureType.values()) {
			map.put(obj.name(), obj.name());
		}
		return map;
	}
}
