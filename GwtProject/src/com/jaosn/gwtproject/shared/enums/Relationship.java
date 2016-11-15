package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum Relationship {
	BROTHER("BROTHER"), DAUGHTER("DAUGHTER"), FATHER("FATHER"), HUSBAND("HUSBAND"), MOTHER("MOTHER"), 
	SISTER("SISTER"), SON("SON"), SUB("SUB"), WIFE("WIFE"),
	DELIMITER("-----"),
	ACCOUNT("ACCOUNT"), ADMIN("ADMIN"), CLERK("CLERK"), DIRECTOR("DIRECTOR"), IN_CHARGE("IN-CHARGE"), 
	MANAGER("MANAGER"), SECRETARY("SECRETARY"), OTHERS("OTHERS");

	private String val;
	
	private Relationship(String val) {
		this.val = val;
	}
	
	public String getValue() {
		return val;
	}
	
	public static Relationship getFromString(String text) {
		for (Relationship relationship : Relationship.values()) {
			if (text.equals(relationship.getValue())) {
				return relationship;
			}
		}
		return null;
	}
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (Relationship relationship : Relationship.values()) {
			list.add(relationship.getValue());
		}
		return list;
	}
	
	public static Map<String, String> getMap(boolean hasEmpty) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (hasEmpty) {
			map.put("", "");
		}
		for (Relationship relationship : Relationship.values()) {
			map.put(relationship.name(), relationship.getValue());
		}
		return map;
	}
}
