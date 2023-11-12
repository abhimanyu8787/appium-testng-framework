package appium.nykaa.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class NykaaProStoreScreenObject extends NykaaCommonScreenObject{
	
	public final By applyforproaccount_title = AppiumBy.xpath("//android.view.View[@text='Apply in three easy steps']");
	public final By applyforproaccount_stepsTitle_replace = AppiumBy.xpath("(//android.view.View[@text='Apply in three easy steps']/following-sibling::android.view.View)[replace]");
	public final By applyforproaccount_stepsDesc_replace = AppiumBy.xpath("(//android.view.View[@text='Apply in three easy steps']/following-sibling::android.view.View)[replace]");
	public final By applyforproaccount_acceptableProofBtn = AppiumBy.xpath("(//android.view.View[@text='Apply in three easy steps']/following-sibling::android.widget.Button)[1]");
	public final By exclusiveOffers_title = AppiumBy.xpath("//android.view.View[@text='MORE PRO EXCLUSIVE OFFERS']");
	public final By advantageProAccount = AppiumBy.xpath("//android.view.View[@text='DN_BANNER_IMAGE']");
	public final By applyforproaccount_FAQ_title = AppiumBy.xpath("//android.view.View[@text='Frequently Asked Questions']");
	public final By applyforproaccount_FAQ_question_replace = AppiumBy.xpath("(//android.view.View[@text='Frequently Asked Questions']/following-sibling::android.view.View)[replace]");
	public final By applyforproaccount_FAQ_question_dropdown_replace = AppiumBy.xpath("(//android.view.View[@text='Frequently Asked Questions']/following-sibling::android.view.View)[replace]");
	public final By applyforproaccount_FAQ_answer_replace = AppiumBy.xpath("(//android.view.View[@text='Frequently Asked Questions']/following-sibling::android.view.View)[replace]");
	
	public final By nykaaProBackButton = AppiumBy.accessibilityId("Navigate up");
	
	public final By nykaaProPageContainer = AppiumBy.xpath("//android.view.ViewGroup[@resource-id='com.fsn.nykaa:id/swipeContainer']");
	
	//acceptable id proofs sub menu
	public final By viewAcceptableProof = AppiumBy.xpath("//android.widget.Button[@text='View Acceptable Proofs']");
	public final By acceptableIdProof_title = AppiumBy.xpath("//android.view.View[@text='Acceptable ID proofs']");
	public final By acceptableIdProof_idproof = AppiumBy.xpath("//android.view.View[@text='ID Proof (any one)']/following-sibling::android.widget.ListView/*/android.view.View[@index=1]");
	public final By acceptableIdProof_businessproof = AppiumBy.xpath("//android.view.View[@text='Business Proof (any one)']/following-sibling::android.widget.ListView/*/android.view.View[@index=1]");
	public final By acceptableIdProof_joinNowBtn = AppiumBy.xpath("//android.widget.Button[@text='JOIN NOW']");
	public final By acceptableIdProof_GotItBtn = AppiumBy.xpath("//android.widget.Button[@text='GOT IT']");
	

}
