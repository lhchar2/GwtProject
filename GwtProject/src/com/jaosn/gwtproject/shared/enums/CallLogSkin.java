package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;
import java.util.List;

import com.jaosn.gwtproject.shared.utils.StringUtils;

public enum CallLogSkin {
	SYSTEM("System Default", CallNatureFieldSkin.SYSTEM),
	PCD_RE("PCD Reactive Retention", CallNatureFieldSkin.A), 
	PCD_PRO("PCD Proactive Retention", CallNatureFieldSkin.A),
	MOB_RE("Mobile Reactive Retention", CallNatureFieldSkin.A),
	MOB_PRO("Mobile Proactive Retention", CallNatureFieldSkin.A),
	DEL_RE("DEL Reactive Retention", CallNatureFieldSkin.A),
	DEL_PRO("DEL Proactive Retention", CallNatureFieldSkin.A), 
	OB_SALES("OB Sales", CallNatureFieldSkin.C),
	IB_SALES("IB Sales", CallNatureFieldSkin.D), 
	FL_CBE("Fixed Line CBE", CallNatureFieldSkin.A),
	FL_CFR("Fixed Line CFR", CallNatureFieldSkin.A),
	FL_CSBE("Fixed Line CS BE", CallNatureFieldSkin.A),
	FL_TSFR("Fixed Line TS FR", CallNatureFieldSkin.A),
	IMS_CS("IMS CS", CallNatureFieldSkin.B),
	IMS_TS("IMS TS", CallNatureFieldSkin.B),
	MOB_CS("Mobile CS", CallNatureFieldSkin.B),
	PT_CS("HKT Premier CS", CallNatureFieldSkin.B),
	PT_SALES("HKT Premier Sales", CallNatureFieldSkin.B), 
	REF_GRP("Referral Group", CallNatureFieldSkin.E),
	SRV_CTR("Service Center", CallNatureFieldSkin.B),
	RETAIL("Retail", CallNatureFieldSkin.A),
	DS("Direct Sales", CallNatureFieldSkin.A),
	PTV_CS("nowTV Premier CS", CallNatureFieldSkin.B),
	V_CS("nowTV Call Centre CS", CallNatureFieldSkin.B),
	CLUB_CSO("CLUB_CSO", CallNatureFieldSkin.A),
	CSL_CRM("CSL-CRM", CallNatureFieldSkin.B),
	CSL_NEW("CSL-Prototype", CallNatureFieldSkin.F),
	SALES_REF("Sales Referral", CallNatureFieldSkin.E);

	private final CallNatureFieldSkin fieldSkin;
	private final String desc;
	
	private CallLogSkin(String desc, CallNatureFieldSkin fieldSkin) {
		this.desc = desc;
		this.fieldSkin = fieldSkin;
	}
	
	public CallNatureFieldSkin getFieldSkin() {
		return fieldSkin;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public CallNatureType getNext(CallNatureType type) {
		return fieldSkin.getNext(type);
	}
	
	public CallNatureType getPrevious(CallNatureType type) {
		return fieldSkin.getPrevious(type);
	}
	
	public boolean contains(CallNatureType type) {
		return fieldSkin.contains(type);
	}
	
	public boolean isFirstType(CallNatureType type) {
		return (fieldSkin.getPrevious(type) == null);
	}
	
	public boolean isLastType(CallNatureType type) {
		return (fieldSkin.getNext(type) == null);
	}
	
	public static List<String> getList() {
		List<String> list = new ArrayList<String>();
		for (CallLogSkin callLogSkin : CallLogSkin.values()) {
			list.add(callLogSkin.name());
		}
		return list;
	}
	
	public static CallLogSkin getByDesc(String desc) {
		if (StringUtils.trimToNull(desc) == null) {
			return null;
		}
		for (CallLogSkin callLogSkin : CallLogSkin.values()) {
			if (desc.equals(callLogSkin.getDesc())) {
				return callLogSkin;
			}
		}
		return null;
	}
}
