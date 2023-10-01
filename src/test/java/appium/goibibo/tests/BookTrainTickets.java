package appium.goibibo.tests;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

import org.testng.Assert;

import appium.goibibo.pojos.PassengerDetails;
import appium.goibibo.pojos.TravellerDetails;
import appium.goibibo.screens.HomeScreen;
import appium.goibibo.screens.LoginScreen;
import appium.goibibo.screens.ReviewScreen;
import appium.goibibo.screens.TrainBookingScreen;
import appium.utils.AndroidBaseTest;
import appium.utils.EnumClass.BookCategory;
import appium.utils.EnumClass.LoginTexts;
import appium.utils.Utility;

public class BookTrainTickets extends AndroidBaseTest{
	
	public HomeScreen homeScreen;
	public TrainBookingScreen trainBookingScreen;
	public ReviewScreen reviewScreen;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	public void book_train_tickets_ui_validations() throws Exception {
	    File travellerDetailsJsonFile = Utility.readFileFromTestData("train-traveller-details.json");
	    TravellerDetails travellerDetails = objectMapper.readValue(travellerDetailsJsonFile, TravellerDetails.class);
	    Assert.assertEquals(loginScreen.getSignupOfferText(), LoginTexts.SIGNUP_OFFER.getOption(), "Verify the signup offer text displayed in banner");
		Assert.assertEquals(loginScreen.getSignupText(), LoginTexts.SIGNIN_MESSAGE.getOption(),"Verify the sign in text displayed on login screen");
		Assert.assertEquals(loginScreen.getNumberFieldPlaceholderText(), LoginTexts.NUMBER_FIELD_PLACEHOLDER.getOption(),"Verify the placeholder text displayed in number field");
		Assert.assertEquals(loginScreen.getTermsAndConditionsText(), LoginTexts.TERMS_AND_CONDITIONS.getOption(),"Verify the terms and conditions message displayed on home screen");
		homeScreen = loginScreen.continueWithoutSignup();
		homeScreen.closeAdPopUp();
		Assert.assertTrue(homeScreen.getIsButtonViaTxtDisplayed(BookCategory.HOTELS.getOption()), "Hotels category should be displayed");
		Assert.assertTrue(homeScreen.getIsButtonViaTxtDisplayed(BookCategory.FLIGHTS.getOption()), "Flights category should be displayed");
		Assert.assertTrue(homeScreen.getIsButtonViaTxtDisplayed(BookCategory.TRAINS.getOption()), "Trains category should be displayed");
		Assert.assertTrue(homeScreen.getIsButtonViaTxtDisplayed(BookCategory.BUS.getOption()), "Bus category should be displayed");
		trainBookingScreen = homeScreen.selectCategoryTrain();
		trainBookingScreen.searchTrains("Delhi", "Gwalior");
		trainBookingScreen.selectDateFromDisplayedCard("2");
		trainBookingScreen.clickButtonViaTxt("SEARCH");
		trainBookingScreen.waitForLoaderToDisappear();
		reviewScreen = trainBookingScreen.selectTrainAndClass("Nzm Jbp Sf Exp", "12191", "2A");
		reviewScreen.waitForLoaderToDisappear();
		List<PassengerDetails> details = travellerDetails.getPassengerDetails();
		for(PassengerDetails passenger : details) {
		    reviewScreen.clickButtonViaTxt("+ Add Traveller");
		    reviewScreen.addPassengerDetails(passenger.getFullName(), passenger.getGender(), Integer.toString(passenger.getAge()), passenger.getNationality(), passenger.getBerthPreference());
		    reviewScreen.clickButtonViaTxt("Save & Close");
		}
	}

}
