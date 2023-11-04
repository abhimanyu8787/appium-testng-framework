package appium.goibibo.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonScreen extends AndroidGenericMethods{
	
	private final By btn_replace = AppiumBy.xpath("//android.widget.TextView[@text='replace']");
	private final By progress_loader = AppiumBy.xpath("//android.widget.ProgressBar");
	
	public CommonScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public By replaceAndCreateCustomLocator(By locator, String replacer){
		String str=locator.toString().replace("replace", replacer);
		return By.xpath(str.split("By.xpath:")[1].trim());
	}
	
	public By replaceAndCreateCustomLocator(By locator, String replacer1, String replacer2){
		String str=locator.toString().replace("replace1", replacer1).replace("replace2", replacer2);
		return By.xpath(str.split("By.xpath:")[1].trim());
	}
	
	public By replaceAndCreateCustomLocator(By locator, String replacer1, String replacer2, String replacer3){
		String str=locator.toString().replace("replace1", replacer1).replace("replace2", replacer2).replace("replace3", replacer3);
		return By.xpath(str.split("By.xpath:")[1].trim());
	}
	
	public void waitForButtonViaTxt(String txt) throws Exception {
		waitForElementToClick(replaceAndCreateCustomLocator(btn_replace, txt), "10");
	}
	
	public void clickButtonViaTxt(String txt) throws Exception {
		waitForElementToClick(replaceAndCreateCustomLocator(btn_replace, txt), "10");
		clickElement(replaceAndCreateCustomLocator(btn_replace, txt));
	}
	
	public void scrollToButtonViaTxt(String txt) throws Exception {
		scrollToElementUsingTouchAction(replaceAndCreateCustomLocator(btn_replace, txt));
	}
	
	public void waitForLoaderToDisappear() {
		waitForAllElementsToDisappear(progress_loader);
	}
	
	public boolean getIsButtonViaTxtDisplayed(String txt) {
		return isElementDisplayed(replaceAndCreateCustomLocator(btn_replace, txt));
	}

}
