package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import firelink.ninzaCRM.GenericUtitlity.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement searchDropDown;
	
	@FindBy(xpath="//div[@class='col-sm-6']//input[@class='form-control']")
	private WebElement searchTF;
	
	@FindBy(xpath="//span[.='Create Contact']")
	private WebElement createCnt;
	
	String data="abzASDVFBG";
	
	@FindBy(xpath="Contact  Successfully Added")
	private WebElement successMsg;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getCreateCnt() {
		return createCnt;
	}
	
	public WebElement getSuccessMsg() {
		return successMsg;
	}
	
	//BUSINESS LIBRARY
	
	public void createContactClick() {
		createCnt.click();
		
	}
	public void searchLeadDropDown(String text,String info) {
		HandleDropDown(text,searchDropDown);
		searchTF.sendKeys(info);
		
	}
	
	public String succesffulMsg() {
		 return successMsg.getText();
	}

	

	
	

}
