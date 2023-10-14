package appium.makemytrip.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class HomeScreenObject extends CommonScreenObject{
	
	public final By majorCategory_replace = AppiumBy.xpath("//android.widget.Button[@resource-id='com.makemytrip:id/container' and @text='replace']");
	public final By popUpAdvertisement = AppiumBy.id("com.makemytrip:id/rl_info");
	public final By popUpAdvertisement_dismissBtn = AppiumBy.id("com.makemytrip:id/tv_left_cta");
	public final By popUpAdvertisement_bookNowBtn = AppiumBy.id("com.makemytrip:id/tv_right_cta");
	public final By minorCategory_replace = AppiumBy.xpath("//*[@resource-id='com.makemytrip:id/secondary_lob_recycler_view']/android.widget.Button[./child::*[@text='replace']]");
	public final By minorCategory_moreBtn = AppiumBy.id("com.makemytrip:id/tv_more_text");
	public final By homeScreen_offersSection = AppiumBy.id("com.makemytrip:id/widget_t5_offer");
	public final By homeScreen_discoverSection = AppiumBy.id("com.makemytrip:id/mainLayout");
	public final By homeScreen_exclusivePartnersSection = AppiumBy.xpath("//*[@resource-id='com.makemytrip:id/container' and .//android.widget.TextView[@text='Exclusive Partners']]");
	public final By homeScreen_whatsNewSection = AppiumBy.xpath("//*[@resource-id='com.makemytrip:id/container' and .//android.widget.TextView[@text=\"What's New\"]]");
	public final By homeScreen_whatsNew_cta_replace = AppiumBy.xpath("//*[@resource-id='com.makemytrip:id/container' and .//android.widget.TextView[@text=\"What's New\"]]//android.widget.LinearLayout[@content-desc='replace']");
	public final By homeScreen_payLaterSection = AppiumBy.xpath("//*[@resource-id='com.makemytrip:id/container' and .//android.widget.TextView[@text=\"Pay Later\"]]");
	public final By homeScreen_bottom_navMenu_replace = AppiumBy.xpath("//*[@resource-id='com.makemytrip:id/rl_images' and .//android.widget.TextView[@text='replace']]");
	
}
