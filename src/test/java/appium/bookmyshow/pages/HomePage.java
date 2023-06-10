package appium.bookmyshow.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidGenericMethods{
    
    AndroidDriver driver;
    
    @AndroidFindBy(id="com.bt.bms:id/subtitle_header_main")
    private WebElement selectedLocation;
    
    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public String getSelectedLocation() {
        return getElementText(selectedLocation);
    }

}
