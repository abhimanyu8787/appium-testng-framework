package appium.goibibo.screens;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ReviewScreen extends CommonScreen{
	
	private final By add_passengers_textfields_replace = AppiumBy.xpath("//android.widget.EditText[./following-sibling::*[contains(@text,'replace')]]");
	private final By add_passengers_dropdown_replace = AppiumBy.xpath("//android.view.ViewGroup[./following-sibling::*[@text='replace']]");
	private final By select_gender_replace = AppiumBy.xpath("//android.view.ViewGroup[./following-sibling::*[@text='replace']]");
	
	public ReviewScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void addPassengerDetails(String fullName, String gender, String age, String nationality, String berthPreference) throws Exception {
		clickElement(replaceAndCreateCustomLocator(add_passengers_textfields_replace, "Full name"));
		enterText(replaceAndCreateCustomLocator(add_passengers_textfields_replace, "Full name"), fullName);
		clickElement(replaceAndCreateCustomLocator(select_gender_replace, gender));
		clickElement(replaceAndCreateCustomLocator(add_passengers_textfields_replace, "Age"));
		enterText(replaceAndCreateCustomLocator(add_passengers_textfields_replace, "Age"), age);
		clickElement(replaceAndCreateCustomLocator(add_passengers_dropdown_replace, "Nationality"));
		scrollToButtonViaTxt(nationality);
		clickButtonViaTxt(nationality);
		clickElement(replaceAndCreateCustomLocator(add_passengers_dropdown_replace, "Berth Preference"));
		scrollToButtonViaTxt(berthPreference);
		clickButtonViaTxt(berthPreference);
	}

}
