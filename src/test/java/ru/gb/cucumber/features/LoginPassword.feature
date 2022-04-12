Feature: LoginPassword

  @ValidCredentials
  Scenario: Login with valid email and empty password

    Given User is on Login page
    When User get valid email
    When User click login button
    Then User should see error message password "Please enter at least 8 characters"