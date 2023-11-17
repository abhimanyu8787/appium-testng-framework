package appium.nykaa.screenactions;

import appium.nykaa.pojos.ProductCard;
import appium.nykaa.screenobjects.NykaaProductListScreenObject;
import io.appium.java_client.android.AndroidDriver;

public class NykaaProductListScreenActions extends NykaaCommonScreenActions{
	
	NykaaProductListScreenObject nykaaProductListScreen = new NykaaProductListScreenObject();
	
	public NykaaProductListScreenActions(AndroidDriver driver) {
		super(driver);
	}
	
	public String getShoppingPageSearchTitle() throws Exception {
		return getElementText(nykaaProductListScreen.productListPageHeading);
	}
	
	public String getResultsCount() throws Exception {
		return getElementText(nykaaProductListScreen.productListPageResultCount);
	}
	
	public void scrollToProduct(String productIndex) {
		scrollToElementUsingSwipe(replaceAndCreateCustomLocator(nykaaProductListScreen.productCardImage_replace, productIndex));
	}
	
	public ProductCard getProductCardDetails(String productIndex) throws Exception {
		ProductCard product = new ProductCard();
		scrollToProduct(productIndex);
		String productName = getElementText(replaceAndCreateCustomLocator(nykaaProductListScreen.productCardTitle_replace, productIndex));
		String productPrice = getElementText(replaceAndCreateCustomLocator(nykaaProductListScreen.productCardPrice_replace, productIndex));
		String productDiscountPercentage = getElementText(replaceAndCreateCustomLocator(nykaaProductListScreen.productCardDiscount_replace, productIndex));
		String productRating = getElementText(replaceAndCreateCustomLocator(nykaaProductListScreen.productCardStarRating_replace, productIndex));
		String productRatingCount = getElementText(replaceAndCreateCustomLocator(nykaaProductListScreen.productCardStarRating_replace, productIndex));
		product.setProductTitle(productName);
		product.setProductPriceOrignal(productPrice.split(" ")[1]);
		product.setProductPriceAfterDiscount(productPrice.split(" ")[0]);
		product.setProductDiscountPercentage(productDiscountPercentage);
		product.setProductRating(productRating);
		product.setProductRatingCount(productRatingCount);
		return product;
	}
	
	public void addToBag(String productIndex) throws Exception {
		scrollToProduct(productIndex);
		clickElement(replaceAndCreateCustomLocator(nykaaProductListScreen.productCardAddToBagBtn_replace, productIndex));
	}
	
	public void addToWishlist(String productIndex) throws Exception {
		scrollToProduct(productIndex);
		clickElement(replaceAndCreateCustomLocator(nykaaProductListScreen.productCardAddToWishlistBtn_replace, productIndex));
	}
	
	public NykaaProductPageScreenActions clickProduct(String productIndex) throws Exception {
		scrollToProduct(productIndex);
		clickElement(replaceAndCreateCustomLocator(nykaaProductListScreen.productCardImage_replace, productIndex));
		return new NykaaProductPageScreenActions(driver);
	}

}
