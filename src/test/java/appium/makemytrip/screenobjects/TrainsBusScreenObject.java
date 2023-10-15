package appium.makemytrip.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class TrainsBusScreenObject extends CommonScreenObject{
	
	public final By trainAndBusOptions_replace = AppiumBy.xpath("//android.widget.TextView[@text='replace']/parent::*");

}
