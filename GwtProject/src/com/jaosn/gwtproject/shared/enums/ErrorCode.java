package com.jaosn.gwtproject.shared.enums;

public enum ErrorCode {
	SVC_00001,	// ValidationException
	SVC_00002,  // FieldValidationException
	SVC_00010,	// SvcTimeoutException
	SVC_00011,	// AccessDeniedException
	SVC_00012,  // APIConnectionException
	
	// 01000 - 01899: MOB 
	SVC_01001, // mob cust profile
	SVC_01002, // mob MyHktLogin
	SVC_01003, // mob AcctProfile
	SVC_01004, // mob ServiceProfile
	SVC_01005, // mob PendingOrder
	SVC_01006, // mob NfcInfo
	SVC_01007, // mob ContractHistory
	SVC_01008, // mob OfferDetail
	SVC_01009, // mob OptOutSuppInd
	SVC_01010, // mob TicklerInfo
	SVC_01011, // mob AvgMonthlySpendingList
	SVC_01012, // mob MonthlyUsageList
	SVC_01013, // mob HandsetRabateList
	SVC_01014, // mob PendingInstallServices
	SVC_01015, // mob ContractDesc
	SVC_01016, // mob CustRemark
	SVC_01017, // mob SB Pending Order
	SVC_01018, // mob CSL Check
	SVC_01019, // mob getMbqUrl
	SVC_01020, // mob checkPendingSR
	SVC_01021, // mob getSrSummary
	SVC_01022, // mob Tab And Go Service
	SVC_01023, // mob Resource Detail Enquiry
	SVC_01024, // mob Payment Detail Enquiry
	SVC_01025, // mob getUsrToken
	SVC_01026, // mob getUsrUrlDetail
	SVC_01027, // mob getMobRebateSchedule
	SVC_01028, // mob getMobPenaltyForecast
	SVC_01029, // mob getTapAndGoKYC
	SVC_01030, // mob getSvcMktInfo
	SVC_01031, // mob getMobBrandSimInfo
	SVC_01032, // mob updateOptOut
	SVC_01033, // mob updatePaymentMethod
	SVC_01034, // mob logViewMarketingInfo
	SVC_01035, // mob updateCustContact
	SVC_01036, // mob updateBillInfo
	
	// 01900 - 01999: IFE
	SVC_01900, // IFE getCslAcctProfile
	SVC_01901, // IFE getCslServiceProfile
	SVC_01902, // IFE getCslTicklerNotes
	SVC_01903, // IFE getCslTicklerDetailsById
	SVC_01904, // IFE searchCslCustomer
	SVC_01905, // IFE getCslServiceSummary
	SVC_01906, // IFE getCslCallLog
	
	// 02000 - 02999: LTS 
	SVC_02001, //lts CustomerProfile
	SVC_02002, //lts AcctProfile
	SVC_02003, //lts ServiceProfile
	SVC_02004, //lts IddffpInfo
	SVC_02005, //lts ContractHistory
	SVC_02006, //lts OfferDetailCommitment
	SVC_02007, //lts OfferDetailRecurringCharge
	SVC_02008, //lts OfferDetailDiscount
	SVC_02009, //lts OfferDetailIncentive
	SVC_02010, //lts ContractDesc
	SVC_02011, //lts AmAsm
	SVC_02012, //lts DataPrivacy
	SVC_02013, //lts ServiceRelatedAccounts
	SVC_02014, //lts CustomerRemark
	SVC_02015, //lts WrittenInPersonRemark
	SVC_02016, //lts SpecialHandlingRemark
	SVC_02017, //lts RecontractRemark
	SVC_02018, //lts PendingOrder
	SVC_02019, //lts PendingInstallServices
	SVC_02020, //lts EyeInfoUsage
	SVC_02021, //lts IddInfoUsage
	SVC_02022, //lts Terminated ServiceProfile
	SVC_02023, //lts checkSbPendingOrder(List)
	SVC_02024, //lts Usage Image Date
	SVC_02025, //lts SR Index
	SVC_02026, //lts Bill Account Summary
	SVC_02027, //lts Call Plan Summary
	SVC_02028, //lts Call Plan Table
	SVC_02029, //lts Demands Notes Detail
	SVC_02030, //lts Bill Account Infomation
	SVC_02031, //lts EyeAlertMsgs
	SVC_02032, //lts getWipMessage
	SVC_02033, //lts SR Summary
	
