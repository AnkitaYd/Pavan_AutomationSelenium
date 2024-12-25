package day46;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//This is utility file and Manage extent file - created by senior people 5year experience
/*#What is use of Listener? - perform post action
#What is post action? - perform post action means after execution completed, based on the result we will perform certain activity or actions this called post actions
#How we implement this post action? - By Listener class method 
Also Post action means generate extend report(customize 3rd party report) like test fail then take screenshot in report - this all implement by TestNG Listener class
After execution we can create report and update the test status 
We maintain one single report and one Listener class throughout project for 100-200TC */

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report- project/module/browser/environment name etc.
	public ExtentTest test; // creating test case entries in the report and update status of the test methods

	public void onStart(ITestContext context) {
			
		//maintain report history by timestamp shown in framework
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");//specify location of the report - here we create reports folder in our project
		
		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter); //attach reporter just combine UI and common info
		
		//actual info during runtime show in framework
		extent.setSystemInfo("Computer Name","localhost"); //setSystemInfo take input as key and pair like Hashmap
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Pavan");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome");				
	}

	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status pass/fail/skip	
	}

	public void onTestFailure(ITestResult result) {
		
 //during fail take SS shown in framework and also instaed showing testmethod will shown testcase class name in report
		test = extent.createTest(result.getName()); //getName return method name
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); //getThrowable return error name 			
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());	
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush(); //flush method mandatory- what we perform should up-to-date in report
	}
}
