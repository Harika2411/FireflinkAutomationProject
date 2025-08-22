package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import firelink.ninzaCRM.GenericUtitlity.WebDriverUtility;

public class VerifyPurchaseOrderWithUpdatedContact {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		  Properties p=new Properties();
		  
		  p.load(fi);
		  
		  String browser =p.getProperty("browser");
		  String Url=p.getProperty("url");
		  String UN=p.getProperty("username");
		  String Pwd=p.getProperty("password");
		  
		  WebDriver driver=null;
		  
		  if(browser.equals("chrome")) {
			  driver=new ChromeDriver();
			  
		  }
		  else if (browser.equals("Edge")) {
			driver=new EdgeDriver();
		}
		  else if (browser.equals("firefox")) {
				driver=new FirefoxDriver();
			}
		  else
		  {
			  driver=new EdgeDriver(); 
		  }
		  
		  WebDriverUtility wd=new  WebDriverUtility();
		  wd.maximizeWindow(driver);
		 // driver.manage().window().maximize();
		  
		  driver.get(Url);
		  
		  String mainHandle=driver.getWindowHandle();	
		  
		  
		  driver.findElement(By.id("username")).sendKeys(UN);
		  driver.findElement(By.id("inputPassword")).sendKeys(Pwd);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	FileInputStream fis=new  FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
	  
	Workbook wb=WorkbookFactory.create(fis);
  Sheet sh= wb.getSheet("Sheet1");
  
 Row row= sh.getRow(1);
 String ContactName=row.getCell(2).getStringCellValue();
 String billAdd=row.getCell(17).getStringCellValue();
 String shipAdd=row.getCell(18).getStringCellValue();
 String billBox=row.getCell(19).toString();
 String shipBox=row.getCell(20).toString();
 String billCity=row.getCell(21).getStringCellValue();
 String city=row.getCell(22).getStringCellValue();
 String billState=row.getCell(23).getStringCellValue();
 String state=row.getCell(24).getStringCellValue();
 String billCode=row.getCell(25).toString();
 String postCode=row.getCell(26).toString();
 String billCoun=row.getCell(27).getStringCellValue();
 String country=row.getCell(28).getStringCellValue();
 String ProdName=row.getCell(8).getStringCellValue();
 
 
 
 driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
 driver.findElement(By.xpath("//span[text()='Create Order']")).click();
 String dueDate=row.getCell(12).toString();
 String sub=row.getCell(13).getStringCellValue();
 
 
		  
 driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(dueDate);
 
 driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(sub);
 driver.findElement(By.xpath("//input[@type='text']/following-sibling::button")).click();
 

 Set<String> childHandles = driver.getWindowHandles();

 
for(String handle:childHandles) {	  
 if(!handle.equals(mainHandle)) {		
	   driver.switchTo().window(handle);
	   
	   driver.manage().window().maximize();
	   
	   driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(ContactName); 
 while(true) {
	   try {
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		  
		   driver.findElement(By.xpath("//td[text()='CON00034']/following::button[@class='select-btn']")).click();
		   break;
	   }
	   catch (Exception e) {
		driver.findElement(By.xpath("//button[@id='next-btn']")).click();
	}
	   }
 }
}
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.switchTo().window(mainHandle);
 
 Actions act=new Actions(driver);
 act.scrollByAmount(0, 700).perform();
 
 driver.findElement(By.xpath("//label[text()='Billing Address']/following-sibling::textarea[@name='address']")).sendKeys( billAdd);
 
 driver.findElement(By.xpath("//label[text()='Shipping Address']/following-sibling::textarea[@name='address']")).sendKeys(shipAdd);
 
 driver.findElement(By.xpath("//label[text()='Billing PO Box']/following-sibling::input[@name='poBox']")).sendKeys(billBox);
 
 driver.findElement(By.xpath("//label[text()='Shipping PO Box']/following-sibling::input[@name='poBox']")).sendKeys(shipBox);
 
