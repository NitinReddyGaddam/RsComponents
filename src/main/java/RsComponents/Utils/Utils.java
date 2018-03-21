package RsComponents.Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class   Utils extends BrowserFactory {

    WebDriverWait wait = new WebDriverWait(driver, AutomationConstants.TIMEOUT);


    public static void waitForIsAlertPresent(){
        Utils w=new Utils();
        w.wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForElementClickable(WebElement element) {
        Utils w=new Utils();
        w.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void handleAlert(){
        try{
            Alert alert=driver.switchTo().alert();
            alert.accept();

        }
        catch (Exception e){
            System.out.println("no alert found");
        }


    }



    public static void waitForElementVisible(WebElement element) {
        Utils w=new Utils();
        w.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void selectFromList(WebElement element, String text) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement we : options) {
            if (we.getText().equals(text)) {
                select.selectByVisibleText(text);
            }
        }
    }


    public static void mouseHoverAndClick(WebElement elementToHover, WebElement elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

    public static void scrollDownWebpage() {

        ((JavascriptExecutor) driver).executeScript("scroll(0,250)");
    }

    public static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementDisplay(final WebElement element, int time) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(time, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(new ExpectedCondition<Boolean>() {
                       @Override
                       public Boolean apply(WebDriver input) {
                           return element.isDisplayed();
                       }
                   }

        );

    }
    public static void closeOverlay() {
        try {
            boolean res = driver.findElement(By.cssSelector("a.acsCloseButton.acsAbandonButton[aria-label='Close Modal Box']")).isDisplayed();
            if (res == true) {
                driver.findElement(By.cssSelector("a.acsCloseButton.acsAbandonButton[aria-label='Close Modal Box']")).click();
            }
        }
        catch(Exception e){
            System.out.println("no overlay");
        }

    }
}

