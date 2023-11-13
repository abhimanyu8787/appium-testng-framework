package appium.nykaa.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class NykaaHomeScreenObject extends NykaaCommonScreenObject{
	
	public final By store_dropdown = AppiumBy.id("com.fsn.nykaa:id/ic_store_dropdown");
	public final By wishlist_icon = AppiumBy.id("com.fsn.nykaa:id/wishlist");
	public final By shopping_cart = AppiumBy.id("com.fsn.nykaa:id/action_shopping_cart");
	public final By nykaa_logo = AppiumBy.id("com.fsn.nykaa:id/toolbar_logo");
	public final By searchbymic_button = AppiumBy.id("com.fsn.nykaa:id/iv_slang_new_mic");
	public final By searchbox = AppiumBy.id("com.fsn.nykaa:id/tv_search");
	public final By searchField = AppiumBy.id("com.fsn.nykaa:id/search_field");
	public final By shoppingBag = AppiumBy.id("com.fsn.nykaa:id/action_shopping_cart");
}
