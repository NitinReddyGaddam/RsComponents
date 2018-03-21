package RsComponents.Pages;

import RsComponents.Utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends  BasePage {

    public SearchPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="searchTerm")
    private WebElement searchBoxTextField;

    @FindBy(id= "btnSearch")
    private WebElement submitSearchField;


    public boolean searchBoxIsDisplayed()
    {

        return(searchBoxTextField.isDisplayed());
    }
    public void setSearchItem(String text)
    {
        searchBoxTextField.sendKeys(text);

    }
    public void submitSearch()
    {
        submitSearchField.click();
    }


    public void expandFilterType(String type)
    {
        List<WebElement> expandFilterTypes = driver.findElements(By.xpath(".//*[@id='brandLinkArea']/div[1]"));
        System.out.println(expandFilterTypes.size());
        for (WebElement expandFilterType : expandFilterTypes) {
            if (expandFilterType.getText().contains(type)) {
                driver.switchTo().defaultContent();
                 expandFilterType.click();
                    break;
                }
            }

        }


    public void selectFilter(String filtervalue)
    {
        List<WebElement> filterOptions = driver.findElements(By.cssSelector(".brandLink>a"));

        for (WebElement filterOption : filterOptions) {
            if (filterOption.getText().contains(filtervalue)) {
                filterOption.click();

                break;
            }
        }
    }
    public List<String> getBrandForAllProducts()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elements = driver.findElements(By.cssSelector(".secondarySearchLink"));
        List<String> allProductBrandList = new ArrayList();
        System.out.println("elements" + elements.size());
        for (WebElement element : elements) {
            String brandInString = element.getText();
            allProductBrandList.add(brandInString);
        }

        return allProductBrandList;
    }

    public void selectPopUpFilter(String value) {
        List<WebElement> filterOptions = driver.findElements(By.cssSelector(".checkbox>label"));

        for (WebElement filterOption : filterOptions) {
            Actions actions = new Actions(driver);
            driver.switchTo().defaultContent();
            if (filterOption.getText().contains(value)) {
                filterOption.click();

                break;
            }
        }
    }
}

