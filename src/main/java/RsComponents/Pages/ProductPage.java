package RsComponents.Pages;

import RsComponents.Utils.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends  BasePage {


    // Utils myUtility=new Utils();
    // ProductPage productPage=new ProductPage();
    public ProductPage()
    {

        PageFactory.initElements(driver, this);
    }


    @FindBy(css=".btn.btn-primary-red.btn-large.btn-add-to-basket")
    private WebElement addProductToBasketField;

    @FindBy(css=".add-to-basket-container")
    private WebElement addToBasketContainerField;

    @FindBy(css=".addToCartRTQContainer")
    private WebElement addToCartContainerField;
    @FindBy(css=".cart-added page-cart-added")
    private WebElement itemaddedcontainerField;
    @FindBy(xpath="//div[@class='addToCartRTQContainer']//div[@class='cart-added page-cart-added']//button[@type='button' and @class='btn btn-secondary-blue btn-large nav-view-cart']")
    private WebElement viewBasketButtonField;


    public void addItemToCart()

    {
        try {
            driver.switchTo().defaultContent();
          Thread.sleep(2000);
           if(addProductToBasketField.isEnabled())
            {
                driver.switchTo().defaultContent();
               Utils.scrollDownWebpage();
           Actions action = new Actions(driver);
           action.moveToElement(addProductToBasketField).build().perform();
            Utils.mouseHoverAndClick(addToCartContainerField,addProductToBasketField);
          }
          } catch (InterruptedException e) {
            e.printStackTrace();
       }



    }
    public void viewBasket()

    {


       try {
            Utils.scrollDownWebpage();
            driver.switchTo().defaultContent();
            Thread.sleep(3000);
            driver.switchTo().defaultContent();
           // myUtility.waitForElementDisplay(viewBasketButtonField,5);
            Actions actions = new Actions(driver);
            actions.moveToElement(viewBasketButtonField).click().perform();

        }catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}
