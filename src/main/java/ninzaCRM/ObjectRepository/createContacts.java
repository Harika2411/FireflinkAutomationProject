package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import firelink.ninzaCRM.GenericUtitlity.WebDriverUtility;

public class createContacts extends WebDriverUtility{
	
	@FindBy(xpath="//input[@name='contactName']")
	private WebElement cntNmae;
	
	@FindBy(xpath="//input[@name='organizationName']")
	private WebElement orgName;
	
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement title;
	
	@FindBy(xpath="//input[@type='text']/following-sibling::button[@type='button']")
	private WebElement plusIcon;
	
	@FindBy(id="search-input")
	private WebElement searchTF;
	
	@FindBy(xpath="//button[.='Create Contact']")
	private WebElement createCntBtn;
	
	public createContacts(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getCntNmae() {
		return cntNmae;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getCreateCntBtn() {
		return createCntBtn;
	}
	
	public void creatingContact(WebDriver driver,String cmpId,String Name,String Org,String mob,String tit) throws InterruptedException {
		cntNmae.sendKeys(Name);
		orgName.sendKeys(Org);
		mobile.sendKeys(mob);
		title.sendKeys(tit);
		plusIcon.click();
		
		SwitchingToWindow(driver);
		Thread.sleep(3000);
		searchTF.sendKeys(cmpId);
		
		driver.findElement(By.xpath("//td[.='"+cmpId+"']/following::button[@class='select-btn']")).click();
		
		switchingToWindowByTitle(driver,"Ninza CRM");
		Thread.sleep(3000);
		scrollByAmountAction(driver, 0, 500);
	
		createCntBtn.click();	
		
		Thread.sleep(6000);
		
		
	}
	
	

}
