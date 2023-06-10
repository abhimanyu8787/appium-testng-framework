package appium.bookmyshow.tests;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import appium.bookmyshow.pages.TermsConditionsPage;
import appium.utils.AndroidBaseTest;

public class Signup_Page_UI_Validations extends AndroidBaseTest{
    
    TermsConditionsPage termsConditionsPage;
    
    @Test
    public void validate_signup_options() throws InterruptedException {
        Assert.assertEquals(signupPage.getGoogleSignUpButtonText(), "Continue with Google");
        Assert.assertEquals(signupPage.getEmailSignUpButtonText(), "Continue with Email");
        Assert.assertEquals(signupPage.getLoginWithMobileFieldText(), "Continue with mobile number");
    }
    
    @Test
    public void validate_terms_conditions() throws Exception {
        termsConditionsPage = signupPage.clickTermsConditions();
        Assert.assertEquals(termsConditionsPage.getTitleDisplayed(), "Terms and Condition");
    }

}
