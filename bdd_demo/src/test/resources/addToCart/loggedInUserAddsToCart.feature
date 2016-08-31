Feature: Add to cart demo tests

  Background:
    Given Switch locale to English
    When Logged in user

  Scenario: Logged in user add multiple products to cart
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

  Scenario: Logged in user add a single product to cart
    When I set search request "iPhone 4S"
    And I perform search
    And I select item "1" in the list
    And I click buy now button
    Then I verify that checkout page is displayed

  Scenario Outline: Logged in user add multiple products to cart with examples
    When I set search request "<product>"
    And I perform search
    And I select item "1" in the list
    And I click buy now button
    And I go to cart
    Then I verify that the cart is not empty

    Examples:
      | product          |
      | iPhone 4S        |
      | Samsung Galaxy   |
      | htc one m8       |

  Scenario Outline: Logged in user add a single product to cart with examples
    When I set search request "<product>"
    And I perform search
    And I select item "1" in the list
    And I click buy now button
    Then I verify that checkout page is displayed

    Examples:
      | product          |
      | iPhone 4S        |
      | Samsung Galaxy   |