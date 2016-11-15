package com.jaosn.gwtproject.shared.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class ServiceTypeNoUtils {

	private ServiceTypeNoUtils() {}
	
	public static Map<String, String> getDFormServiceTypeMap(boolean hasEmpty) {
		Map<String, String> result = new LinkedHashMap<String, String>();
		if (hasEmpty) {
			result.put("", "");
		}
		result.put(SvcConstants.SERVICE_TYPE_IMS_CODE, SvcConstants.SERVICE_TYPE_IMS_DESC);
		result.put("TEL" + SvcConstants.LTS_TPDAT_DELIMITER + "DEL", "TEL" + SvcConstants.LTS_TPDAT_DELIMITER + "DEL");
		result.put("TEL" + SvcConstants.LTS_TPDAT_DELIMITER + "NCR", "TEL" + SvcConstants.LTS_TPDAT_DELIMITER + "NCR");
		return result;
	}
	
	public static String getServiceTypeDesc(String lob, String serviceType, String datCode) {
		if (SvcConstants.SYSTEM_ID_LTS.equals(lob) && StringUtils.isNotBlankAfterTrim(datCode)) {
			return serviceType + SvcConstants.LTS_TPDAT_DELIMITER + datCode;
		} else if (SvcConstants.SYSTEM_ID_IMS.equals(lob) || (lob == null && SvcConstants.SERVICE_TYPE_IMS_CODE.equals(serviceType))) {
			return SvcConstants.SERVICE_TYPE_IMS_DESC;
		} else if (SvcConstants.SYSTEM_ID_CSL.equals(lob) || (lob == null && SvcConstants.SERVICE_TYPE_CSL_CODE.equals(serviceType))) {
			return SvcConstants.SERVICE_TYPE_CSL_DESC;
		} else if (SvcConstants.SYSTEM_ID_MOB.equals(lob) || (lob == null && SvcConstants.SERVICE_TYPE_MOB_CODE.equals(serviceType))) {
			// handle LTS MOB/MOB
			return SvcConstants.SERVICE_TYPE_MOB_DESC;
		} else {
			return serviceType;
		}
	}

	public static String getServiceTypeNoDesc(String lob, String serviceType, String datCode, String serviceNo) {
		String typeDesc = getServiceTypeDesc(lob, serviceType, datCode);
		if (StringUtils.isNotBlankAfterTrim(typeDesc)) {
			if (StringUtils.equals(serviceType, "ITS")) {
				return typeDesc + SvcConstants.SERVICE_TYPE_NO_DELIMITER + serviceNo;
			} else {
				return typeDesc + SvcConstants.SERVICE_TYPE_NO_DELIMITER + StringUtils.stripStart(serviceNo, '0');
			}
		}
		return serviceNo;
	}

	public static String getServiceNo(String typeNoDesc) {
		return getServiceNo(typeNoDesc, true);
	}

	public static String getServiceNo(String typeNoDesc, boolean nullable) {
		if (StringUtils.isNotBlankAfterTrim(typeNoDesc)) {
			int delimiterIndex = typeNoDesc.indexOf(SvcConstants.SERVICE_TYPE_NO_DELIMITER);
			if (delimiterIndex > -1) {
				return typeNoDesc.substring(delimiterIndex + 1);
			} else {
				return typeNoDesc;
			}
		}
		return (nullable ? null : "");
	}
	
	public static String getServiceTypeDescWithDatCode(String typeNoDesc) {
		return getServiceTypeDescWithDatCode(typeNoDesc, true);
	}

	public static String getServiceTypeDescWithDatCode(String typeNoDesc, boolean nullable) {
		if (StringUtils.isNotBlankAfterTrim(typeNoDesc)) {
			int delimiterIndex = typeNoDesc.indexOf(SvcConstants.SERVICE_TYPE_NO_DELIMITER);
			if (delimiterIndex > -1) {
				return typeNoDesc.substring(0, delimiterIndex);
			}
			return typeNoDesc;
		}
		return (nullable ? null : "");
	}

 	public static String getServiceTypeDesc(String typeNoDesc) {
		return getServiceTypeDesc(typeNoDesc, true);
	}

	public static String getServiceTypeDesc(String typeNoDesc, boolean nullable) {
		String serviceTypeDat = getServiceTypeDescWithDatCode(typeNoDesc);
		if (StringUtils.isNotBlankAfterTrim(serviceTypeDat)) {
			int delimiterIndex = serviceTypeDat.indexOf(SvcConstants.LTS_TPDAT_DELIMITER);
			if (delimiterIndex > -1) {
				return serviceTypeDat.substring(0, delimiterIndex);
			} else {
				return serviceTypeDat;
			}
		}
		return (nullable ? null : "");
	}

	public static String getDatCode(String typeNoDesc) {
		return getDatCode(typeNoDesc, true);
	}

	public static String getDatCode(String typeNoDesc, boolean nullable) {
		String serviceTypeDat = getServiceTypeDescWithDatCode(typeNoDesc);
		if (StringUtils.isNotBlankAfterTrim(serviceTypeDat)) {
			int delimiterIndex = serviceTypeDat.indexOf(SvcConstants.LTS_TPDAT_DELIMITER);
			if (delimiterIndex > -1) {
				return serviceTypeDat.substring(delimiterIndex + 1);
			} else {
				// return serviceTypeDat;
			}
		}
		return (nullable ? null : "");
	}
	
	public static String getServiceType(String typeNoDesc) {
		return getServiceType(typeNoDesc, true);
	}
	
	public static String getServiceType(String typeNoDesc, boolean nullable) {
		String typeDesc = getServiceTypeDesc(typeNoDesc);
		if (StringUtils.isNotBlankAfterTrim(typeDesc)) {
			if (SvcConstants.SERVICE_TYPE_IMS_DESC.equals(typeDesc)) {
				return SvcConstants.SERVICE_TYPE_IMS_CODE;
			} else if (SvcConstants.SERVICE_TYPE_CSL_DESC.equals(typeDesc)) {
				return SvcConstants.SERVICE_TYPE_CSL_CODE;
			} else if (SvcConstants.SYSTEM_MOB_DESC.equals(typeDesc)) {
				return SvcConstants.SERVICE_TYPE_MOB_CODE;
			} else {
				return typeDesc;
			}
		}
		return (nullable ? null : "");
	}
	
}