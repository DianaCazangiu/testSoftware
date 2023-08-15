Feature: Follow a call created by other operator

  @Smoke
  Scenario: Follow a call created by other operator
    Given I am on GEMMA login page
    And I am able to enter username and password
    When I Open the calls list
    Then I follow a call from the list