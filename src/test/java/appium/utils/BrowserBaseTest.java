package appium.utils;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BrowserBaseTest {
    
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    
	@BeforeClass(alwaysRun = true)
	public void ConfigureAppium() throws IOException, InterruptedException {
		String ipAddress = Utility.getGlobalProperties("IPAddress");
		String port = Utility.getGlobalProperties("Port");
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(Utility.getGlobalProperties("DeviceName"));
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\test-app\\goibibo.apk");
		options.setChromedriverExecutable(System.getProperty("user.dir")+ "\\src\\test\\resources\\test-browserdrivers\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL(Utility.getGlobalProperties("AppiumServiceURL")), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = Utility.getGlobalProperties("App");
		driver.get(url);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
