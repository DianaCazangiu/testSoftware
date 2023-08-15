Feature: Working with an existing incident

	@Smoke
	Scenario: Link incident to other existent incident
	Given I am on GEMMA login page
	And I am able to enter username and password
	When I Open an incident case file
	Then I link the incident to other incident