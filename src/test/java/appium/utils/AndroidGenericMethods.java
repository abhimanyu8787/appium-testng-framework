package appium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import io.netty.handler.timeout.TimeoutException;

public class AndroidGenericMethods {

    protected AndroidDriver driver;
    private WebElement element = null;
    private WebElement dropdown = null;
    private Select selectList = null;
    private String old_win = null;
    private String latWinHandle;
    private List<WebElement> elementList;

    public AndroidGenericMethods(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Method to verify page title
     * 
     * @since: 13/02/2023
     * @author: abhimanyu_kumar
     * @param driver   : WebDriver : driver object
     * @param title    : String : expected title
     * @param contains : boolean : contains[true or false]
     * @throws Exception
     */
    public void checkTitle(String title, boolean contains) throws Exception {
        String pageTitle = getPageTitle();
        if (contains) {
            if (!pageTitle.equals(title))
                throw new Exception("Page Title Not Matched, Actual Page Title : " + pageTitle);
        } else {
            if (pageTitle.equals(title))
                throw new Exception("Page Title Matched, Actual Page Title : " + pageTitle);
        }
    }

    /**
     * Method to verify partial page title
     * 
     * @since: 13/02/2023
     * @author: abhimanyu_kumar
     * @param driver   : WebDriver : driver object
     * @param title    : String : expected title
     * @param contains : boolean : contains[true or false]
     * @throws Exception
     */
    public void checkPartialTitle(String partialTitle, boolean contains) throws Exception {
        String pageTitle = getPageTitle();
        if (contains) {
            if (!pageTitle.contains(partialTitle))
                throw new Exception("Partial Page Title Not PResent, Actual Page Title : " + pageTitle);
        } else {
            if (pageTitle.contains(pageTitle))
                throw new Exception("Partial Page Title Present, Actual Page Title : " + pageTitle);
        }
    }

    public void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        driver.hideKeyboard();
    }
    
    public void enterText(By locator, String text) throws Exception {
        waitForElementToClick(locator, "10");
        driver.findElement(locator).sendKeys(text);
        driver.hideKeyboard();
    }

    public void clearText(WebElement element) throws Exception {
        element.clear();
    }
    
    public void clearText(By locator) throws Exception {
        driver.findElement(locator).clear();
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }
    
    public String getElementText(By locator) throws Exception {
    	waitForElementToDisplay(locator, "10");
        return driver.findElement(locator).getText();
    }

    public String getElementAttribute(WebElement element, String attributeName) throws Exception {
        return element.getAttribute(attributeName);
    }
    
