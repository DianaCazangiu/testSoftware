Feature: GEMMA login

  @Smoke
Scenario Outline: Login to Web
    Given I am on GEMMA login page
    When I am able to enter username and password and "<role>"
    Then I Change background color

    Examples:
    |role|
#    |dispecer|
#    |receptor|
#    |TestSuperuserNoSuperviser|
    |TestSuperuserAndSuperviser|

    @GemmaNegativeTest
    Scenario: Login to Gemma negative test
        Given I am on GEMMA login page
        When I request access in GEMMA page
        Then I get an error message





