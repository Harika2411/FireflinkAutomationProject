package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sampleTest() {
		System.out.println("step1");
		System.out.println("step2");
		
		Assert.assertEquals(1, 1);
		
		System.out.println("step3");
		Assert.assertEquals(0, 1);
		System.out.println("step4");
		
		
	}
	
	@Test
	public void sampleTestSoft() {
		
		SoftAssert sa=new SoftAssert(); 
		System.out.println("step1");
		System.out.println("step2");
		
		sa.assertEquals(1, 1);
		
		System.out.println("step3");
		
		sa.assertEquals(0, 1);
		System.out.println("step4");
		sa.assertAll();
		
		
	}

}
