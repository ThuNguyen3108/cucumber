Feature: Login CMS
  As a user
  User want to be able to log in to the system
  So that user can access my account

  Scenario Outline:
    Given user navigate to Login page
    When  user enter email is <email> and password is <password>
    And   click login button
    Then  user should navigate to slide page
    Examples:
      | EMAIL                      | PASSWORD   |
      |anh.nguyen.quoc@tpssoft.com | anh@Tps123 |
Scenario:



#  Scenario Outline: Invalid username
#    Given user am on the login page
#    When user enter an invalid username
#    And user enter a valid password
#    And user click on the "Login" button
#    Then user should see an error message indicating invalid credentials
#    Examples:
#      |NAVIGATE                | EMAIL                      | PASSWORD   | REDIRECT                                   |
#      |https://dstest.vibe.fyi |anh.nguyen.quoc@tpssoft.com | anh@Tps123 | https://dstest.vibe.fyi/portal/slide-editor|
#
#
#  Scenario Outline: Invalid password
#    Given user am on the login page
#    When user enter a valid username
#    And user enter an invalid password
#    And user click on the "Login" button
#    Then user should see an error message indicating invalid credentials
#    Examples:
#      |NAVIGATE                | EMAIL                      | PASSWORD   | REDIRECT                                   |
#      |https://dstest.vibe.fyi |anh.nguyen.quoc@tpssoft.com | anh@Tps123 | https://dstest.vibe.fyi/portal/slide-editor|
#
#  Scenario: Empty username and password
#    Given user am on the login page
#    When  user leave the username and password fields empty
#    And   user click on the "Login" button
#    Then  user should see an error message indicating required fields
#
#  Scenario: Forgot password
#    Given user am on the login page
#    When  user click on the "Forgot Password" link
#    Then  user should be redirected to the password recovery page
#
#  Scenario: Account locked
#    Given user am on the login page
#    When  user enter a valid username
#    And   user enter an incorrect password multiple times
#    And   user click on the "Login" button
#    Then  user should see an error message indicating that my account is locked