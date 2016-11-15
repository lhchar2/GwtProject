package com.jaosn.gwtproject.shared.enums;

public enum DictionaryURL {
	ENV("environment"),
	VERSION("version"),
	SVC_HOME("svcHomeUrl"), TIMEOUT("svcTimeoutUrl"),
	TV_VIM("tvVimUrl"),
	TV_NEW_VIM("tvNewVimUrl"),
	SOPHIE("sophieUrl"),
	PROJECT_DIAMOND("projectDiamondUrl"), PROJECT_DIAMOND_AC("projectDiamondAc"), PROJECT_DIAMOND_PW("projectDiamondPw"),
	PROJECT_GOLD_ADMIN("projectGoldAdminUrl"), PROJECT_GOLD_TOPUP("projectGoldTopupUrl"),
	IFE_URL("ifeUrl"),
	USR_URL("usrUrl"),
	CRM_ACTION_FORM_URL("crmActionFormUrl"),
	SVC_EDIT_ACTION_FORM_URL("svcEditActionFormUrl"),
	SVC_VIEW_ACTION_FORM_URL("svcViewActionFormUrl"),
	SVC_SUBMIT_ACTION_FORM_URL("svcSubmitActionFormUrl"),
	SVC_REVISE_ACTION_FORM_URL("svcReviseActionFormUrl"),
	SVC_DELETE_ACTION_FORM_URL("svcDeleteActionFormUrl"),
	SVC_CREATE_ACTION_FORM_URL("svcCreateActionFormUrl"),
	SVC_COPY_ACTION_FORM_URL("svcCopyActionFormUrl"),
	CRM_CALL_LOG_DETAIL("crmCallLogDetailUrl"),
	CEKS_PAN_CAPTURE("ceksPanCaptureUrl"),
	QUICK_HELP("quickHelpUrl"), 
	QR_PAYMENT_SLIP("paymentSlipUrl");
	
	private String val;
	
	private DictionaryURL(String val) {
		this.val = val;
	}
	
	public String getValue() {
		return val;
	}
}