 driver.findElement(By.xpath("//label[text()='Billing City']/following-sibling::input[@name='city']")).sendKeys(billCity);
 
 driver.findElement(By.xpath("//label[text()='City']/following-sibling::input[@name='city']")).sendKeys(city);
 
 driver.findElement(By.xpath("//label[text()='Billing State']/following-sibling::input[@name='state']")).sendKeys(billState);
 
 driver.findElement(By.xpath("//label[text()='State']/following-sibling::input[@name='state']")).sendKeys(state);
 
 driver.findElement(By.xpath("//label[text()='Billing Postal Code']/following-sibling::input[@name='postalCode']")).sendKeys(billCode);
 
 driver.findElement(By.xpath("//label[text()='Postal Code']/following-sibling::input[@name='postalCode']")).sendKeys(postCode);
 
 driver.findElement(By.xpath("//label[text()='Billing Country']/following-sibling::input[@name='country']")).sendKeys(billCoun);
 
 driver.findElement(By.xpath("//label[text()='Country']/following-sibling::input[@name='country']")).sendKeys(country);
 
 
 driver.findElement(By.xpath("//label[text()='Products']/following::button[@class='action-button']")).click();
 Set<String> childHandles1 = driver.getWindowHandles();
	  
 
 for(String handle1:childHandles1) {	  
	   if(!handle1.equals(mainHandle)) {		
		   driver.switchTo().window(handle1);
		   
		   driver.manage().window().maximize();
		   
		   driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(ContactName); 
	   while(true) {
		   try {
			   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
			  
			   driver.findElement(By.xpath("//td[.='VivoBook24']/following::button[@class='select-btn']")).click();
			   break;
		   }
		   catch (Exception e) {
			driver.findElement(By.xpath("//button[@id='next-btn']")).click();
		}
		   }
	   

 
 }
 

 
}
	driver.switchTo().window(mainHandle)	 ;
	driver.findElement(By.xpath("//button[.='Create Purchase Order']")).click();
	

	 System.out.println("waiting is over");
//	 driver.findElement(By.xpath("//div[text()='Purchase-Order Vivibook Successfully Added']")).click();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 String h=driver.getWindowHandle();
	 driver.switchTo().window(h);
	 
	
	 driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
	 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	 
	 WebElement cnt = driver.findElement(By.xpath("//select[@class='form-control']"));
	 Select s=new Select(cnt);
	 s.selectByVisibleText("Search by Contact Id");

	 driver.findElement(By.xpath("//input[@placeholder='Search by Contact Id']")).sendKeys("CON01093");
	 
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 wd.ImplicitlyWaits(driver);
	driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();
	
	WebElement updateName = driver.findElement(By.xpath("//input[@name='contactName']"));
	
	   act.keyDown(Keys.BACK_SPACE).perform();
	   act.keyUp(Keys.BACK_SPACE).perform();
	   
	   updateName.sendKeys("Harika vemula");
	   
	driver.findElement(By.xpath("//button[.='Update Contact']")).click();
	
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
   
	

	 Thread.sleep(6000);
	 driver.getWindowHandle();
	 driver.switchTo().window(h);
	
	 
	 driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
	 WebElement ele1 = driver.findElement(By.xpath("//select[@class='form-control']"));
	 
	 Select s1=new Select(ele1);
	 s1.selectByVisibleText("Search by Order Id");
	 
	 driver.findElement(By.xpath("//input[@placeholder='Search by Order Id']")).sendKeys("PO00398");
	 
	 wd.ImplicitlyWaits(driver);
	driver.findElement(By.xpath("//i[@class='material-icons' and @title='Edit']")).click();
	
	act.scrollByAmount(0, 400).perform();
	
	driver.findElement(By.xpath("//button[.='Update Purchase Order']")).click();
	 
	 
	
	 
	
	
	 
	 
	 
	}

}
