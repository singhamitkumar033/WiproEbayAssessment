Feature: check WordPress Login Functinality with Different User 
Description: The purpose of this feature is to test the Background keyword

Background: To close the browser
And ggghjg
 When navigate to wordpress page
Scenario Outline: Title of your scenario 
	When user logged in using username as "<Username>" and password as "<password>"
	And rggggh
	Then home page should be displayed
	
	Examples: 
		|Username|password|
		|sumitsingh21|demo@5318|
#@Ignore
#Scenario Outline: Seach in WordPress
#	When user logged in using username as "<Username>" and password as "<password>"
#	Then home page should be displayed
#	When User enter the searchtext in wordPress SearchBox
#	
#	Examples: 
#		|Username|password|
#		|sumitsingh21|demo@5318|	
