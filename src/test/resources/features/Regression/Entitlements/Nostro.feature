Feature: NostroEntitlementsOperation

  @UI @Regression @userRole @Nostro
  Scenario Outline: Check and uncheck Access Nostro Menu Entitlement
    Given I login to the FXoffice with valid credentials
    And I Click AdminTab
    And I Click UserRoleManagerButton
    And I Create user role "<UserRoleName>"
    And I Search the user "<UserRoleName>"
    And I Uncheck all roles
    And I Check entitlement for user "<MainMenu>"
    And I Check multiple entitlement "<EntitlementName>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    Then I Verify "<MenuName>" single submenu "<SubMenuName>" Checked Successfully
    Given I login to the FXoffice with valid credentials
    And I Click AdminTab
    And I Click UserRoleManagerButton
    And I Search the user "<UserRoleName>"
    And I Check entitlement for user "General Access"
    And I Check entitlement for user "<MainMenu>"
    And I Check entitlement for user "<MenuDropDown>"
    And I UnCheck entitlement for user "<UserRoleName>" "<SubMenu>"
    And I Check multiple entitlement "<MultipleInnerMenu>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    Then I Verify "<MenuName>" single submenu "<SubMenuName>" UnChecked Successfully

    @Test
    Examples: 
      | UserRoleName     | EntitlementName                    | ApproverUser | ApproverPassword | MenuName | SubMenuName     | MainMenu           | MenuDropDown    | SubMenu                   | MultipleInnerMenu            |
      | AutoTestUserRole | Access Nostro Menu,Nostro Recon    | Rajesh2      | Rajesh@789       | Nostro   | Nostro Recon    | Access Nostro Menu | Nostro Recon    | Reconcile Nostro Accounts | Nostro Transfer,Nostro       |
      | AutoTestUserRole | Access Nostro Menu,Nostro Transfer | Rajesh2      | Rajesh@789       | Nostro   | Nostro Transfer | Access Nostro Menu | Nostro Transfer | Reconcile Nostro Transfer     | Nostro Recon,Nostro          |
      | AutoTestUserRole | Access Nostro Menu,Nostro          | Rajesh2      | Rajesh@789       | Nostro   | Statements      | Access Nostro Menu | Nostro          | Access Nostro Statements  | Nostro Recon,Nostro Transfer |
