package com.jaosn.gwtproject.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.jaosn.gwtproject.client.SvcPageTemplate;
import com.jaosn.gwtproject.client.common.CustomerSearchSession;
import com.jaosn.gwtproject.client.common.HotOfTheDayAdmin;
import com.jaosn.gwtproject.client.speedtest.NetworkTest;
import com.jaosn.gwtproject.client.utils.SvcClientUtils;
import com.jaosn.gwtproject.client.utils.SvcFunctionUtil;
import com.jaosn.gwtproject.client.widget.actionform.ActionFormAdmin;
import com.jaosn.gwtproject.client.widget.actionform.ActionFormDataSearch;
import com.jaosn.gwtproject.client.widget.admin.CallNatureImport;
import com.jaosn.gwtproject.client.widget.admin.UpdateProfile;
import com.jaosn.gwtproject.client.widget.admin.user.UserAdmin;
import com.jaosn.gwtproject.client.widget.calllog.BomCallLogHistory;
import com.jaosn.gwtproject.client.widget.calllog.CallLogHistoryFilterable;
import com.jaosn.gwtproject.client.widget.calllog.CreateCallLog;
import com.jaosn.gwtproject.client.widget.calllog.CrmCallLogHistory;
import com.jaosn.gwtproject.client.widget.calllog.CslCallLogHistory;
import com.jaosn.gwtproject.client.widget.calllog.nature.admin.CallNatureAdmin;
import com.jaosn.gwtproject.client.widget.calllog.search.SearchCallLog;
import com.jaosn.gwtproject.client.widget.csl.CslAcctProfile;
import com.jaosn.gwtproject.client.widget.csl.CslCustProfile;
import com.jaosn.gwtproject.client.widget.csl.CslServiceProfile;
import com.jaosn.gwtproject.client.widget.csl.CslTicklerNotes;
import com.jaosn.gwtproject.client.widget.customer.Campaign;
import com.jaosn.gwtproject.client.widget.customer.CustomerContactHistory;
import com.jaosn.gwtproject.client.widget.customer.OrderHistory;
import com.jaosn.gwtproject.client.widget.customer.PrepaidSim;
import com.jaosn.gwtproject.client.widget.custsearch.CustomerSearch;
import com.jaosn.gwtproject.client.widget.custsearch.HistorySearchResult;
import com.jaosn.gwtproject.client.widget.custsearch.MultipleCustSearchResult;
import com.jaosn.gwtproject.client.widget.dform.CustomerDform;
import com.jaosn.gwtproject.client.widget.dform.SearchDform;
import com.jaosn.gwtproject.client.widget.email.CreateNewEmail;
import com.jaosn.gwtproject.client.widget.email.EmailSentHistory;
import com.jaosn.gwtproject.client.widget.email.EmailTemplateManager;
import com.jaosn.gwtproject.client.widget.followup.FollowUpCustResult;
import com.jaosn.gwtproject.client.widget.followup.admin.FollowUpAdmin;
import com.jaosn.gwtproject.client.widget.followup.create.CreateLogCase;
import com.jaosn.gwtproject.client.widget.lts.LtsBillAcctProfile;
import com.jaosn.gwtproject.client.widget.lts.LtsCustProfile;
import com.jaosn.gwtproject.client.widget.lts.LtsProfile;
import com.jaosn.gwtproject.client.widget.lts.usage.LtsUsage;
import com.jaosn.gwtproject.client.widget.mob.MobBillAccountProfile;
import com.jaosn.gwtproject.client.widget.mob.MobCustProfile;
import com.jaosn.gwtproject.client.widget.mob.MobServiceProfile;
import com.jaosn.gwtproject.client.widget.mob.usage.MobMobileUsage;
import com.jaosn.gwtproject.client.widget.pcd.ImsServiceProfile;
import com.jaosn.gwtproject.client.widget.pcd.PcdBillAcctProfile;
import com.jaosn.gwtproject.client.widget.pcd.PcdCustProfile;
import com.jaosn.gwtproject.client.widget.pcd.usage.ImsUsage;
import com.jaosn.gwtproject.client.widget.prospectcustomer.InitProspectCustomer;
import com.jaosn.gwtproject.client.widget.slv.SlvServiceSummary;
import com.jaosn.gwtproject.client.widget.sms.admin.SmsTempAdminManage;
import com.jaosn.gwtproject.client.widget.sms.create.SmsTempSearchManage;
import com.jaosn.gwtproject.client.widget.sms.history.SmsSendHistoryPage;
import com.pccw.springboard.svc.shared.dto.custsearch.CustomerOverviewDTO;
import com.pccw.springboard.svc.shared.enums.CallLogSkin;
import com.pccw.springboard.svc.shared.enums.ErrorCode;
import com.pccw.springboard.svc.shared.enums.SvcContent;
import com.pccw.springboard.svc.shared.enums.WidgetMode;
import com.pccw.springboard.svc.shared.exception.ApplicationException;
import com.pccw.springboard.svc.shared.utils.SvcConstants;

