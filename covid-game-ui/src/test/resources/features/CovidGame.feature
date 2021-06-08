@RegressionTest

Feature: Covid Game
  Covid game to fight covid-19

 Background:
   Given User opened the webpage

Scenario Outline: Verify that score increases when user selects correct option
  Given User creates a Warrior <WarriorName> and starts the Journey
  When User chooses <Battle> Battlefield
  Then Battlefield page is displayed
  When User selects the right option
  Then Option Correct Popup is displayed
  When User Clicks on Check your Score
  Then Leaderboard page is displayed
  And check Warrior score is increased
  Examples:
  | WarriorName      |       Battle             |
  |  Warrior1 |   Take the bus           |
  |  Warrior2 |   Go to a public place   |
  |  Warrior3 |   Go to the office       |


 Scenario Outline:  Verify that user can try again when incorrect option is selected
    Given User creates a Warrior <WarriorName> and starts the Journey
    When User chooses <Battle> Battlefield
    Then Battlefield page is displayed
    And User selects an incorrect option
    Then Option Incorrect Popup is returned
    When User clicks on Try again on Incorrect Popup
    Then Battlefield page is displayed
    Examples:
      | WarriorName      |       Battle             |
      |  Warrior1 |   Take the bus           |
      |  Warrior2 |   Go to a public place   |
      |  Warrior3 |   Go to the office       |

  Scenario Outline: Test Time Up Scenario
    Given User creates a Warrior <WarriorName> and starts the Journey
    When User chooses <Battle> Battlefield
    Then Battlefield page is displayed
    When User does not select option within timeout
    Then Time Up Popup is returned
    When User clicks on Try again on Time Up Popup
    Then Battlefield page is displayed
    And User does not select option within timeout
    Then Time Up Popup is returned
    When User clicks on Return Home
    Then Choose Battle page is displayed
    Examples:
      | WarriorName      |       Battle            |
      |  Warrior1 |   Take the bus          |
      |  Warrior2 |   Go to a public place  |
      |  Warrior3 |   Go to the office      |

  Scenario Outline: Verify Try Next Battle Scenario
    Given User creates a Warrior <WarriorName> and starts the Journey
    When User chooses <Battle> Battlefield
    Then Battlefield page is displayed
    When User selects the right option
    Then Option Correct Popup is displayed
    When User clicks on Try Next Battle
    Then Next Battlefield <NextBattle> page is displayed
  Examples:
    | WarriorName      |       Battle            | NextBattle |
    |  Warrior1 |   Take the bus           | Go to a public place|
    |  Warrior2|   Go to a public place  | Go to the office     |
    |  Warrior3|   Go to the office      | Take the bus         |

  Scenario Outline: Verify that When all questions are finished, check your score is displayed
    Given User creates a Warrior <WarriorName> and starts the Journey
    When User chooses <Battle> Battlefield
    Then Battlefield page is displayed
    When User answers all questions in <Battle> battle
    Then Check your Score Option is displayed
    When User clicks on check your score
    Then Leaderboard page is displayed
    When User clicks on Continue Fighting
    Then Choose Battle page is displayed
  Examples:
      | WarriorName      |       Battle            |
  |  Warrior1 |   Take the bus          |
  |  Warrior2 |   Go to a public place  |
  |  Warrior3 |   Go to the office      |

  Scenario: Verify Are you Game? Scenario
    Given User creates a Warrior Warrior1 and starts the Journey
    When User chooses Are you game? Battlefield
    Then Battlefield page is displayed
    When User does not select option within timeout
    Then Virus contracted popup is displayed
    When user clicks on try again on Virus Contracted popup
    Then Home page is displayed










