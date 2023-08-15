Feature: Incident creation on GEMMA

  @IncidentCreation @Smoke
  Scenario: Incident file creation
    Given I am on GEMMA login page
    And I am able to enter username and password
    When I Create an incident case file
    Then I enter the victim data for incident


  @Smoke @IncidentEdit
  Scenario: Add resource to a incident case file
    Given I am on GEMMA login page
    And I am able to enter username and password
    When I Open an incident case file
    Then I assign resources to an incident case file