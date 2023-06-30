package appium.bookmyshow.tests;

import org.testng.annotations.Test;

import appium.bookmyshow.pages.HomePage;
import appium.bookmyshow.pages.MoviesPage;
import appium.bookmyshow.pages.SelectLocationPage;
import appium.utils.AndroidBaseTest;

public class HomePage_Validations extends AndroidBaseTest{
    
    public SelectLocationPage selectLocationPage;
    public HomePage homePage;
    public MoviesPage moviesPage;
    
    @Test
    public void book_movie_tickets_recommended_section() throws Exception {
        selectLocationPage = signupPage.clickSkipButton();
        selectLocationPage.clickSelectManually();
        selectLocationPage.selectCityManually("Delhi");
        homePage = selectLocationPage.selectRegionByIndex(1);
        homePage.selectMovieFromRecommended();
    }
    
    @Test
    public void book_movie_tickets() throws Exception {
        selectLocationPage = signupPage.clickSkipButton();
        selectLocationPage.clickSelectManually();
        selectLocationPage.selectCityManually("Delhi");
        homePage = selectLocationPage.selectRegionByIndex(1);
        moviesPage = homePage.selectMoviesFromNavBar();
        moviesPage.selectLanguage("English");
        moviesPage.selectMovieByIndex(0);
        moviesPage.bookTicket("IMAX", 2);
        Thread.sleep(5000);
    }

}
