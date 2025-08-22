package ninzaCRM.Products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import firelink.ninzaCRM.GenericUtitlity.BaseClass;
import ninzaCRM.ObjectRepository.DashBoardPage;
import ninzaCRM.ObjectRepository.ProductsPage;
import ninzaCRM.ObjectRepository.createContacts;

public class CreateProductssTest extends  BaseClass{
	
	@Test
	public void TC_E2E_01_createProductTest() throws EncryptedDocumentException, IOException {
		
		 String QUANTITY=fUtil.readDataFromExcel("Sheet1",1,7);
	  	  String PRODUCTNAME=fUtil.readDataFromExcel("Sheet1",1,8);
	  	  String PRICEPU=fUtil.readDataFromExcel("Sheet1",1,9);
		  String CATEGORY =fUtil.readDataFromExcel("Sheet1",1,10);
		  String VENDOR= fUtil.readDataFromExcel("Sheet1",1,11);
		  
		  DashBoardPage db=new DashBoardPage(driver);
	 	  db.ProductsClick();
	 	  
	 	 ProductsPage cp=new ProductsPage(driver);
	 	 cp.addProductClick();
	 	 
		  createContacts cc=new createContacts(driver);
		  cc.creatingContact(driver, CMGID, CONTACTNAME, ORG, MOBILE, TITLE);
	}

}
