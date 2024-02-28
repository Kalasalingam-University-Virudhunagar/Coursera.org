Feature: Coursera Campus for organization Students

  @regression
  Scenario: Coursera Campus
    Given Navigate to the Url
    When Scroll the page upto the enterprise element
    When click on the enterprise
    When click on the Solutions
    When click on the campus Coursera
    When Enter the form data with invalid data
    Then Submit the Form
    Then Retrive the error message