public class WidgetFactory {

	// avoid initialize this class accidentally
	private WidgetFactory() {
	};
	
	public static SvcPanel getWidgetWithSvcPanel(SvcContent svcContent) {
		return getWidgetWithSvcPanel(svcContent, null);
	}

	public static SvcPanel getWidgetWithSvcPanel(SvcContent svcContent, String dataKey) {
		SvcPanel result = new SvcPanel();
		result.setDataKey((dataKey == null ? "" : dataKey));
		result.setSvcContentId(svcContent);
		switch (svcContent) {
		//IMS functions
		case IMS_CUST_PROFILE:
		case IMS_ACCT_PROFILE:
		case IMS_SERVICE_PROFILE:
			result.setStyle(SvcPanel.Style.IMS);
			break;
		case IMS_TV_VIEWERSHIP:
			result.setStyle(SvcPanel.Style.TV);
			break;
		//LTS functions
		case LTS_CUST_PROFILE:
		case LTS_ACCT_PROFILE:
		case LTS_SERVICE_PROFILE:
		case LTS_USAGE:
			result.setStyle(SvcPanel.Style.LTS);
			break;
		//MOB functions
		case MOB_CUST_PROFILE: 
		case MOB_ACCT_PROFILE:
		case MOB_SERVICE_PROFILE:
		case MOB_USAGE:
			result.setStyle(SvcPanel.Style.MOB);
			break;
		// SLV functions
		case SLV_SERVICE_SUMMARY:
			result.setStyle(SvcPanel.Style.SLV);
			break;
		// CSL functions
		case CSL_CUST_PROFILE: 
		case CSL_ACCT_PROFILE:
		case CSL_SERVICE_PROFILE:
		case CSL_TICKLER_NOTES:
			result.setStyle(SvcPanel.Style.CSL);
			break;
		default:
			break;
		}
		Widget content = getRawWidget(svcContent, dataKey);
		result.setContent(content);

		return result;
	}
	
	public static Widget getRawWidget(SvcContent svcContent) {
		return getWidgetWithSvcPanel(svcContent, null);
	}
	
