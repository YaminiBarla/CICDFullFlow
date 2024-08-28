
@tag
Feature: Error Validation
  I want to use this template for my feature file

  

  @ErrorValidation
  Scenario Outline: Negative Scenario
  	Given I landed on ecommere page
    When Logged in with username <id> and password <pw>
    Then "Incorrect email or password." message is displayed on that page.


    Examples: 
      | id  						 |    pw 					 |
      | yamni@gmail.com | $Bynsunanda$410 | 
      
