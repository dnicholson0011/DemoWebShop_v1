Feature: Login functionality
  As a user
  I want to be able to login to the website
  So that I can access my account and place orders

  Scenario: Successful login
    Given the user is on the login page
    When the user enters a valid email and password
    And clicks the login button
    Then the user should be redirected to the home page

#  Scenario: Unsuccessful login
#    Given the user is on the login page
#    When the user enters an invalid email and password
#    And clicks the login button
#    Then the user should see an error message
