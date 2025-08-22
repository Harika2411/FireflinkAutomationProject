package firelink.ninzaCRM.GenericUtitlity;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {
	
	int count=0;
	int retryCount=3; //manual analysis //IF TEST SCRIPT IS FAILED
	
	
	public boolean retry(ITestResult result) {
		
		while(count<retryCount) {
			count++;
			return true;  //retry for three times
		}
		return false;//stop retry
		
	}
	
	

}
