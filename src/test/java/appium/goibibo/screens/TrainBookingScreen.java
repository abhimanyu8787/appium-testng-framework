package appium.goibibo.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import appium.utils.AndroidGenericMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TrainBookingScreen extends CommonScreen{
	
	AndroidDriver driver;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='From']")
	private WebElement fromStation;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='To']")
	private WebElement toStation;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter city, station name or code']")
	private WebElement selectStation;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")
	private WebElement stationSearchResult;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='11 Jul']")
	private WebElement journeyDate;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SEARCH']")
	private WebElement searchBtn;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"+ Add Traveller\")")
	private WebElement addPassengerBtn;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Full name (As per govt. ID)\")")
	private WebElement fullNameField;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Age\")")
	private WebElement ageField;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Berth Preference\")")
	private WebElement berthPreference;
	
	private final By select_station_replace = AppiumBy.xpath("//android.widget.EditText[@text='replace']/following-sibling::android.widget.EditText");
	private final By select_station_field_replace = AppiumBy.xpath("//android.widget.TextView[@text='replace']/following-sibling::*");
	private final By switch_selected_stations_btn = AppiumBy.xpath("//android.widget.EditText[@text='From']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.ImageView");
	private final By select_date_card_replace = AppiumBy.xpath("(//*[@text='Depart']/parent::*/following-sibling::android.widget.HorizontalScrollView/*/*)[replace]");
	private final By select_coach_train_replace = AppiumBy.xpath("//android.widget.TextView[@text='replace1']/following-sibling::android.widget.HorizontalScrollView//android.widget.TextView[@text='replace2']");
	private final By addTraveller_fullname_field = AppiumBy.xpath("//android.widget.TextView[@text='Full name (As per govt. ID)']/parent::*");
	private final By select_gender_radio_button_replace = AppiumBy.xpath("//android.widget.TextView[@text='replace']/parent::*");
	private final By addTraveller_age_field = AppiumBy.xpath("//android.widget.TextView[@text='Age']/preceding-sibling::*");
	
	public TrainBookingScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void searchTrains(String from, String to) throws Exception {
		waitForButtonViaTxt("Trains");
		clickElement(replaceAndCreateCustomLocator(select_station_replace, "From"));
		enterText(replaceAndCreateCustomLocator(select_station_field_replace, "From"), "Gwalior");
	}
	
	public void selectTrainAndClass(String coachClass) {
		scrollToText(coachClass);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"AVL 25\")")).click();
		addPassengerBtn.click();
	}
	
	public void addTravellerDetails(String fullName, String gender, String age, String berthPreferences) {
		enterText(fullNameField, fullName);
		enterText(ageField, age);
	}
	
	

}
