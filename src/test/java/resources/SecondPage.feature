@test
Feature: Verify Client Reference and Request Details

  Scenario: User verifies client reference and request details after logging in
    Given the user is logged in
    When the user verifies the client reference
    Then the status should be Pending
    And the type should be B2C Delivery
