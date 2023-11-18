package appium.nykaa.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class NykaaProductListScreenObject extends NykaaCommonScreenObject{
	public final By pageContainerToScroll = AppiumBy.id("com.fsn.nykaa:id/rv_product_list");
	public final By productListPageHeading = AppiumBy.id("com.fsn.nykaa:id/tv_header_text");
	public final By productListPageResultCount = AppiumBy.id("com.fsn.nykaa:id/tv_header_count_text");
	
	public final By productCardImage_replace = AppiumBy.xpath("(//android.widget.ImageView[@resource-id='com.fsn.nykaa:id/img_product'])[replace]");
	public final By productCardName_replace = AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tv_product_name'])[replace]");
	public final By productCardBrand_replace = AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.fsn.nykaa:id/actv_brand_name'])[replace]");
	public final By productCardPrice_replace = AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tv_price'])[replace]");
	public final By productCardOrignalPrice_replace = AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tv_original_price'])[replace]");
	public final By productCardDiscount_replace = AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tv_discount'])[replace]");
	public final By productCardStarRating_replace = AppiumBy.xpath("(//android.widget.RatingBar[@resource-id='com.fsn.nykaa:id/rating_bar'])[replace]");
	public final By productCardRatingCount_replace = AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.fsn.nykaa:id/tv_rating_count'])[replace]");
	public final By productCardAddToBagBtn_replace = AppiumBy.xpath("(//android.widget.Button[@resource-id='com.fsn.nykaa:id/btn_add_to_bag'])[replace]");
	public final By productCardAddToWishlistBtn_replace = AppiumBy.xpath("(//android.widget.RelativeLayout[@resource-id='com.fsn.nykaa:id/rl_wishlist'])[replace]");
}
