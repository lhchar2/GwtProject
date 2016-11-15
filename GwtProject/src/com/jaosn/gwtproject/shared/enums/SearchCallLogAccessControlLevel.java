package com.jaosn.gwtproject.shared.enums;

import com.pccw.springboard.svc.shared.validation.CallLogSearchDTOValidationGroup;

public enum SearchCallLogAccessControlLevel {
	STAFF_LEVEL   (CallLogSearchDTOValidationGroup.StaffLv.class),
	CHANNEL_LEVEL (CallLogSearchDTOValidationGroup.ChannelLv.class);

	private final Class<?> validationGroups[];
	
	private SearchCallLogAccessControlLevel(Class<?>... validationGroups){
		this.validationGroups = validationGroups;
	}
	
	public Class<?>[] getValidationGroups(){
		return this.validationGroups;
	}
	
	public static SearchCallLogAccessControlLevel getDefault(){
		return SearchCallLogAccessControlLevel.CHANNEL_LEVEL;
	}
}
