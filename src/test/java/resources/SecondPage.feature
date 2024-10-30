@test
Feature: Verify Client Reference and Request Details

  Scenario: User verifies client reference and request details after logging in
    Given the user is logged in
    When the user verifies the client reference
    And the user verifies the client request details
    Then the status should be Pending
    And the type should be B2C Delivery
    And I return to the homepage
    And I should see the homepage logo
