package com.jaosn.gwtproject.shared.enums;

public enum SvcLookupType {
	REJECT_REASON,
	INVALID_REFERRAL,
	MOB_BILL_PERIOD, MOB_BILL_FORMAT, MOB_BILL_LANG;
	
	public static boolean contain(String target) {
		for (SvcLookupType value : values()) {
			if (value.name().equals(target)) {
				return true;
			}
		}
		return false;
	}

}
