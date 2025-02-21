Feature: Davy Careers page

  Background:
    Given I open the "https://www.davy.ie/working-at-davy/opportunities"

  Scenario Outline: Test home page

    Then the title should be "<pageTitle>"

    Examples:
      | pageTitle                              |
      | Explore Current Job Opportunities \| Davy |


  Scenario Outline: Open Wealth Management and check Titles of each page
    Then the title should be "<pageTitle>"
    Then I click on "openColoumn"
    Then I click on "wealthMangement"
    Then I click on "wealthMangmentSubmenu"
    Then the title should be "<wealthTitle>"
    Then I click on "bookconsulation"
    Then the title should be "<consultationTitle>"
    Examples:
      | pageTitle                              | wealthTitle|consultationTitle|
      | Explore Current Job Opportunities \| Davy | Wealth Management – Wealth Managers & Advisers Dublin, London, Belfast, Cork and Galway \| Davy| Let's start a conversation about wealth management \| Davy|

  Scenario Outline: I open book consultation and fill the form and cancels afterwards
    Then I click on "openColoumn"
    Then I click on "wealthMangement"
    Then I click on "wealthMangmentSubmenu"
    Then I click on "bookconsulation"
    And I enter "name" with "<name>"
    And I enter "phone" with "<phone>"
    And I enter "email" with "<email>"
    And I Select "No, I am not a Davy Client"
    And I Select "Up to €500K"
    And I Select "Investing"

    Examples:
    | name           | phone         | email           |
    | Rachel Green   |  3265487895   |   rg@hmail.com  |