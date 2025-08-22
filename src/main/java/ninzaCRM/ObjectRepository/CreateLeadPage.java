package ninzaCRM.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import firelink.ninzaCRM.GenericUtitlity.WebDriverUtility;

public class CreateLeadPage extends  WebDriverUtility  {
	


		@FindBy(xpath = "//input[@name='name']")
		private WebElement leadName;
		
		@FindBy(xpath = "//input[@name='company']")
		private WebElement company;
		
		@FindBy(xpath = "//input[@name='leadSource']")
		private WebElement leadSource;
		
		@FindBy(xpath = "//input[@name='industry']")
		private WebElement industry;
		
		@FindBy(xpath = "//input[@name='annualRevenue']")
		private WebElement annualRevenue;
		
		@FindBy(xpath = "//input[@name='noOfEmployees']")
		private WebElement noOfEmployees;
		
		@FindBy(xpath = "//input[@name='phone']")
		private WebElement phone;
		
		@FindBy(xpath = "//input[@name='email']")
		private WebElement email;
		
		@FindBy(xpath = "//input[@name='secondaryEmail']")
		private WebElement secondaryEmail;
		
		@FindBy(xpath = "//input[@name='leadStatus']")
		private WebElement leadStatus;
		
		@FindBy(xpath = "//input[@name='rating']")
		private WebElement rating;
		
		@FindBy(xpath = "//input[@name='assignedTo']")
		private WebElement assignedTo;
		
		@FindBy(xpath = "//textarea[@name='address']")
		private WebElement address;
		
		@FindBy(xpath = "//input[@name='city']")
		private WebElement city;
		
		@FindBy(xpath = "//input[@name='country']")
		private WebElement country;
		
		@FindBy(xpath = "//input[@name='postalCode']")
		private WebElement postalCode;
		
		@FindBy(xpath = "//input[@name='website']")
		private WebElement website;
		
		@FindBy(xpath = "//textarea[@name='description']")
		private WebElement description;
		
		@FindBy(xpath = "//*[local-name()='svg' and @data-icon='plus']")
		private WebElement plusIcon;
		
		@FindBy(xpath = "//h3[text()='Select a Campaign']")
		private WebElement selectCampaignText;
		
		@FindBy(xpath = "//select[@id='search-criteria']")
		private WebElement searchBar;
		
		@FindBy(xpath = "//option[text()='Campaign ID']")
		private WebElement searchByCmpId;
		
		@FindBy(xpath = "//option[text()='Campaign Name']")
		private WebElement searchByCmpName;
		
		@FindBy(xpath = "//input[@id='search-input']")
		private WebElement searchTF;
		
		@FindBy(xpath = "//button[text()='Next']")
		private WebElement nextBtn;
		
		public CreateLeadPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getLeadName()
		{
			return leadName;
		}

		public WebElement getCompany()
		{
			return company;
		}

		public WebElement getLeadSource()
		{
			return leadSource;
		}

		public WebElement getIndustry()
		{
			return industry;
		}

		public WebElement getAnnualRevenue()
		{
			return annualRevenue;
		}

		public WebElement getNoOfEmployees()
		{
			return noOfEmployees;
		}

		public WebElement getPhone()
		{
			return phone;
		}

		public WebElement getEmail()
		{
			return email;
		}

		public WebElement getSecondaryEmail()
		{
			return secondaryEmail;
		}

		public WebElement getLeadStatus()
		{
			return leadStatus;
		}

		public WebElement getRating()
		{
			return rating;
		}

		public WebElement getAssignedTo()
		{
			return assignedTo;
		}

		public WebElement getAddress()
		{
			return address;
		}

		public WebElement getCity()
		{
			return city;
		}

		public WebElement getCountry()
		{
			return country;
		}

		public WebElement getPostalCode()
		{
			return postalCode;
		}

		public WebElement getWebsite()
		{
			return website;
		}

		public WebElement getDescription()
		{
			return description;
		}

		public WebElement getPlusIcon()
		{
			return plusIcon;
		}

		public WebElement getSelectCampaignText()
		{
			return selectCampaignText;
		}

		public WebElement getSearchBar()
		{
			return searchBar;
		}

		public WebElement getSearchByCmpId()
		{
			return searchByCmpId;
		}

		public WebElement getSearchByCmpName()
		{
			return searchByCmpName;
		}

		public WebElement getSearchTF()
		{
			return searchTF;
		}

		public WebElement getNextBtn()
		{
			return nextBtn;
		}
		
		
		//Business Library for lead page creation
		
		public void CreatingLeadPage(WebDriver driver,String cmpId,String leadname,String companys,String indus,String leadsrc,String annRev,String noOfEmp,String phn,String emailId,String semail,String leadstat,String rate,String AssTo,String add,String cty,String coun,String postC,String web,String desc) throws InterruptedException {
			
			leadName.sendKeys(leadname);
			company.sendKeys(companys);
			leadSource.sendKeys(leadsrc);
			industry.sendKeys(indus);
			annualRevenue.sendKeys(annRev);
			noOfEmployees.sendKeys(noOfEmp);
			phone.sendKeys(phn);
			email.sendKeys(emailId);
			secondaryEmail.sendKeys(semail);
			leadStatus.sendKeys(leadstat);
			rating.sendKeys(rate);
			assignedTo.sendKeys(AssTo);
			address.sendKeys(add);
			country.sendKeys(coun);
			city.sendKeys(cty);
			postalCode.sendKeys(postC);
			website.sendKeys(web);
			description.sendKeys(desc);
			plusIcon.click();
			switchingToWindowByTitle(driver,"Campaign");
			searchTF.sendKeys(cmpId);
			driver.findElement(By.xpath("//td[.='CAM00010']/following::button[@class='select-btn']")).click();
			Thread.sleep(3000);
			switchingToWindowByTitle(driver,"ninza");
			nextBtn.click();
			
			
		}
		
		

	}