	public static Widget getRawWidget(SvcContent svcContent, String dataKey) {
		switch (svcContent) {
		// Customer
		case SB_ORDER_HISTORY:
			return new OrderHistory();
		case SB_ORDER_HISTORY2:
			return new OrderHistory(true);
		case CAMPAIGN:
			return new Campaign();
		case CUST_CONTACT_HISTORY:
			return new CustomerContactHistory();
		// Call Logs
		case CALL_LOG_CREATION:
			CallLogSkin callLogSkin = SvcFunctionUtil.getCallLogCreationParam1();
			if (callLogSkin == null) {
				SvcClientUtils.handleException( new ApplicationException(ErrorCode.SVC_18001,"Invalid Access Control Setup - Interaction Log Creation - Invalid Param1"));
				return null;
			} else {
				return new CreateCallLog(callLogSkin);
			}
		case CALL_LOG_SEARCH:
			return new SearchCallLog();
		case CALL_LOG_HISTORY:
			CustomerSearchSession custSession = SvcPageTemplate.get().getCustomerSearchSession();
			
			//Get the csl' Cust IdDocList.(It may be not single customer on CSL side)
			ArrayList<String> cslIdDocList = new ArrayList<String>();
			for (CustomerOverviewDTO idDocNo: custSession.getCustomerData()){
				if (idDocNo.getSystemId()!= null && SvcConstants.SYSTEM_ID_CSL.equals(idDocNo.getSystemId())){
					cslIdDocList.add(idDocNo.getIdDocNum());
				}
			}
			return new CallLogHistoryFilterable(custSession.getBomParentCustNo(), custSession.getSlvCustNo(), null, cslIdDocList);
		case CALL_NATURE_IMPORT: //TEST_PAGE:
			return new CallNatureImport();
		case CRM_CALL_LOG_HISTORY:
			return new CrmCallLogHistory();
		case BOM_CALL_LOG_HISTORY:
			return new BomCallLogHistory();
		case CSL_CALL_LOG_HISTORY:
			return new CslCallLogHistory();
		case CALL_NATURE_ADMIN:
			List<CallLogSkin> skins = SvcFunctionUtil.getCallNatureAdminParam1();
			if (skins != null && skins.size() > 0) {
				return new CallNatureAdmin(skins);
			} else {
				SvcClientUtils.handleException(new ApplicationException(ErrorCode.SVC_16001, "Invalid Access Control Setup - Call Nature Admin - Invalid Param1"));
				return null;
			}
		//IMS functions
		case IMS_CUST_PROFILE:
			return new PcdCustProfile(dataKey);
		case IMS_ACCT_PROFILE:
			return new PcdBillAcctProfile(dataKey);
		case IMS_SERVICE_PROFILE:
			return new ImsServiceProfile(dataKey);
		case IMS_TV_VIEWERSHIP:
			return new ImsUsage();
		//LTS functions
		case LTS_CUST_PROFILE:
			return new LtsCustProfile(dataKey);
		case LTS_ACCT_PROFILE:
			return new LtsBillAcctProfile(dataKey);
		case LTS_SERVICE_PROFILE:
			return new LtsProfile(dataKey);
		case LTS_USAGE:
			return new LtsUsage();
		//MOB functions
		case MOB_CUST_PROFILE: 
			return new MobCustProfile(dataKey);
		case MOB_ACCT_PROFILE:
			return new MobBillAccountProfile(dataKey);
		case MOB_SERVICE_PROFILE:
			return new MobServiceProfile(dataKey);
		case MOB_USAGE:
			return (new MobMobileUsage());
		case PREPAID_SIM:
			return new PrepaidSim();
		// SLV functions
		case SLV_SERVICE_SUMMARY:
			return new SlvServiceSummary(dataKey);
		// CSL functions
		case CSL_CUST_PROFILE: 
			return new CslCustProfile(dataKey);
		case CSL_ACCT_PROFILE:
			return new CslAcctProfile(dataKey);
		case CSL_SERVICE_PROFILE:
			return new CslServiceProfile(dataKey);
		case CSL_TICKLER_NOTES:
			return new CslTicklerNotes(dataKey);
		// D-Form
		case DFORM_CUST:
			return new CustomerDform();
		case DFORM_MANAGEMENT:
			return new SearchDform();
		// Follow-up
		case FOLLOW_UP_CREATE_CASE:
			return new CreateLogCase(0, true, true);
		case FOLLOW_UP_ADMIN:
			return new FollowUpAdmin();
		case CUST_FOLLOWUP:
			return new FollowUpCustResult();
		// Email
		case CREATE_NEW_EMAIL:
			return new CreateNewEmail();
		case EMAIL_SENT_HISTORY:
			return new EmailSentHistory();
		case EMAIL_TEMPLATE_MANAGER:
			return new EmailTemplateManager();
		// SMS
		case CREATE_NEW_SMS:
			return new SmsTempSearchManage();
		case SMS_HISTORY:
			return new SmsSendHistoryPage();
		case SMS_TEMP_ADMIN_MANAGER:
			return new SmsTempAdminManage();
		// Fax
		//case FAX_DOC_SEARCH:
		//	return new FaxDocSearch();
		// Action Form
		case ACTION_FORM_ADMIN:
			return new ActionFormAdmin();
		case ACTION_FORM_DATA_SEARCH:
			return new ActionFormDataSearch();
		// Other
		case CUST_SEARCH:
			return new CustomerSearch();
		case CUST_SEARCH_RESULT_MULTIPLE:
			return new MultipleCustSearchResult();
		case HISTORY_SEARCH_RESULT:
			return new HistorySearchResult();
		case USER_ADMIN:					
			return new UserAdmin();
		case HOT_OF_THE_DAY_ADMIN:
			return new HotOfTheDayAdmin();
		case NETWORK_TEST:
			return new NetworkTest();
		case PROSPECT_CUST:
			return new InitProspectCustomer(WidgetMode.CREATE);
		case UPDATE_PROFILE:
			return new UpdateProfile();
		case PROSPECT_CUST_SEARCH:
			
			
		default:
			return new Label("Under Construction");
		}		
	}

}