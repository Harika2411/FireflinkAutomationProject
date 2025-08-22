package ninzaCRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import firelink.ninzaCRM.GenericUtitlity.FileUtility;
import firelink.ninzaCRM.GenericUtitlity.WebDriverUtility;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.ObjectRepository.LoginPage;

public class CreateCampaign {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		   FileUtility ff=new FileUtility();
		   
           String BROWSER = ff.readDataFromPropertyFile("browser");
           String URL=ff.readDataFromPropertyFile("url");
		
           String USERNAME=ff.readDataFromPropertyFile("username");
		
           String PASSWORD=ff.readDataFromPropertyFile("password");
           
     	  WebDriver driver=null;
    	  
    	  if(BROWSER.equals("chrome")) {
    		  driver=new ChromeDriver();
    		  
    	  }
    	  else if (BROWSER.equals("Edge")) {
    		driver=new EdgeDriver();
    	}
    	  else if (BROWSER.equals("firefox")) {
    			driver=new FirefoxDriver();
    		}
    	  else
    	  {
    		  driver=new EdgeDriver(); 
    	  }
    	  //maximize window
    	  
    	  WebDriverUtility wd=new  WebDriverUtility();
    	  wd.maximizeWindow(driver);
    	  driver.get(URL);
    	  LoginPage lp=new LoginPage(driver);
    	  lp.LoginToApp( USERNAME, PASSWORD);
    	  
    	  System.out.println("Succesfully logged");
    	  
    	  
    	 // DashBoardPage db=new DashBoardPage(driver);
     	  //db.CampaignClick();
     	  
     	  Thread.sleep(3000);
     	  
     	 CampaignPage cp=new CampaignPage(driver);
     	 cp.createCampaignClick();
    	  
    	  String CMGNAME = ff.readDataFromExcel("Sheet1", 10, 2);
    	  String STATUS = ff.readDataFromExcel("Sheet1", 10, 3);
    	  String TRGTSIZE = ff.readDataFromExcel("Sheet1", 10, 4);
    	 String CLOSEDATE = ff.readDataFromExcel("Sheet1", 10, 5);
    	  String TGTAUD = ff.readDataFromExcel("Sheet1", 10, 6);
    	  String DESCRIP = ff.readDataFromExcel("Sheet1", 10, 7);
    	  
    	
    	  
    	  CreateCampaignPage c=new CreateCampaignPage(driver);
    	  c.creatingCampaign(CMGNAME, STATUS, TRGTSIZE, CLOSEDATE, TGTAUD, DESCRIP);
    	  
    	 
    	  
    	  
    	  
           
           

	}

}
