package appium.nykaa.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class NykaaCommonScreenObject {
	
	public final By common_textview_replace = AppiumBy.xpath("//android.widget.TextView[@text='replace']");
	public final By landingscreen_loader = AppiumBy.id("com.fsn.nykaa:id/progressBar");
	public final By storeselector_heading = AppiumBy.id("com.fsn.nykaa:id/title");
	public final By storeselector_close_icon = AppiumBy.id("com.fsn.nykaa:id/iv_title_cross");
	public final By storeselector_storeTitle_replace = AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.fsn.nykaa:id/store_title'])[replace]");
	public final By storeselector_store_selector_replace = AppiumBy.id("(//android.widget.ImageView[@resource-id='com.fsn.nykaa:id/next'])[replace]");
	public final By storeselector_nykaapro_title = AppiumBy.id("com.fsn.nykaa:id/title");
}
