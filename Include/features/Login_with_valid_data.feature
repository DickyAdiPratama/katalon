#Author: your.email@your.domain.com
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
@tag
Feature: Login

  @valid
  Scenario Outline: Login with valid data
    Given I navigate to Cura System homepage
    When I click Make Appointment buttton
    And I enter valid username <username> and password <password>
    And I click button Login
    Then I should be able to Login successfully and verify homepage

    Examples: 
      |username|password|
      |John Doe|ThisIsNotAPassword|
