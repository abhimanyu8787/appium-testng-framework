package appium.makemytrip.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class CommonScreenObject {
	
	public final By common_textview_replace = AppiumBy.xpath("//android.widget.TextView[@text=\"replace\"]");
	public final By common_button_replace = AppiumBy.xpath("//android.widget.Button[@text=\"replace\"]");
	public final By common_progressbar = AppiumBy.xpath("//android.widget.ProgressBar[@resource-id='com.makemytrip:id/loading_view']");
	

}
