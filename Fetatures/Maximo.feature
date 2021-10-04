@smoketest 
Feature: As a user we need to create New Location in IBM Maximo application

Scenario: Successfully create location in IBM Maximo 
	Given user alredy in home page & verify the Page Title is "Start Center" 
	When user navigates to location page from go to button 
	And user navigate to Common Actions and click on create new location button 
	And user type and capture a new location name as "LO002" into location field 
	And user enter "This Location is for test Automation" into the Location description field 
	And user click on magnifying glass icon adjacent to Type text box under Location Field 
	Then user select "OPERATING" from the Type dialog box for Location 
	And user left mouse click on disk icon for Save Location within Maximo tool bar 
	Then user verify "Record has been saved" message appears