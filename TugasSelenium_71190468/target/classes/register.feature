Feature: Feature to test register functionality
  Scenario Outline: Check register valid
    Given buka browser
    And user di halaman register
    When user memasukkan <user> <email> <password>
    And ada tombol reset dan create
    And username tidak kosong dan kata sandi valid <user> <email> <password>
    Then create button di klik
    Examples:
    |user|email|password|
    |yossia1   |yossi1@gmail.com    |1234abc  |
    |          |yossi2@gmail.com    |abcd1234 |
    |yossia3   |yossi3@gmail.com    |1qaz2wsx |
    |yossia4   |yossi4@gmail.com    |         |
    |yossia5   |                    |qwerty12345|
    |yossia6   |yossi6@gmail.com    |abcde12345|
    |yossia7   |yossi7@gmail.com    |@#345678910|
    |          |yossi8@gmail.com    |           |