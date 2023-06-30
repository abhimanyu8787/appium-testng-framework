package appium.bookmyshow.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MoviesPage extends AndroidGenericMethods{
    
    AndroidDriver driver;
    
    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id='com.bt.bms:id/rvQuickFilters']/android.widget.LinearLayout/android.widget.TextView")
    private List<WebElement> languages;
    
    @AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='listing-mob-1']/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout")
    private List<WebElement> movieList;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Book tickets']")
    private WebElement bookTicketsButton;
    
    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id='com.bt.bms:id/recycler_container_movie_format']/android.widget.Button")
    private List<WebElement> selectMovieFormat;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.bt.bms:id/movie_show_timing_text']/parent::android.view.ViewGroup")
    private List<WebElement> movieTimings;
    
    @AndroidFindBy(id="com.bt.bms:id/select_seats_button_picker")
    private WebElement selectSeatsButton;
    
    public MoviesPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public void selectLanguage(String option) throws Exception {
        System.out.println("Number of languages present " +languages.size());
        for(WebElement element: languages) {
            if(getElementText(element).equalsIgnoreCase(option)) {
                click(element);
                break;
            }
        }
    }
    
    public void selectMovieByIndex(int index) throws Exception {
        Thread.sleep(2000);
        scrollToGivenArea(42, 519, 683, 921);
        System.out.println("Number of elements in movie list: "+ movieList.size());
        click(movieList.get(0));
    }
    
    public void bookTicket(String format, int numberOfTickets) throws Exception {
        click(bookTicketsButton);
        for(WebElement element: selectMovieFormat) {
            if(getElementText(element).contains(format)) {
                click(element);
                break;
            }
        }
        Thread.sleep(2000);
        System.out.println("number of elements in time list "+movieTimings.size());
        click(movieTimings.get(0));
        //select number of seats
        //click(90, 1297);
        click(selectSeatsButton);
        tap(887, 1500);
        Thread.sleep(5000);
        
    }
    
    

}
