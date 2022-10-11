Feature: Search
  Scenario: Hotel rating
    Given Booking search page is opened
    When User enters hotel "Hilton Istanbul Bosphorus" title into the search field
    And User clicks on Search button
    Then Then "Hilton Istanbul Bosphorus" hotel exists on page
    And Hotel rating is "8.5"