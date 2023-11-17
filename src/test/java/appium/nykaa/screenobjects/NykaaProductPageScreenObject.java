package appium.nykaa.screenobjects;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class NykaaProductPageScreenObject extends NykaaCommonScreenObject{
	
	public final By productName = AppiumBy.id("com.fsn.nykaa:id/product_title_text");
	public final By productRatingStars = AppiumBy.id("com.fsn.nykaa:id/imgsec_avg_ratings_bar");
	public final By productRatingValue = AppiumBy.id("com.fsn.nykaa:id/imgsec_product_ratingreview");
	public final By productRatingCount = AppiumBy.id("com.fsn.nykaa:id/imgsec_product_rating_count");
	public final By productPrice = AppiumBy.id("com.fsn.nykaa:id/tv_product_price_text");
	public final By productDiscountPercentage = AppiumBy.id("com.fsn.nykaa:id/tv_product_discount");
	public final By productSoldBy = AppiumBy.id("com.fsn.nykaa:id/tv_sold_by");
	public final By productShareBtn = AppiumBy.id("com.fsn.nykaa:id/share_lottie");
	public final By productAddToBag = AppiumBy.id("com.fsn.nykaa:id/tv_add_to_bag");
	public final By productAddToWishlist = AppiumBy.id("com.fsn.nykaa:id/iv_wish_img_1");
	public final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

}
