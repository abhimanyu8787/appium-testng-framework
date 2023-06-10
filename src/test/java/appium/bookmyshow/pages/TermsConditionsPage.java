package appium.bookmyshow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TermsConditionsPage extends AndroidGenericMethods{
    
    AndroidDriver driver;
    
    @AndroidFindBy(xpath="(//android.webkit.WebView/android.view.View)[1]")
    private WebElement titleDisplayed;
    
    public TermsConditionsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public String getTitleDisplayed() {
        return getElementText(titleDisplayed);
    }

}
