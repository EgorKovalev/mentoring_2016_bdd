Feature: Demo examples

  Scenario:Running a Full Text Quick Search
    Given I set search request "iPhone 4S"
    When I perform search
    Then the term query "iPhone 4S" should be the first in the Search Result grid

  Scenario Outline: Running a Full Text Quick Search
    Given I set search request "<request>"
    When I perform search
    Then the term query "<request>" should be the first in the Search Result grid

    Examples:
      | request        |
      | iPhone 4S      |
      | Samsung Galaxy |
