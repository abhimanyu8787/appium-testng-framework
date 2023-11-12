package appium.nykaa.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import appium.nykaa.screenactions.NykaaProStoreScreenActions;
import appium.utils.AndroidBaseTest;
import appium.utils.EnumClass.NykaaSearchBoxPlaceholders;
import appium.utils.EnumClass.NykaaStoresTitle;

public class NykaaStoreSelectorTestcases extends AndroidBaseTest{
	
	public NykaaProStoreScreenActions nykaaProStore;
	
	@Test
	public void store_selector_ui_validations() throws Exception {
		nykaaHomeScreenActions.waitForLandingPageLoaderToDisappear();
		Assert.assertEquals(nykaaHomeScreenActions.getSearchBoxPlaceholderText(), NykaaSearchBoxPlaceholders.NYKAA.getOption(), "Verify if user is landed on nykaa store page");
		nykaaHomeScreenActions.clickStoreSelectorDropdown();
		Assert.assertEquals(nykaaHomeScreenActions.getNykaProStoreHeadline(), NykaaStoresTitle.STORE_SELECTOR_TITLE.getOption(), "Verify if store selector title is displayed in dropdown");
		Assert.assertEquals(nykaaHomeScreenActions.getSelectStoreDropDownTitle("Nykaa"), NykaaStoresTitle.NYKAA.getOption());
		Assert.assertEquals(nykaaHomeScreenActions.getSelectStoreDropDownTitle("Nykaa Luxe"), NykaaStoresTitle.NYKAA_LUXE.getOption());
		Assert.assertEquals(nykaaHomeScreenActions.getSelectStoreDropDownTitle("Nykaa Crossborder"), NykaaStoresTitle.NYKAA_CROSSBORDER.getOption());
		Assert.assertEquals(nykaaHomeScreenActions.getSelectStoreDropDownTitle("Nykaa Pro"), NykaaStoresTitle.NYKAA_PRO.getOption());
		nykaaHomeScreenActions.clickStore("Nykaa Luxe");
		Assert.assertEquals(nykaaHomeScreenActions.getSearchBoxPlaceholderText(), NykaaSearchBoxPlaceholders.NYKAA_LUXE.getOption(), "Verify if user is landed on nykaa luxe store page");
		nykaaHomeScreenActions.clickStoreSelectorDropdown();
		nykaaHomeScreenActions.clickStore("Nykaa Crossborder");
		Assert.assertEquals(nykaaHomeScreenActions.getSearchBoxPlaceholderText(), NykaaSearchBoxPlaceholders.NYKAA_CROSSBORDER.getOption(), "Verify if user is landed on nykaa crossborder store page");
		nykaaHomeScreenActions.clickStoreSelectorDropdown();
		nykaaProStore = nykaaHomeScreenActions.navigateToNykaProStore();
		Assert.assertTrue(nykaaProStore.getIsApplyStepsTitleDisplayed(), "Verify that steps to apply for pro account are displayed");
		nykaaHomeScreenActions = nykaaProStore.clickBackButtonNavigateToHome();
	}
	
	@Test
	public void nykaa_pro_store_ui_validations() throws Exception {
		nykaaHomeScreenActions.waitForLandingPageLoaderToDisappear();
		Assert.assertEquals(nykaaHomeScreenActions.getSearchBoxPlaceholderText(), NykaaSearchBoxPlaceholders.NYKAA.getOption(), "Verify if user is landed on nykaa store page");
		nykaaHomeScreenActions.clickStoreSelectorDropdown();
		nykaaProStore = nykaaHomeScreenActions.navigateToNykaProStore();
		nykaaProStore.waitForLandingPageLoaderToDisappear();
		Assert.assertTrue(nykaaProStore.getIsExclusiveOfferTitleDisplayed(), "Verify if exclusive offer section is displayed");
		Assert.assertTrue(nykaaProStore.getIsProAdvantageSectionDisplayed(), "Verify if advantages of pro account is displayed");
		nykaaProStore.clickViewAcceptableProofs();
		Assert.assertTrue(nykaaProStore.getIsAcceptableIdProofTitleDisplayed(),"Verify if submenu title is displayed");
		Assert.assertTrue(nykaaProStore.getIsBusinessProofTitleDisplayed(),"Verify if business proof title is displayed");
		Assert.assertTrue(nykaaProStore.getIsIdProofTitleDisplayed(),"Verify if Id proof title is displayed");
		List<String> acceptableIdProofList= nykaaProStore.getAcceptableProofList("ID Proof");
		List<String> acceptableBusinessProofList= nykaaProStore.getAcceptableProofList("Business");
		nykaaProStore.clickGotItButton();
		//verify if why pro's love us section is displayed
		//verify if apply in three easy steps is displayed
		//verify view acceptable proofs
		//verify if FAQ Section is displayed
		//Verify first 5 questions and answers
		
	}
}
