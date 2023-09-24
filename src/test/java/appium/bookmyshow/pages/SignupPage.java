package appium.bookmyshow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignupPage extends AndroidGenericMethods{
    
    public AndroidDriver driver;
    
    @AndroidFindBy(id="com.bt.bms:id/social_bt_google")
    private WebElement signInWithGoogleButton;
    
    @AndroidFindBy(id="com.bt.bms:id/email_otp_login_btn")
    private WebElement signInWithEmailButton;
    
    @AndroidFindBy(id="com.bt.bms:id/signup_et_mobileno")
    private WebElement loginWithMobileNumber;
    
    @AndroidFindBy(id="com.bt.bms:id/signup_tv_terms_and_conditions")
    private WebElement termsAndConditions;
    
    @AndroidFindBy(id="com.bt.bms:id/launcher_tv_for_skip")
    private WebElement skipButton;
    
    public SignupPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public String getGoogleSignUpButtonText() {
        return getElementText(signInWithGoogleButton);
    }
    
    public String getEmailSignUpButtonText() {
        return getElementText(signInWithEmailButton);
    }
    
    public String getLoginWithMobileFieldText() {
        return getElementText(loginWithMobileNumber);
    }
    
    public TermsConditionsPage clickTermsConditions() throws Exception {
        clickElement(termsAndConditions);
        Thread.sleep(5000);
        return new TermsConditionsPage(driver);
    }
    
    public SelectLocationPage clickSkipButton() throws Exception {
        clickElement(skipButton);
        return new SelectLocationPage(driver);
    }
    

}
