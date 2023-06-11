package appium.bookmyshow.tests;

import org.testng.annotations.Test;

import appium.bookmyshow.pages.HomePage;
import appium.bookmyshow.pages.SelectLocationPage;
import appium.utils.AndroidBaseTest;

public class HomePage_Validations extends AndroidBaseTest{
    
    public SelectLocationPage selectLocationPage;
    public HomePage homePage;
    
    @Test
    public void book_movie_tickets_recommended_section() throws Exception {
        selectLocationPage = signupPage.clickSkipButton();
        selectLocationPage.clickSelectManually();
        selectLocationPage.selectCityManually("Delhi");
        homePage = selectLocationPage.selectRegionByIndex(1);
        homePage.selectMovieFromRecommended();
    }

}
