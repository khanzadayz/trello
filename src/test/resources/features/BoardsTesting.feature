Feature: Trello automation testing

  Background:
    Given Trello is opened
    And User is logged in

  Scenario: Board testing
    Given create a new Board
    Then add Priority 1 tasks to the board
    And card link is clicked
    Then card Planning is added
    And card Analysis is added
    And card Design is added
    And card Development and Implementation is added
    And card Testing is added
    And card Maintenance is added
    And add Priority 2 tasks to the board
    And add Priority 3 tasks to the board
    And Comments are added to the cards
    And move Design to Priority 2 tasks
    And move Development and Implementation to Priority 2 tasks
    And move Testing to Priority 3 tasks
    And move Maintenance to Priority 3 tasks






