package ninzaCRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import firelink.ninzaCRM.GenericUtitlity.FileUtility;
import firelink.ninzaCRM.GenericUtitlity.WebDriverUtility;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.ObjectRepository.LoginPage;
import ninzaCRM.ObjectRepository.createContacts;

public class ContactTest extends FileUtility {

	
@Test
	public  void sampleTest () throws IOException, InterruptedException {
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
  	  
  	  wd.ImplicitlyWaits(driver);
  	  
      
  	  String ContactName=ff.readDataFromExcel("Sheet1",1,2);
  	  String organization=ff.readDataFromExcel("Sheet1",1,3);
  	  String Mobile=ff.readDataFromExcel("Sheet1",1,4);
	  String title=ff.readDataFromExcel("Sheet1",1,5);
	  String cpgId= ff.readDataFromExcel("Sheet1",1,6);
	  String email= ff.readDataFromExcel("Sheet1",1,15);
	  String Dept= ff.readDataFromExcel("Sheet1",1,14);
	  String offPhone=ff.readDataFromExcel("Sheet1",1,16);
  	  
  	   DashBoardPage db=new DashBoardPage(driver);
  	   db.contactsClick();
  	   
  	  ContactsPage cp=new ContactsPage(driver);
  	  cp.createContactClick();
  	  
  	  
	  createContacts cc=new createContacts(driver);
	  cc.creatingContact(driver, cpgId, ContactName, organization, Mobile, title);
	  
	  wd.closingBrowser(driver);
	  
	
	  
	  
  	
  	 
  	 
  			 
  	   

	}

}
