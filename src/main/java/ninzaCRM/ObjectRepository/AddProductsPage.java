package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductsPage {
	
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement quantity;
	
	@FindBy(xpath="//input[@name='productName']")
	private WebElement productName;
	
	@FindBy(xpath="//input[@name='price']")
	private WebElement pricePU;
	

	

}
