package appium.goibibo.tests;

import org.testng.annotations.Test;

import appium.goibibo.screens.HomeScreen;
import appium.goibibo.screens.LoginScreen;
import appium.goibibo.screens.ReviewScreen;
import appium.goibibo.screens.TrainBookingScreen;
import appium.utils.AndroidBaseTest;

public class BookTrainTickets extends AndroidBaseTest{
	
	public HomeScreen homeScreen;
	public TrainBookingScreen trainBookingScreen;
	public ReviewScreen reviewScreen;
	
	@Test
	public void book_train_tickets_ui_validations() throws Exception {
		homeScreen = loginScreen.continueWithoutSignup();
		trainBookingScreen = homeScreen.selectCategoryTrain();
		trainBookingScreen.searchTrains("Delhi", "Gwalior");
		trainBookingScreen.selectDateFromDisplayedCard("2");
		trainBookingScreen.clickButtonViaTxt("SEARCH");
		trainBookingScreen.waitForLoaderToDisappear();
		reviewScreen = trainBookingScreen.selectTrainAndClass("Nzm Jbp Sf Exp", "12191", "3A");
		reviewScreen.waitForLoaderToDisappear();
		reviewScreen.clickButtonViaTxt("+ Add Traveller");
		reviewScreen.addPassengerDetails("Mahi Sharma", "Female", "25", "Indian", "Lower Berth");
		reviewScreen.clickButtonViaTxt("Save & Close");
	}

}
