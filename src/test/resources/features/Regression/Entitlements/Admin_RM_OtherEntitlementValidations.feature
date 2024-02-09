Feature: RelationShipManagerOtherEntitlement

  @UI @Regression @userRole @Admin @RelationShipManagerEntitlement @SaveBtn
  Scenario Outline: Check and Uncheck AdminCostCenterOtherEntitlement  Save Button Entitlement
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
    Then I Verify "<MenuName>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" Checked Successfully
    When I Click on One of the Existing relation manager
    Then I Verify Save Button Enabled SuccessFully
    And I click on Logout Button; from Home Page
    
    Given I login to the FXoffice with valid credentials
    And I Click AdminTab
    And I Click UserRoleManagerButton
    And I Search the user "<UserRoleName>"
    And I Check entitlement for user "General Access"
    And I Check multiple entitlement "<EntitlementName>"
    And I Check entitlement for user "<MainMenu>"
    And I Check entitlement for user "<MenuDropDown>"
    And I UnCheck multiple entitlement for user "<UserRoleName>" "<SubMenu>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" UnChecked Successfully
    When I Click on One of the Existing relation manager
    Then I Verify Save Button Disabled SuccessFully
    And I click on Logout Button; from Home Page

    @Test
    Examples: 
      | UserRoleName | EntitlementName                                                                                         | ApproverUser | ApproverPassword | MenuName | SubMenuName          | MainMenu          | MenuDropDown | SubMenu                                                   | InnerMenu         |
      | Automation   | Access Admin Menu,Access Relationship Manager,Add_Edit Relationship Manager,Delete Relationship Manager | Rajesh2      | Rajesh@789       | Admin    | Relationship Manager | Access Admin Menu | Admin        | Add_Edit Relationship Manager,Delete Relationship Manager | New,Update,Delete |
