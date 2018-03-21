@Regression
Feature: Customer want to search and item and see  all products avaialble to purchase.


  #happy path scenario

  @filter1 @smoke
  Scenario: search an item by keyword
    Given customer see searchbox
    And customer type search item "AA-Battery"
    And customer select search
    And customer expand a "Brand" filter type
    And customer select a "Energizer" filter value
    Then I should see all respective products set to "Energizer"

  @filter2 @smoke
  Scenario: search an item by keyword
    Given customer see searchbox
    And customer type search item "AA-Battery"
    And customer select search
    And customer expand a "Brand" filter type
    And customer select a "Energizer" filter value
    And customer hover on Filter "Chemistry"
    And customer select a "Alkaline" from popup filter
    When customer Apply Filter
    Then I should see all respective products set to Chemistry "Alkaline"

    @filter3
    Scenario: search an item by keyword and apply 3 filters
      Given customer see searchbox
      And customer type search item "AA-Battery"
      And customer select search
      And customer expand a "Brand" filter type
      And customer select a "Energizer" filter value
      And customer hover on Filter "Chemistry"
      And customer select a "Alkaline" from popup filter
      And customer hover on Filter "Brand Range"
      And customer select a "Energizer MAX" from popup filter
      When customer Apply Filter
      Then I should see all respective products set to Brand Range "Energizer MAX"


      


