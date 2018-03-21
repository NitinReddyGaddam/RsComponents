package RsComponents.Pages;


import RsComponents.Utils.Utils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryPage extends BasePage {

    public DeliveryPage()
    {
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:CustomerContactDetailsWidgetAction_title_decorate']/span/select")
    private WebElement titleField;

    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:CustomerContactDetailsWidgetAction_firstName_decorate:CustomerContactDetailsWidgetAction_firstName']")
    private WebElement firstNameTextField;

    @FindBy(xpath =".//*[@id='deliveryCollectionForm:CustomerContactDetailsWidgetAction_surName_decorate:CustomerContactDetailsWidgetAction_surName']")
    private WebElement lastNameTextField;

    @FindBy(xpath= ".//*[@id='deliveryCollectionForm:CustomerContactDetailsWidgetAction_contactNumber_decorate:CustomerContactDetailsWidgetAction_contactNumber']")
    private WebElement contactNumberTextField;
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:GuestDeliveryAddressWidgetAction_companyNameOne_decorate:GuestDeliveryAddressWidgetAction_companyNameOne']")
    private WebElement companyTextField;
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:GuestDeliveryAddressWidgetAction_addressLineOne_decorate:GuestDeliveryAddressWidgetAction_addressLineOne']")
    private WebElement addressLine1TextField;
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:GuestDeliveryAddressWidgetAction_addressLineThree_decorate:GuestDeliveryAddressWidgetAction_addressLineThree']")
    private WebElement townTextField;
    @FindBy(xpath = ".//*[@id='deliveryCollectionForm:GuestDeliveryAddressWidgetAction_postCode_decorate:GuestDeliveryAddressWidgetAction_postCode']")
    private WebElement postCodeTextField;

    @FindBy(css= "#checkoutSecurelyBtn")
    private WebElement submitPayementButtonField;

    @FindBy(css="a.acsCloseButton.acsAbandonButton[aria-label='Close Modal Box']")
    public  WebElement surveyButton;


    public void setPrsonnelData()
    {
        try {
            Thread.sleep(3000);
             Utils.selectFromList(titleField,"Mrs.");
             firstNameTextField.sendKeys("Sahiti");
             lastNameTextField.sendKeys("Maryada");
             contactNumberTextField.sendKeys("0778899123");
             companyTextField.sendKeys("xyz");
             addressLine1TextField.sendKeys("12 Lonsdale street");
             townTextField.sendKeys("Leicester");
             postCodeTextField.sendKeys("Le1 3pj");
   } catch (InterruptedException e) {
        e.printStackTrace();
    }

    }

    public void submitPayment() {
        submitPayementButtonField.click();

    }
}
