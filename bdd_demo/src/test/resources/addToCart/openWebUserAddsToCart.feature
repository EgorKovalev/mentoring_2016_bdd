Feature: Open web user adds to cart demo tests

  Scenario: Not logged in user add to cart
   Given Switch locale to English
   When I set search request "iPhone 4S"
   And I perform search
   And I select item "1" in the list
   And I click buy now button
   Then I verify that login page is displayed
