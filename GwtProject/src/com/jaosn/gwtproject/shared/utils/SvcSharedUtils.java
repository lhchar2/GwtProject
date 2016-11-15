package com.jaosn.gwtproject.shared.utils;

public class SvcSharedUtils {
	public static final String DEFAULT_S_TO_C_DATE_FORMAT = "dd-MM-yyyy";
	public static final String DEFAULT_S_TO_C_DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm";
	public static final String DEFAULT_S_TO_C_DATE_SECOND_FORMAT = "dd-MM-yyyy HH:mm:ss";
	
	private SvcSharedUtils() {}
	
	public static String getLob(String systemId) {
		if (StringUtils.equals(systemId, SvcConstants.SYSTEM_ID_LTS)) {
			return SvcConstants.LOB_LTS;
		} else if (StringUtils.equals(systemId, SvcConstants.SYSTEM_ID_PSS)) {
			return SvcConstants.LOB_PSS;			
		}
		return systemId;
	}

	public static String longToTimeString(Long timeInSecond){
		if (timeInSecond == null){
			return "00:00:00";
		}else if (timeInSecond > 86400){
			return "Error: Time is over maximun time quota(24 hours)";
		}else{
			long hour = (timeInSecond / 60) / 60;
			long minutes = (timeInSecond / 60) % 60;
			long second = timeInSecond - (hour * (60*60) + (minutes * 60));
			return (hour<10?"0"+hour:hour) + ":" + (minutes<10?"0"+minutes:minutes) + ":" + (second<10?"0"+second:second);
		}
	}
}
