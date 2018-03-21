package RsComponents.Pages;

import RsComponents.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage extends  BasePage {



    public CheckOutPage()
    {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "iframe#_fsCtrlFr._FSFRAME_")
    private WebElement iframeField;

    @FindBy(css = "iframe#lpSS_16988771192")
    private WebElement iframeLoginField;

    @FindBy(css = "#checkoutSecurelyAndPuchBtn")
    private WebElement clickProceedToCheckoutButton;

    @FindBy(css= "#guestCheckoutForm>div>div>span>div>input")
    private WebElement emailTxtField;

    @FindBy(css = ".loginBtn>input[value='Guest checkout']")
    private WebElement guestCheckoutRedButtonField;

    public boolean seeProductInMyCart(String text) {
        Actions actions = new Actions(driver);
        driver.switchTo().defaultContent();

        Boolean status=false;

        List<WebElement> Search= driver.findElements(By.cssSelector("a.link2"));

        for (WebElement element:Search )
        {
            if (element.getText().equalsIgnoreCase(text)) {

                Utils.waitForElementVisible(element);
                 status=true;

            }

        }
        return status;
    }

    public void selectCheckOut() {
        Actions actions = new Actions(driver);
        driver.switchTo().defaultContent();
        actions.moveToElement(clickProceedToCheckoutButton).click().perform();
    }

    public void setEmailAddress(String email) throws NoAlertPresentException{
        try {

            Actions actions = new Actions(driver);
            driver.switchTo().defaultContent();
            if(emailTxtField.isEnabled()) {
                Thread.sleep(3000);
                Actions action = new Actions(driver);
                action.moveToElement(emailTxtField).build().perform();
                Utils.waitForElementVisible(emailTxtField);
                Utils.handleAlert();
                emailTxtField.sendKeys(email);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void selectGuestCheckout() {

        driver.switchTo().defaultContent();
        if(guestCheckoutRedButtonField.isEnabled()) {
            guestCheckoutRedButtonField.click();
        }
        driver.switchTo().defaultContent();
    }

}