	// 03000 - 03999: IMS 
	SVC_03001, // ims cust profile
	SVC_03002, // ims acct profile
	SVC_03003, // ims broadband profile
	SVC_03004, // ims nowtv profile
	SVC_03005, // ims data privacy
	SVC_03006, // ims offer detail commitmentList
	SVC_03007, // ims offer detail recurringChargeList
	SVC_03008, // ims offer detail discountList
	SVC_03009, // ims offer detail incentiveList
	SVC_03010, // ims amasm
	SVC_03011, // ims sophie cust sub
	SVC_03012, // ims sophie channel
	SVC_03013, // ims customer remarks
	SVC_03014, // ims written in person remarks
	SVC_03015, // ims special handling remarks
	SVC_03016, // ims contract history
	SVC_03017, // ims secondary package
	SVC_03018, // ims TvGeneralViewership
	SVC_03019, // ims TvSpecificViewership
	SVC_03020, // ims addressProfile
	SVC_03021, // ims Address1AmsEnquiryMain
	SVC_03022, // ims Address1AmsDetail
	SVC_03023, // ims ContractDesc
	SVC_03024, // ims PendingInstallServices
	SVC_03025, // ims PendingOrder
	SVC_03026, // ims HKCSSIndicator
	SVC_03027, // ims getUhub
	SVC_03028, // ims checkUHubOnlineCustomer	
	SVC_03029, // ims SB PendingOrder
	SVC_03030, // ims PendingOrders
	SVC_03031, // ims domain
	SVC_03032, // ims InstallActivateServiceFeeInfoMain
	SVC_03033, // ims InstallActivateServiceFeePONHistory
	SVC_03034, // ims getStandaloneTvCustProfile
	SVC_03035, // ims getTargetSBLkupMsg
	SVC_03036, // ims SR Index
	SVC_03037, // ims SR History Summary
	SVC_03038, // ims getCashPointEnquiry
	SVC_03039, // ims getNowDollarCheckOut
	SVC_03040, // ims getNowDollarMovement
	SVC_03041, // ims getPonCustMsg
	
	// 04000 - 04999: Call Log 
	SVC_04001, //calllog AllActiveDnis
	SVC_04002, //calllog CallLogById
	SVC_04003, //calllog CallLogsByBomParentCustNoAndSlvCustNo
	SVC_04004, //calllog CallLogsBySvcProspectCustId
	SVC_04005, //calllog CallLogsBySlvCustNo
	SVC_04006, //calllog CallLogsBySe archDTO
	SVC_04007, //calllog saveCallLog
	SVC_04008, //calllog Contact
	SVC_04009, //calllog saveCallLogAndFollowup
	SVC_04010, //calllog BomCallLog
	SVC_04011, //calllog BomCallLogDetail
	SVC_04012, //calllog EncryptedData
	SVC_04013, //calllog CrmLinksByCallLogSkin
	SVC_04014, //calllog NewCrmRef
	SVC_04015, //calllog NewCrmRef
	SVC_04016, //calllog NoCallbackCrmRefs
	SVC_04017, //calllog CrmRefById
	SVC_04018, //calllog updateCrmRefAfterCrmCallback
	SVC_04019, //calllog SvcCustomerIdByCallLogId
	SVC_04020, //calllog CrmCallLogHistory
	SVC_04021, //calllog CrmCallLogDetails
	SVC_04022, //calllog viewSvcActionForm
	SVC_04023, //calllog getAllActiveLastTierTermPlanCode
	SVC_04024, //calllog saveCallLogAndFollowupAndSendEmail
	SVC_04025, //calllog getInputtedActionForms
	
	//client
	SVC_04501, //call log history onRangeChanged
	SVC_04502, //call log nature getCrmBtnClickHandler
	
