package com.jaosn.gwtproject.shared.utils;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.Format;

public class DateUtils {

	public static final long SECONDS = 1000;
	public static final long MINUTES = 60 * SECONDS;
	public static final long HOURS = 60 * MINUTES;
	
	public static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";

	public static final DateTimeFormat DATEFORMAT_SHORT = DateTimeFormat.getFormat("dd/MM/yyyy");
	public static final Format DATEBOX_DATEFORMAT_SHORT = new DateBox.DefaultFormat(DATEFORMAT_SHORT);
	public static final int DATEFORMAT_SHORT_LENGTH = 10;	
	
	private DateUtils() {
	}

	@SuppressWarnings("deprecation")
	public static Date getCurrentDate() {
		Date val = new Date();
		val.setHours(0);
		val.setMinutes(0);
		val.setSeconds(0);
		// remove the millis
		long longVal = val.getTime() / 1000;
		Date result = new Date(longVal * 1000);
		return result;
	}

	public static int compareDate(Date a, Date b) {
		if (a != null && b != null) {
			return a.compareTo(b);
		} else if (a == null && b == null) {
			return 0;
		} else if (a == null) {
			return -1;
		} else if (b == null) {
			return 1;
		}
		return 0;
	}
	
	public static boolean equals(Date a, Date b){
		if (a == null && b == null) {
			return true;
		} else if (a == null || b == null) {
			return false;
		} else if (a.equals(b)) {
			return true;
		} else {
			return false;
		}
	}

	public static Date addHoursToDate(Date date, int hour) {
		if (date == null)
			return date;
		Date result = new Date(date.getTime() + hour * HOURS);
		return result;
	}

	public static Date addMinutesToDate(Date date, int minute) {
		if (date == null)
			return date;
		Date result = new Date(date.getTime() + minute * MINUTES);
		return result;
	}

//	public static Date addTimeToDate(Date date, String time)
//			throws FieldValidationException {
//		if (date != null && StringUtils.isNotBlankAfterTrim(time)) {
//			try {
//				int hours = Integer.valueOf(time.substring(0, 2));
//				int minutes = Integer.valueOf(time.substring(3, 5));
//				return addMinutesToDate(addHoursToDate(date, hours), minutes);
//			} catch (Exception e) {
//				return date;
//			}
//		}
//		return date;
//	}
	
	@SuppressWarnings("deprecation")
	public static boolean isWithinCertainDaysBefore(Date date, int days) {
		if (date == null) {
			return false;
		}
		Date limitedFromDate = new Date();
		Date currDate = new Date();
		limitedFromDate.setDate(currDate.getDate() - days - 1);
		
		if((limitedFromDate.after(date)) || date.after(currDate)){
			return false;
		}
		return true;
	}
}
