Feature: Call creation for training

  @Smoke
  Scenario: Call creation for training
    Given I am on GEMMA login page test
    And I am able to enter username and password for test training
    And I am able to enter the role
    When I Create a call file for training test
    Then I enter the data

  @Smoke
  Scenario: Retrieve final count from Oracle database
    Given I connect to database
    When I check into data table
    Then I retrieve the final count number for the new data