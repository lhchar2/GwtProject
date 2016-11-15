package com.jaosn.gwtproject.shared.utils;

import java.util.ArrayList;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.ui.TextBox;
import com.jaosn.gwtproject.shared.enums.IdDocType;

public class ValidationUtils {

	public final static String NUMBER_ONLY_PATTERN = "^\\d{1,}$";
	public final static String PHONE_NUM_PATTERN = "^[235689][0-9]{7}$";
	public final static int PHONE_NUM_LENGTH = 8;
	public final static String EMAIL_PATTERN = "^[A-Z0-9._&%+-]+@(?:[A-Z0-9-]+\\.)+[A-Z]{2,4}$";
	public final static int EMAIL_LENGTH = 254;
	
	public final static String NUMBER_AND_SPACE_PATTERN = "^[\\d ]{1,}$";
	public final static String SLV_CONTACT_NUM_PATTERN = "^[2356789][0-9]{7}$";
	
	public final static String HKID_PATTERN = "^[A-Z]{1,2}\\d{6}\\([A-Z0-9]\\)$";
	public final static int HKID_LENGTH = 11;
	public final static String PASSPORT_PATTERN = "^[0-9a-zA-Z\\-]{6,}$";
	public final static String HKBR_PATTERN = "^\\d{8}\\-[0-9a-zAZ-Z]{3}$";
	public final static int HKBR_LENGTH = 12;
	public final static String CERT_PATTERN = ".*";
	public final static String CCC_PATTERN = ".*";
	
	public final static String ACCOUNT_NUM_PATTERN = "^\\d{10}(\\d{4})?$";
	public final static int ACCOUNT_MAX_LENGTH = 14;
	public final static String FSA_PATTERN = "^\\d{8}$";
	public final static int FSA_LENGTH = 8;
	public final static String MRT_PATTERN = "^[569][0-9]{7}$";
	public final static int MRT_LENGTH = 10;
	public final static String TEL_PATTERN = "^\\d{8}$";
	public final static int TEL_LENGTH = 8;
	public final static int AGR_LENGTH = 16;
	
	public final static String D_FORM_SERIAL_PATTERN = "^[0-9a-zA-Z]{1,20}$";
	public final static int D_FORM_SERIAL_LENGTH = 20;
	
	public final static String SMS_NUMBER_PATTERN = "^[569][0-9]{7}$";
	public final static int SMS_NUMBER_LENGTH = 8;
	
	public final static String SMS_PHONE_PATTERN = "^[45689][0-9]{7}$";
	public final static int SMS_PHONE_LENGTH = 8;
	
	public final static int STAFF_NUM_LENGTH = 8;
	
	public final static int DEFAULT_TEXT_LENGTH = 300;
	
	public final static int REMARK_LENGTH = 1000;
	
	public final static int D_FORM_CONTACT_NAME_LENGTH = 80;
	
	public final static String ASCII_PATTERN = "^[\u0020-\u007E]{1,}$";

	public final static int PREPAID_SIM_LENGTH_22 = 22;
	public final static int PREPAID_STARTER_PACK_ID_LENGTH_10 = 10;
	public final static int PREPAID_STARTER_PACK_ID_LENGTH_14 = 14;
	public final static String NUMBER_AND_LETTER_PATTERN = "^[a-zA-Z0-9]*$";
	
	public final static String TIME_FORMAT_PATTERN = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
	
	public static ArrayList<String> getMatches(String input, String pattern, boolean ignoreCase) {
		if (input == null || pattern == null) {
			return null;
		}
		ArrayList<String> matches = new ArrayList<String>();
		String flag = "g";
		if (ignoreCase) {
			flag += "i";
		}
		RegExp regExp = RegExp.compile(pattern, flag);
		for (MatchResult matcher = regExp.exec(input); matcher != null; matcher = regExp.exec(input)) {
			matches.add(matcher.getGroup(0));
		}
		return matches;
	}
	
	public static boolean isValidPattern(String input, String pattern, boolean ignoreCase) {
		if (StringUtils.isBlank(input) || pattern == null) {
			return true;
		}
		String flag = "g";
		if (ignoreCase) {
			flag += "i";
		}
		RegExp regExp = RegExp.compile(pattern, flag);
		MatchResult matcher = regExp.exec(input);
		if (matcher != null) {
			return true;
		}
		return false;
	}

