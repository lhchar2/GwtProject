package com.jaosn.gwtproject.shared.utils;

public class SvcConstants {
	
	private SvcConstants() {
		
	}
	
	public static final String EMPTY_LABEL = "--";
	public static final String LOADING_LABEL = "Loading...";
	public static final String ERROR_LABEL = "Error";
	public static final String SEPERATOR = " > ";
	public static final String LINE_SEPARATOR = "\n";
	public static final String DOUBLE_LINE_SEPARATOR = "\n\n";
	
	public final static String LTS_TPDAT_DELIMITER = "/";	
	public final static String SERVICE_TYPE_NO_DELIMITER = ":";	
	
	public static final String SYSTEM_ID_BOM = "BOM";
	public static final String SYSTEM_ID_IMS = "IMS";
	public static final String SYSTEM_ID_LTS = "DRG";
	public static final String SYSTEM_ID_MOB = "MOB";
	public static final String SYSTEM_ID_SLV = "SLV";
	public static final String SYSTEM_ID_SVC = "SVC";
	public static final String SYSTEM_ID_CSL = "CSL";
	public static final String SYSTEM_ID_PSS = "PSS";

	public static final String LOB_LTS = "LTS";
	public static final String LOB_IMS = "IMS";
	public static final String LOB_MOB = "MOB";
	public static final String LOB_SLV = "SLV";
	public static final String LOB_CSL = "CSL";
	public static final String LOB_PSS = "PrePaid";

	public static final String SYSTEM_IMS_DESC = "FSA";
	public static final String SYSTEM_MOB_DESC = "MRT";
	public static final String SYSTEM_LTS_DESC = "TEL";
	
	public static final String SERVICE_TYPE_IMS_CODE = "IMS";
	public static final String SERVICE_TYPE_MOB_CODE = "3G";
	public static final String SERVICE_TYPE_CSL_CODE = "CSL";

	public static final String SERVICE_TYPE_IMS_DESC = "FSA";
	public static final String SERVICE_TYPE_MOB_DESC = "MRT";
	public static final String SERVICE_TYPE_CSL_DESC = "MRT(CSL)";
	
	public static final String ET_PARAMETER = "SSO_ET";
	
	public static final String FOLLOWUP_CASE_HEADER = "Case-";
	public static final int FOLLOWUP_CHECK_PERIOD = 30; //minute(s)
	public static final int FOLLOWUP_ALERT_POPUP_BEFORE = 15; //minute(s)
	public static final int FOLLOWUP_ALERT_OK_DELAY = 15 * 60; //second(s)
	public static final int FOLLOWUP_ALERT_CANCEL_DELAY = 5 * 60; //second(s)
	public static final int FOLLOWUP_SELF_FOLLOWUP_DAY_LIMIT = 30;
	public static final int FOLLOWUP_CALLBACK_DAY_LIMIT = 7;
	public static final int FOLLOWUP_CALLBACK_DAY_EXTEND_LIMIT = 30;
	public static final int FOLLOWUP_UNREACH_CNT = 3;

	public static final String CRM_CALL_LOG_HISTORY_SUCCESS = "success";

	public static final String USER_CATEGORY_SALESMANAGER = "SALES MANAGER";
	public static final String USER_CATEGORY_MANAGER = "MANAGER";
	public static final String USER_CATEGORY_FRONTLINE = "FRONTLINE";
	
	public static final int CUST_SEARCH_MAX_SERVICE_CNT = 50;
	
	public static final String DFORM_PREFIX_ALL_ACCESSIBLE = "All Accessible";
	public static final String DFORM_STATUS_ALL_ACCESSIBLE = "All Accessible";
	public static final Long DFORM_STATUS_ALL_ACCESSIBLE_VAL = 0l;
	
	public final static String DFORM_STATUS_ID_RETAIL_HARD_COPY_GIVEN_AND_RECEIVED = "61";
	public final static String DFORM_STATUS_ID_RETAIL_FORM_RECEIVED = "62";
	public final static String DFORM_STATUS_ID_SC_HARD_COPY_GIVEN_AND_RECEIVED = "61";
	public final static String DFORM_STATUS_ID_SC_FORM_RECEIVED = "65";
	
	public final static String DFORM_PREFIX_LOB_DEL = "DEL";
	public final static String DFORM_PREFIX_LOB_EYE = "EYE";
	public final static String DFORM_PREFIX_LOB_PCD = "PCD";
	public final static String DFORM_PREFIX_LOB_PCDTV = "PCD+TV";
	public final static String DFORM_PREFIX_LOB_TV = "TV";
	public final static String DFORM_PREFIX_LOB_NE = "NE";
	public final static String DFORM_PREFIX_LOB_OTHERS = "Others";
	
	public static final String SVC_DW_LTS_PARAMETERS = "SVC_DW_LTS_MTH";
	public static final String SVC_DW_IMS_PARAMETERS = "SVC_DW_IMS_MTH";
	public static final String SVC_DW_MOB_PARAMETERS = "SVC_DW_MOB_MTH";
	