	// 05000 - 05999: DForm 
	SVC_05001, //DForm DFormsByBomParentCustNo
	SVC_05002, //DForm DFormsBySearchDTO
	SVC_05003, //DForm DFormsBySearchDTO
	SVC_05004, //DForm getDFormStatuses(statusGroup)
	SVC_05005, //DForm getDFormPrefixes(String prefixGroup)
	SVC_05006, //DForm registerNewDForm
	SVC_05007, //DForm isDFormPrefixSerialExist
	SVC_05008, //DForm DFormSerial
	SVC_05009, //DForm DFormStatus
	SVC_05010, //DForm BulkDFormStatus
	SVC_05011, //DForm getDFormAdditionalFields
	SVC_05012, //DForm getBillingAddress
	SVC_05013, //DForm getDFormStatuses(statusGroup, curSeq)
	SVC_05014, //DForm getDFormStatuses(statusGroup, lastStatusId)
	SVC_05015, //DForm getDFormPrefixes(ArrayList<String> prefixGroups)
	SVC_05016, //DForm updateBulkDFormSerial
	SVC_05017, //DForm updateDFormPrefix
	SVC_05018, //DForm getDFormPrefixesAll()
	SVC_05019, //DForm getDFormsBySearchHistoryDTO
	SVC_05020, //DForm getDFormsBySearchHistoryDTO
	SVC_05021, //DForm getDFormStatuses
	
	//client
	SVC_05501, // DFform refreshRecord
	SVC_05502, //DForm initFormPanel
	SVC_05503, //DForm refreshRecord
	
	// 06000 - 06999 call nature
	SVC_06001, //CallNature CallNatureListBySkin
	SVC_06002, //CallNature CallNatureListBySkin
	SVC_06003, //CallNature importNodes
	SVC_06004, //CallNature saveChangedNodes
	SVC_06005, //CallNature importCallResultReason
	SVC_06006, //CallNature getCallNatureActionFormDefPair
	
	//client
	SVC_06501, //CallNature CallNatureImport
	SVC_06502,  //CallNature CallNatureImport
	SVC_06503,  //CallNature CallNatureImport
	
	// 07000 - 7999 Customer Service
	SVC_07001, //customerService customerSearch
	SVC_07002, //customerService customerSearch
	SVC_07003, //customerService PendingOrders
	SVC_07004, //customerService PendingInstallerOrders
	SVC_07005, //customerService CampaignList
	SVC_07006, //customerService SbOrderHistory
	SVC_07007, //customerService SbOrderHistory
	SVC_07008, //customerService IMS SbOrderHistory
	SVC_07009, //customerService LTS SbOrderHistory
	SVC_07010, //customerService MOB SbOrderHistory
	SVC_07011, //customerService SLV SbOrderHistory
	SVC_07012, //customerService checkSpecialComplaintCase
	SVC_07013, //customerService getMyHktClubRegisterStatus
	SVC_07014, //customerService getCustomerAccounts
	SVC_07015, //customerService searchCustomerContactHistory
	SVC_07016, //customerService fillDailyIvrCustContactHistory
	
	//08000 - 8999 Follow Up Service
	SVC_08001, //FollowUpService searchFollowupCase
	SVC_08002, //FollowUpService createFollowupCase
	SVC_08003, //FollowUpService createFollowupCases
	SVC_08004, //FollowUpService FollowupCaseDetail
	SVC_08005, //FollowUpService reassignCase
	SVC_08006, //FollowUpService updateStatus
	SVC_08007, //FollowUpService updateUnreach
	SVC_08008, //FollowUpService FollowupCaseHistory
	SVC_08009, //FollowUpService bulkDistribute
	SVC_08010, //FollowUpService returnFollowup
	SVC_08011, //FollowUpService extendCallbackTimeFrame
	SVC_08012, //FollowUpService createNextFollowup
	SVC_08013, //FollowUpService AllDepartments
	SVC_08014, //FollowUpService ToDepartments
	SVC_08015, //FollowUpService AllCentres
	SVC_08016, //FollowUpService ToCentres
	SVC_08017, //FollowUpService Teams
	SVC_08018, //FollowUpService Staffs
	SVC_08019, //FollowUpService TeamEmailList
	SVC_08020, //FollowUpService searchStaffByAssigner
	SVC_08021, //FollowUpService AssignerScope
	SVC_08022, //FollowUpService UserAlerts
	SVC_08023, //FollowUpService SvcFollowupCount
	SVC_08024, //FollowUpService FollowupForAlert
	SVC_08025, //FollowUpService searchStaffWithDept
	SVC_08026, //FollowUpService getStaffsWithDtl
	SVC_08027, //FollowUpService getLanguageEmailList
	SVC_08028, //FollowUpService getAssignerList
	SVC_08029, //FollowUpService getChannelAndTeam
	SVC_08030, //FollowUpService searchStaffWithAssignableDept
	SVC_08031, //FollowUpService acceptOrder
	SVC_08032, //FollowUpService getRetailDepartments
	SVC_08033, //FollowUpService getTeamDefaultDeptCentre

