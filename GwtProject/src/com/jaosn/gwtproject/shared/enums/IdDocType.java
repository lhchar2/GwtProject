package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum IdDocType {
	// refer to b_customer id_doc_type
	HKID("HKID"), PASS("Passport"), BS("HKBR"), CERT("CERT"), CCC("CCC");
	
	private final String val;
	
	private IdDocType(String val) {
		this.val = val;
	}
	

	public String getValue() {
		return val;
	}
	
	public static IdDocType getFromCode(String code) {
		if (code == null) {
			return null;
		}
		for (IdDocType idDocType : IdDocType.values()) {
			if (idDocType.name().equals(code)) {
				return idDocType;
			}
		}
		return null;
	}
	
	public static IdDocType getFromString(String val) {
		if (val == null) {
			return null;
		}
		for (IdDocType idDocType : IdDocType.values()) {
			if (val.equals(idDocType.getValue())) {
				return idDocType;
			}
		}
		return null;
	}
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (IdDocType idDocType : IdDocType.values()) {
			list.add(idDocType.getValue());
		}
		return list;
	}
	
	public static Map<String, String> getMap(boolean hasEmpty) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (hasEmpty) {
			map.put("", "");
		}
		for (IdDocType idDocType : IdDocType.values()) {
			map.put(idDocType.name(), idDocType.getValue());
		}
		return map;
	}
}