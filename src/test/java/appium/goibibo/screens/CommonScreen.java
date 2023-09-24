package appium.goibibo.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonScreen extends AndroidGenericMethods{

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

}
