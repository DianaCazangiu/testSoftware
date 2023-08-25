Feature: GEMMA login training

  @Smoke
  Scenario: Login to Web test training
    Given I am on GEMMA login page test
    When I am able to enter username and password for test training
    And I am able to enter the role
    #Then I Change background color for test training