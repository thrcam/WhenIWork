#Author: Tahir Cam (tahir.cam07@gmail.com)
Feature: Login

  Background: 
    Given user navigates to login page

  Scenario: Succesful Login
    When user puts in valid email address and valid password
    And user clicks on login button
    Then user should successfully log in and navigate to the dashboard
    And user logs out

  #achieving parameterization with Scenario Outline
  #login attempts with invalid user credentials
  Scenario Outline: Unsuccessful Login
    When user enters "<email_address>" and "<password>"
    And user clicks on login button
    Then user should get error message

    Examples: 
      | email_address         | password    |
      | tahir.cam07@gmail.com |  1234567890 |
      | tahir.cam07@gmail.com | dummyPass   |
      | tahir.cam07@gmail.com | abc1234567  |
      | tahir.cam07@gmail.com | 4bc@!3%15_  |
      | tahir.cam07@gmail.com | .           |
      | dummy@gmail.com       | tahir123456 |
      | dummy@outlook.com     | tahir123456 |
      | test123@test.com      | tahir123456 |
      | $test_&@gmail.co      | tahir123456 |
