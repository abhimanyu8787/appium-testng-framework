package appium.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidGenericMethods{
    
    AndroidDriver driver;
    
    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> productNamesList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPriceList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalPrice;
    
    double calculateTotalPriceOfProducts() {
        double sum = 0;
        for(WebElement element : productPriceList) {
            sum += Double.valueOf(element.getText().substring(2));
        }
        return sum;
    }
    
    double getTotalPurchaseAmount() throws NumberFormatException, Exception {
        return Double.valueOf(getElementText(totalPrice).substring(2));
    }

}
