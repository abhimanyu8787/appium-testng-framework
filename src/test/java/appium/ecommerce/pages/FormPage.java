package appium.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidGenericMethods {

    AndroidDriver driver;

    @AndroidFindBy(className = "android.widget.TextView")
    public WebElement countrySelectText;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

    @AndroidFindBy(id = "android:id/text1")
    public WebElement countrySelector;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    public WebElement genderSelectorMale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    public WebElement genderSelectorFemale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement letsShopButton;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void inputName(String name) {
        enterText(nameField, name);
    }

    public void setGender(String gender) throws Exception {
        if (gender.equalsIgnoreCase("Male"))
            click(genderSelectorMale);
        else
            click(genderSelectorFemale);
    }

    public void selectCountry(String countryName) throws Exception {
        click(countrySelector);
        scrollToText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
    }

    public ProductCatalogue submitForm() throws Exception {
        click(letsShopButton);
        return new ProductCatalogue(driver);
    }

}
