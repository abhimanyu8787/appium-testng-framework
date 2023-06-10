package appium.bookmyshow.tests;

import org.testng.annotations.Test;

import appium.bookmyshow.pages.SelectLocationPage;
import appium.utils.AndroidBaseTest;

public class Select_Location_Functionality_Validations extends AndroidBaseTest{
    
    public SelectLocationPage selectLocationPage;
    
    @Test
    public void validate_select_location_functionality() throws Exception {
        selectLocationPage = signupPage.clickSkipButton();
        selectLocationPage.clickSelectManually();
        selectLocationPage.selectCityManually("Delhi");
        selectLocationPage.selectRegionByIndex(1);
        
    }

}
