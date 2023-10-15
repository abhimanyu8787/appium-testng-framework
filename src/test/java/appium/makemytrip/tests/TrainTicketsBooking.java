package appium.makemytrip.tests;

import org.testng.annotations.Test;

import appium.makemytrip.screenactions.TrainSearchScreenActions;
import appium.makemytrip.screenactions.TrainsBusScreenActions;
import appium.utils.AndroidBaseTest;
import appium.utils.EnumClass.MakeMyTripCategoriesMajor;
import appium.utils.EnumClass.MakeMytripTrainAndBusOptions;

public class TrainTicketsBooking extends AndroidBaseTest{
	
	TrainsBusScreenActions trainBusScreenActions;
	TrainSearchScreenActions trainSearchScreenActions;
	
	@Test
	public void trains_category_ui_validations() throws Exception {
		Thread.sleep(5000);
		homeScreenActions.dismissAdvertisementPopUp();
		trainBusScreenActions = homeScreenActions.clickMajorCategory(MakeMyTripCategoriesMajor.TRAIN_BUS.getOption(), TrainsBusScreenActions.class);
		trainSearchScreenActions = trainBusScreenActions.selectTrainAndBusOption(MakeMytripTrainAndBusOptions.BOOK_TRAIN_TICKETS.getOption(), TrainSearchScreenActions.class);
		trainSearchScreenActions.selectDateFromCalendar("2023-11-18");
	}

}
