package ninzaCRM.ObjectRepository;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage
	{
		@FindBy(id = "username")
		private WebElement usernameTF;
		
		@FindBy(name = "password")
		private WebElement passwordTF;
		
		@FindBy(xpath = "//button[text()='Sign In']")
		private WebElement signInBtn;
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getUsernameTF()
		{
			return usernameTF;
		}

		public WebElement getPasswordTF()
		{
			return passwordTF;
		}

		public WebElement getSignInBtn()
		{
			return signInBtn;
		}
		
		
		//Business Library
		
		
		public void LoginToApp(String username,String password) {
			usernameTF.sendKeys(username);
			passwordTF.sendKeys(password);
			signInBtn.click();
			
		}

	}


