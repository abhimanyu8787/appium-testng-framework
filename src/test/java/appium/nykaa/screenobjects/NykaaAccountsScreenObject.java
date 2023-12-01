package appium.nykaa.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class NykaaAccountsScreenObject extends NykaaCommonScreenObject{
	public final By accounts_screen_scroll_container = AppiumBy.id("com.fsn.nykaa:id/rv_account_types");
	public final By accounts_menu_title_replace = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tv_section_title' and @text='replace']");
	public final By accounts_menu_description_replace = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tv_section_description' and ./preceding-sibling::*[@text='Orders']]");
	public final By addresses_add_new_address_button = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tvAddNewAddress']");
	public final By addresses_default_tag = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tvDefault']");
	public final By new_address_pincode = AppiumBy.id("com.fsn.nykaa:id/tilPincode");
	public final By new_address_pincode_textbox = AppiumBy.id("com.fsn.nykaa:id/etPincode");
	public final By new_address_houseflatnumber = AppiumBy.id("com.fsn.nykaa:id/tilHouseFlatOfficeNo");
	public final By new_address_houseflatnumber_textBox = AppiumBy.id("com.fsn.nykaa:id/etHouseFlatOfficeNo");
	public final By new_address_roadareacolony = AppiumBy.id("com.fsn.nykaa:id/etRoadAreaColony");
	public final By new_address_roadareacolony_textBox = AppiumBy.id("com.fsn.nykaa:id/etRoadAreaColony");
	public final By new_address_defaultaddresstoggle = AppiumBy.id("com.fsn.nykaa:id/switchCompatDefaultAddress");
	public final By new_address_contactName = AppiumBy.id("com.fsn.nykaa:id/etName");
	public final By new_address_contactPhone = AppiumBy.id("com.fsn.nykaa:id/etPhoneNumber");
	public final By new_address_autoDetectBtn = AppiumBy.id("com.fsn.nykaa:id/tvAutoDetect");
	public final By addAddressButton = AppiumBy.xpath("//android.widget.Button[@resource-id='com.fsn.nykaa:id/btnShip' and @text='Add Address']");
	public final By remove_address_button = AppiumBy.xpath("(//android.widget.ImageView[@resource-id='com.fsn.nykaa:id/ivSelectOrDelete'])[replace]");
	public final By remove_address_confirm_btn = AppiumBy.id("com.fsn.nykaa:id/btnConfirmSaveChanges");
	public final By remove_address_cancelChanges_btn = AppiumBy.id("com.fsn.nykaa:id/tvInfoErrorCancel");
	
	public final By new_address_cityText = AppiumBy.id("com.fsn.nykaa:id/etCity");
	public final By new_address_stateText = AppiumBy.id("com.fsn.nykaa:id/etState");
	
	//displayed addresses
	public final By displayed_address_contact_name = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tvName']");
	public final By displayed_address_address = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tvAddress']");
	public final By displayed_address_cityPincodeStateNumber = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tvCityStatePhone']");
	public final By displayed_address_cards_replace = AppiumBy.xpath("(//*[@resource-id='com.fsn.nykaa:id/addressLayout'])[replace]");
	public final By displayed_address_default = AppiumBy.id("com.fsn.nykaa:id/tvDefault");
	
	//orders page
	public final By ordernumbers = By.xpath("//span[text()='Order Number']/following-sibling::span[contains(text(),'NYK')]");
	public final By orderDetailsBtn = AppiumBy.xpath("(//*[@text='ORDER NUMBER']/following-sibling::*/android.widget.Button)[replace]");
}
