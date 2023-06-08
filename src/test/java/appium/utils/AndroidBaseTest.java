package appium.utils;

import java.io.IOException;
import java.net.URL;

import org.testng.annotations.BeforeClass;

import appium.pages.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest {
    
    AndroidDriver driver;
    AppiumDriverLocalService service;
    FormPage formPage;
    
    @BeforeClass(alwaysRun=true)
    public void ConfigureAppium() throws IOException {
        String ipAddress = Utility.getGlobalProperties("IpAddress");
        String port = Utility.getGlobalProperties("Port");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(Utility.getGlobalProperties("DeviceName"));
        options.setApp(System.getProperty("user.dir")+"src\\test\\resources\\test-app\\General-Store.apk");
        driver = new AndroidDriver(new URL (Utility.getGlobalProperties("AppiumServiceURL")), options);
        formPage = new FormPage(driver);
    }
    

}
