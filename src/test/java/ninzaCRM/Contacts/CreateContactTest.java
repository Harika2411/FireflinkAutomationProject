package ninzaCRM.Contacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import firelink.ninzaCRM.GenericUtitlity.BaseClass;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.ObjectRepository.createContacts;

public class CreateContactTest extends BaseClass {
	
	@Test
	public void TC_E2E_01_createContactTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		  String CONTACTNAME=fUtil.readDataFromExcel("Sheet1",1,2);
	  	  String ORG=fUtil.readDataFromExcel("Sheet1",1,3);
	  	  String MOBILE=fUtil.readDataFromExcel("Sheet1",1,4);
		  String TITLE=fUtil.readDataFromExcel("Sheet1",1,5);
		  String CMGID= fUtil.readDataFromExcel("Sheet1",1,6);
		  String EMAIL= fUtil.readDataFromExcel("Sheet1",1,15);
		  String DEPT=fUtil.readDataFromExcel("Sheet1",1,14);
		  String OFFPHONE=fUtil.readDataFromExcel("Sheet1",1,16);
		  
		  DashBoardPage db=new DashBoardPage(driver);
	  	   db.contactsClick();
	  	   
	  	  ContactsPage cp=new ContactsPage(driver);
	  	  cp.createContactClick();
	  	  
	  	  
		  createContacts cc=new createContacts(driver);
		  cc.creatingContact(driver, CMGID, CONTACTNAME, ORG, MOBILE, TITLE);
	}
	@Test(groups="RegressionSuite")
	public void SampleTest() {
		System.out.println("Regression suite");
	}
	
	@Test
	public void sample() {
		System.out.println("REGIONAL SUITE");
	}
	
	@Test
	public void sample1() {
		System.out.println("----IMPACTED METHOD---");
	}

}
