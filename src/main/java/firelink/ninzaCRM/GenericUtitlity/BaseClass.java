package firelink.ninzaCRM.GenericUtitlity;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.ObjectRepository.LoginPage;



public class BaseClass  {
	
	 public WebDriverUtility wdUtil=new WebDriverUtility();
	 public JavaUtility jUtil=new JavaUtility();
	 public FileUtility fUtil =new FileUtility();
     public WebDriver driver;
			
			
	 public static  WebDriver sdriver;
	@BeforeSuite(alwaysRun =true)
	public void bsConfig() {
		System.out.println("======== DB CONNECTION SUCCESSFULL==========");
	}
	
	//@Parameters("browser")
//	@BeforeTest(alwaysRun =true)
	
	@BeforeClass(alwaysRun =true)
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		String URL = fUtil.readDataFromPropertyFile("url");
       // WebDriver driver;
    	  
    	  if(BROWSER.equals("chrome")) {
    		  driver=new ChromeDriver();
    		  
    	  }
    	  else if (BROWSER.equals("edge")) {
    		  
    		  WebDriverManager.edgedriver().setup();
    		driver=new EdgeDriver();
    	}
    	  else if (BROWSER.equals("firefox")) {
    		  WebDriverManager.firefoxdriver().setup();
    			driver=new FirefoxDriver();
    		}
    	  else
    	  {
    		  driver=new EdgeDriver(); 
    	  }
    	  //maximize window
    	  
    	  sdriver=driver;
    	  //WebDriverUtility wd=new  WebDriverUtility();
    	  wdUtil.maximizeWindow(driver);
    	  driver.get(URL);
		
		System.out.println("===========SUCCESSFULLY LAUNCHED "+BROWSER+" browser============");
		
		
	}
	
	
	
	@BeforeMethod(alwaysRun =true)
	public void bmConfig() throws IOException {
		String USERNAME = fUtil.readDataFromPropertyFile("username");
	
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("===SUCCESSFULLY LOGGED IN========");
		
	}
	
	@AfterMethod(alwaysRun =true)
	public void amConfig() {
		DashBoardPage db=new DashBoardPage(driver);
		db.UserIconClick();
		db.logoutClick();
		System.out.println("==========logout successful============");
	}
	//@AfterTest(alwaysRun =true)
	@AfterClass(alwaysRun =true)
	public void acConfig() {
		//driver.quit();
		System.out.println("==========SUCCESSFULLLY CLOSED  BROWSER============");
	}
	
	
	@AfterSuite(alwaysRun =true)
	public void asConfig() {
		System.out.println("=========DB CONNECTION CLOSED==========");
	}

}
