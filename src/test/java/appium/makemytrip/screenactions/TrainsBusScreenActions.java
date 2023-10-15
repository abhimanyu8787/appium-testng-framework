package appium.makemytrip.screenactions;

import appium.makemytrip.screenobjects.TrainsBusScreenObject;
import io.appium.java_client.android.AndroidDriver;

public class TrainsBusScreenActions extends CommonScreenActions{

	public TrainsBusScreenActions(AndroidDriver driver) {
		super(driver);
	}
	
	TrainsBusScreenObject trainBusScreen = new TrainsBusScreenObject();
	
	public <T> T selectTrainAndBusOption(String option, Class<T> returnType) throws Exception {
		clickElement(replaceAndCreateCustomLocator(trainBusScreen.trainAndBusOptions_replace, option));
		if(returnType == TrainSearchScreenActions.class)
			return returnType.cast(new TrainSearchScreenActions(driver));
		else
			return null;
	}

}
