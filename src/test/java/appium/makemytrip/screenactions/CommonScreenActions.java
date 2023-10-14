package appium.makemytrip.screenactions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import appium.makemytrip.screenobjects.CommonScreenObject;
import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonScreenActions extends AndroidGenericMethods{
	
	public CommonScreenActions(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	CommonScreenObject commonScreen = new CommonScreenObject();
	
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
		waitForElementToClick(replaceAndCreateCustomLocator(commonScreen.common_button_replace, txt), "10");
	}
	
	public void clickButtonViaTxt(String txt) throws Exception {
		waitForElementToClick(replaceAndCreateCustomLocator(commonScreen.common_button_replace, txt), "10");
		clickElement(replaceAndCreateCustomLocator(commonScreen.common_button_replace, txt));
	}
	
	public void scrollToButtonViaTxt(String txt) throws Exception {
		scrollToElement(replaceAndCreateCustomLocator(commonScreen.common_button_replace, txt));
	}
	
	public void waitForTextView(String txt) throws Exception {
		waitForElementToClick(replaceAndCreateCustomLocator(commonScreen.common_textview_replace, txt), "10");
	}
	
	public void clickTextView(String txt) throws Exception {
		waitForElementToClick(replaceAndCreateCustomLocator(commonScreen.common_textview_replace, txt), "10");
		clickElement(replaceAndCreateCustomLocator(commonScreen.common_textview_replace, txt));
	}
	
	public void scrollToTextView(String txt) throws Exception {
		scrollToElement(replaceAndCreateCustomLocator(commonScreen.common_textview_replace, txt));
	}
	
	public void waitForProgressBarToDisappear() {
		waitForAllElementsToDisappear(commonScreen.common_progressbar);
	}
}
