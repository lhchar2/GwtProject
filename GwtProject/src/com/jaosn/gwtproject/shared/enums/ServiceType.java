package com.jaosn.gwtproject.shared.enums;

import com.pccw.springboard.svc.shared.utils.StringUtils;

public enum ServiceType {
	FSA("IMS", "FSA"), MRT("3G", "MRT"), 
	TEL("TEL", "TEL"), MOB("MOB", "MOB"), AGR("AGR", "AGR"), ITS("ITS", "ITS");
	
	private final String code;
	private final String desc;
	
	private ServiceType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}	

	public static String getDesc(String code) {
		for (ServiceType serviceType : ServiceType.values()) {
			if (StringUtils.equals(serviceType.getCode(), code)) {
				return serviceType.getDesc();
			}
		}
		return code;
	}

}
