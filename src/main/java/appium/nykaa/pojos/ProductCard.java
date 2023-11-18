package appium.nykaa.pojos;

public class ProductCard {
	
	private String productTitle;
	private String productBrand;
	private String productPriceOrignal;
	private String productPriceAfterDiscount;
	private String productDiscountPercentage;
	private String productRating;
	private String productRatingCount;
	
	public String getProductTitle() {
		return productTitle;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductPriceOrignal() {
		return productPriceOrignal;
	}
	public void setProductPriceOrignal(String productPriceOrignal) {
		this.productPriceOrignal = productPriceOrignal;
	}
	public String getProductPriceAfterDiscount() {
		return productPriceAfterDiscount;
	}
	public void setProductPriceAfterDiscount(String productPriceAfterDiscount) {
		this.productPriceAfterDiscount = productPriceAfterDiscount;
	}
	public String getProductDiscountPercentage() {
		return productDiscountPercentage;
	}
	public void setProductDiscountPercentage(String productDiscountPercentage) {
		this.productDiscountPercentage = productDiscountPercentage;
	}
	public String getProductRating() {
		return productRating;
	}
	public void setProductRating(String productRating) {
		this.productRating = productRating;
	}
	public String getProductRatingCount() {
		return productRatingCount;
	}
	public void setProductRatingCount(String productRatingCount) {
		this.productRatingCount = productRatingCount;
	}
	
	@Override
	public String toString() {
		return "ProductCard [productTitle=" + productTitle + ", productBrand=" + productBrand + ", productPriceOrignal="
				+ productPriceOrignal + ", productPriceAfterDiscount=" + productPriceAfterDiscount
				+ ", productDiscountPercentage=" + productDiscountPercentage + ", productRating=" + productRating
				+ ", productRatingCount=" + productRatingCount + "]";
	}

}
