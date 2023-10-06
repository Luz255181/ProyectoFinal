#Author: M. Luz Cabral
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Buy items
  as a user I want to be able to add two or more products to the cart and proceed with the purchase by placing the order

	Scenario: Buy two or more items
		Given I am on the web page
		When I add two or more items to the cart
		And I click "Place Order" button
		And I complete de form
		Then the page show a confirmation message
		And The information in the confirmation message is correct