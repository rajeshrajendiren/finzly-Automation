Feature: verify Manage Trade

  @UI @Regression @Boss @ManageTrade
  Scenario Outline: Manage Trade Page Verification
    Given launch the url "https://uat1.swapstech.net/bossPortal/"
    And I Enter Credentials in Login Page "<UserName>" "<Password>" for Boss Portal
    Then I Verify Boss Home Page Loaded Successfully
    And I click New Trade Tab
    Then I verify New Trade Page
    And I click Manage Trade Tab
    Then I verify Manage Trade Tab
    And I Verify Book Data

    @Test
    Examples: 
      | UserName | Password  |
      | Raj1     | Raj!12345 |
