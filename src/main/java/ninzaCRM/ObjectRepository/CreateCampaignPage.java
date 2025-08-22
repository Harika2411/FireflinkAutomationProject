package ninzaCRM.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	

		@FindBy(xpath = "//input[@name='campaignName']")
		private WebElement campaignName;
		
		@FindBy(xpath = "//input[@name='campaignStatus']")
		private WebElement campaignStatus;
		
		@FindBy(xpath = "//input[@name='targetSize']")
		private WebElement targetSize;
		
		@FindBy(xpath = "//input[@name='expectedCloseDate']")
		private WebElement expectedCloseDate;
		
		@FindBy(xpath = "//input[@name='targetAudience']")
		private WebElement targetAudience;
		
		@FindBy(xpath = "//textarea[@name='description']")
		private WebElement description;
		
		@FindBy(xpath = "//button[text()='Create Campaign']")
		private WebElement createCampaign;
		
		public CreateCampaignPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getCampaignName()
		{
			return campaignName;
		}

		public WebElement getCampaignStatus()
		{
			return campaignStatus;
		}

		public WebElement getTargetSize()
		{
			return targetSize;
		}

		public WebElement getExpectedCloseDate()
		{
			return 
					expectedCloseDate;
		}

		public WebElement getTargetAudience()
		{
			return targetAudience;
		}

		public WebElement getDescription()
		{
			return description;
		}

		public WebElement getCreateCampaign()
		{
			return createCampaign;
		}
		/**
		 * This method is for creating campaigning by entering the fields 
		 * @param cmgName
		 * @param cmgStatus
		 * @param trgtSize
		 * @param closedate
		 * @param tgtAud
		 * @param desc
		 * @throws InterruptedException 
		 */
		public void creatingCampaign(String cmgName,String cmgStatus,String trgtSize,String closedate,String tgtAud,String desc) throws InterruptedException {
			
			campaignName.sendKeys(cmgName);
			campaignStatus.sendKeys(cmgStatus);
			targetSize.clear();
			targetSize.sendKeys(trgtSize);
			expectedCloseDate.sendKeys(closedate);
			targetAudience.sendKeys(tgtAud);
			description.sendKeys(desc);
		    createCampaign.click();
		    Thread.sleep(6000);
				
		}
		
		
		

	

}