	SVC_08105, //FollowUpService saveFollowupLanguage
	SVC_08106, //FollowUpService saveFollowupAssigner
	SVC_08107, //FollowUpService getTeamList
	SVC_08108, //FollowUpService getControlList
	SVC_08109, //FollowUpService saveFollowupCentreEdit
	SVC_08110, //FollowUpService saveFollowupDeptEdit
	SVC_08111, //FollowUpService saveFollowupTeam
	SVC_08112, //FollowUpService getApproverList
	SVC_08113, //FollowUpService saveFollowupApprover
	SVC_08114, //FollowUpService getDeptByCentre
	SVC_08115, //FollowUpService getCentre
	SVC_08116, //FollowUpService checkDeptName
	SVC_08117, //FollowUpService checkCentreName
	SVC_08118, //FollowUpService getAllTeamList
	SVC_08119, //FollowUpService saveTeamDefaultEdit
	SVC_08120, //FollowUpService countOutStandingCase
	SVC_08121, //FollowUpService getCentres
	
	//client
	SVC_08501, //FollowUpResult exportBtnOnClick
	SVC_08502, //FollowUpAdmin exportBtnOnClick
	
	//09000 - 9999 Hot Of Day
	SVC_09001, //HotOfDay getHotOfDay
	SVC_09002, //HotOfDay createHotOfDay
	SVC_09003, //HotOfDay updateHotOfDay
	SVC_09004, //HotOfDay removeHotOfDay
	SVC_09005, //HotOfDay getAllHotOfDay
	SVC_09006, //HotOfDay getControlList
	
	//10000 - 10999 Look Up Service
	SVC_10001, // LookUpService MobTicklerTypes
	SVC_10002, // LookUpService SearchServiceTypes
	SVC_10003, // LookUpService FollowupSearchServiceTypes
	SVC_10004, // LookUpService getSvcLookupList
	SVC_10005, // LookUpService getSearchCallLogServiceTypes
	SVC_10006, // LookUpService getCallLogXferFromList
	SVC_10007, // LookUpService getCallLogXferToList
	SVC_10008, // LookUpService getCslTicklerActions
	SVC_10009, // LookUpService getCslLocations
	SVC_10010, // LookUpService getCallLogMediaSource
	SVC_10011, // LookUpService getLookupDesc
	SVC_10012, // LookUpService getOptOutFlag
	SVC_10013, // LookUpService getSvcLookupListWithParentId
	SVC_10014, // LookUpService getAreas
	SVC_10015, // LookUpService getDistricts
	SVC_10016, // LookUpService getSections
	SVC_10017, // LookUpService getStreetCats
	SVC_10018, // LookUpService FaxServiceTypes
	SVC_10019, // LookUpService getBankName
	SVC_10020, // LookUpService getBankCode
	SVC_10021, // LookUpService getBranchName
	SVC_10022, // LookUpService getBranchCode
	SVC_10023, // LookUpService getPremierCode
	
	//11000 - 11999 Customer Service
	SVC_11001, //CustomerService getProspectCustomerById
	SVC_11002, //CustomerService saveProspectCust
	SVC_11003, //CustomerService saveCallLog
	SVC_11004, //CustomerService saveProspectCustAndCallLog
	SVC_11005, //CustomerService updateProspectCust
	SVC_11006, //CustomerService getProspectCustomersBySearchDTO
	
