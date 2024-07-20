package skappium.AppiumFrameWorkDesign.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import skappium.AppiumFrameWorkDesign.AdnroidActions.AndroidActions;

public class productCatalogue extends AndroidActions{
	
	AndroidDriver driver;
	
	public productCatalogue(AndroidDriver driver) {
		
//		Here, we used super() because we need to give information to our parent class AndroidActions that what a driver is.
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCart;
	
	public void addToCartAction(int index) {
		
		addToCart.get(index).click();
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement goToCartButton;
	
	public cartPage goToCart() throws InterruptedException {
		goToCartButton.click();
		Thread.sleep(3000);
		return new cartPage(driver);
	}
	
	

}
