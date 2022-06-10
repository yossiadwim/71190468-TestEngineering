Feature: Feature to test login functionality
  Scenario Outline: Check login with valid credentials
    Given browser opened
    And user in  register page
    And menuju halaman login
    When user insert email and password <email> <password>
    And login button clicked
    Then user redirect to main screen
    Examples:
      |user|email|password|
      |yossia1   |yossi1@gmail.com    |1234abc  |
      |          |yossi2@gmail.com    |abcd1234 |
      |yossia3   |yossi3@gmail.com    |1qaz2wsx |
      |yossia4   |yossi4@gmail.com    |         |
      |yossia5   |                     |qwerty12345|
      |yossia6   |yossi6@gmail.com    |abcde12345|
      |yossia7   |yossi7@gmail.com    |@#345678910|
      |          |yossi8@gmail.com    |           |

