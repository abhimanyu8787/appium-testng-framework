package appium.goibibo.tests;

import org.testng.annotations.Test;

import appium.goibibo.screens.HomeScreen;
import appium.goibibo.screens.LoginScreen;
import appium.goibibo.screens.TrainBookingScreen;
import appium.utils.AndroidBaseTest;

public class BookTrainTickets extends AndroidBaseTest{
	
	public HomeScreen homeScreen;
	public TrainBookingScreen trainBookingScreen;
	
	@Test
	public void book_train_tickets_ui_validations() throws Exception {
		homeScreen = loginScreen.continueWithoutSignup();
		trainBookingScreen = homeScreen.selectCategoryTrain();
		trainBookingScreen.searchTrains("Gwalior", "Jhansi");
		trainBookingScreen.selectTrainAndClass("3A");
		trainBookingScreen.addTravellerDetails("Mahi Sharma", "Female", "25" , "Lower");
	}

}
