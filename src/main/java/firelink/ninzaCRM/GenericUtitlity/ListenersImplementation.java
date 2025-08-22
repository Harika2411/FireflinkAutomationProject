package firelink.ninzaCRM.GenericUtitlity;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenersImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
	
		System.out.println(MethodName+" SUITE EXECUTION STARTED------");
		
		//Intimate extent reports for @Test start
		
		 test = report.createTest(MethodName); //returns ExtentTest class
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		
		System.out.println(MethodName+" SUITE EXECUTION SUCCESFULL------");
		
		//Log the status as @Test as PASS 
		test.log(Status.PASS,MethodName+" -----Test Execution is PASS----");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		
		
		
		System.out.println(MethodName+" SUITE EXECUTION FAILED------");
		
		//capture exception
		System.out.println(result.getThrowable());
		
		//log the exception in extent reports
		
		test.log(Status.WARNING,MethodName+" -----Test Execution is giving WARNING----");
		
		//capture the screenshot
		JavaUtility j=new JavaUtility();
		WebDriverUtility w=new 	WebDriverUtility();
		
		
		//ScreenShotname
		String screenshotname=MethodName+j.GenerateDate();
		try {
			
			String path=w.captureScreenShot(BaseClass.sdriver, screenshotname);
			
			
			//ATTACH SCREENSHOT TO REPORT
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//LOg the status  as fail in report
		test.log(Status.FAIL,MethodName+" -----Test Execution is FAIL----");
		
				
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		
		System.out.println(MethodName+" SUITE EXECUTION SKIPPED------");
		
		System.out.println(result.getThrowable());
		
		//log the exception
		test.log(Status.WARNING, MethodName);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	System.out.println("SUITE STARTED ");
	
	//Extent report configution
	
	ExtentSparkReporter er=new ExtentSparkReporter(".\\ExtentReport\\Extent-Report-"+new JavaUtility().GenerateDate()+".html");
	er.config().setDocumentTitle("Ninza CRM Automation Report");
	er.config().setTheme(Theme.DARK);
	er.config().setReportName("Web Automation Execution Report");
	
	 report =new  ExtentReports();
	report.attachReporter(er);
	report.setSystemInfo("Base Browser","Microsoft Edge");
	report.setSystemInfo("Base Platform"," Windows");
	report.setSystemInfo("Base URL", "Test Env");
	report.setSystemInfo("Reporter Name", "Harika");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("SUITE EXECUTION FINISHED");
		
		//Report generation
		report.flush();  //it specifies that execution is completed  now it need to generate report
		
	}
	
	
	
	
	
	

}
