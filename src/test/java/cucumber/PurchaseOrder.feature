
@tag
Feature: Purchase Order from ecommerse site
  I want to use this template for my feature file

 	Background:
 		Given I landed on ecommere page
 		

  @SubmitTest
  Scenario Outline: Positive scenario to place order
    Given Logged in with username <id> and password <pw>
    When I add the product name <product> to cart 
    And Checkout <product> and submit
    Then "THANKYOU FOR THE ORDER." message is displayed.

    Examples: 
      | id  						 |    pw 					 |  product  |
      | yamini@gmail.com | $Bynsunanda$410 |ZARA COAT 3|
     
