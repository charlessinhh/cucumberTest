Feature: Login

@lvd
Scenario: Successful login with valid credentials
		Given User Launch chrome browser
		When User opens url "https://admin-demo.nopcommerce.com/login"
		And User enters Email as "admin@yourstore.com" and Password as "admin"
		And Click on Login
		Then Page Title should be "Dashboard / nopCommerce administration"
		When User Click on Log Out button
		Then Page Title should be "Your store. Login"
		And Close the browser 

@ldd
Scenario Outline: Login Data Driven
		Given User Launch chrome browser
		When User opens url "https://admin-demo.nopcommerce.com/login"
		And User enters Email as "<email>" and Password as "<password>"
		And Click on Login
		Then Page Title should be "Dashboard / nopCommerce administration"
		When User Click on Log Out button
		Then Page Title should be "Your store. Login"
		And Close the browser 
		
		Examples:
					| email | password |
					| admin1@yourstore.com  | admin123 |
					| admin@yourstore.com   | admin |
