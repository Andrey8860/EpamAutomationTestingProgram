Feature: Google Cloud Search

	@Smoke
	Scenario: Google Cloud Home Page search returns results
		Given I am on the Google Cloud Home Page
		When I search for the "Google Cloud Price Calculator"
		Then Search results are available
