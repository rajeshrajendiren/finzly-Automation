Feature: StaticData_FixingSource_OtherEntitlement

  @UI @Regression @userRole @StaticData @FixingSource_OtherEntitlement @SaveBtn
  Scenario Outline: Check and Uncheck Static Data Fixing Source with Save Button OtherEntitlement
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
    And I Click "<MenuName>" and single submenu "<SubMenuName>"
    Then I Verify "<InnerMenu>" Checked Successfully
    When I Click Add button,if the button present in "<InnerMenu>"
    Then I Verify Save Button Enabled SuccessFully
    And I click on Logout Button; from Home Page
    Given I login to the FXoffice with valid credentials
    And I Click AdminTab
    And I Click UserRoleManagerButton
    And I Search the user "<UserRoleName>"
    And I Check entitlement for user "General Access"
    And I Check multiple entitlement "<EntitlementName>"
    And I Check multiple entitlement "<MultipleInnerMenu>"
    And I Check entitlement for user "<MainMenu>"
    And I Check entitlement for user "<MenuDropDown>"
    And I UnCheck multiple entitlement for user "<UserRoleName>" "<SubMenu>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    And I Click "<MenuName>" and single submenu "<SubMenuName>"
    Then I Verify "<InnerMenu>" UnChecked Successfully
    And I click on Logout Button; from Home Page

    @Test
    Examples: 
      | UserRoleName | EntitlementName                                                                                                     | ApproverUser | ApproverPassword | MenuName    | SubMenuName   | MainMenu                | MenuDropDown | SubMenu                                                                | InnerMenu                    | MultipleInnerMenu                                    |
      | Automation   | Access Static Data Menu,Access Fixing Source,Add_Edit Fixing Source,Delete Fixing Source                            | Rajesh2      | Rajesh@789       | Static Data | Fixing Source | Access Static Data Menu | Static Data  | Add_Edit Fixing Source,Delete Fixing Source                            | New,Edit,Delete              | Field Audit Fixing Source,Record Audit Fixing Source |
      | Automation   | Access Static Data Menu,Access Fixing Source,Add_Edit Fixing Source,Field Audit Fixing Source                       | Rajesh2      | Rajesh@789       | Static Data | Fixing Source | Access Static Data Menu | Static Data  | Add_Edit Fixing Source,Field Audit Fixing Source                       | New,Edit,Field Audit         | Delete Fixing Source,Record Audit Fixing Source      |
      | Automation   | Access Static Data Menu,Access Fixing Source,Add_Edit Fixing Source,Record Audit Fixing Source                      | Rajesh2      | Rajesh@789       | Static Data | Fixing Source | Access Static Data Menu | Static Data  | Add_Edit Fixing Source,Record Audit Fixing Source                      | New,Edit,Record Audit        | Field Audit Fixing Source,Delete Fixing Source       |
      | Automation   | Access Static Data Menu,Access Fixing Source,Add_Edit Fixing Source,Delete Fixing Source,Record Audit Fixing Source | Rajesh2      | Rajesh@789       | Static Data | Fixing Source | Access Static Data Menu | Static Data  | Add_Edit Fixing Source,Delete Fixing Source,Record Audit Fixing Source | New,Edit,Record Audit,Delete | Field Audit Fixing Source                            |
      | Automation   | Access Static Data Menu,Access Fixing Source,Add_Edit Fixing Source,Delete Fixing Source,Field Audit Fixing Source  | Rajesh2      | Rajesh@789       | Static Data | Fixing Source | Access Static Data Menu | Static Data  | Add_Edit Fixing Source,Delete Fixing Source,Field Audit Fixing Source  | New,Edit,Field Audit,Delete  | Record Audit Fixing Source                           |

  @UI @Regression @userRole @StaticData @FixingSource_OtherEntitlement @WithoutSaveBtn
  Scenario Outline: Check and Uncheck Static Data Fixing Source without Save Button Entitlement
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
    And I Click "<MenuName>" and single submenu "<SubMenuName>"
    Then I Verify "<InnerMenu>" Checked Successfully
    Given I login to the FXoffice with valid credentials
    And I Click AdminTab
    And I Click UserRoleManagerButton
    And I Search the user "<UserRoleName>"
    And I Check entitlement for user "General Access"
    And I Check multiple entitlement "<EntitlementName>"
    And I Check multiple entitlement "<MultipleInnerMenu>"
    And I Check entitlement for user "<MainMenu>"
    And I Check entitlement for user "<MenuDropDown>"
    And I UnCheck multiple entitlement for user "<UserRoleName>" "<SubMenu>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    And I Click "<MenuName>" and single submenu "<SubMenuName>"
    Then I Verify "<InnerMenu>" UnChecked Successfully

    @Test
    Examples: 
      | UserRoleName | EntitlementName                                                                                   | ApproverUser | ApproverPassword | MenuName    | SubMenuName   | MainMenu                | MenuDropDown | SubMenu                                              | InnerMenu                | MultipleInnerMenu                                 |
      | Automation   | Access Static Data Menu,Access Fixing Source,Delete Fixing Source,Record Audit Fixing Source      | Rajesh2      | Rajesh@789       | Static Data | Fixing Source | Access Static Data Menu | Static Data  | Delete Fixing Source,Record Audit Fixing Source      | Delete,Record Audit      | Field Audit Fixing Source,Add_Edit Fixing Source  |
      | Automation   | Access Static Data Menu,Access Fixing Source,Delete Fixing Source,Field Audit Fixing Source       | Rajesh2      | Rajesh@789       | Static Data | Fixing Source | Access Static Data Menu | Static Data  | Delete Fixing Source,Field Audit Fixing Source       | Delete,Field Audit       | Add_Edit Fixing Source,Record Audit Fixing Source |
      | Automation   | Access Static Data Menu,Access Fixing Source,Field Audit Fixing Source,Record Audit Fixing Source | Rajesh2      | Rajesh@789       | Static Data | Fixing Source | Access Static Data Menu | Static Data  | Field Audit Fixing Source,Record Audit Fixing Source | Field Audit,Record Audit | Add_Edit Fixing Source,Delete Fixing Source       |
