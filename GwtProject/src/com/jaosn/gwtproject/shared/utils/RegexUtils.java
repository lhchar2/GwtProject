package com.jaosn.gwtproject.shared.utils;


public class RegexUtils {
	public static String getEscapedSpecCharCheckString(String input){
		String result = input;
		//TODO major Change it as RegExp Format to reduce coding
		//e.g. ^[A-Z0-9._&%+-]+@(?:[A-Z0-9-]+\\.)+[A-Z]{2,4}$
		// "\" Must be on the start to avoid overwrite
		if (result.indexOf("\\") > -1){
			result = result.replaceAll("\\\\", "\\\\\\\\");
		}		
		if (result.indexOf("|") > -1){
			result = result.replaceAll("\\|", "\\\\|");
		}
		if (result.indexOf("$") > -1){
			result = result.replaceAll("\\$", "\\\\\\$");
		}
		if (result.contains(".")){
			result = result.replaceAll("\\.", "\\\\.");
		}
		if (result.indexOf("^") > -1){
			result = result.replaceAll("\\^", "\\\\^");
		}
		if (result.indexOf("*") > -1){
			result = result.replaceAll("\\*", "\\\\*");
		}
		if (result.indexOf("+") > -1){
			result = result.replaceAll("\\+", "\\\\+");
		}
		if (result.indexOf("-") > -1){
			result = result.replaceAll("\\-", "\\\\-");
		}
		if (result.indexOf("?") > -1){
			result = result.replaceAll("\\?", "\\\\?");
		}
		if (result.indexOf("%") > -1){
			result = result.replaceAll("\\%", "\\\\%");
		}
		
		if (result.indexOf("(") > -1){
			result = result.replaceAll("\\(", "\\\\(");
		}
		if (result.indexOf(")") > -1){
			result = result.replaceAll("\\)", "\\\\)");
		}
		if (result.indexOf("[") > -1){
			result = result.replaceAll("\\[", "\\\\[");
		}
		if (result.indexOf("]") > -1){
			result = result.replaceAll("\\]", "\\\\]");
		}
		if (result.indexOf("{") > -1){
			result = result.replaceAll("\\{", "\\\\{");
		}
		if (result.indexOf("}") > -1){
			result = result.replaceAll("\\}", "\\\\}");
		}
		
		return result;
	}
}
