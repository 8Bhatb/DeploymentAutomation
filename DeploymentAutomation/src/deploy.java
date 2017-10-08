
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;


public class deploy {

	public deploy() {
		// TODO Auto-generated constructor stub
	}

	public void processCSV(String file) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		String [][] commands = {
				{"1","Go to page","https://test.salesforce.com",""},
				//{"2","Set value","id=username",""},
				{"3","Set value","id=password","password"},
				{"4","Click","id=Login",""},
				//{"5","Go to page","/lightning/switcher?destination=classic",""},
				
				/*      to uncomment, add a * here>> * /
				{"6","Go To Page","/domainname/DomainName.apexp",""},
				{"8","Click","id=thePage:domainBlock:ssoForm:sso",""},
				{"6","Go To Page","/domainname/DomainName.apexp",""},
				{"8","Click","id=thePage:domainBlock:deployForm:deploy",""},
				{"6","Go To Page","/setup/ui/picklist_masteredit.jsp?tid=500&pt=19&setupid=CaseFields",""},
				{"7","Set Value","name=p1","Returned\nApproved\nTransferred\nSubmitted\nRejected"},
				{"8","Click","xpath=//input[@name='save' and @type='submit']",""},
				{"12","Go To Page","/setup/ui/picklist_masteredit.jsp?tid=500&pt=14&setupid=CaseFields",""},
				{"13","Set Value","name=p1","Fulfillment"},
				{"14","Click","xpath=//input[@name='save' and @type='submit']",""},
				{"6","Go To Page","/setup/ui/picklist_masteredit.jsp?tid=500&pt=19&setupid=CaseFields",""},
				{"7","Set Value","name=p1",""},
				{"8","Click","xpath=//input[@name='save' and @type='submit']",""},
				{"6","Go To Page","/setup/ui/picklist_masteredit.jsp?tid=500&pt=13&setupid=CaseFields",""},
				{"7","Set Value","name=p1","Branch\nChatter"},
				{"8","Click","xpath=//input[@name='save' and @type='submit']",""},
				{"9","Go To Page","/setup/ui/picklist_masteredit.jsp?tid=500&pt=12&setupid=CaseFields",""},
				{"10","Set Value","name=p1","Cancellation\nAmount Change\nReceipt Name Change\nRecipient Address Change\nAdd Additional Comments/Instructions"},
				{"11","Click","xpath=//input[@name='save' and @type='submit']",""},
				{"12","Go To Page","/p/setup/custent/CustomObjectsPage",""},
				{"14","Click","xpath=//a[text()='Financial Account']",""},
				{"14","Click","xpath=//td[text()='FinServ__FinancialAccountType__c']/preceding::th[1]/div/a",""},
				{"14","Click","xpath=//input[@title='New Values']",""},
				{"13","Set Value","name=p1","Deposit\nMMCD\nIRA\nMortgage\nLoan\nDebit\nLoan Check\nShare Draft"},
				{"14","Click","xpath=//input[@name='save' and @type='submit']",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","266 Processing"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","X266_Processing"},{"8","Click","name=save",""},
			 	{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","270"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","X270"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","270C"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","X270C"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","417"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","X417"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","55"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","X55"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","703C"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","X703C"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","722"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","X722"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","802"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","X802"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","All MSR/BSR"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","All_MSR_BSR"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","ATM Generic"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","ATM_Generic"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Call Assist Line"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Call_Assist_Line"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Card Replacement"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Card_Replacement"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Check copies"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Check_copies"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Collateral Control Box"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Collateral_Control_Box"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Credit Cards"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Credit_Cards"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","EFT Group"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","EFT_Group"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Estate Accounts"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Estate_Accounts"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Inbox"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Inbox"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Kana Request"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Kana_Request"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Letters"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Letters"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Loans Inbox"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Loans_Inbox"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Monetary"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Monetary"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Mortgage"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Mortgage"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Other"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Other"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","PenFed Foundation"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","PenFed_Foundation"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","PSD Cards"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","PSD_Cards"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Research and Maintenance"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Research_and_Maintenance"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Research Inbox"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Research_Inbox"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Share Desk"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Share_Desk"},{"8","Click","name=save",""},
				{"6","Go To Page","/setup/own/groupedit.jsp?setupid=PublicGroups",""},{"7","Set Value","name=p2","Supervisor Inbox"},{"7","Clear","name=dn",""},{"7","Set Value","name=dn","Supervisor_Inbox"},{"8","Click","name=save",""},
				
				{"6","Go To Page","/email-admin/editOrgEmailSettings.apexp",""},
				{"7","Click","xpath=//select[@id='thePage:theForm:editBlock:sendEmailAccessControlSection:sendEmailAccessControl:sendEmailAccessControlSelect']/option[text()='All email']",""},
				{"8","Click","id=thePage:theForm:editBlock:buttons:saveBtn",""},
	 /* */
		};
		deployConfiguration d = new deployConfiguration(commands);

	}

}
