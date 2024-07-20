package skappium.AppiumFrameWorkDesign.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import skappium.AppiumFrameWorkDesign.AdnroidActions.AndroidActions;

public class cartPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public cartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	public WebElement cartButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> prices; 
	
	public double findSum() {
		
		double sum = 0.0; 
		
		int valueSize = prices.size();
		for(int i=0; i<valueSize; i++)
			sum = sum + Double.parseDouble((prices.get(i).getText()).substring(1));
		return sum;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement getSum;
	
	public void getSumDisplayed() {
		getSum.getText();
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsConditions;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement termsConditionsClose;
	
	public void acceptTermsConditions() {
		longClickGesture(termsConditions);
		termsConditionsClose.click();
	}
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;
	
	public void proceed() throws InterruptedException {
		checkBox.click();
		proceedButton.click();
		Thread.sleep(4000);
	}
	
}
