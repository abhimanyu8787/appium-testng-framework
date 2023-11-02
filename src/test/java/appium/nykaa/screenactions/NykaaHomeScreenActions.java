package appium.nykaa.screenactions;

import org.openqa.selenium.By;

import appium.nykaa.screenobjects.NykaaHomeScreenObject;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class NykaaHomeScreenActions extends NykaaCommonScreenActions{
	
	public NykaaHomeScreenActions(AndroidDriver driver) {
		super(driver);
	}
	
	NykaaHomeScreenObject homeScreen = new NykaaHomeScreenObject();
	
	public void clickStoreSelectorDropdown() throws Exception {
		clickElement(homeScreen.store_dropdown);
	}
	
	public void clickWishList() throws Exception {
		clickElement(homeScreen.wishlist_icon);
	}
	
	public String getSearchBoxPlaceholderText() throws Exception {
		return getElementText(homeScreen.searchbox);
	}
	
}
