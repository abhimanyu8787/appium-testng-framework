package appium.nykaa.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class NykaaProStoreScreenObject extends NykaaCommonScreenObject{
	
	public final By applyforproaccount_title = AppiumBy.xpath("//android.view.View[@text='Apply in three easy steps']");
	public final By applyforproaccount_stepsTitle_replace = AppiumBy.xpath("(//android.view.View[@text='Apply in three easy steps']/following-sibling::android.view.View)[replace]");
	public final By applyforproaccount_stepsDesc_replace = AppiumBy.xpath("(//android.view.View[@text='Apply in three easy steps']/following-sibling::android.view.View)[replace]");
	public final By applyforproaccount_acceptableProofBtn = AppiumBy.xpath("(//android.view.View[@text='Apply in three easy steps']/following-sibling::android.widget.Button)[1]");
	public final By applyforproaccount_joinNowBtn = AppiumBy.xpath(null);
	public final By applyforproaccount_FAQ_title = AppiumBy.xpath(null);
	public final By applyforproaccount_FAQ_question_replace = AppiumBy.xpath(null);
	public final By applyforproaccount_FAQ_question_dropdown_replace = AppiumBy.xpath(null);
	public final By applyforproaccount_FAQ_answer_replace = AppiumBy.xpath(null);
	
	public final By nykaaProBackButton = AppiumBy.accessibilityId("Navigate up");

}
