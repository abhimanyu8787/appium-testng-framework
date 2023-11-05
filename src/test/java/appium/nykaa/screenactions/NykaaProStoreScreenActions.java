package appium.nykaa.screenactions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import appium.nykaa.screenobjects.NykaaProStoreScreenObject;
import io.appium.java_client.android.AndroidDriver;

public class NykaaProStoreScreenActions extends NykaaCommonScreenActions{

	public NykaaProStoreScreenActions(AndroidDriver driver) {
		super(driver);
	}
	
	NykaaProStoreScreenObject nykaaProStore = new NykaaProStoreScreenObject();
	
	public boolean getIsApplyStepsTitleDisplayed() {
		scrollToElementUsingSwipe(nykaaProStore.applyforproaccount_title);
		return getIsElementDisplayed(nykaaProStore.applyforproaccount_title);
	}
	
	public boolean getIsAcceptableIdProofTitleDisplayed() {
		scrollToElementUsingTouchAction(nykaaProStore.acceptableIdProof_title);
		return getIsElementDisplayed(nykaaProStore.acceptableIdProof_title);
	}
	
	public boolean getIsIdProofTitleDisplayed() throws InterruptedException {
		waitForElementToAppear(nykaaProStore.acceptableIdProof_title);
		return getIsElementDisplayed(nykaaProStore.acceptableIdProof_idproof);
	}
	
	public boolean getIsBusinessProofTitleDisplayed() throws InterruptedException {
		waitForElementToAppear(nykaaProStore.acceptableIdProof_title);
		return getIsElementDisplayed(nykaaProStore.acceptableIdProof_businessproof);
	}
	
	public boolean getIsApplyForProAccountTitleDisplayed() {
		return getIsElementDisplayed(nykaaProStore.applyforproaccount_title);
	}
	
	public List<String> getAcceptableProofList(String type) throws Exception{
		By locator = type.equalsIgnoreCase("ID proof") ? nykaaProStore.acceptableIdProof_idproof : nykaaProStore.acceptableIdProof_businessproof;
		List<String> proofList = getElementsText(locator);
		return proofList;
	}
	
	public boolean getIsGotItButtonDisplayed() {
		return getIsElementDisplayed(nykaaProStore.acceptableIdProof_GotItBtn);
	}
	
	public boolean getIsJoinNowButtonDisplayed() {
		return getIsElementDisplayed(nykaaProStore.acceptableIdProof_joinNowBtn);
	}
	
	public List<String> getApplicationStepsTitleAndSubtitle(String type) throws Exception{
		List<String> titles = new ArrayList<>();
		int i = type.equalsIgnoreCase("title") ? 2 : 3;
		while(i<8) {
			String num = Integer.toString(i);
			String title = getElementText(replaceAndCreateCustomLocator(nykaaProStore.applyforproaccount_stepsTitle_replace, num));
			titles.add(title);
			i+=3;
		}
		return titles;
	}
	
	public void clickViewAcceptableProofs() throws Exception {
		clickElement(nykaaProStore.applyforproaccount_acceptableProofBtn);
	}
	
	public boolean getIsFAQSectionDisplayed() {
		return getIsElementDisplayed(nykaaProStore.applyforproaccount_FAQ_title);
	}
	
	public List<String> faqQuestionsAndAnswers() throws Exception{
		List<String> questionAndAnswers = new ArrayList<String>();
		for(int i=1; i<=5; i=i+2) {
			String temp = "";
			scrollToElementUISelector(replaceAndCreateCustomLocator(nykaaProStore.applyforproaccount_FAQ_question_replace, Integer.toString(i)));
			temp += getElementText(replaceAndCreateCustomLocator(nykaaProStore.applyforproaccount_FAQ_question_replace, Integer.toString(i))) + "|";
			clickElement(replaceAndCreateCustomLocator(nykaaProStore.applyforproaccount_FAQ_question_replace, Integer.toString(i)));
			temp += getElementText(replaceAndCreateCustomLocator(nykaaProStore.applyforproaccount_FAQ_question_replace, Integer.toString(i+1))) + "|";
			questionAndAnswers.add(temp);
		}
		return questionAndAnswers;
	}
	
	public NykaaHomeScreenActions clickBackButtonNavigateToHome() throws Exception {
		clickElement(nykaaProStore.nykaaProBackButton);
		return new NykaaHomeScreenActions(driver);
	}

}
