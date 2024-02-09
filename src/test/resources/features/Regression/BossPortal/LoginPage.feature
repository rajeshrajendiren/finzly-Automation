# BossPortalLogin.feature
Feature: Boss Portal Login
 @login
  Scenario Outline: Login with valid credentials
    Given I navigate to the Boss Portal login page
    When I login to the Boss Portal with valid credentials "<username>" and "<password>"

    @Boss
    Examples: 
      | username | password  |
      | Raj1     | Raj@12345 |