	public static boolean isValidNumber(String text) {
		/*
		if (StringUtils.isNotBlank(text)) {
			try {
				Long value = Long.valueOf(text);
				if (value != null && value.longValue() < 0) {
					return false;
				}
				return true;
			} catch (NumberFormatException iae) {
				return false;
			}
		}
		return false;
		*/
		if (StringUtils.isBlank(text)) {
			return true;
		}
		return isValidPattern(text, NUMBER_ONLY_PATTERN, true);
	}
	
	public static boolean isValidNumber(String text, final int length) {
		if (StringUtils.isNotBlank(text) && isValidLength(text, length)) {
			return isValidNumber(text);
		}
		return false;
	}
	
	public static boolean isValidNumberAndSpace(String text) {
		if (StringUtils.isBlank(text)) {
			return true;
		}
		return isValidPattern(text, NUMBER_AND_SPACE_PATTERN, true);
	}	
	
	public static boolean isValidLength(String text, int length) {
		if (StringUtils.isNotBlank(text) && text.length() == length) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidHKID(String text) {
		return (isValidPattern(text, HKID_PATTERN, true) && isValidHKIDcheckDigit(text));
	}
	
	private static boolean isValidHKIDcheckDigit(String input) {
		boolean result = false;
		if (input != null && !input.equals("")) {
			try {
				boolean matchPattern = false;
				String firstAlphabet = null;
				String secondAlphabet = null;
				String numberPart = null;
				String checkDigit = null;

				if (input.length() == 11) {
					matchPattern = true;
					firstAlphabet = input.substring(0, 1);
					secondAlphabet = input.substring(1, 2);
					numberPart = input.substring(2, 8);
					checkDigit = input.substring(9, 10);
				} else if (input.length() == 10) {
					matchPattern = true;
					firstAlphabet = " ";
					secondAlphabet = input.substring(0, 1);
					numberPart = input.substring(1, 7);
					checkDigit = input.substring(8, 9);
				}
				if (matchPattern) {
					if (checkDigit.equals("A")) {
						checkDigit = "10";
					}
					int sum = 0;
					sum += (getLetterValue(firstAlphabet) + 10) * 9;
					sum += (getLetterValue(secondAlphabet) + 10) * 8;
					for (int i = 0; i < numberPart.length(); i++) {
						sum += Integer.parseInt(numberPart.substring(i, i + 1)) * (7 - i);
					}
					int checkNumber = (11 - (sum % 11)) % 11;

					if (checkNumber == Integer.parseInt(checkDigit)) {
						result = true;
					} else {
						result = false;
					}
				}
			} catch (Exception e) {
				result = false;
			}
		} else {
			result = true;
		}
		return result;
	}
	
	private static int getLetterValue(String letter) { 
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ ".indexOf(letter);
	}

	public static String getFormattedHKID(String text) {
		if (StringUtils.isBlankAfterTrim(text)) {
			return StringUtils.trimToNull(text);
		}
		text = text.toUpperCase().trim();
		if (text.indexOf(")") != text.length() - 1) {
			text = text + ")";
		}
		if (text.indexOf("(") != text.length() - 3) {
			text = text.substring(0, text.length() - 2) + "(" + text.substring(text.length() - 2);
		}
		return text;
	}

	public static boolean isValidPassport(String text) {
		return isValidPattern(text, PASSPORT_PATTERN, true);
	}
	
	public static boolean isValidHKBR(String text) {
		return (isValidPattern(text, HKBR_PATTERN, true) && isValidHKBRcheckDigit(text));
	}
	
	private static boolean isValidHKBRcheckDigit(String input) {
		int nSum = 0;
		int nChkDigit = 0;
		boolean result = false;
		
		if (input.substring(0).equalsIgnoreCase("#") || input.length() != 12) {
			result = false;
		} else {
			try {
				nSum = 2 * Integer.parseInt(input.substring(0,1));
				nSum = nSum + 9 * Integer.parseInt(input.substring(1,2));
				nSum = nSum + 8 * Integer.parseInt(input.substring(2,3));
				nSum = nSum + 7 * Integer.parseInt(input.substring(3,4));
				nSum = nSum + 4 * Integer.parseInt(input.substring(4,5));
				nSum = nSum + 3 * Integer.parseInt(input.substring(5,6));
				nSum = nSum + 2 * Integer.parseInt(input.substring(6,7));
				
				nChkDigit = 10 - ( nSum % 10);
				
				if (Integer.parseInt(input.substring(7,8)) == (nChkDigit % 10)) {
					result = true;
				}
			} catch (NumberFormatException nfe) {
				return false;
			}
		}
		
		return result;
	}
	
	public static boolean isValidIdDocTypeNum(IdDocType type, String idDocNum) {
		if (type == null) {
			return false;
		}
		switch(type) {
			case HKID:
				return isValidHKID(idDocNum);
			case PASS:
				return isValidPassport(idDocNum);
			case BS:
				return isValidHKBR(idDocNum);
			case CERT:
				return true;
			case CCC:
				return true;
		}
		return true;
	}
	
	public static boolean isValidAccountNum(String text) {
		return isValidPattern(text, ACCOUNT_NUM_PATTERN, true);
	}
	
	public static boolean isValidFsa(String text) {
		return isValidPattern(text, FSA_PATTERN, true);
	}
	
	public static boolean isValidMrt(String text) {
		return isValidPattern(text, MRT_PATTERN, true);
	}
	
	public static boolean isValidTel(String text) {
		return isValidPattern(text, TEL_PATTERN, true);
	}
	
	public static boolean isValidServiceTypeNum(String serviceType, String serviceNum) {
		if (serviceType == null) {
			return false;
		}
		if (SvcConstants.SERVICE_TYPE_IMS_CODE.equals(serviceType)) {
			return isValidFsa(serviceNum);
		} else if (SvcConstants.SERVICE_TYPE_MOB_CODE.equals(serviceType)) {
			return isValidMrt(serviceNum);
		} else if ("TEL".equals(serviceType)) {
			return isValidTel(serviceNum);
		} else {
			return isValidTel(serviceNum);
		}
	}
	
	public static boolean isValidPhoneNum(String text) {
		return isValidPattern(text, PHONE_NUM_PATTERN, true);
	}
	
	public static boolean isValidEmail(String text) {
		return isValidPattern(text, EMAIL_PATTERN, true);
	}
	
	public static boolean isValidDateFormat(String text, DateTimeFormat dateTimeFormat) {
		try {
			dateTimeFormat.parseStrict(text);
			if (text.length() != dateTimeFormat.getPattern().length()) {
				return false;
			}
			return true;
		} catch (IllegalArgumentException iae) {
			return false;
		}
	}

	public static void setTextBoxMaxLength(TextBox textBox, IdDocType type) {
		if (textBox != null) {
			textBox.setMaxLength(DEFAULT_TEXT_LENGTH);
			if (type != null) {
				switch(type) {
				case HKID:
					textBox.setMaxLength(ValidationUtils.HKID_LENGTH);
					break;
				case PASS:
					textBox.setMaxLength(DEFAULT_TEXT_LENGTH);
					break;
				case BS:
					textBox.setMaxLength(ValidationUtils.HKBR_LENGTH);
					break;
				case CERT:
					textBox.setMaxLength(DEFAULT_TEXT_LENGTH);
					break;
				case CCC:
					textBox.setMaxLength(DEFAULT_TEXT_LENGTH);
					break;
				}
			}
		}
	}
	
	public static boolean isValidDFormSerial(String val) {
		return isValidPattern(val, D_FORM_SERIAL_PATTERN, true);
	}
	
	//Target for sending SMS
	// 569 - OK
	// 8 -  forwarding services: TBC, excluded for this method
	// 23 - TBC: special telephone device may accept SMS
	public static boolean isValidSmsNumber(String val) {
		return isValidPattern(val, SMS_NUMBER_PATTERN, true);
	}
	
	//Target for sending SMS
	// 569 - OK
	// 8 -  forwarding services: TBC, included for this method
	// 4 - not used in HK yet (but is included?)
	// 23 - TBC: special telephone device may accept SMS
	public static boolean isValidSmsPhoneNumber(String val) {
		return isValidPattern(val, SMS_PHONE_PATTERN, true);
	}
	
	//Target for mobile contact number
	// 8 -  forwarding services should be included
	public static boolean isValidMobilePhoneNumber(String val) {
		return isValidPattern(val, SMS_PHONE_PATTERN, true);
	}
	
	public static boolean isAsciiOnly(String val) {
		return isValidPattern(val, ASCII_PATTERN, true);
	}
	
	public static boolean isValidNumberAndLetterOnly(String val) {
		return isValidPattern(val, NUMBER_AND_LETTER_PATTERN, true);
	}
	
	public static boolean isValidNumberAndLetterOnly(String val, final int length) {
		if (StringUtils.isNotBlank(val) && isValidLength(val, length)) {
			return isValidNumberAndLetterOnly(val);
		}
		return false;
	}
	
	public static boolean isValidTimeFormat(String text) {
		return isValidPattern(text, TIME_FORMAT_PATTERN, true);
	} 
}
