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
		if(!getIsElementDisplayed(nykaaShoppingBag.emptyBagMessage)) {
			//cart has some products already added
			List<WebElement> deleteBtns = driver.findElements(nykaaShoppingBag.productDeleteBtns);
			for(WebElement ele : deleteBtns) {
				clickElement(ele);
				clickElement(nykaaShoppingBag.deleteModal_RemoveBtn);
				waitForSeconds(2);
			}
			waitForElementToAppear(nykaaShoppingBag.emptyBagMessage);
		}
	}

}
