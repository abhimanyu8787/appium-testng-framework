package appium.makemytrip.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class CommonScreenObject {
	
	public final By common_textview_replace = AppiumBy.xpath("//android.widget.TextView[@text=\"replace\"]");
	public final By common_button_replace = AppiumBy.xpath("//android.widget.Button[@text=\"replace\"]");
	public final By common_progressbar = AppiumBy.xpath("//android.widget.ProgressBar[@resource-id='com.makemytrip:id/loading_view']");
	public final By common_calendarMonth_replace = AppiumBy.xpath("//android.view.ViewGroup[./android.widget.TextView[@text='replace1'] and ./android.widget.TextView[@text='replace2']]");
	public final By common_calendarDate_replace = AppiumBy.xpath("//android.view.ViewGroup[./android.widget.TextView[@text='replace1'] and ./android.widget.TextView[@text='replace2']]/following-sibling::android.view.ViewGroup[.//android.widget.TextView[@text='replace3']]");
	

}
