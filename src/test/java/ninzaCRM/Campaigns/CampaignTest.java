package ninzaCRM.Campaigns;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import firelink.ninzaCRM.GenericUtitlity.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.DashBoardPage;

@Listeners(firelink.ninzaCRM.GenericUtitlity.ListenersImplementation.class)

public class CampaignTest extends BaseClass {
	
	@Test
	public void TC_E2F_05_createCampaignTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		
		 String CMGNAME = fUtil.readDataFromExcel("Sheet1", 10, 2);
   	     String STATUS = fUtil.readDataFromExcel("Sheet1", 10, 3);
   	     String TRGTSIZE = fUtil.readDataFromExcel("Sheet1", 10, 4);
   	     String CLOSEDATE = fUtil.readDataFromExcel("Sheet1", 10, 5);
   	     String TGTAUD = fUtil.readDataFromExcel("Sheet1", 10, 6);
   	     String DESCRIP = fUtil.readDataFromExcel("Sheet1", 10, 7);
   	     
   	  DashBoardPage db=new DashBoardPage(driver);
 	  db.CampaignClick();
 	//  Reporter.log("Campaign is clicked");
 	  
 	 CampaignPage cp=new CampaignPage(driver);
 	 cp.createCampaignClick();
 //	Reporter.log(" create Campaign is clicked",true);
 	
 	//Assert.fail();
 	
 	 CreateCampaignPage ccp=new CreateCampaignPage(driver);
 	 ccp.creatingCampaign(CMGNAME, STATUS, TRGTSIZE, CLOSEDATE, TGTAUD, DESCRIP);
 	//Reporter.log("  Campaign is created successfully",true);
		
	}
	@Test(groups="SmokeSuite")
	public void SampleTest() {
		//Assert.fail();
		System.out.println("Hii Hello");
	
		
	}

}
