package appium.nykaa.tests;

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
		nykaaHomeScreenActions.waitForLandingPageLoaderToDisappear();
		Assert.assertEquals(nykaaHomeScreenActions.getSearchBoxPlaceholderText(), NykaaSearchBoxPlaceholders.NYKAA_LUXE.getOption(), "Verify if user is landed on nykaa luxe store page");
		nykaaHomeScreenActions.clickStoreSelectorDropdown();
		nykaaHomeScreenActions.clickStore("Nykaa Crossborder");
		nykaaHomeScreenActions.waitForLandingPageLoaderToDisappear();
		Assert.assertEquals(nykaaHomeScreenActions.getSearchBoxPlaceholderText(), NykaaSearchBoxPlaceholders.NYKAA_CROSSBORDER.getOption(), "Verify if user is landed on nykaa crossborder store page");
		nykaaHomeScreenActions.clickStoreSelectorDropdown();
		nykaaProStore = nykaaHomeScreenActions.navigateToNykaProStore();
		nykaaProStore.waitForLandingPageLoaderToDisappear();
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
		nykaaProStore.clickViewAcceptableProofs();
		Assert.assertTrue(nykaaProStore.getIsAcceptableIdProofTitleDisplayed(),"Verify if submenu title is displayed");
		Assert.assertTrue(nykaaProStore.getIsBusinessProofTitleDisplayed(),"Verify if business proof title is displayed");
		Assert.assertTrue(nykaaProStore.getIsIdProofTitleDisplayed(),"Verify if Id proof title is displayed");
		List<String> acceptableIdProofList= nykaaProStore.getAcceptableProofList("ID Proof");
		List<String> acceptableBusinessProofList= nykaaProStore.getAcceptableProofList("Business");
		String[] expectedIdProofList = {"GST Certificate", "Government Issued Photo ID"};
		String[] expectedBusinessProofList = {"Website Link", "Social or online business presence", "Training certificate", "Business card with credentials", "Salary Slip/Invoice", "Press or digital coverage"};
		for(int i = 0; i<acceptableIdProofList.size(); i++) {
			Assert.assertEquals(acceptableIdProofList.get(i),expectedIdProofList[i]);
		}
		for(int i = 0; i<acceptableBusinessProofList.size(); i++) {
			Assert.assertEquals(acceptableBusinessProofList.get(i),expectedBusinessProofList[i]);
		}
		nykaaProStore.clickGotItButton();
	}
	
	@Test
	public void nykaa_pro_faq_section_validations() throws Exception {
		nykaaHomeScreenActions.waitForLandingPageLoaderToDisappear();
		Assert.assertEquals(nykaaHomeScreenActions.getSearchBoxPlaceholderText(), NykaaSearchBoxPlaceholders.NYKAA.getOption(), "Verify if user is landed on nykaa store page");
		nykaaHomeScreenActions.clickStoreSelectorDropdown();
		nykaaProStore = nykaaHomeScreenActions.navigateToNykaProStore();
		nykaaProStore.waitForLandingPageLoaderToDisappear();
		Assert.assertTrue(nykaaProStore.getIsFAQSectionDisplayed());
		List<String> displayedFAQ = nykaaProStore.faqQuestionsAndAnswers();
		Assert.assertEquals(displayedFAQ.get(0).split("\\|")[0], "1. What is Nykaa PRO?");
		Assert.assertEquals(displayedFAQ.get(0).split("\\|")[1], "Nykaa PRO is an exclusive membership program for salons, makeup artists, independent beauticians, hair stylists and academies that gives them access to special offers on professional products along with educational content from leading beauty experts.");
	}
	
	@Test
	public void nykaa_place_order_validations() {
		//empty existing cart if any product is there
		//search for a product
		//validate search results
		//validate product count
		//add random products to bag
	}
	
}
