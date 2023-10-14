package appium.makemytrip.tests;

import org.testng.annotations.Test;
import appium.utils.AndroidBaseTest;
import appium.utils.EnumClass.MakeMyTripCategoriesMajor;

public class TrainTicketsBooking extends AndroidBaseTest{
	
	@Test
	public void trains_category_ui_validations() throws Exception {
		homeScreenActions.clickMajorCategory(MakeMyTripCategoriesMajor.TRAIN_BUS.getOption());
		Thread.sleep(10000);
	}

}
