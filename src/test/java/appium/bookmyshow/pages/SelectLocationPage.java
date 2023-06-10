package appium.bookmyshow.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectLocationPage extends AndroidGenericMethods{
    
    AndroidDriver driver;
    
    @AndroidFindBy(id="com.bt.bms:id/btn_positive")
    private WebElement detectMyLocationButton;
    
    @AndroidFindBy(id="com.bt.bms:id/btn_negative")
    private WebElement selectManuallyButton;
    
    @AndroidFindBy(id="com.bt.bms:id/location_pop_cities_name")
    private List<WebElement> popularCities;
    
    @AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
    private WebElement searchForYourCityField;
    
    @AndroidFindBy(id="com.bt.bms:id/location_popular_image")
    private WebElement matchedResult;
    
    @AndroidFindBy(id="com.bt.bms:id/sub_region_tv_for_label")
    private List<WebElement> regionsList;

    public SelectLocationPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public void clickSelectManually() throws Exception {
        click(selectManuallyButton);
    }
    
    public void selectCityManually(String cityName) throws Exception {
        enterText(searchForYourCityField, cityName);
        click(matchedResult);
    }
    
    public void selectRegionByIndex(int index) throws Exception {
        click(regionsList.get(index));
    }

}
