package appium.nykaa.screenactions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import appium.nykaa.screenobjects.NykaaCommonScreenObject;
import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NykaaCommonScreenActions extends AndroidGenericMethods{
	
	public NykaaCommonScreenActions(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	NykaaCommonScreenObject commonScreen = new NykaaCommonScreenObject();
	
	public By replaceAndCreateCustomLocator(By locator, String replacer){
		String str=locator.toString().replace("replace", replacer);
		return By.xpath(str.split("By.xpath:")[1].trim());
	}
	
	public By replaceAndCreateCustomLocator(By locator, String replacer1, String replacer2){
		String str=locator.toString().replace("replace1", replacer1).replace("replace2", replacer2);
		return By.xpath(str.split("By.xpath:")[1].trim());
	}
	
	public By replaceAndCreateCustomLocator(By locator, String replacer1, String replacer2, String replacer3){
		String str=locator.toString().replace("replace1", replacer1).replace("replace2", replacer2).replace("replace3", replacer3);
		return By.xpath(str.split("By.xpath:")[1].trim());
	}
	
	public void waitForLandingPageLoaderToDisappear() {
		waitForAllElementsToDisappear(commonScreen.landingscreen_loader);
	}
	
	public String getSelectStoreDropDownTitle() throws Exception {
		return getElementText(commonScreen.storeselector_heading);
	}
	
	public String getSelectStoreDropDownTitle(String storeName) throws Exception {
		String storeTitle = null;
		switch (storeName.toUpperCase()) {
		case "NYKAA":
			storeTitle = getElementText(replaceAndCreateCustomLocator(commonScreen.storeselector_storeTitle_replace, "1"));
			break;
		case "NYKAA LUXE":
			storeTitle = getElementText(replaceAndCreateCustomLocator(commonScreen.storeselector_storeTitle_replace, "2"));
			break;
		case "NYKAA CROSSBORDER":
			storeTitle = getElementText(replaceAndCreateCustomLocator(commonScreen.storeselector_storeTitle_replace, "3"));
			break;
		case "NYKAA PRO":
			storeTitle = getElementText(replaceAndCreateCustomLocator(commonScreen.storeselector_storeTitle_replace, "4"));
			break;
		default:
			throw new Exception("Invalid/Incorrect store name entered: "+storeName);
		}
		return storeTitle;
	}
	
	public void clickStore(String storeName) throws Exception {
		switch (storeName.toUpperCase()) {
		case "NYKAA":
			clickElement(replaceAndCreateCustomLocator(commonScreen.storeselector_store_selector_replace, "1"));
			break;
		case "NYKAA LUXE":
			clickElement(replaceAndCreateCustomLocator(commonScreen.storeselector_store_selector_replace, "2"));
			break;
		case "NYKAA CROSSBORDER":
			clickElement(replaceAndCreateCustomLocator(commonScreen.storeselector_store_selector_replace, "3"));
			break;
		case "NYKAA PRO":
			clickElement(replaceAndCreateCustomLocator(commonScreen.storeselector_store_selector_replace, "4"));
			break;
		default:
			throw new Exception("Invalid/Incorrect store name entered: "+storeName);
		}
	}
	
	public String getNykaProStoreHeadline() throws Exception {
		return getElementText(commonScreen.storeselector_nykaapro_title);
	}
}
