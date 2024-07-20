package skappium.AppiumFrameWorkDesign.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject() {
		
		String File = System.getProperty("user.dir")+"\\reports\\ExtentReportResult.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(File);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test Runner", "Suresh Kumar");
		return extent;
		
	}

}
