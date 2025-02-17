Feature: Davy Careers page

  Scenario Outline: Test home page
    Given I open the "<url>"
    Then the title should be "<pageTitle>"

    Examples:
      | url                                               | pageTitle                              |
      | https://www.davy.ie/working-at-davy/opportunities | Explore Current Job Opportunities \| Davy |