	//12000 - 12999 SLV Service
	SVC_12001, //SLVService getSlvCustomer
	SVC_12002, //SLVService getSlvServiceSummary
	SVC_12003,
	SVC_12004, //SLVService getSlvAlertCnt
	
	//13000-13999 SVC Customer Service
	SVC_13001, // SvcCustomerService saveSvcCustomer
	SVC_13002, // SvcCustomerService SvcCustomerById
	SVC_13003, // SvcCustomerService SvcCustomerByBomCustNo
	SVC_13004, // SvcCustomerService SvcCustomerBySlvCustNo
	SVC_13005, // SvcCustomerService SvcCustomerBySvcProspectCustId
	SVC_13006, // SvcCustomerService SvcCustomerByUniqueFields
	SVC_13007, // SvcCustomerService matchProspectCustWithBomCust
	SVC_13008, // SvcCustomerService renewProspectCustBomParentCustNo
	SVC_13009, // SvcCustomerService insertCustomerContactHistory
	SVC_13010, // SvcCustomerService updateCustomerContactHistoryDetailId
	SVC_13011, // SvcCustomerService getCustomerContactHistoryById
	
	//14000-14999 User Service
	SVC_14001, //UserService checkAccessRight
	SVC_14002, //UserService getWebSession
	SVC_14003, //UserService getAccessibleFunctions
	SVC_14004, //UserService searchStaffRecord
	SVC_14005, //UserService searchStaffRecords
	SVC_14006, //UserService getSt4ChannelAndCentre
	SVC_14007, //UserService getSt4Teams
	SVC_14008, //UserService getSt4Teams
	SVC_14009, //UserService getStaffIdsAndNames
	SVC_14010, //UserService getDepartments
	SVC_14011, //UserService getCentres
	SVC_14012, //UserService getSt4Teams
	SVC_14013, //UserService prepareFunctionCall
	SVC_14014, //UserService getDFormAccess
	SVC_14015, //UserService getSt4Role
	SVC_14016, //UserService createEditUser
	SVC_14017, //UserService InsertUser
	SVC_14018, //UserService updateUserInfo
	SVC_14019, //UserService endUserActiveRecord
	SVC_14020, //UserService searchStaffList
	SVC_14021, //UserService profileMatch
	SVC_14022, //UserService assignmentMatch
	SVC_14023, //UserService savePaymentSlipLog
	SVC_14024, //UserService geMyHktUrlDetail
	SVC_14025, //UserService getSRUrlDetail
	SVC_14026, //UserService getPaymentSlipUrl
	SVC_14027, //UserService getCustomerSearchHistory
	SVC_14028, //UserService getFunctionParm2
	
	//15000-15999 Client Prospect Customer
	SVC_15001, // ClientProspectCustomer  saveBtnOnClick
	SVC_15002, // ClientProspectCustomer initButtons
	SVC_15003, // ClientProspectCustomer saveBtnOnClick
	SVC_15004, // ClientProspectCustomer saveBtnOnClick
	
	//16000-16999 SVC page
	SVC_16001, //SVC page showInfo
	
	//17000-17999 Client SVC Dictionary
	SVC_17001, //ClientSVCDictionary get
	
	//18000-18999 Customer Profile
	SVC_18001, // Customer Profile showInfo
	
	//19000-19999 SearchCallLog
	SVC_19001, //SearchCallLog initFormPanel
	SVC_19002, //SearchCallLog Invalid Access Control Setup
	
