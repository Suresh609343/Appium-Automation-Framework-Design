package skappium.AppiumFrameWorkDesign;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import skappium.AppiumFrameWorkDesign.TestUtils.BaseTest;
import skappium.AppiumFrameWorkDesign.pageObjects.android.cartPage;
import skappium.AppiumFrameWorkDesign.pageObjects.android.productCatalogue;

public class eCommerce_tc_3_Hybrid extends BaseTest{
	
	@Test(dataProvider="getData", groups="Smoke")
	public void FilForm(String name, String gender, String country) throws InterruptedException {
		
		
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountry(country);
		
		productCatalogue produccatelouge = formPage.letsShopButton();
		produccatelouge.addToCartAction(0);
		
		cartPage cartpage = produccatelouge.goToCart();
		cartpage.explictWait(cartpage.cartButton, "text", "Cart", driver);
		
		cartpage.findSum();
		cartpage.getSumDisplayed();
		cartpage.acceptTermsConditions();
		cartpage.proceed();
		
		Set<String> contexts = driver.getContextHandles();
		for(String context : contexts) {
			
			System.out.println(context);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void preSetup() {
		formPage.setActivity();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		return new Object[][] { {"Kalpana","Female","Austria"},{"Vinay","Male","Austria"} };
	}
	
	
}
