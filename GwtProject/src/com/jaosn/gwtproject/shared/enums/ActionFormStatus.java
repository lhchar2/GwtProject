package com.jaosn.gwtproject.shared.enums;

public enum ActionFormStatus {
	DELETEED(0),
	ACTIVE(1),
	DISABLED(2);
	
	private final int value;
	private ActionFormStatus(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public static ActionFormStatus get(int value){
		switch (value){
		case 0: return DELETEED;
		case 1: return ACTIVE;
		case 2: return DISABLED;
		default: return DELETEED;
		}
	}
}
