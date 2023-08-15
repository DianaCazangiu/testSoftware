Feature: Call creation on GEMMA

  @Smoke
  Scenario Outline: Call creation
    Given I am on GEMMA login page
    And I am able to enter username and password
    When I Create a call file
    Then I enter the "<victim>" data
    #Then I am able to logout

  Examples:
    |victim|
    #|victim1|
    #|victim2|
    |victim3|

