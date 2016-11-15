package com.jaosn.gwtproject.shared.utils;

import java.util.ArrayList;
import java.util.List;

import com.jaosn.gwtproject.shared.enums.Title;

//Because GWT Client side cannot use the Apache Common Language Library
public class EnumUtils {

	private EnumUtils() {}
	
	public static <E extends Enum<E>> E getEnum(Class<E> enumClass, String enumName) {
		if (enumName == null) {
			return null;
		}
		try {
			if (Title.class.getName().equals(enumClass.getName())) {
				// return enumClass.cast(Title.getByValue(enumName));
				enumName = Title.convertForGetByValue(enumName);
			}
			return Enum.valueOf(enumClass, enumName);
		} catch (IllegalArgumentException iae) {
			return null;
		}
	}
	
	public static <E extends Enum<E>> String getEnumName(Enum<E> enumValue) {
		return getEnumName(enumValue, false);
	}
	
	public static <E extends Enum<E>> String getEnumName(Enum<E> enumValue, boolean emptyString) {
		if (enumValue == null) {
			return (emptyString ? "" : null);
		}
		try {
			return enumValue.name();
		} catch (IllegalArgumentException iae) {
			return (emptyString ? "" : null);
		}
	}
	
	public static <E extends Enum<E>> List<String> getEnumNames(List<E> enums) {
		if (enums == null || enums.size() == 0) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		for (Enum<E> obj : enums) {
			result.add(obj.name());
		}
		return result;
	}
	
	public static <E extends Enum<E>> String nvlToString(Enum<E> enumValue) {
		if (enumValue == null) {
			return "";
		}
		return enumValue.toString();
	}
}
