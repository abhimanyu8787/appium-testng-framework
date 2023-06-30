package appium.bookmyshow.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidGenericMethods {

    AndroidDriver driver;

    @AndroidFindBy(id = "com.bt.bms:id/subtitle_header_main")
    private WebElement selectedLocation;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']")
    private List<WebElement> recommendedMovies;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recommended Movies']")
    private WebElement recommendedMoviesSection;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"TOP_MOVIES_MOBILE\"]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.FrameLayout")
    private WebElement movieToSelect;

    @AndroidFindBy(id = "com.bt.bms:id/lblProfile")
    private List<WebElement> moviesSection;

    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getSelectedLocation() {
        return getElementText(selectedLocation);
    }

    public void selectMovieFromRecommended() throws Exception {
        Thread.sleep(2000);
        scrollToGivenArea(42, 508, 904, 571);
        Thread.sleep(2000);
        swipeAction(885, 564, 1080, 1303, "left");
        click(movieToSelect);
        Thread.sleep(4000);
    }

    public MoviesPage selectMoviesFromNavBar() throws Exception {
        System.out.println(moviesSection.get(1).getText());
        click(moviesSection.get(1));
        return new MoviesPage(driver);
    }

}
