package RsComponents.Pages;

import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage
{
    public HomePage() {

        PageFactory.initElements(driver, this);
    }
    public boolean isOnHomePage() {

        return driver.getCurrentUrl().contains("uk.rs-online");
    }


}
