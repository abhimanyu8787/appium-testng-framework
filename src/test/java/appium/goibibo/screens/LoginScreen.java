package appium.goibibo.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends AndroidGenericMethods {

	AndroidDriver driver;
	@AndroidFindBy(id="com.goibibo:id/textView")
	private WebElement signupMessage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.goibibo:id/buttonSkip']")
	private WebElement signupLaterBtn;
	@AndroidFindBy(id = "com.goibibo:id/okButton")
	private WebElement signupNowBtn;
	@AndroidFindBy(id = "com.goibibo:id/close")
	private WebElement adCloseBtn;
	@AndroidFindBy(id = "com.goibibo:id/expand")
	private WebElement adExpandBtn;
	
	private final By adExpandBtn2 = AppiumBy.id("com.goibibo:id/expand");

	public LoginScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public String getSignupText() {
		return getElementText(signupMessage);
	}

	public HomeScreen continueWithoutSignup() throws Exception {
		Thread.sleep(2000);
		pressKey("Back");
		Thread.sleep(2000);
		// By locator = MobileBy.AndroidUIAutomator("new UiSelector().text(\"DO IT
		// LATER\")");
		By buttonLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"DO IT LATER\")");
		driver.findElement(buttonLocator).click();
		return new HomeScreen(driver);
	}

}
