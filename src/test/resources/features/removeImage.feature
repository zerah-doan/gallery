Feature: Remove images
  As a user
  I want to remove images that i uploaded

  Background:
    Given I have multiple file to upload as below
      | pngExample.png |
      | gifExample.gif |
      | jpgExample.jpg |

  Scenario Outline: : Remove a image
    Given I open image number <img_num>
    When I remove viewing image
    Then View image modal is closed
    And Image is removed from gallery
    Examples:
      | img_num |
      | 3       |
      | 2       |
      | 1       |

  Scenario: Remove multiple images
    Given I open image number 3
    When I remove viewing image
    And I open image number 2
    And I remove viewing image
    Then View image modal is closed
    And Image is removed from gallery

  Scenario: Cancel removing image
    Given I open image number 1
    When I remove viewing image but cancel at confirmation popup
    Then View image modal is displayed
    And Number of image is not changed
