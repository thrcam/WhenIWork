#Author: Tahir Cam (tahir.cam07@gmail.com)
Feature: Add Employee

  Background: 
    Given user navigates to login page
    And user puts in valid email address and valid password
    And user clicks on login button
    And user should successfully log in and navigate to the dashboard

  #achieving parameterization with Data Table
  #adding employees
  Scenario: Successful Employee Add
    When user navigates to employees page
    And user hits add employee button
    And user enters employee details and saves the record
      | FirstName | LastName | Email               | MobileNumber | HourlyRate | MaxHours | EmployeeID | TimeZone     |
      | Barbara   | Goodwin  | b_goodwin@gmail.com |   2018446566 |         20 |       40 |     111222 | Pacific Time |
      | Mike      | Phimm    | m_phimm@outlook.com |   4042471926 |         25 |       40 |     222111 | Samoa        |
      | Augusto   | Costa    | a_costa@test.com    |   4012266126 |         47 |       40 |    3333444 | Central Time |
      | Emily     | Boan     | e_baon@yahoo.com    |   6038671646 |         20 |       40 |    4444333 | Pacific Time |
    Then new employee record is displayed on employees panel
      | FirstName | LastName | Email               | MobileNumber |
      | Barbara   | Goodwin  | b_goodwin@gmail.com |   2018446565 |
      | Mike      | Phimm    | m_phimm@outlook.com |   4042471924 |
      | Augusto   | Costa    | a_costa@test.com    |   4012266120 |
      | Emily     | Boan     | e_baon@yahoo.com    |   6038671645 |

      
      