Feature: Login to Vibe
  As a user, user want to be able to login into the Vibe system
  So that user can manage customer information

  Scenario: Successful login
    Given user navigate to login page "https://dstest.vibe.fyi"
    When user enter email "anh.nguyen.quoc@tpssoft.com" and password "anh@Tps123"
    And click login button
    Then user redirect to slide page "https://dstest.vibe.fyi/portal/slide-editor"

  Scenario: Login fails with email incorrect format
    Given user navigate to login page "https://dstest.vibe.fyi"
    When user enter email "anh1.nguyen.quoc@tpssoft.com" and password "anh@Tps123"
    And click login button
    Then user redirect to slide page "https://dstest.vibe.fyi/portal/slide-editor"

  Scenario: Login fails with password incorrect format
    Given user navigate to login page "https://dstest.vibe.fyi"
    When user enter email "anh.nguyen.quoc@tpssoft.com" and password "anh1@Tps123"
    And click login button
    Then user redirect to slide page "https://dstest.vibe.fyi/portal/slide-editor"