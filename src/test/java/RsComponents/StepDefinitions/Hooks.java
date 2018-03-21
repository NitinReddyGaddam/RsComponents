package RsComponents.StepDefinitions;

import RsComponents.Pages.BasePage;
import RsComponents.Pages.DeliveryPage;
import RsComponents.Utils.BrowserFactory;
import RsComponents.Utils.Utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BasePage {


    Scenario scenario;

    @Before
    public void startUp() {

        BrowserFactory.startBrowser();
        maximiseBrowser();
        Utils.closeOverlay();


    }

    @After
  public void closeUp(){

       BrowserFactory.stopBrowser();
    }


}
