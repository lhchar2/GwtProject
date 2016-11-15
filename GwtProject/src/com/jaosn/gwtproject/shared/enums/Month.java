package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum Month {
	JAN("JAN"), FEB("FEB"), MAR("MAR"), APR("APR"), MAY("MAY"), JUN("JUN"), 
	JUL("JUL"), AUG("AUG"), SEP("SEP"), OCT("OCT"), NOV("NOV"), DEC("DEC");
	
	private String val;
	
	private Month(String val) {
		this.val = val;
	}
	
	public String getValue() {
		return val;
	}
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (Month month : Month.values()) {
			list.add(month.getValue());
		}
		return list;
	}
	
	public static Map<String, String> getMap(boolean hasEmpty) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (hasEmpty) {
			map.put("", "");
		}
		for (Month month : Month.values()) {
			map.put(month.name(), month.getValue());
		}
		return map;
	}
}
