package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.List;

import com.jaosn.gwtproject.shared.utils.StringUtils;

public enum Title {
	MR, MRS, MS, MDM, DR, PROF, REV, CO;
	
	public static List<String> getList(boolean hasEmpty) {
		List<String> list = new ArrayList<String>();
		if (hasEmpty) {
			list.add("");
		}
		for (Title val : Title.values()) {
			list.add(val.name());
		}
		return list;
	}
	
	public static Title getByValue(String val) {
		if (StringUtils.isNotBlankAfterTrim(val)) {
			return Title.valueOf(convertForGetByValue(val));
			/*
			for (Title title : Title.values()) {
				if (newVal.equals(title.name())) {
					return title;
				}
			}
			if (newVal.equals("MISS")) {
				return Title.MS;
			}
			*/
		}
		// return Title.MR;
		return null;
	}
	
	public static String convertForGetByValue(String val) {
		if (StringUtils.isNotBlankAfterTrim(val)) {
			String newVal = val.replace(".", "").trim().toUpperCase();
			if ("MISS".equals(newVal)) {
				newVal = "MS";
			}
			return newVal;
		}
		return null;
	}
	
	
}
