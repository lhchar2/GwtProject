package com.jaosn.gwtproject.shared.enums;

public enum CslTicklerNotesType {
	PRIORITY("P"), GENERAL("G");
	
	private String val;
	
	private CslTicklerNotesType(String val) {
		this.val = val;
	}
	
	public String getValue() {
		return val;
	}
}
