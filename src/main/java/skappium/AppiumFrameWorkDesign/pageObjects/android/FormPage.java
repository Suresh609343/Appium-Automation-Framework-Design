package skappium.AppiumFrameWorkDesign.pageObjects.android;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import skappium.AppiumFrameWorkDesign.AdnroidActions.AndroidActions;

public class FormPage extends AndroidActions{
	
//	Now, to create driver and to get the access of the original driver, 1st we need to build Constructor.
//	Constructor is something which will be called automatically when you create object of that class.
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		
//		Here, we used super() because we need to give information to our parent class AndroidActions that what a driver is.
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	This is to create a seperate variable to store the WebElement
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	
//	This is the action class for the nameField.
	public void setNameField(String name) {
		
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
//	This is the action class to select the gender
	public void setGender(String gender) {
		
		if(gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement country;
	
//	This is a class to scroll that particular country and select it.
	public void setCountry(String countryName) {
		
		country.click();
		scrollTotext(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();

	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShop;
	
	public productCatalogue letsShopButton() {
		letsShop.click();
		return new productCatalogue(driver);
	}
	
	public void setActivity() {
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				"intent" ,"com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"
			));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
}
