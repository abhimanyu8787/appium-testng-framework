package appium.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidGenericMethods {

    AndroidDriver driver;

    public ProductCatalogue(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;
    
    public void addItemToCartByIndex(int index) {
        addToCart.get(index).click();
    }
    
    public CartPage goToCartPage() throws Exception {
        click(cart);
        Thread.sleep(2000);
        return new CartPage(driver);
    }

}
