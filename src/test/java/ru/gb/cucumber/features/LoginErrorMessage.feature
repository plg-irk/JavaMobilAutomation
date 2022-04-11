Feature: Login

  @ValidCredentials
  Scenario: Login with empty fields

    Given User is on Login page
    When User click login button
    Then User should see error message "Please enter a valid email address"

