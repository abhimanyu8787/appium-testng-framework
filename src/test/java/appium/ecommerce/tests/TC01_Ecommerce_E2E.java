package appium.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import appium.ecommerce.pages.CartPage;
import appium.ecommerce.pages.ProductCatalogue;
import appium.utils.AndroidBaseTest;

public class TC01_Ecommerce_E2E extends AndroidBaseTest{
    
    @Test
    public void fillForm() throws Exception {
        formPage.inputName("Abhimanyu Kumar");
        formPage.setGender("Male");
        formPage.selectCountry("India");
        ProductCatalogue productCatalogue = formPage.submitForm();
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);
        CartPage cartPage = productCatalogue.goToCartPage();
        
        double totalSum = cartPage.calculateTotalPriceOfProducts();
        double displayedTotalSum = cartPage.getTotalPurchaseAmount();
        
        Assert.assertEquals(displayedTotalSum, totalSum);
    }

}
