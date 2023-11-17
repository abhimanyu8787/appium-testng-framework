package appium.nykaa.screenactions;

import appium.nykaa.screenobjects.NykaaProductPageScreenObject;
import io.appium.java_client.android.AndroidDriver;

public class NykaaProductPageScreenActions extends NykaaCommonScreenActions{

	public NykaaProductPageScreenActions(AndroidDriver driver) {
		super(driver);
	}
	
	NykaaProductPageScreenObject nykaaProductPage = new NykaaProductPageScreenObject();
	
	public void addProductToBag() throws Exception {
		clickElement(nykaaProductPage.productAddToBag);
	}
	
	public void addProductToWishlist() throws Exception {
		clickElement(nykaaProductPage.productAddToWishlist);
	}
	
	public String getProductName() throws Exception {
		return getElementText(nykaaProductPage.productName);
	}
	
	public String getRatingStars() throws Exception {
		return getElementText(nykaaProductPage.productRatingStars);
	}
	
	public String getRatingValue() throws Exception {
		return getElementText(nykaaProductPage.productRatingValue);
	}
	
	public String getRatingCount() throws Exception {
		return getElementText(nykaaProductPage.productRatingCount);
	}
	
	public String getSellerName() throws Exception {
		scrollToElementUsingSwipe(nykaaProductPage.productSoldBy);
		return getElementText(nykaaProductPage.productSoldBy);
	}
	
	public String getProductPrice() throws Exception {
		return getElementText(nykaaProductPage.productPrice);
	}
	
	public String getProductDiscount() throws Exception {
		return getElementText(nykaaProductPage.productDiscountPercentage);
	}

}