	public final static String CUSTSEARCH_PARM1_IDDOC_ONLY = "IDDOC_ONLY";
	
	public final static String PSG_PORTAL_PARM1_BACK_OFFICE = "BACK_OFFICE";
	public final static String PSG_PORTAL_PARM1_SHOP = "SHOP";
	
	public final static String PSG_PORTAL_ACTIVATION_STATUS_ACTIVE = "ACTIVE";
	public final static String PSG_PORTAL_ACTIVATION_STATUS_INACTIVE = "INACTIVE";
	
	public final static String SVC_LOOKUP_TYPE_DEBUGGER = "SVC_DEBUGGER";
	public final static String SVC_LOOKUP_TYPE_OPTOUT_AREA = "OPTOUT_AREA";
	public final static String SVC_LOOKUP_TYPE_OPTOUT_FLAG = "OPTOUT_FLAG";
	public final static String SVC_LOOKUP_TYPE_ATTACHMENT_FILE_TYPE = "ATTACHMENT_FILE_TYPE";
	public final static String SVC_LOOKUP_TYPE_EMAIL_GATEWAY_TYPE = "EMAIL_GATEWAY_TYPE";
	
	public final static String PAYSLIP_LOB_TYPE_NETVIGATOR = "PCD";
	public final static String PAYSLIP_LOB_TYPE_NOWTV = "TV";
	public final static String PAYSLIP_LOB_TYPE_LTS = "LTS";
	public final static String PAYSLIP_LOB_TYPE_MOB = "MOB";
	public final static String PAYSLIP_LOB_TYPE_CSL = "O2F";
	public final static String PAYSLIP_LOB_TYPE_1010 = "101";
	
	public final static String OPTOUT_AREA_BROADBAND = "Broadband";
	public final static String OPTOUT_AREA_TV = "TV";
	public final static String OPTOUT_AREA_MOBILE = "Mobile";
	public final static String OPTOUT_AREA_LTS = "LTS";
	public final static String OPTOUT_AREA_IDD = "IDD";
	public final static String OPTOUT_AREA_PCD = "PCD";
	
	public final static String OPTOUT_FLAG_BM = "BM";
	public final static String OPTOUT_FLAG_BILL_INSERT = "Bill Insert";
	public final static String OPTOUT_FLAG_CD_OUTDAIL = "CD Outdail";
	public final static String OPTOUT_FLAG_DIRECT_MAIL_SUPPRESS = "Direct Mail Suppress";
	public final static String OPTOUT_FLAG_DIRECT_MAILING = "Direct Mailing";
	public final static String OPTOUT_FLAG_EMAIL = "Email";
	public final static String OPTOUT_FLAG_EMAIL_SUPPRESS = "Email Suppress";
	public final static String OPTOUT_FLAG_ONLINE_PORTAL = "Online Portal";
	public final static String OPTOUT_FLAG_OUTBOUND = "Outbound";
	public final static String OPTOUT_FLAG_PCCW_SUPPRESS = "PCCW Suppress";
	public final static String OPTOUT_FLAG_SMS = "SMS";
	public final static String OPTOUT_FLAG_SMS_EYE = "SMS (eye)";
	public final static String OPTOUT_FLAG_SMS_SUPPRESS = "SMS Suppress";
	public final static String OPTOUT_FLAG_TELEMARKETING_SUPPRESS = "Telemarketing Suppress";
	public final static String OPTOUT_FLAG_WEB_BILL = "Web Bill";
	
	public final static String PARTITION_CONTACT_EMAIL_VALUES = "EMAIL";
	public final static String PARTITION_CONTACT_SMS_VALUES = "SMS";
	public final static String PARTITION_CONTACT_FAX_VALUES = "FAX";
	public final static String PARTITION_CONTACT_CUSTSEARCH_VALUES = "CUST_SEARCH";
	public final static String PARTITION_CONTACT_CSL_IVR_VALUES = "CSL_IVR";
	
	public final static String ACTIVE_INDEX = "Y";
	public final static String INACTIVE_INDEX = "N";
	
	public final static String SEND_SUCCESS = "SUCCESS";
	public final static String SEND_FAIL = "FAIL";
	public final static String SEND_BUSY = "BUSY";
	public final static String SEND_INVALID_GATEWAY = "INVALID_GATEWAY";
	
	public final static String EMAIL_SENT_REF_INDEX = "EMAIL-";
	public final static String EMAIL_DOMAIN_PCCW = "pccw.com";
	public final static String EMAIL_DOMAIN_CSL = "hkcsl.com";
	public final static String EMAIL_GATEWAY_CSL = "smtp.hkcsl.com";
	public final static String EMAIL_GATEWAY_CSL_DR = "smtp.dr.hkcsl.com";
	
	public final static String MOB_PAYMENT_METHOD_AUTOPAY = "Autopay";
	public final static String MOB_PAYMENT_METHOD_CASH = "Cash";
	public final static String MOB_PAYMENT_METHOD_CREDIT_CARD = "Credit Card";
	
	public final static String PARAMETER_PASSING_SLV = "SLV";

}
