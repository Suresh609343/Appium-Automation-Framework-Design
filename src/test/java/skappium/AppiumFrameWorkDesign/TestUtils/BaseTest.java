package skappium.AppiumFrameWorkDesign.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import skappium.AppiumFrameWorkDesign.AdnroidActions.AppiumUtils;
import skappium.AppiumFrameWorkDesign.pageObjects.android.FormPage;

public class BaseTest extends AppiumUtils{
	
	public AppiumDriverLocalService service;	
	public AndroidDriver driver;
	public FormPage formPage;
	
	@BeforeClass(alwaysRun = true)
	public void ConfigureClass() throws URISyntaxException, IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		prop.load(fis);
//		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		
		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setApp("C:\\Users\\sures\\Appium\\AppiumFrameWorkDesign\\src\\main\\java\\resources\\General-Store.apk");
		
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);	
	}
	
	@AfterClass
	public void tearDown() {
		
		service.stop();
		driver.quit();
		
	}

}
