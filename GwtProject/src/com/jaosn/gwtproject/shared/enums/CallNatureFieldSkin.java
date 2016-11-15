package com.jaosn.gwtproject.shared.enums;

import java.util.ArrayList;

public enum CallNatureFieldSkin {
	SYSTEM(CallNatureType.PRODUCT_TYPE, CallNatureType.CALL_NATURE),
	A(CallNatureType.PRODUCT_TYPE, CallNatureType.CALL_NATURE, CallNatureType.CALL_NATURE_SUB),
	B(CallNatureType.PRODUCT_TYPE, CallNatureType.SERVICE_TYPE, CallNatureType.SERVICE_TYPE_SUB ,CallNatureType.CALL_NATURE, CallNatureType.CALL_NATURE_SUB),
	C(CallNatureType.PRODUCT_TYPE, CallNatureType.CALL_NATURE),
	D(CallNatureType.PRODUCT_TYPE, CallNatureType.CALL_NATURE, CallNatureType.CALL_NATURE_SUB),
	E(CallNatureType.PRODUCT_TYPE, /*CallNatureType.PRODUCT_TYPE_SUB, */CallNatureType.CALL_NATURE, CallNatureType.CALL_NATURE_SUB),
	F(CallNatureType.PRODUCT_TYPE, CallNatureType.SERVICE_TYPE, CallNatureType.SERVICE_TYPE_SUB ,CallNatureType.CALL_NATURE);
	
	private final ArrayList<CallNatureType> fields;
	
	private CallNatureFieldSkin(CallNatureType ...callNatureTypes) {
		fields = new ArrayList<CallNatureType>();
		for (CallNatureType val : callNatureTypes) {
			fields.add(val);
		}
	}
	
	public boolean contains(CallNatureType type) {
		if (fields.contains(type)) {
			return true;
		}
		return false;
	}
	
	public CallNatureType getNext(CallNatureType type) {
		if (type == null) {
			return fields.get(0);
		}
		int index = fields.indexOf(type);
		if (index != -1 && index + 1 < fields.size()) {
			return fields.get(index+1);
		} else {
			return null;
		}
	}
	
	public CallNatureType getPrevious(CallNatureType type) {
		if (type == null) {
			return fields.get(0);
		}
		int index = fields.indexOf(type);
		if (index > 0) {
			return fields.get(index-1);
		} else {
			return null;
		}
	}
	
	public ArrayList<CallNatureType> getTypes() {
		return this.fields;
	}
	
}
