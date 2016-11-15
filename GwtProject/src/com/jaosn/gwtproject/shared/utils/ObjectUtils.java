package com.jaosn.gwtproject.shared.utils;

import java.util.List;

public class ObjectUtils {
	
	private ObjectUtils() {}

	public static StringBuilder getDatabaseFieldNames(List<String> databaseFieldNames, String prefix, boolean isEndWithComma) {
		StringBuilder sql = new StringBuilder();
		if (StringUtils.trimToNull(prefix) == null) {
			for (String fieldName : databaseFieldNames) {
				sql.append(fieldName)
					.append(", ");
			}
		} else {
			for (String fieldName : databaseFieldNames) {
				sql.append(prefix)
				.append(".")
				.append(fieldName)
				.append(" ")
				.append(prefix)
				.append("_")
				.append(fieldName)
				.append(", ");
			}
		}
		if (!isEndWithComma) {
			sql.deleteCharAt(sql.lastIndexOf(","));
		}
		return sql;
	}
	
	public static int compareInteger(Integer a , Integer b){
		if (a != null && b != null){
			return a-b;
		}
		else if (a == null && b == null){
			return 0;
		}
		else if (a == null){
			return 0-b;
		}
		else if (b == null){
			return a-0;
		}
		return 0;
	}
	public static int compareString(String a , String b){
		if (a != null && b != null){
			return a.compareTo(b);
		}
		else if (a == null && b == null){
			return 0;
		}
		else if (a == null){
			return -1;
		}
		else if (b == null){
			return 1;
		}
		return 0;
	}
}
