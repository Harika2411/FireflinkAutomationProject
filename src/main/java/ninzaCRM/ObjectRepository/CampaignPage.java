package ninzaCRM.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import firelink.ninzaCRM.GenericUtitlity.WebDriverUtility;

public class CampaignPage extends WebDriverUtility {

		@FindBy(xpath = "//span[text()='Create Campaign']")
		private WebElement createCampaign;
		
		
		@FindBy(xpath = "//select[@class='form-control']")
		private WebElement searchDropdown;
		
		
		
		@FindBy(xpath="//input[@class='form-control']")
		private WebElement SearchTF;
		
		//String data="tyfgcv";
		
		@FindBy(xpath = "//div[text()='Campaign   Successfully Added']")
		private WebElement succesfulMsg;
		
		public CampaignPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getCreateCampaign()
		{
			return createCampaign;
		}

		public WebElement getSearchDropdown()
		{
			
			return searchDropdown;
		}

		

		public WebElement getSuccesfulMsg()
		{
			return succesfulMsg;
		}

	
		
		//Business Library for campaign page
		//for selecting drop down and search the campaign
		/**
		 * This method is for handle drop down for searching campaign
		 * @param text
		 * @param info
		 */
		
		public void SearchCampaignDropDown(String text,String info) {
			HandleDropDown(text,searchDropdown);
			SearchTF.sendKeys(info);
			
		
		
		}
		/**
		 * This method is clicking on create campaign
		 */
		public void createCampaignClick() {
			createCampaign.click();
		}
		/**
		 * getting successful msg for campaign
		 * @return
		 */
		
		public  String gettingSuccessMsg() {
			 return succesfulMsg.getText();
			
		}
		
		

	}


