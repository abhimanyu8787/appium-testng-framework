package appium.goibibo.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import appium.utils.EnumClass.Button;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends CommonScreen {

	AndroidDriver driver;
	
	private final By signupMessage = AppiumBy.id("com.goibibo:id/textView");
	private final By signupLaterBtn = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.goibibo:id/buttonSkip']");
	private final By signupNowBtn = AppiumBy.id("com.goibibo:id/okButton");
	private final By adCloseBtn = AppiumBy.id("com.goibibo:id/close");
	private final By adExpandBtn = AppiumBy.id("com.goibibo:id/expand");
	private final By signupInfoMessage = AppiumBy.id("com.goibibo:id/textView");

	public LoginScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
 
	public String getSignupText() throws Exception {
		return getElementText(signupMessage);
	}

	public HomeScreen continueWithoutSignup() throws Exception {
		waitForElementToDisplay(signupInfoMessage, "10");
		pressKey("Back");
		waitForButtonViaTxt(Button.SIGNUPNOW.getOption());
		clickButtonViaTxt(Button.SIGNUPLATER.getOption());
		return new HomeScreen(driver);
	}

}
