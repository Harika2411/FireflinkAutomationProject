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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateSalesOrderWithMandatoryFields {

	public static void main(String[] args) throws IOException {
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
		  
		  driver.manage().window().maximize();
		  
		  driver.get(Url);
		  
		  String mainHandle=driver.getWindowHandle();	
		  
		  
		  driver.findElement(By.id("username")).sendKeys(UN);
		  driver.findElement(By.id("inputPassword")).sendKeys(Pwd);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  
		  FileInputStream fis=new  FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
		  
			Workbook wb=WorkbookFactory.create(fis);
		    Sheet sh= wb.getSheet("Sheet1");
		    int rowCount = sh.getLastRowNum();
		    String tc="TC_E2E_04";
		    String ContactName="";
		    String organization="";
		    String Mobile="";
		    String title="";
		    String cpgId="";
		    String nextSt="";
		    String opName="";
		    String stage="";
		    String amt="";
		    String btype ="";
		    
		  
		   for(int i=1;i<=rowCount;i++) {
			   String actualTc1="";
		   
			   try 
			   {
			    actualTc1=sh.getRow(i).getCell(0).toString();
			    
			   if(tc.equals(actualTc1))
			   {
				    ContactName=sh.getRow(i).getCell(2).getStringCellValue();
				    System.out.println( ContactName);
			        organization=sh.getRow(i).getCell(3).getStringCellValue();
			        Mobile= sh.getRow(i).getCell(4).toString();
				   title=sh.getRow(i).getCell(5).getStringCellValue();
				   cpgId =sh.getRow(i).getCell(6).getStringCellValue();
				  System.out.println(cpgId);
				  nextSt=sh.getRow(i).getCell(7).getStringCellValue();
				 opName=  sh.getRow(i).getCell(8).getStringCellValue();
				 stage=sh.getRow(i).getCell(9).getStringCellValue();
				amt = sh.getRow(i).getCell(10).toString();
				btype = sh.getRow(i).getCell(11).getStringCellValue();
				
				
			   }
		   }
			   catch(Exception e) 
			   {
				   
			   }
		   }
		   driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		   driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		     driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(ContactName);		  
		  driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organization);
			  
			  driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(Mobile);
			  
			  driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
			  
			  driver.findElement(By.xpath("//input[@type='text']/following-sibling::button[@type='button']")).click();
			  

			  Set<String> childHandles = driver.getWindowHandles();
			   for(String handle:childHandles) {
				   if(!handle.equals(mainHandle)) {
					   driver.switchTo().window(handle);
					   					   driver.manage().window().maximize();
					   
					   driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(cpgId);
					   
					   
				
					   while(true) {
						   try {
//								   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
						   driver.findElement(By.xpath("//td[text()='CAM05313']/following::button[@class='select-btn']")).click();
							   break;
						   }
					   
						  catch(Exception e) {
		                  driver.findElement(By.xpath("//button[@id='next-btn']")).click();
						 
		                          }						   
					                }
					   driver.switchTo().window(mainHandle);
//					   
//					   
//						  
				   driver.findElement(By.xpath("//button[@type='submit']")).submit();			
				   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					 
			   String h=driver.getWindowHandle();
				 driver.switchTo().window(h);
					 driver.findElement(By.xpath("//button[@aria-label='close']")).click();
					 
					 
					 
					 driver.findElement(By.xpath("//a[.='Opportunities']")).click();
					 driver.findElement(By.xpath("//span[.='Create Opportunity']")).click();
					 
					 driver.findElement(By.xpath("//input[@name='nextStep']")).sendKeys(nextSt);
					 
					 driver.findElement(By.xpath("//input[@name='opportunityName']")).sendKeys(opName);
					 driver.findElement(By.xpath("//input[@name='salesStage']")).sendKeys(stage);
					 driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(amt);
					 System.out.println(amt);
					 driver.findElement(By.xpath("//input[@name='businessType']")).sendKeys(btype);
					 driver.findElement(By.xpath("//input[@type='text']/following-sibling::button[@type='button']")).click();
					   Set<String> handle1 = driver.getWindowHandles();
					   for(String handle12:handle1) {	  
						   if(!handle12.equals(mainHandle)) {		
							   driver.switchTo().window(handle12);
							   
							   driver.manage().window().maximize();
					   while(true) {
						   try {
							   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
							  
								 driver.findElement(By.xpath("//td[.='6544544566']/following::button")).click();
							   break;
						   }
						   catch (Exception e) {
							driver.findElement(By.xpath("//button[@id='next-btn']")).click();
						}
						   }
						   }
					   }
						 
					  
						 driver.switchTo().window(h);
					Actions act=new Actions(driver);
					act.scrollByAmount(0, 500).perform();
					 driver.findElement(By.xpath("//button[.='Create Opportunity']")).click();
					   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					  
					 
					 driver.findElement(By.xpath("//a[.='Quotes']")).click();
					 driver.findElement(By.xpath("//span[.='Create Quote']")).click();
						   }
					  
				  
			

					   }
				
			   
		   }
}
