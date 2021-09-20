package hitoriaDeUsuario.page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Driver;

import java.io.IOException;


public class BasePage extends Driver {
    protected WebDriverWait wait;
    protected WebDriver webDriver;
    protected JavascriptExecutor jsExecutor;

    public BasePage() throws IOException {
        this.wait = new WebDriverWait(driver, 600);
        jsExecutor = ((JavascriptExecutor) driver);
    }

    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean WaitUntilWebElementIsVisibleBy(By by) {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + by.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public void waitAndClickElement(WebElement element) {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
            attempts++;
        }
    }

    public void waitAndClickElementsUsingByLocator(By by) throws InterruptedException {
        boolean clicked = false;
        int attempts = 0;
        while (!clicked && attempts < 10) {
            try {
                this.wait.until(ExpectedConditions.elementToBeClickable(by)).click();
                clicked = true;
            } catch (Exception e) {
                System.out.println("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
                Assert.fail("Unable to wait and click on the element using the By locator, element: " + "<"+ by.toString() + ">");
            }
            attempts++;
        }
    }

    public void sendKeysToWebElement(WebElement element, String textToSend) throws Exception {
        try {
            this.WaitUntilWebElementIsVisible(element);
            element.clear();
            element.sendKeys(textToSend);
        } catch (Exception e) {
            System.out.println("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + textToSend);
            Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
    }

    public String getTextToWebElement(WebElement element) throws Exception {
        String textWebElement="";
        try {
            this.WaitUntilWebElementIsVisible(element);
            textWebElement=element.getText();
        } catch (Exception e) {
            System.out.println("Unable to locate WebElement: " + "<" + element.toString() );
            Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
        }
        return textWebElement;
    }

    public String getXpath(WebElement element){
        String str= element.toString();
        String result= str.substring(str.indexOf("//"),str.length()-1);
        //System.out.println("GetXpath: "+ result);
        return  result;
    }

    public String replaceLabelXpath(WebElement webElement,String lbl){
        String xpath= getXpath(webElement);
        xpath= xpath.replace("@label",lbl);
        //System.out.println("GetXpath: "+ xpath);
        return xpath;
    }

}
