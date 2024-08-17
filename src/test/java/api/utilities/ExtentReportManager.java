package api.utilities;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
public ExtentSparkReporter sparkReporter; //look and feel of the report
public ExtentReports extent;
public ExtentTest test;

String repName;


	    public void onStart(ITestContext testContext) {
	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time Stamp
	        repName="Test-Report-"+timeStamp+".html";
	        
	        sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName); // specify location of the report
	        
	        sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); //title of the report -- UI of the reports
	        sparkReporter.config().setReportName("Pet Store Users API"); // name of the report
	        sparkReporter.config().setTheme(Theme.DARK);
	        
	        extent=new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Application", "Pet Store Users API");
	        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
	        extent.setSystemInfo("User Name", System.getProperty("user name"));
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("user", "shivani");
	        
	    }
	    public void onTestSuccess(ITestResult result)
	    {
	    	test=extent.createTest(result.getName());
	    	test.assignCategory(result.getMethod().getGroups());
	    	test.createNode(result.getName());
	    	test.log(Status.PASS, "Test Passed"); // listenser concept
	    	  
	    }
	    
	    public void onTestFailure(ITestResult result)
	    {
	    	test=extent.createTest(result.getName());
	    	test.assignCategory(result.getMethod().getGroups());
	    	test.createNode(result.getName());
	    	test.log(Status.FAIL, "Test Passed"); // listenser concept
	    	test.log(Status.FAIL, result.getThrowable().getMessage());  // listenser concept
	    	
	    }
	    
	    public void onTestSkipped(ITestResult result)
	    {
	    	test=extent.createTest(result.getName());
	    	test.createNode(result.getName());
	    	test.assignCategory(result.getMethod().getGroups());
	    	test.log(Status.SKIP, "Test Skipped");   // listenser concept
	    	test.log(Status.SKIP, result.getThrowable().getMessage());  // listenser concept
	   
	    }
	    public void onFinish(ITestContext testContext)
	    {
	    	extent.flush(); // once you created everything we call the flush method -- >> without this the report will not generated
	}


}
