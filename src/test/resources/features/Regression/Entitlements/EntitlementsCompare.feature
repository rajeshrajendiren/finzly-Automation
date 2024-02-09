Feature: UserRoleEntitlementsOperations

  @UI @Regression @userRole @EntitlementCompareAndModify
  Scenario Outline: Check and Uncheck Access Enttity Manager  Menu Entitlement
    Given launch the url "https://uat1.swapstech.net/fxoffice/login"
    And I Enter Credentials in Login Page "<ApproverUser>" "<ApproverPassword>" for other env
    And I Click AdminTab
    And I Click Entitlement
    And I Click FXOffice Application
    Then I Search and Compare Entitlement

    @Test
    Examples: 
      | ApproverUser | ApproverPassword |
      | Rajesh1      | Finzly@123       |
