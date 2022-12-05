Feature: Customers

Scenario: Add a new Customer
		Given User Launch chrome browser
		When User opens url "https://admin-demo.nopcommerce.com/login"
		And User enters Email as "admin@yourstore.com" and Password as "admin"
		And Click on Login
		Then User can View Dashboard
		When User click on Customers menu
		And User click on Customers menu Item
		And User click on Add new button
		Then user can view Add new customer page
		When User enter customer info
		And click on Save button
		Then user can view confirmation message "The new customer has been added successfully."  
		And User Click on Log Out button
		And Close the browser 
		