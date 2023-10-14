package appium.utils;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import appium.bookmyshow.pages.SignupPage;
import appium.ecommerce.pages.FormPage;
import appium.goibibo.screens.LoginScreen;
import appium.makemytrip.screenactions.HomeScreenActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	public SignupPage signupPage;
	public LoginScreen loginScreen;
	public HomeScreenActions homeScreenActions;

	@BeforeClass(alwaysRun = true)
	public void ConfigureAppium() throws IOException, InterruptedException {
		String ipAddress = Utility.getGlobalProperties("IPAddress");
		String port = Utility.getGlobalProperties("Port");
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(Utility.getGlobalProperties("DeviceName"));
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\test-app\\makemytrip.apk");
		options.setCapability("noReset", true);
		options.setCapability("fullReset", false);
		driver = new AndroidDriver(new URL(Utility.getGlobalProperties("AppiumServiceURL")), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String appName = Utility.getGlobalProperties("App");
		if(appName.equalsIgnoreCase("goibibo")) {
			loginScreen =  new LoginScreen(driver);
		}else if(appName.equalsIgnoreCase("makemytrip")) {
			homeScreenActions = new HomeScreenActions(driver);
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
