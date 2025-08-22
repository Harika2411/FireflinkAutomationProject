package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer=firelink.ninzaCRM.GenericUtitlity.RetryAnalyzerImplementation.class)
	public void Sample() {
		Assert.fail();
		System.out.println("failllll");
		
	}

}
