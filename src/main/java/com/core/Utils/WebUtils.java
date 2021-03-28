package com.core.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class WebUtils {

    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static WebElement getElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public static WebElement getElement(WebElement element, String tagName) {
        return element.findElement(By.tagName(tagName));
    }

    public static List<WebElement> getElements(WebDriver driver, By locator) {
        return driver.findElements(locator);
    }

    public static void elementClick(WebElement element) {
        element.click();
    }

    public static boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public static boolean isDisplayed(WebDriver driver, By locator) {
        if (getElements(driver, locator).size() == 0)
            return false;
        else {
            return getElement(driver, locator).isDisplayed();
        }
    }

    public static String getAttributeValue(WebElement element, String name) {
        return element.getAttribute(name);
    }

    public static void enterKeys(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static List<WebElement> waitUntilElementsAreVisible(WebDriver driver, By locator, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void scrollByXYcoordinate(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(a,b)"
                .replace("a", String.valueOf(x))
                .replace("b", String.valueOf(y)));
    }

    public static void javascriptClick(WebDriver driver, WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        HelperUtils.doWait(Thread.currentThread(), 500);
    }

    public static void goToUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public static By getLocatorFromXpath(String name) {
        return By.xpath(name);
    }

    public static String get1stChildWindowIDs(WebDriver driver) {
        return driver.getWindowHandles().stream().collect(Collectors.toList())
                .get(1);
    }

    public static boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }
}
