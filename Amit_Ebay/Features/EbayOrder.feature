Feature: Login to Ebay to purchase a product 
	Description: Login to eBay mobile application and search for an item and add to cart and purchase it

Scenario: Title of your scenario
 	Given user launches the brouwser
 	When User clicks on humberger Menu ICon
 	And User moves to setting submenu	
 	And User select the country as 'Australia'
 	And User navigates back to Home Page
 	And User clicks on Sign-In Button
	When User logged in using username, password and click signIn Button
	Then User should see that home page is displayed
	When User serches for '65-inch TV'
	And User click on one of the TV's displayes except first and Last
	And User Add the Product to cart
    And User moves to cart Page
    Then User verify the name, Price and description of the product
	
	
	
	
