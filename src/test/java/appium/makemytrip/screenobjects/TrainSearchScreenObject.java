package appium.makemytrip.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class TrainSearchScreenObject extends CommonScreenObject{
	
	public final By fromandtoFieldPlaceholderText = AppiumBy.xpath("//android.widget.TextView[@text='replace']/following-sibling::android.widget.TextView");
	public final By fromandtoField = AppiumBy.xpath("//android.widget.TextView[@text='replace']/parent::android.view.ViewGroup/parent::*");
	public final By dateField = AppiumBy.xpath("//android.view.ViewGroup[@resource-id='undefined_searchForm_journeyDate']");
	public final By dateFieldPlaceholderName = AppiumBy.xpath("(//android.view.ViewGroup[@resource-id='undefined_searchForm_journeyDate']/android.widget.TextView)[1]");
	public final By dateFieldPlaceholderCurrentDate = AppiumBy.xpath("(//android.view.ViewGroup[@resource-id='undefined_searchForm_journeyDate']/android.widget.TextView)[2]");
	public final By dateFieldPlaceholderCurrentDay = AppiumBy.xpath("(//android.view.ViewGroup[@resource-id='undefined_searchForm_journeyDate']/android.widget.TextView)[3]");
	public final By dateFieldTomorrowButton = AppiumBy.id("undefined_searchForm_journeyDate_tomorrow");
	public final By dateFieldDayAfterButton = AppiumBy.id("undefined_searchForm_journeyDate_dayAfter");
	public final By zeroCancellationCheckBox = AppiumBy.xpath("((//*[@resource-id='undefined_searchForm_journeyDate']/parent::*/following-sibling::*)[1]//android.view.ViewGroup[.//android.widget.ImageView])[2]");
	public final By searchButton = AppiumBy.xpath("//android.widget.TextView[@text='SEARCH']/parent::android.view.ViewGroup");

}
