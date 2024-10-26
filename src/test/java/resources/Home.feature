@test
Feature: Homepage Login and Verification

  Scenario: User logs in and verifies homepage aspects
    Given the user navigates to the control app
    When the user logs in manually
    Then the hub menu should be visible and assert that it is TEST_A1
    And the service should be B2C Delivery
    And the Home status should be Pending
    And the user clicks on the third item on the page
