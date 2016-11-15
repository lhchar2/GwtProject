package com.jaosn.gwtproject.shared.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
	
	private StringUtils() {
		
	}
	
	public static String nvl(String value) {
		return (value==null)? "": value;
	}
	
	public static String nvl(String value, String defaultValue) {
		return (value==null)? defaultValue: value;
	}
	
	public static String replaceAllSymbol(String value) {
		return value.replaceAll("[^0-9]", "");
	}
	
	public static String replaceSymbol(String value) {
		return value.replaceAll("[^a-zA-Z0-9]", "");
	}
	
	public static String nvl2(String value) {
		return (isBlankAfterTrim(value) || "null".equals(value) ? SvcConstants.EMPTY_LABEL : value);
	}
	
	public static String nvl2(String value, String defaultValue) {
		return (isBlankAfterTrim(value) ? defaultValue : value);
	}
	
	public static boolean isTrue(String value) {
		return ("Y".equals(value) ? true : false);
	}
	
	public static boolean isNotTrue(String value) {
		return !isTrue(value);
	}

	public static boolean isBlank(String value) {
		return ((value == null || "".equals(value)) ? true : false);
	}
	
	public static boolean isBlankAfterTrim(String value) {
		return ((value == null || "".equals(value.trim())) ? true : false);
	}
	
	public static boolean isNotBlank(String value) {
		return !isBlank(value);
	}
	
	public static boolean isNotBlankAfterTrim(String value) {
		return !isBlankAfterTrim(value);
	}
	
	public static boolean isBlank2(String value) {
		return ((value == null || SvcConstants.EMPTY_LABEL.equals(value)) ? true : false);
	}
	
	public static boolean isBlankAfterTrim2(String value) {
		return ((value == null || SvcConstants.EMPTY_LABEL.equals(value.trim())) ? true : false);
	}
	
	public static boolean isNotBlank2(String value) {
		return !isBlank2(value);
	}
	
	public static boolean isNotBlankAfterTrim2(String value) {
		return !isBlankAfterTrim2(value);
	}
	
	public static boolean equals(String value1, String value2) {
		if (value1 == null && value2 == null) {
			return true;
		} else if (value1 == null || value2 == null) {
			return false;
		} else if (value1.equals(value2)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String trimToNull(String value) {
		if (value == null || isBlank(value.trim())) {
			return null;
		}
		return value.trim();
	}
	
	public static String trimToBlank(String value) {
		if (value == null) {
			return "";
		}
		return value.trim();
	}
	
	public static String trimToNull2(String value) {
		if (value == null || isBlank2(value.trim())) {
			return null;
		}
		return value.trim();
	}
	
	public static String trimToBlank2(String value) {
		if (value == null) {
			return SvcConstants.EMPTY_LABEL;
		}
		return value.trim();
	}
	
	public static Integer getInteger(String value) {
		if (isBlank(value.trim())) {
			return null;
		}
		try {
			return Integer.valueOf(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public static Long getLong(String value) {
		if (isBlank(value.trim())) {
			return null;
		}
		try {
			return Long.valueOf(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public static Float getFloat(String value) {
		if (isBlank(value.trim())) {
			return null;
		}
		try {
			return Float.valueOf(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public static String stripStart(String value, char padChar) {
		if (value == null) return value;
		
		int idx = 0;
		for (int i=0;i< value.length();i++) {
			if (value.charAt(i) == padChar) {
				idx = i+1;
			} else {
				break;
			}
		}
		return value.substring(idx);
	}
	
	public static String join(List<String> list) {
		return join(list, ",");
	}
	
	public static String join(List<String> list, String delimiter) {
		String result = "{";
		if (list != null && list.size() > 0) {
			for (String val : list) {
				result += "\"" + val + "\"" + delimiter;
			}
			if (result.endsWith(delimiter)) {
				result = result.substring(0, result.lastIndexOf(delimiter));
			}
		}
		return result + "}";
	}

	public static String trim(String text) {
		if (text != null) {
			return text.trim();
		}
		return null;
	}

	public static String padLast(String val, char padChar, int length) {
		if (val == null) {
			val = "";
		}
		StringBuilder sb = new StringBuilder();
		char[] pad = new char[length - val.length()];
		Arrays.fill(pad, padChar);
		return sb.append(val).append(pad).toString();
	}
	
	public static String getFromBoolean(Boolean val) {
		if (val != null && Boolean.TRUE.equals(val)) {
			return "Y";
		}
		return "N";
	}
	
	public static int nullSafeStringComparator(final String a, final String b) {
		if (a == null && b == null) {
	        return 0;
	    }
	    if (a == null || b == null) {
	        return (a == null ? -1 : 1);
	    }
	    return a.compareTo(b);
	}
	
	public static String removeStrangeUnicode(String val) {
		if (val != null) {
			// return val.replaceAll("[\u0000-\u001f]", "");
			// keep the line break
			return val.replaceAll("[\u0000-\u0009\u000B-\u001f]", "");
		}
		return null;
	}
	
	public static String leftPad(String val, int size, char c) {
		if (val == null) return null;
		int pads = size - val.length();
		if (pads <= 0) {
			return val; // returns original String when possible
		} else {
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<pads;i++) {
				sb.append(c);	
			}
			sb.append(val);
			return sb.toString();
		}
	}
}
