package appium.nykaa.screenactions;

import appium.nykaa.screenobjects.NykaaAccountsScreenObject;
import io.appium.java_client.android.AndroidDriver;

public class NykaaAccountsScreenActions extends NykaaCommonScreenActions{

	public AndroidDriver driver;
	
	public NykaaAccountsScreenActions(AndroidDriver driver) {
		super(driver);
	}
	NykaaAccountsScreenObject accountsScreen = new NykaaAccountsScreenObject();
	
	public void clickAccountMenuOption(String menuOption) throws Exception {
		scrollToElementNotDisplayedInView(replaceAndCreateCustomLocator(accountsScreen.accounts_menu_title_replace, menuOption));
		clickElement(replaceAndCreateCustomLocator(accountsScreen.accounts_menu_title_replace, menuOption));
	}
	
	public void addNewAddress(String pincode, String addressLine1, String addressLine2, String contactName, String contactNumber) throws Exception {
		clickElement(accountsScreen.addresses_add_new_address_button);
		clickElement(accountsScreen.new_address_pincode);
		enterText(accountsScreen.new_address_pincode, pincode);
		clickElement(accountsScreen.new_address_houseflatnumber);
		enterText(accountsScreen.new_address_houseflatnumber, addressLine1);
		clickElement(accountsScreen.new_address_roadareacolony);
		enterText(accountsScreen.new_address_houseflatnumber, addressLine2);
		clickElement(accountsScreen.new_address_contactName);
		enterText(accountsScreen.new_address_contactName, contactName);
		clickElement(accountsScreen.new_address_contactPhone);
		enterText(accountsScreen.new_address_contactPhone, contactNumber);
		clickElement(accountsScreen.addAddressButton);
	}
	
	public void removeAddressByIndex(int index) throws Exception {
		clickElement(replaceAndCreateCustomLocator(accountsScreen.remove_address_button, Integer.toString(index)));
		clickElement(accountsScreen.remove_address_confirm_btn);
		waitForNykaaLoaderToDisappear();
	}

}
