Feature: Web Development Courses
  @smoke
  Scenario: Retriving data of WebDevelopment Courses
    Given Navigate to the Url
    When passing the parameter "Web Development"
    When and Click on the Search
    And click on english Language
    And click on Begineer level
    Then Retriving the details of two courses
    