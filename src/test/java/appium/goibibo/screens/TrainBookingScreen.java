package appium.goibibo.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TrainBookingScreen extends CommonScreen{
	
	AndroidDriver driver;
	
	private final By select_station_replace = AppiumBy.xpath("//android.widget.EditText[@text='replace']/following-sibling::android.widget.EditText");
	private final By select_station_field_replace = AppiumBy.xpath("//android.widget.TextView[@text='replace']/following-sibling::*");
	private final By switch_selected_stations_btn = AppiumBy.xpath("//android.widget.EditText[@text='From']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.ImageView");
	private final By select_date_card_replace = AppiumBy.xpath("(//*[@text='Depart']/parent::*/following-sibling::android.widget.HorizontalScrollView/*/*)[replace]");
	private final By select_coach_train_replace = AppiumBy.xpath("//android.widget.TextView[@text='replace1']/following-sibling::android.widget.HorizontalScrollView//android.widget.TextView[@text='replace2']");
	private final By addTraveller_fullname_field = AppiumBy.xpath("//android.widget.TextView[@text='Full name (As per govt. ID)']/parent::*");
	private final By select_gender_radio_button_replace = AppiumBy.xpath("//android.widget.TextView[@text='replace']/parent::*");
	private final By addTraveller_age_field = AppiumBy.xpath("//android.widget.TextView[@text='Age']/preceding-sibling::*");
	private final By first_suggestion_select_station = AppiumBy.xpath("(//android.view.ViewGroup[./child::android.widget.TextView[contains(@text,'replace1')]])[replace2]");
	private final By coach_train_name_number_replace = AppiumBy.xpath("//*[@text='replace1'and ./following-sibling::*[@text='replace2']]/following-sibling::android.widget.HorizontalScrollView//android.view.ViewGroup[./child::*[@text='replace3']]/parent::*");
	
	public TrainBookingScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void searchTrains(String from, String to) throws Exception {
		clickElement(replaceAndCreateCustomLocator(select_station_replace, "From"));
		enterText(replaceAndCreateCustomLocator(select_station_field_replace, "From"), from);
		clickElement(replaceAndCreateCustomLocator(first_suggestion_select_station, from,"1"));
		enterText(replaceAndCreateCustomLocator(select_station_field_replace, "To"), to);
		clickElement(replaceAndCreateCustomLocator(first_suggestion_select_station, to,"1"));
	}
	
	public void selectDateFromDisplayedCard(String cardNumber) throws Exception {
		clickElement(replaceAndCreateCustomLocator(select_date_card_replace, cardNumber));
	}
	
	public ReviewScreen selectTrainAndClass(String trainName, String trainNumber, String coachClass) throws Exception {
		scrollToText(trainName);
		clickElement(replaceAndCreateCustomLocator(coach_train_name_number_replace, trainNumber, trainName, coachClass));
		return new ReviewScreen(driver);
	}
	
}
