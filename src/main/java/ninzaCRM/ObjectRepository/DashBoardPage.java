package ninzaCRM.ObjectRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class DashBoardPage
	{
		
		
		@FindBy(xpath = "//a[text()='Campaigns']")
		private WebElement campaignsLink;
		
		@FindBy(xpath = "//a[text()='Contacts']")
		private WebElement contactsLink;
		
		@FindBy(xpath = "//a[text()='Leads']")
		private WebElement leadsLink;
		
		@FindBy(xpath = "//a[text()='Opportunities']")
		private WebElement opportunitiesLink;
		
		@FindBy(xpath = "//a[text()='Products']")
		private WebElement productsLink;
		
		@FindBy(xpath = "//a[text()='Quotes']")
		private WebElement quotesLink;
		
		@FindBy(xpath = "//a[text()='Purchase Order']")
		private WebElement purchaseOrderLink;
		
		@FindBy(xpath = "//a[text()='Sales Order']")
		private WebElement salesOrderLink;
		
		@FindBy(xpath = "//a[text()='Invoice']")
		private WebElement invoice;
		
		@FindBy(xpath = "//li[text()='Admin Console']")
		private WebElement adminConsole;
		
		@FindBy(xpath = "//div[@class='user-icon']")
		private WebElement userIcon;
		
		@FindBy(xpath = "//div[text()='Logout ']")
		private WebElement logoutBtn;
		
		public DashBoardPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		/**
		 * creating business library for all the links present in dashboard for campaign,leads,products,opportunities,
		 * contacts,quotes,purchase order,salesorder,invoice,logout,usericon
		 * @return
		 */

		public WebElement getCampaignsLink()
		{
			return campaignsLink;
		}

		public WebElement getContactsLink()
		{
			return contactsLink;
		}

		public WebElement getLeadsLink()
		{
			return leadsLink;
		}

		public WebElement getOpportunitiesLink()
		{
			return opportunitiesLink;
		}

		public WebElement getProductsLink()
		{
			return productsLink;
		}

		public WebElement getQuotesLink()
		{
			return quotesLink;
		}

		public WebElement getPurchaseOrderLink()

		{
			return purchaseOrderLink;
		}

		public WebElement getSalesOrderLink()
		{
			return salesOrderLink;
		}

		public WebElement getInvoice()
		{
			return invoice;
		}

		public WebElement getAdminConsole()
		{
			return adminConsole;
		}

		public WebElement getUserIcon()
		{
			return userIcon;
		}

		public WebElement getLogoutBtn()
		{
			return logoutBtn;
		}
		
		
		//BUSINESS LIBRARY FOR DASHBOARD
		
		public void CampaignClick() {
			campaignsLink.click();
			
		}
		
		public void contactsClick() {
			contactsLink.click();
			
		}
		
		public void leadsClick() { 
			leadsLink.click();
		}
		
		public void opportunityClick() {
			opportunitiesLink.click();
		}
		
		public void ProductsClick() {
			productsLink.click();
		}
		
		public void quotesClick() {
			quotesLink.click();
		}
		
		public void PurchaseOrderClick() { 
			purchaseOrderLink.click();
		}
		
		public void salesOrderClick() {
			salesOrderLink.click();
		}
		
		public void invoiceClick() {
			invoice.click();
		}
		public void adminConsoleClick() {
			adminConsole.click();
		}
		
		public void UserIconClick() {
			userIcon.click();
		}
		public void logoutClick() {
			logoutBtn.click();
		}
		
		
		
		

	}


