package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import firelink.ninzaCRM.GenericUtitlity.WebDriverUtility;

public class ProductsPage extends WebDriverUtility {
	


	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement createProduct;
	
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement searchDropdown;
	
	
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchTF;
	
	
	
	public  ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}



	public WebElement getCreateProduct() {
		return createProduct;
	}



	public WebElement getSearchDropdown() {
		return searchDropdown;
	}



	public WebElement getSearchTF() {
		return SearchTF;
	}
	
	public void searchProductByDropDown(String text,String info) {
		HandleDropDown(text,searchDropdown);
		 SearchTF.sendKeys(info);
		
		
	}
	
	public void addProductClick() {
		createProduct.click();
		
	}
	




	
	

}
