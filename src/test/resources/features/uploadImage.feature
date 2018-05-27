Feature: Upload images
  As a user
  I want to upload images
  In order to have image in gallery


  Scenario Outline: Upload different image file types
    When I upload <file>
    Then Image is added to gallery
    Examples:
      | file           |
      | pngExample.png |
      | gifExample.gif |
      | jpgExample.jpg |

  Scenario Outline: Upload invalid file types
    When I upload <file>
    Then Error popup is displayed
    And Image is NOT added to gallery
    Examples:
      | file          |
      | htlmFile.html |
      | textFile.txt  |
      |               |

  Scenario:  Upload multiple file
    When I have multiple file to upload as below
      | pngExample.png |
      | gifExample.gif |
      | jpgExample.jpg |
    Then All image is added