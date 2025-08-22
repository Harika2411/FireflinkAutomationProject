package Practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(invocationCount =2,priority=-2,dataProvider="getInfo")
	public void create(String name,int number) {
		//Assert.fail();
		System.out.println(name+" and "+number+"created");
	}
	
	@Test(priority= 2,enabled=true)
	public void update() {
		System.out.println("update");
	}
	
	@Test(dependsOnMethods="create",priority=3)  //enabled=false
	public void delete() {
		System.out.println("Delete");
	}
	
	@DataProvider()
		public Object[][] getInfo(){
			
		Object[][] data=new Object[3][2];
		
		data[0][0]="Harika";
		data[0][1]=1;
		
		data[1][0]="Preethi";
		data[1][1]=2;
		
		data[2][0]="Anusha";
		data[2][1]=3;
		return data;
		
		
	}

	
	
}
	
		
	
	
	


