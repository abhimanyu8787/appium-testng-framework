package appium.goibibo.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends AndroidGenericMethods{
	
	AndroidDriver driver;
	
	@AndroidFindBy(accessibility = "hotels")
	private WebElement hotelsBooking;
	@AndroidFindBy(accessibility = "flights")
	private WebElement flightsBooking;
	@AndroidFindBy(accessibility = "trains")
	private WebElement trainBooking;
	@AndroidFindBy(accessibility = "bus")
	private WebElement busBooking;

	public HomeScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public TrainBookingScreen selectCategoryTrain() throws Exception {
		click(trainBooking);
		return new TrainBookingScreen(driver);
	}

}
