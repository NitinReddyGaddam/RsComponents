package RsComponents.Pages;

import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    public PaymentPage()
    {
        PageFactory.initElements(driver, this);

    }

    public boolean onPaymentPage()
    {
         return driver.getCurrentUrl().contains("payment");
    }
}
