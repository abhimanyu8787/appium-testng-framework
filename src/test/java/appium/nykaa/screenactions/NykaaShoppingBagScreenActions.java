package appium.nykaa.screenactions;

import java.util.List;

import org.openqa.selenium.WebElement;

import appium.nykaa.screenobjects.NykaaShoppingBagScreenObject;
import io.appium.java_client.android.AndroidDriver;

public class NykaaShoppingBagScreenActions extends NykaaCommonScreenActions{

	public NykaaShoppingBagScreenActions(AndroidDriver driver) {
		super(driver);
		
	}
	
	NykaaShoppingBagScreenObject nykaaShoppingBag = new NykaaShoppingBagScreenObject();
	
	public void clearCart() throws Exception {
		if (getIfShippingChargeWarningMessageDisplayed()) {
			tapAtCenterOfScreen();
		}
		if(!getIsElementDisplayed(nykaaShoppingBag.emptyBagMessage)) {
			//cart has some products already added
			List<WebElement> deleteBtns = driver.findElements(nykaaShoppingBag.productDeleteBtns);
			for(WebElement ele : deleteBtns) {
				clickElement(ele);
				waitForElementToAppear(nykaaShoppingBag.deleteModal_RemoveBtn);
				clickElement(nykaaShoppingBag.deleteModal_RemoveBtn);
				waitForSeconds(2);
			}
			waitForElementToAppear(nykaaShoppingBag.emptyBagMessage);
		}
	}
	
	public List<String> getProductsName() throws Exception{
		return getElementsText(nykaaShoppingBag.productsTitle);
	}
	
	public List<String> getProductsPrice() throws Exception{
		return getElementsText(nykaaShoppingBag.productsOrignalPrice);
	}
	
	public List<String> getProductsFinalPrice() throws Exception{
		return getElementsText(nykaaShoppingBag.productsFinalPrice);
	}
	
	public String getCartGrandTotalFinalValue() throws Exception {
		return getElementText(nykaaShoppingBag.shoppingBagFinalPrice);
	}
	
	public String getCartGrandTotalValue() throws Exception {
		return getElementText(nykaaShoppingBag.shoppingBagTotalPrice);
	}
	
	public boolean getIfShippingChargeWarningMessageDisplayed() {
		return getIsElementDisplayed(nykaaShoppingBag.saveShippingWarningMessage);
	}
	
	public void clickProceedButton() throws Exception {
		clickElement(nykaaShoppingBag.proceedBtn);
	}
	
	public void getProductsInBagCount() {
		
	}
	
	public boolean getIsWarningDialogueDisplayed() {
		return getIsElementDisplayed(nykaaShoppingBag.warningDialogueTitle) && 
		getIsElementDisplayed(nykaaShoppingBag.warningDialogueImage) &&
		getIsElementDisplayed(nykaaShoppingBag.warningDialogueDesc) &&
		getIsElementDisplayed(nykaaShoppingBag.warningDialogueOkBtn);
	}
	
	public String getWarningModalTitle() throws Exception {
		return getElementText(nykaaShoppingBag.warningDialogueTitle);
	}
	
	public String getWarningModalDescription() throws Exception {
		return getElementText(nykaaShoppingBag.warningDialogueDesc);

	}
	
	public void clickWarningModalOkButton() throws Exception {
		clickElement(nykaaShoppingBag.warningDialogueOkBtn);
	}

}
