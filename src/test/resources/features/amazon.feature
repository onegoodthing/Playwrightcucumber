Feature: Amazon India Homepage and browsing mobiles phone
  Background:
    Given I open the "https://www.amazon.in/"

  Scenario Outline: Test home page

    Then the title should be "<pageTitle>"

    Examples:
      | pageTitle                              |
      | Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in |

    Scenario Outline: Open Amazon home page and search for oneplus mobile phone
      Then I click on "searchBar"
      And I enter "searchbar" with "<mobile>"
      Then I click on "searchButton"
      Then the title should be "<pageTitle>"
      Examples:
        | mobile                              | pageTitle|
        |  oneplus                            |Amazon.in : oneplus|

  Scenario Outline: Open Amazon home page and search for oneplus mobile phone and get all links on that page and verifying broken links
    Then I click on "searchBar"
    And I enter "searchbar" with "<mobile>"
    Then I click on "searchButton"
    Then the title should be "<pageTitle>"
    And I get all anchor tags on this page
    Examples:
      | mobile                              | pageTitle|
      |  oneplus                            |Amazon.in : oneplus|

  Scenario Outline: Open Amazon home page and search for oneplus mobile phone and get all links on that page and open in new tab
    Then I click on "searchBar"
    And I enter "searchbar" with "<mobile>"
    Then I click on "searchButton"
    Then the title should be "<pageTitle>"
    And I get all anchor tags on this page
    And I open all the links in new tabs
    Examples:
      | mobile                              | pageTitle|
      |  oneplus                            |Amazon.in : oneplus|
