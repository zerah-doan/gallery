Feature: View images
  As a user
  I want to view images that i uploaded

  Background:
    Given I have multiple file to upload as below
      | pngExample.png |
      | gifExample.gif |
      | jpgExample.jpg |

  Scenario Outline: View images
    When I open image number <img_num>
    Then View image modal is displayed
    And Image number <img_num> is displayed
    Examples:
      | img_num |
      | 1       |
      | 2       |
      | 3       |

  Scenario Outline: Move forward
    When I open image number <img_num>
    And Click next button
    Then Next image of image number <img_num> will be displayed
    Examples:
      | img_num |
      | 1       |
      | 2       |
      | 3       |

  Scenario Outline: Move backward
    When I open image number <img_num>
    And Click previous button
    Then Previous image of image number <img_num> will be displayed
    Examples:
      | img_num |
      | 1       |
      | 2       |
      | 3       |

  Scenario: Close view image modal
    When I open image number 1
    And Click close button
    Then View image modal is closed
