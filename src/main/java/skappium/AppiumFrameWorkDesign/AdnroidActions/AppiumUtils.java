package skappium.AppiumFrameWorkDesign.AdnroidActions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	public AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startAppiumServer(String iPAddress, int port) {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\sures\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(iPAddress).usingPort(port).build();
		service.start();
		return service;
	}
	
	
	public void explictWait(WebElement ele, String current, String next, AppiumDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeToBe(ele , current, next));
	}
	
	public String getScreenshot(String testcaseName, AppiumDriver driver) throws IOException {
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	
	}

}
