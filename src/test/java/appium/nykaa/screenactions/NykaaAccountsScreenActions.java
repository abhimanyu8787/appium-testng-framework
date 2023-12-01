package appium.nykaa.screenactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import appium.nykaa.screenobjects.NykaaAccountsScreenObject;
import io.appium.java_client.android.AndroidDriver;

public class NykaaAccountsScreenActions extends NykaaCommonScreenActions{

	public AndroidDriver driver;
	
	public NykaaAccountsScreenActions(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}
	NykaaAccountsScreenObject accountsScreen = new NykaaAccountsScreenObject();
	
	public void clickAccountMenuOption(String menuOption) throws Exception {
		scrollToElementNotDisplayedInView(replaceAndCreateCustomLocator(accountsScreen.accounts_menu_title_replace, menuOption));
		clickElement(replaceAndCreateCustomLocator(accountsScreen.accounts_menu_title_replace, menuOption));
	}
	
	public List<String> addNewAddress(String pincode, String addressLine1, String addressLine2, String contactName, String contactNumber) throws Exception {
		waitForSeconds(2);
		List<String> cityState = new ArrayList<String>();
		clickElement(accountsScreen.addresses_add_new_address_button);
		waitForSeconds(2);
		clickElement(accountsScreen.new_address_pincode);
		enterText(accountsScreen.new_address_pincode_textbox, pincode);
		cityState.add(getElementText(accountsScreen.new_address_cityText));
		cityState.add(getElementText(accountsScreen.new_address_stateText));
		clickElement(accountsScreen.new_address_houseflatnumber);
		enterText(accountsScreen.new_address_houseflatnumber_textBox, addressLine1);
		clickElement(accountsScreen.new_address_roadareacolony);
		enterText(accountsScreen.new_address_roadareacolony_textBox, addressLine2);
		clickElement(accountsScreen.new_address_contactName);
		clearText(accountsScreen.new_address_contactName);
		enterText(accountsScreen.new_address_contactName, contactName);
		clickElement(accountsScreen.new_address_contactPhone);
		clearText(accountsScreen.new_address_contactPhone);
		enterText(accountsScreen.new_address_contactPhone, contactNumber);
		clickElement(accountsScreen.addAddressButton);
		return cityState;
	}
	
	public void removeAddressByIndex(int index) throws Exception {
		clickElement(replaceAndCreateCustomLocator(accountsScreen.remove_address_button, Integer.toString(index)));
		clickElement(accountsScreen.remove_address_confirm_btn);
		waitForNykaaLoaderToDisappear();
	}
	
	public List<HashMap<String, String>> getAddedAddresses() throws Exception{
		waitForSeconds(2);
		List<String> contactNames = getElementsText(accountsScreen.displayed_address_contact_name);
		List<String> addresses = getElementsText(accountsScreen.displayed_address_address);
		List<String> cityStatePhone = getElementsText(accountsScreen.displayed_address_cityPincodeStateNumber);
		List<HashMap<String, String>> addedAddresses = new ArrayList<HashMap<String, String>>();
		for(int i = 0; i<contactNames.size(); i++) {
			HashMap<String, String> address = new HashMap<String, String>();
			address.put("contactName", contactNames.get(i));
			address.put("address", addresses.get(i));
			address.put("contactPhone", cityStatePhone.get(i).split(" ")[cityStatePhone.get(i).split(" ").length-1].split("\n")[1]);
			int size = cityStatePhone.get(i).length();
			address.put("cityState", cityStatePhone.get(i).substring(0, size-10).trim());
			addedAddresses.add(address);
		}
		return addedAddresses;
	}
	
	public int getDefaultAddressCardIndex() {
		List<WebElement> addressCards = driver.findElements(replaceAndCreateCustomLocator(accountsScreen.displayed_address_cards_replace, "*"));
		int totalAddresses = addressCards.size();
		
		for(int i = 1; i<=totalAddresses; i++) {
			if(getIsChildElementDisplayed(replaceAndCreateCustomLocator(accountsScreen.displayed_address_cards_replace, Integer.toString(i)),accountsScreen.displayed_address_default)) {
				return i;
			}
		}
		return 0;
	}
	
	public void deleteNonDefaultAddresses() throws Exception {
		List<WebElement> addressCards = driver.findElements(replaceAndCreateCustomLocator(accountsScreen.displayed_address_cards_replace, "*"));
		if(addressCards.size()>1) {
			int totalAddresses = addressCards.size();
			int index = 1;
			while(totalAddresses>1) {
				if(getIsChildElementDisplayed(replaceAndCreateCustomLocator(accountsScreen.displayed_address_cards_replace, Integer.toString(index)), accountsScreen.displayed_address_default)) {
					index++;
					continue;
				}
				addressCards.get(index-1).findElement(replaceAndCreateCustomLocator(accountsScreen.remove_address_button, "1")).click();
				clickElement(accountsScreen.remove_address_confirm_btn);
				waitForNykaaLoaderToDisappear();
				addressCards = driver.findElements(replaceAndCreateCustomLocator(accountsScreen.displayed_address_cards_replace, "*"));
				totalAddresses = addressCards.size();
			}
		}
	}
	
	public List<String> getOrderIdList() throws Exception{
		return getElementsText(replaceAndCreateCustomLocator(accountsScreen.ordernumbers, "."));
	}
	
	public void clickOrderDetailsBtn(String index) throws Exception {
		clickElement(replaceAndCreateCustomLocator(accountsScreen.orderDetailsBtn, index));
	}

}
