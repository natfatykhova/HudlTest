@login
Feature: Test login page

  Background:
    Given I open "Login" page
    And I should see login form

  Scenario: Should see Hudl logo on login page
    And I should see Hudl logo on login page

  Scenario: Should log in with valid credentials
    And I enter email for user "user1" to login form
    And I enter password for user "user1" to login form
    When I click "Log in" button on login page
    Then I should see user name "Coach F" in profile menu

  Scenario Outline: Should see error for invalid credentials
    And I enter email "<Email>" to login form
    And I enter password "<Password>" to login form
    When I click "Log in" button on login page
    Then I should see error message "We didn't recognize that email and/or password. Need help?"

    Examples: Data to test login
      | Email                         | Password |
      | mymail@gmail.com              | 123      |
      | test@test.com !               | 123      |
      | %s                            | 123      |
      | <script>alert('hi');</script> | 123      |
      |                               |          |

  Scenario: Should see reset password page for login error link
    And I click "Log in" button on login page
    When I click "Need help? in error" button on login page
    Then I should be taken to Reset password page

  Scenario: Remember me functionality should save user email
    And I enter email for user "user1" to login form
    And I enter password for user "user1" to login form
    And I check Remember me checkbox
    And I click "Log in" button on login page
    And I should see user name "Coach F" in profile menu
    And I click log out button in user profile
    And I open "Login" page
    And I should see user "user1" email saved in login form

  Scenario: Verify Sign up url redirect
    When I click "Sign up" button on login page
    Then I should be taken to Request a demo page

  Scenario: Verify Need help url redirect
    When I click "Need help?" button on login page
    Then I should be taken to Reset password page

  Scenario: Verify Log in with an Organisation redirect
    When I click "Log in with an Organisation" button on login page
    Then I should be taken to Join as organisation page
