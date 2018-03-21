package RsComponents.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage
{
    public static WebDriver driver;
    //Create Constructor
    public BasePage(){
        PageFactory.initElements(driver, this);
    }
    //Getting currentUrl
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    //Getting title
    public String getTitle(){
        return driver.getTitle();
    }
    //maximise browser

    public void maximiseBrowser()
{

    driver.manage().window().maximize();
}
}
