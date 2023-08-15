Feature: Editing an existent call case file


  @Smoke
  Scenario: Add classification to an existent call
    Given I am on GEMMA login page
    And I am able to enter username and password
    When I open a call case file
    Then I add the classification to a call case file