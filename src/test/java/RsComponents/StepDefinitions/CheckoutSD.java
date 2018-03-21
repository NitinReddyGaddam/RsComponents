package RsComponents.StepDefinitions;

import RsComponents.Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutSD {
    private HomePage homePage=new HomePage();
    private HeaderPage headerPage = new HeaderPage();
    private CheckOutPage checkout=new CheckOutPage();
    private ProductPage productPage=new ProductPage();
    private ResultPage resultPage=new ResultPage();
    private DeliveryPage deliveryPage=new DeliveryPage();
    private  PaymentPage paymentPage=new PaymentPage();

    @Given("^User is on the home page$")
    public void user_is_on_the_home_page()  {

        assertThat(homePage.isOnHomePage(), is(true));
    }

    @When("^I select on \"([^\"]*)\"$")
    public void i_select_on_something(String hoveritem)  {

        headerPage.hoverToMegaNavElements(hoveritem);
        headerPage.selectItemsFromNavOptions(hoveritem);

    }

    @When("^I select  \"([^\"]*)\"$")
    public void i_select_anitem(String item)  {
        headerPage.selectItemsFromNavOptions(item);

    }

    @When("^I select  \"([^\"]*)\" Category$")
    public void i_select_something_type(String category1)

    {
        headerPage.hoverToCatNavElements(category1);
        // headerPage.selectItemsFromNavOptions(category1);
    }
    @When("^I select a \"([^\"]*)\" subcategory$")
    public void i_select_a_something_subcategory(String subcategory2)  {
        headerPage.hoverToCatNavElements(subcategory2);

    }

    @When("^I select a product\"([^\"]*)\"$")
    public void i_select_a_productsomething(String product) {

        resultPage.selectProduct(product);
    }

    @When("^I select AddToBasket$")
    public void i_select_add() {
        productPage.addItemToCart();


    }
    @When("^I go to Basket$")
    public void i_go_to_basket()  {
        productPage.viewBasket();
    }


    @Then("^I should see \"([^\"]*)\" added in my basket$")
    public void seeProductInMyCart(String expectedProduct)
    {
        assertThat(checkout.seeProductInMyCart(expectedProduct),is(true));


    }

    @When("^I select checkout$")
    public void i_select_checkout()  {
        checkout.selectCheckOut();
    }
    @And("^I provide email address \"([^\"]*)\"$")
    public void i_provide_email_address_something(String email)  {

        checkout.setEmailAddress(email);
    }
    @When("^I select Guestcheckout$")
    public void i_select_guestcheckout()  {
        checkout.selectGuestCheckout();
    }
    @When("^I add delivery details$")
    public void i_add_delivery_detials()  {
        deliveryPage.setPrsonnelData();

    }

    @When("^I select payment$")
    public void i_select_payment() {
        deliveryPage.submitPayment();
    }

    @Then("^i should see payement page$")
    public void i_should_see_payement_page()  {

        assertThat(paymentPage.onPaymentPage(), is(true));
    }

    @When("^I select brands \"([^\"]*)\"$")
    public void i_select_brands_something(String brands)  {
        headerPage.selectBrands(brands);
    }

    @When("^I select category \"([^\"]*)\"$")
    public void i_select_category_something(String category)  {
        headerPage.selectPopularCategory(category);
    }

    @When("^I add product \"([^\"]*)\" to basket$")
    public void i_add_product_something_to_basket(String productname) {

        resultPage.addProductToBasket(productname);

    }



}
