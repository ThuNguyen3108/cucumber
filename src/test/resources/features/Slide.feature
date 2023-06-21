Feature: Create Slide

  Scenario: Create and add slide item
    Given user navigates to login page "https://dstest.vibe.fyi"
    When user enters email "anh.nguyen.quoc@tpssoft.com" and password "anh@Tps123"
    And user clicks login button
    Then user is redirected to slide page "https://dstest.vibe.fyi/portal/slide-editor"

    When user clicks create slide button
    And user enters title template slide "Noticeboard (Blocks)"
    And user selects this template
    And user enters title slide "Anh Title"
    And user clicks create slide button template
    Then create slide is verified

    And user clicks add item button
    And user drags image of item
    And user adds image of item
    And user updates list item
    And user enters title of add item "Anh Item Title 1"
    And user enters summary of add item "Anh Item Summary 1"
    And user clicks save button
    And user clicks add item button
    And user drags image of item
    And user adds image of item
    And user updates list item
    And user enters title of add item "Anh Item Title 2"
    And user enters summary of add item "Anh Item Summary 2"
    And user clicks save button
    Then item 1 is verified
    And item 2 is verified
