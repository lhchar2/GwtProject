package com.jaosn.gwtproject.shared.enums;

import java.util.Arrays;
import java.util.List;

import com.pccw.springboard.svc.shared.utils.StringUtils;

public enum SystemLanguage {
	EN("DEFAULT", "EN"), ZH("ZH_TW", "ZH_HK");
	
	private final List<String> vals;
	
	private SystemLanguage(String... vals) {
		this.vals = Arrays.asList(vals);
	}
	
	public List<String> getValues() {
		return vals;
	}
	
	public boolean containValue(String text) {
		for (String val : vals) {
			if (val.equals(text)) {
				return true;
			}
		}
		return false;
	}
	
	public static SystemLanguage getSystemLanguage(String val) {
		if (StringUtils.isBlankAfterTrim(val)) {
			return null;
		}
		val = val.toUpperCase();
		for (SystemLanguage lang : SystemLanguage.values()) {
			if (lang.containValue(val)) {
				return lang;
			}
		}
		return null;
	}
}
