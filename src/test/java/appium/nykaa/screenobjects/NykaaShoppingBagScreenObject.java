package appium.nykaa.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class NykaaShoppingBagScreenObject extends NykaaCommonScreenObject{
	public final By emptyBagMessage = AppiumBy.id("com.fsn.nykaa:id/tvEmptyBagMsg");
	public final By emptyBagMessageDesc = AppiumBy.id("com.fsn.nykaa:id/tvEmptyBagDescMsg");
	public final By backToHomeBtn = AppiumBy.id("com.fsn.nykaa:id/tvStartShop");
	public final By wishlistBtn = AppiumBy.id("com.fsn.nykaa:id/txt_toolbar_wishlist");
	public final By emptyCartImage = AppiumBy.accessibilityId("imageDesc");
	public final By backBtn = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	
	public final By cartPageContainer = AppiumBy.id("com.fsn.nykaa:id/nsvCartSection");
	
	public final By shoppingBagTitle = AppiumBy.id("com.fsn.nykaa:id/txt_toolbar_title");
	public final By shoppingBagTotalPrice = AppiumBy.id("com.fsn.nykaa:id/tvTotalStrike");
	public final By shoppingBagFinalPrice = AppiumBy.id("com.fsn.nykaa:id/tvGrandTotalValue");
	public final By proceedBtn = AppiumBy.id("com.fsn.nykaa:id/tvProceed");
	public final By productsFinalPrice = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tvFinalPrice']");
	public final By productsOrignalPrice = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tvPriceStrikeThru']");
	public final By productsTitle = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tvProductTitle']");
	public final By productsSize = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tvItemSize']");
	public final By productsQuantity = AppiumBy.id("com.fsn.nykaa:id/tvQuantity");
	public final By shoppingBagSavingsMsg = AppiumBy.id("com.fsn.nykaa:id/txtSavingsDescription");
	
	public final By addressPinCode = AppiumBy.id("com.fsn.nykaa:id/tvEddDelTo");
	public final By addressDesc = AppiumBy.id("com.fsn.nykaa:id/tvEddAddress");
	public final By addressCity = AppiumBy.id("com.fsn.nykaa:id/tvEddCity");
	public final By addressChangeBtn = AppiumBy.id("com.fsn.nykaa:id/btnChangeEdd");
	
	public final By productDeleteBtns = AppiumBy.xpath("//android.widget.ImageView[@resource-id='com.fsn.nykaa:id/ivIconTrash']");
	public final By deleteModal_Message = AppiumBy.id("com.fsn.nykaa:id/tv_title");
	public final By deleteModal_Desc = AppiumBy.id("com.fsn.nykaa:id/tv_msg");
	public final By deleteModal_RemoveBtn = AppiumBy.id("com.fsn.nykaa:id/tv_cancel");
	public final By deleteModal_AddToWishlistBtn = AppiumBy.id("com.fsn.nykaa:id/tv_ok");
	
}
