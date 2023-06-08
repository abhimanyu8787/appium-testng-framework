package appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidGenericMethods {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement countrySelectText;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrySelector;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement genderSelectorMale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement genderSelectorFemale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShotButton;

    void inputName(String name) {
        enterText(nameField, name);
    }

    void setGender(String gender) throws Exception {
        if (gender.equalsIgnoreCase("Male"))
            click(genderSelectorMale);
        else
            click(genderSelectorFemale);
    }
    
    void selectCountry(String countryName) throws Exception {
        click(countrySelector);
        
    }

}
