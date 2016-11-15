package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.List;

public enum Language {
	Cantonese, English, Putonghua, Japanese;
	
	public static List<String> getList(boolean hasEmpty) {
		List<String> list = new ArrayList<String>();
		if (hasEmpty) {
			list.add("");
		}
		for (Language language : Language.values()) {
			list.add(language.name());
		}
		return list;
	}

} 