    public String getElementAttribute(By locator, String attributeName) throws Exception {
    	waitForElementToDisplay(locator, attributeName);
    	return driver.findElement(locator).getAttribute(attributeName);
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void clickElement(WebElement element) throws Exception {
        try {
            waitForElementToClick(element, "10");
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            String error = e.getMessage();
            throw new Exception("Error While Clicking on " + element, e);
        }
    }
    
    public void clickElement(By locator) throws Exception {
        try {
            waitForElementToClick(locator, "10");
            driver.findElement(locator).click();
        } catch (Exception e) {
            e.printStackTrace();
            String error = e.getMessage();
            throw new Exception("Error While Clicking on " + locator, e);
        }
    }

    public void click(int x, int y) {
        driver.executeScript("mobile: clickGesture",
                ImmutableMap.of("x", x, "y", y));
    }
    
    public void tap(int x, int y) {
        TouchAction ac = new TouchAction(driver);
        PointOption pointOptions = new PointOption().withCoordinates(x, y);
        ac.tap(pointOptions);
    }

    public void longPressAction(WebElement element) {
        driver.executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }

    /**
     * Method to perform double click operation on a WebElement
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param driver     : WebDriver : driver object
     * @param objectName : String : Object Name
     * @throws Exception
     */
    public void doubleClick(WebElement element, String objectName) throws Exception {

        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
    }
    
    public void doubleClick(By locator, String objectName) throws Exception {
    	waitForElementToClick(locator, "10");
    	element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
    }

    /**
     * Method to select element from Dropdown by type
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param select_list : Select : Select variable
     * @param byType      : String : Name of by type
     * @param option      : String : Option to select
     * @throws Exception
     */
    public void selectElementFromDropdownByType(Select select_list, String byType, String option) {
        if (byType.equals("selectByIndex")) {
            int index = Integer.parseInt(option);
            select_list.selectByIndex(index);
        } else if (byType.equals("value")) {
            select_list.selectByValue(option);
        } else if (byType.equals("text")) {
            select_list.selectByVisibleText(option);
        }
    }

    /**
     * Method to select element from dropdown list
     * 
     * @since: 11/02/2023
     * @author: abhimanyu_kumar
     * @param driver     : WebDriver : driver object
     * @param objectName : String : Object name
     * @param optionBy   : String : Name of by type
     * @param option     : String : Option to select
     * @throws Exception
     */
    public void selectOptionFromDropdown(WebElement dropdown, String optionBy, String option) throws Exception {

        selectList = new Select(dropdown);
        if (optionBy.equals("selectByIndex"))
            selectList.selectByIndex(Integer.parseInt(option) - 1);
        else if (optionBy.equals("value"))
            selectList.selectByValue(option);
        else if (optionBy.equals("text"))
            selectList.selectByVisibleText(option);
    }

    public void waitForElementToDisplay(WebElement element, String duration) throws Exception {
        WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(duration))));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitForElementToDisplay(By locator, String duration) throws Exception {
    	element = driver.findElement(locator);
        WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(duration))));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToClick(WebElement element, String duration) throws Exception {
        WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(duration))));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void waitForElementToClick(By locator, String duration) throws Exception {
        element = driver.findElement(locator);
    	WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(duration))));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method to execute autoItScript to upload file
     * 
     * @since: 05/03/2023
     * @author: abhimanyu_kumar
     * @param filePath   : String : Location of file which needs to be uploaded
     * @param scriptPath : String : Location of the autoItScript
     */
    public void uploadFile(String filePath, String scriptPath) {
        System.out.println("Started Execution of AutoIt Script: " + scriptPath);
        System.out.println("Uploading File: " + filePath);
        ProcessBuilder processBuilder = new ProcessBuilder(scriptPath, filePath);
        try {
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void handleAlert(String decision) {
        if (decision.equals("accept"))
            driver.switchTo().alert().accept();
        else
            driver.switchTo().alert().dismiss();
    }

    /**
     * Method to navigate forward or backwards
     * 
     * @since: 05/03/2023
     * @author: abhimanyu_kumar
     * @param driver    : WebDriver : driver object
     * @param direction : String : Navigate forward or backward
     */
    public void navigate(String direction) {
        if (direction.equalsIgnoreCase("back"))
            driver.navigate().back();
        else
            driver.navigate().forward();
    }
    
    public void pressKey(String key) {
    	switch (key) {
		case "Back":
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			break;

		default:
			break;
		}
    }

    /**
     * Method to scroll to a particular element
     * 
     * @since: 05/03/2023
     * @author: abhimanyu_kumar
     * @param driver     : WebDriver : driver object
     * @param objectName : String : Object name
     * @throws Exception
     */
    public void scrollToElement(WebElement element) throws Exception {
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement) element).getId(), "direction", "down", "percent", 0.75));
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

    public void scrollToGivenArea(int left, int top, int width, int height) {
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", left, "top", top,
                "width", width, "height", height, "direction", "down", "percent", 1.0));
    }

    public void swipeAction(WebElement element, double percent, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement) element).getId(), "direction", direction, "percent", percent));
    }

    public void swipeAction(int left, int top, int width, int height, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", left, "top", top,
                "width", width, "height", height, "direction", direction, "percent", 0.75));
    }

    /**
     * Method to press Backspace n number of times
     * 
     * @since: 05/03/2023
     * @author: abhimanyu_kumar
     * @param driver     : WebDriver : driver object
     * @param objectName : String : Object name
     * @param iteration  : Integer : Number of times, Backspace will be pressed
     */
    public void clickBackspaceButton(WebElement element, int iteration) throws Exception {
        for (int i = 0; i < iteration; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }

    }

    /**
     * Method to drag and drop an element from source location to destination
     * location
     * 
     * @since: 05/03/2023
     * @author: abhimanyu_kumar
     * @param driver                : WebDriver : driver object
     * @param sourceObjectName      : String : Source WebElement Name
     * @param destinationObjectName : String : Destination WebElement Name
     */
    public void dragAndDropElement(WebElement fromElement, WebElement toElement) throws Exception {

        Actions action = new Actions(driver);
        action.dragAndDrop(fromElement, toElement).build().perform();
        Thread.sleep(5000);
    }

    /**
     * Method to switch frame by index
     * 
     * @since: 05/03/2023
     * @author: abhimanyu_kumar
     * @param driver : WebDriver : driver object
     * @param index  : Integer : Source WebElement Name
     */
    public void switchFrameByIndex(int index) throws Exception {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            throw new Exception("iFrame is not available for the given index", e);
        }
    }

    /**
     * Method to switch frame by name or id
     * 
     * @since: 05/03/2023
     * @author: abhimanyu_kumar
     * @param driver   : WebDriver : driver object
     * @param nameOrId : String : Name or Id of iFrame
     */
    public void switchFrameByNameOrId(String nameOrId) throws Exception {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (Exception e) {
            throw new Exception("iFrame with name/id " + nameOrId + " not found", e);
        }
    }

    /**
     * Method to switch frame by WebElement
     * 
     * @since: 05/03/2023
     * @author: abhimanyu_kumar
     * @param driver     : WebDriver : driver object
     * @param objectName : String : Locator of the WebElement of frame
     */
    public void switchFrame(WebElement element) throws Exception {
        driver.switchTo().frame(element);
    }

    /**
     * Method to read data from excel
     * 
     * @since: 05/03/2023
     * @author: abhimanyu_kumar
     * @param driver       : WebDriver : driver object
     * @param sheet        : String : name of sheet in which data is supposed to be
     *                     read from
     * @param testCaseName : String : name of the row from which data is supposed to
     *                     be read
     * @param columnName   : String : name of the column from which data is supposed
     *                     to be read
     */
    public String readDataFromExcel(String excelFileName, String sheet, String testCaseName, String columnName)
            throws IOException {
        String filePath = "./src/test/resources/testData";
        String fileName = excelFileName;
        String sheetName = sheet;
        int rowNumber = 0;
        String cellValue = null;
        Workbook testWorkbook = null;

        File file = new File(filePath + "/" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        testWorkbook = new XSSFWorkbook(inputStream);
        Sheet testSheet = testWorkbook.getSheet(sheetName);
        int rowCount = testSheet.getLastRowNum() - testSheet.getFirstRowNum();
        try {
            for (int i = 0; i <= rowCount; i++) {
                Row row = testSheet.getRow(i);
                if (row.getCell(0).getStringCellValue().equals(testCaseName)) {
                    rowNumber = i;
                    break;
                }
            }

            int columnNumber = -1;
            Row row = testSheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
                    columnNumber = i;
                    break;
                }
            }

            row = testSheet.getRow(rowNumber);
            Cell cell = row.getCell(columnNumber);
            cellValue = cell.getStringCellValue();
            inputStream.close();
            testWorkbook.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("data was not found in testdata sheet");
            return null;
        }

        return cellValue;
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
    
    public boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
    
    public boolean waitForAllElementsToDisappear(By locator) {
    	int attempts=0;
    	while(attempts<3) {
    		try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				List<WebElement> allElements = driver.findElements(locator);
				return wait.until(ExpectedConditions.invisibilityOfAllElements(allElements));
			} catch (TimeoutException e) {
				return true;
			} catch (StaleElementReferenceException e) {
				//skip
			} catch (WebDriverException e) {
				//skip
			}
    		attempts++;
    	}
    	return false;
    }

}
