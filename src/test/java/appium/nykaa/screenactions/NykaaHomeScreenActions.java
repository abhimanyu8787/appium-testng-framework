package appium.nykaa.screenactions;

import appium.nykaa.screenobjects.NykaaHomeScreenObject;
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
		waitForElementToAppear(homeScreen.searchbox);
		return getElementText(homeScreen.searchbox);
	}
	
	public void waitForNykaaLogoToBeDisplayed() throws InterruptedException {
		waitForElementToAppear(homeScreen.nykaa_logo);
	}
	
	public NykaaProductListScreenActions searchForProduct(String query) throws Exception {
		clickElement(homeScreen.searchbox);
		enterText(homeScreen.searchField, query);
		pressKey("Search");
		waitForLandingPageLoaderToDisappear();
		waitForNykaaLogoToBeDisplayed();
		return new NykaaProductListScreenActions(driver);
	}
	
	public NykaaShoppingBagScreenActions navigateToShoppingBag() throws Exception {
		clickElement(homeScreen.shoppingBag);
		return new NykaaShoppingBagScreenActions(driver);
	}
	
}
