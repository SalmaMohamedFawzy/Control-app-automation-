@test
Feature: Homepage Login and Verification

  Scenario: User logs in and verifies homepage aspects
    Given the user navigates to the control app
    When the user logs in manually and select TEST-A1
    Then the hub menu should be visible and assert that it is TEST_A1
    And the service should be B2C Delivery
    And the home status should be Pending
    And the leg Type should be Delivery
    And the reason should be rescheduled
    And the country should be AE
    And the user clicks on the result item
    And complete soft assertion check