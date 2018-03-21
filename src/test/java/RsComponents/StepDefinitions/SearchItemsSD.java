package RsComponents.StepDefinitions;

import RsComponents.Pages.ProductPage;
import RsComponents.Pages.ResultPage;
import RsComponents.Pages.SearchPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchItemsSD {
    public ProductPage productPage=new ProductPage();
    public SearchPage searchPage=new SearchPage();
    public ResultPage resultPage=new ResultPage();

    @Given("^customer see searchbox$")
    public void customer_see_searchbox() {

        assertThat(searchPage.searchBoxIsDisplayed(), is(true));
    }

    @When("^customer type search item \"([^\"]*)\"$")
    public void customer_type_search_item_something(String searchitem) {
        searchPage.setSearchItem(searchitem);
    }

    @When("^customer select search$")
    public void customer_select_search() {
        searchPage.submitSearch();
    }



    @When("^customer expand a \"([^\"]*)\" filter type$")
    public void customer_expand_a_something_filter_type(String type)  {
        searchPage.expandFilterType(type);
    }

    @And("^customer select a \"([^\"]*)\" filter value$")
    public void customer_select_a_something_filter_value(String filtervalue) {

        searchPage.selectFilter(filtervalue);
    }

    @When("^customer hover on Filter \"([^\"]*)\"$")
    public void customer_hover_on_Filter(String filtervalue) {
        // Write code here that turns the phrase above into concrete actions
        resultPage.hoverOnProductFilter(filtervalue);
    }
    @When("^customer select a \"([^\"]*)\" from popup filter$")
    public void customer_select_a_something_from_popup_filter(String value)  {

        searchPage.selectPopUpFilter(value);
    }


    @When("^customer Apply Filter$")
    public void customer_Apply_Filter() {
        resultPage.submitApplyFilter();

    }
    @Then("^I should see all respective products set to \"([^\"]*)\"$")
    public void i_should_see_all_respective_products_set_to_something(String  filtervalue)  {
        boolean actualList = resultPage.checkDescForAllProducts(filtervalue);

        assertThat(actualList, is(true));


    }
    @Then("^I should see all respective products set to Chemistry \"([^\"]*)\"$")
    public void i_should_see_all_respective_products_set_to_Chemistry(String  filtervalue)  {
        boolean actualList = resultPage.checkAllProductsByChemistryFilter(filtervalue);
        assertThat(actualList, is(true));


    }


    @Then("^I should see all respective products set to Brand Range \"([^\"]*)\"$")
    public void iShouldSeeAllRespectiveProductsSetToBrandRange(String filterValue)  {
        boolean actualList = resultPage.checkAllProductsByChemistryFilter(filterValue);
        assertThat(actualList, is(true));
    }
}
