@Sanity
Feature: User able to login with valid username & password 

	Description: "User login zoopla web site, search the property &"
        "select the property as well as verify the property price."  
              
Scenario:
User can login the application, search the fifth number property & verify the price 

	Given Users able to verify successfully login & verify the homepage title as "MyZoopla - Zoopla"
	When Users can mouse hover left corner top on the page for sale under the for sale & select UK property for sale 
	And Users able to  enter location as  "New York, Lincolnshire" in text box
	And Users can search the property & verify the price 
	And Users able to print all property value/price in consule and click on thard property 
	And Users click on the fifth number of property & print out the property address 
	Then Users can Verify the price of the property 
	
	
	
	