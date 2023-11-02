package appium.nykaa.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import appium.utils.AndroidBaseTest;
import appium.utils.EnumClass.NykaaSearchBoxPlaceholders;
import appium.utils.EnumClass.NykaaStoresTitle;

public class NykaaStoreSelectorTestcases extends AndroidBaseTest{
	
	
	@Test
	public void store_selector_ui_validations() throws Exception {
		nykaaHomeScreenActions.waitForLandingPageLoaderToDisappear();
		//verify that by default nyka priv store is opened
		Assert.assertEquals(nykaaHomeScreenActions.getSearchBoxPlaceholderText(), NykaaSearchBoxPlaceholders.NYKAA.getOption(), "Verify if user is landed on nykaa store page");
		//click on store selector dropdown
		nykaaHomeScreenActions.clickStoreSelectorDropdown();
		//verify if all the options are displayed
		Assert.assertEquals(nykaaHomeScreenActions.getSelectStoreDropDownTitle("Nykaa"), NykaaStoresTitle.NYKAA.getOption());
		Assert.assertEquals(nykaaHomeScreenActions.getSelectStoreDropDownTitle("Nykaa Luxe"), NykaaStoresTitle.NYKAA_LUXE.getOption());
		Assert.assertEquals(nykaaHomeScreenActions.getSelectStoreDropDownTitle("Nykaa Crossborder"), NykaaStoresTitle.NYKAA_CROSSBORDER.getOption());
		Assert.assertEquals(nykaaHomeScreenActions.getSelectStoreDropDownTitle("Nykaa Pro"), NykaaStoresTitle.NYKAA_PRO.getOption());
		nykaaHomeScreenActions.clickStore("Nykaa Luxe");
		//verify if all the options are displayed
		//click on first store - nykaa luxe
		//verify if user is navigated to nykaa luxe
		//click on second store - nykaa crossborder
		//verify if user is navigated to nykaa crossborder
		//similarly validate for nykaa pro store
	}
}
