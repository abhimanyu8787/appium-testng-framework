package appium.bookmyshow.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import appium.bookmyshow.pages.HomePage;
import appium.bookmyshow.pages.SelectLocationPage;
import appium.utils.AndroidBaseTest;

public class Select_Location_Functionality_Validations extends AndroidBaseTest{
    
    public SelectLocationPage selectLocationPage;
    public HomePage homePage;
    
    @Test
    public void validate_select_location_functionality() throws Exception {
        selectLocationPage = signupPage.clickSkipButton();
        selectLocationPage.clickSelectManually();
        selectLocationPage.selectCityManually("Delhi");
        homePage = selectLocationPage.selectRegionByIndex(1);
        Assert.assertEquals(homePage.getSelectedLocation(), "Delhi");
    }

}
