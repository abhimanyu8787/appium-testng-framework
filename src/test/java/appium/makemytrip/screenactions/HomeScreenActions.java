package appium.makemytrip.screenactions;

import org.openqa.selenium.NotFoundException;

import appium.makemytrip.exceptions.InvalidBottomNavigationMenuOption;
import appium.makemytrip.exceptions.InvalidHomeScreenSectionName;
import appium.makemytrip.screenobjects.HomeScreenObject;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreenActions extends CommonScreenActions{

	public HomeScreenActions(AndroidDriver driver) {
		super(driver);
	}
	
	HomeScreenObject homeScreen = new HomeScreenObject();
	
	public Object clickMajorCategory(String categoryName) throws Exception {
		clickElement(replaceAndCreateCustomLocator(homeScreen.majorCategory_replace, categoryName));
		switch (categoryName.toUpperCase()) {
		case "TRAINS/BUS":
			return new TrainsBusScreenActions(driver);

		default:
			return null;
		}
	}
	
	public void clickMinorCategory(String categoryName) throws Exception {
		clickElement(replaceAndCreateCustomLocator(homeScreen.minorCategory_replace, categoryName));
	}
	
	public void expandMinorCategory() throws Exception {
		scrollToElement(homeScreen.minorCategory_moreBtn);
		clickElement(homeScreen.minorCategory_moreBtn);
	}
	
	public boolean getIsSectionDisplayed(String sectionName) throws InvalidHomeScreenSectionName {
		boolean isSectionDisplayed = false;
		switch (sectionName.toUpperCase()) {
		case "OFFERS":
			isSectionDisplayed = isElementDisplayed(homeScreen.homeScreen_offersSection);
			break;
		case "DISCOVER":
			isSectionDisplayed = isElementDisplayed(homeScreen.homeScreen_discoverSection);
			break;
		case "EXCLUSIVE PARTNERS":
			isSectionDisplayed = isElementDisplayed(homeScreen.homeScreen_exclusivePartnersSection);
			break;
		case "WHAT'S NEW":
			isSectionDisplayed = isElementDisplayed(homeScreen.homeScreen_whatsNewSection);
			break;
		case "PAY LATER":
			isSectionDisplayed = isElementDisplayed(homeScreen.homeScreen_payLaterSection);
			break;
		default:
			throw new InvalidHomeScreenSectionName(sectionName + "is not a valid section on homescreen");
		}
		return isSectionDisplayed;
	}
	
	public void selectBottomNavigationMenuOption(String option) throws Exception {
		try {
			clickElement(replaceAndCreateCustomLocator(homeScreen.homeScreen_bottom_navMenu_replace, option));
		} catch (NotFoundException e) {
			throw new InvalidBottomNavigationMenuOption(option + "is not found on bottom navigation menu");
		}
	}
	
}
