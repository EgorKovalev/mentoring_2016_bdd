Feature: Add to cart demo tests

  Scenario: Not logged in user add to cart
    Given Switch locale to English
    When I set search request "iPhone 4S"
    And I perform search
    And I select item "1" in the list
    And I click buy now button
    Then I verify that login page is displayed

  Scenario: Logged in user add a single product to cart
    Given Logged in user
    When I set search request "iPhone 4S"
    And I perform search
    And I select item "1" in the list
    And I click buy now button
    Then I verify that checkout page is displayed

  Scenario: Logged in user add multiple products to cart
    Given Logged in user
    When I set search request "iPhone 4S"
    And I perform search
    And I select item "1" in the list
    And I click buy now button
    And I go to cart
    And I set search request "Samsung Galaxy"
    And I perform search
    And I select item "1" in the list
    And I click buy now button
    And I go to cart
    Then I verify that the cart is not empty