	//20000-20999 ActionFormService
	SVC_20001, //ActionFormService getActionFormDef
	SVC_20002, //ActionFormService getActionFormData
	SVC_20003, //ActionFormService getActionFormTemplate
	SVC_20004, //ActionFormService getActionFormTemplateCallNatureAdmin
	SVC_20005, //ActionFormService svcEditActionForm
	SVC_20006, //ActionFormService svcDeleteActionForm
	SVC_20007, //ActionFormService svcToggleEnableActionForm
	SVC_20008, //ActionFormService readForm
	SVC_20009, //ActionFormService readForm
	SVC_20010, //ActionFormService readFormData
	SVC_20011, //ActionFormService insertFormData
	SVC_20012, //ActionFormService updateFormData
	SVC_20013, //ActionFormService insertForm
	SVC_20014, //ActionFormService updateForm
	SVC_20015, //ActionFormService tryTriggerAccessData
	SVC_20016, //ActionFormService tryTriggerAccessForm
	SVC_20017, //ActionFormService svcGetLinkedCallNature
	
	//21000-21999 Email
	SVC_21001, //SearchEmailTemplate 	initFormPanel
	SVC_21002, //SearchEmailHistory  	initFormPanel
	SVC_21003, //CreateEmailTemplate 	initFormPanel
	SVC_21004, //EmailUploadAttachment  initFormPanel
	SVC_21005, //EmailService sendEmailFromMailHelper
	SVC_21006, //EmailService createEmailTemplate
	SVC_21007, //EmailDownloadAttachment
	SVC_21008, //EmailService getEmailCategoryList
	SVC_21009, //EmailService addEmailCategory
	SVC_21010, //EmailService deleteEmailCategory
	SVC_21011, //EmailService updateEmailCategoryActive
	SVC_21012, //EmailService getActiveEmailCategory
	SVC_21013, //EmailService checkDeleteEmailCategory
	SVC_21014, //EmailService getEmailTemplateList
	SVC_21015, //EmailService updateEmailTemplateActive
	SVC_21016, //EmailService createEmailSentHistory
	SVC_21017, //EmailService getEmailHistoryList	
	SVC_21018, //EmailService insertAttachmentTempRecord
	SVC_21019, //EmailService insertEmailSavedAttachment
	SVC_21020, //EmailServiec getAttachmentByTemplateDetailID
	SVC_21021, //EmailService isValidFileExtention
	SVC_21022, //EmailService updateEmailCategory
	SVC_21023, //EmailService checkExistEmailCategoryName
	SVC_21024, //EmailService getTemplateOptOutList
	SVC_21025, //EmailService insertEmailCustomerContactHistory
	SVC_21026, //EmailSerivce getSendHistoryById
	SVC_21027, //EmailService getOptOutListWithValue
	SVC_21028, //EmailService getVariableNameList
	SVC_21029, //EmailService getVariableList
	SVC_21030, //EmailService getEmailGroup
	SVC_21031, //EmailService checkExistingEmailGatewayLookup
	SVC_21032, //EmailService getEmailGatewayList
	SVC_21033, //EmailService getEmailSenderCslList
	
	//22000-22999 SMS
	SVC_22001, // SmsService searchSmsTemp
	SVC_22002, // SmsService createNewSmsTemp
	SVC_22003, // SmsService updateSmsTemp
	SVC_22004, // SmsService getVariable
	SVC_22005, // SmsService getCategoryList
	SVC_22006, // SmsService searchSmsSentHistory
	SVC_22007, // SmsService addCategory
	SVC_22008, // SmsService setTempActive
	SVC_22009, // SmsService saveSmsSendHistory
	SVC_22010, // SmsService removeCategory
	SVC_22011, // SmsService checkTempIsUsed
	SVC_22012, // SmsService editCategory
	SVC_22013, // SmsService switchCategoryEnable
	SVC_22014, // SmsService getOptOutListWithValue
	SVC_22015, // SmsService getOptOutListWithId
	SVC_22016, // SmsService getUserQuota
	SVC_22017, // SmsService getChannelByFuncGroup
	SVC_22018, // SmsService sendSms
	SVC_22019, // SmsService getSenderList
	
	//23000-23999 CommonService
	SVC_23001, // CommonService getAttachmentPath
	
	//24000-24999 FaxService
	SVC_24001, // FaxService searchFaxDoc
	SVC_24002, // FaxService updateFaxCat
	
	//25000-25999 PrepaidService
	SVC_25001, // PrepaidService getPrepaidInfo
	
	CLIENT_ERROR,
	UNDEFINED;
	
	private ErrorCode() {
	}

}
