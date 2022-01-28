package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import pages.Home;

import java.util.*;

public class Parent {

    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions actions;
    private static WebDriver driver;

    public Parent() {
        wait = new WebDriverWait(Drivers.getDriver(), 15);
        js = (JavascriptExecutor) Drivers.getDriver();
        actions = new Actions(Drivers.getDriver());
    }

    public void clickElement(WebElement element) { // scrolls to element and click on it
        scrollToElement(element);
        waitUntilClickable(element);
        element.click();
    }

    public void scrollToElement(WebElement element) { // scrolls to element
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void waitUntilClickable(WebElement element) { // waits until the element to be able to be clicked
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(WebElement element) { // waits until the element to be able to be seen
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sendKeys(WebElement element, String input) { // scrolls to element, clears the previous input and sends the new input
        scrollToElement(element);
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(input);
    }

    public void assertMessage(WebElement element, String message) { // asserts a webelement's text contains message
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().trim().contains(message));
    }

    public void assertMessage(WebElement element, String messageDE, String messageTR, String messageEN) { // asserts a webelement's text contains message
        waitUntilVisible(element);
        switch (Drivers.threadLanguage.get()) {
            case "DE":
                assertMessage(element, messageDE);
                break;
            case "TR":
                assertMessage(element, messageTR);
                break;
            case "EN":
                assertMessage(element, messageEN);
                break;
        }
    }

    public void assertUrl(String urlPart) { // asserts if the url contains a String
        Assert.assertTrue(Drivers.getDriver().getCurrentUrl().contains(urlPart));
    }

    public void assertUrl(String urlPartDE, String urlPartTR, String urlPartEN) {
        switch (Drivers.threadLanguage.get()) {
            case "DE":
                assertUrl(urlPartDE);
                break;
            case "TR":
                assertUrl(urlPartTR);
                break;
            case "EN":
                assertUrl(urlPartEN);
                break;
        }
    }

    public int randomIndexForLists(List<WebElement> list) { // generates random index
        return (int) (Math.random() * list.size());
    }

    public void clickRandomlyFromAList(List<WebElement> list) { // clicks an element from a list randomly
        list.get(randomIndexForLists(list)).click();
    }

    public void hoverOverRandomlyOnAnElement(List<WebElement> list) { // hovers over an element of a list randomly
        actions.moveToElement(list.get(randomIndexForLists(list))).build().perform();
    }

    public void hoverOverRandomlyOnAnElement(WebElement element) { // hovers over an element
        actions.moveToElement(element).build().perform();
    }

    public void javaScriptClick(WebElement element) {
        scrollToElement(element);
        waitUntilClickable(element);
        JavascriptExecutor executor = (JavascriptExecutor) Drivers.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void navigateToUrl(String language) {
        driver = Drivers.getDriver();
        switch (language) {
            case "TR":
                driver.get("https://www.mevlanacay.de/tr");
                break;
            case "EN":
                driver.get("https://www.mevlanacay.de/en");
                break;
            case "DE":
                driver.get("https://www.mevlanacay.de/");
                break;
        }
        Home hm = new Home();
        hm.waitUntilVisible(hm.getHome_cookise_accept());
        hm.clickElement(hm.getHome_cookise_accept());
    }

    public void switchToNewTab() {
        String homePageID = Drivers.getDriver().getWindowHandle();
        Set<String> windowIds = Drivers.getDriver().getWindowHandles();
        for (String id : windowIds) {
            if (id.equals(homePageID)) continue;

            Drivers.getDriver().switchTo().window(id);
        }
    }

    public void options_actions(WebElement element, WebDriver driver) {
        actions.moveToElement(element).sendKeys(Keys.ENTER).build().perform();
    }
}
