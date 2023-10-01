package appium.goibibo.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appium.utils.AndroidGenericMethods;
import appium.utils.EnumClass.BookCategory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends CommonScreen {

	AndroidDriver driver;

	private final By categories_replace = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='replace']");
	private final By popup_advertisement = AppiumBy.id("com.goibibo:id/pip_view");
	private final By advertisement_close_button = AppiumBy.id("com.goibibo:id/close");
	private final By advertisement_expand_button = AppiumBy.id("com.goibibo:id/close");

	public HomeScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void closeAdPopUp() throws Exception {
		if (isElementDisplayed(popup_advertisement))
			clickElement(advertisement_close_button);
	}

	public TrainBookingScreen selectCategoryTrain() throws Exception {
		clickElement(replaceAndCreateCustomLocator(categories_replace, "trains"));
		return new TrainBookingScreen(driver);
	}

}
