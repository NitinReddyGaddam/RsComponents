@Regression
Feature: I want to add item to cart and  purchase item

  Background:
    Given User is on the home page

  #happy path scenario
@test
  @checkout1 @smoke
  Scenario: Add product to cart
    When I select on "All Products"
    And I select  "Batteries"
    And I select  "Non-Rechargeable Batteries" Category
    And I select a "C Batteries" subcategory
    And I select a product"Energizer Industrial Alkaline C Battery"
    When I select AddToBasket
    And I go to Basket
    Then I should see "Energizer Industrial Alkaline C Battery" added in my basket
    When I select checkout
    And I provide email address "srd120412@gmail.com"
    And I select Guestcheckout
    And I add delivery details
    When I select payment
    Then i should see payement page

  @checkout2 @smoke
  Scenario: Add product to cart
    When I select on "Our Brands"
    And I select brands "Fluke"
    And I select category "Digital Multimeters"
    And I add product "Fluke 115 Handheld Digital Multimeter, 10A ac 600V ac 10A dc 600V dc" to basket
    When I select AddToBasket
    And I go to Basket
    Then I should see "Fluke 115 Handheld Digital Multimeter, 10A ac 600V ac 10A dc 600V dc" added in my basket
    When I select checkout
    And I provide email address "srd120412@gmail.com"
    And I select Guestcheckout
    And I add delivery details
    When I select payment
    Then i should see payement page
