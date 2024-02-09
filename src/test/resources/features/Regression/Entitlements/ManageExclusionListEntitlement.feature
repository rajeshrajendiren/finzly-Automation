Feature: ManageExclusionListEntitlement

  @UI @Regression @userRole @Admin @ManageExclusionListEntitlement @SaveBtn
  Scenario Outline: Check and Uncheck ManageExclusionListEntitlement  Save Button Entitlement
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
    When I Click on One of the Existing Exclusion Manager
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
    When I Click on One of the Existing Exclusion Manager
    Then I Verify Save Button Disabled SuccessFully
    And I click on Logout Button; from Home Page

    @Test
    Examples: 
      | UserRoleName | EntitlementName                                                                               | ApproverUser | ApproverPassword | MenuName | SubMenuName           | MainMenu          | MenuDropDown | SubMenu                                        | InnerMenu             | MultipleInnerMenu                                                                                        |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Add Edit Exclusion,Delete Exclusion            | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Add Edit Exclusion,Delete Exclusion            | Add,Edit,Delete       | Download Exclusion List,Activities Exclusion List,Field Audit Exclusion List,Record Audit Exclusion List |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Add Edit Exclusion,Download Exclusion List     | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Add Edit Exclusion,Download Exclusion List     | Add,Edit,Download     | Delete Exclusion,Activities Exclusion List,Field Audit Exclusion List,Record Audit Exclusion List        |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Add Edit Exclusion,Activities Exclusion List   | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Add Edit Exclusion,Activities Exclusion List   | Add,Edit,Activities   | Delete Exclusion,Download Exclusion List,Field Audit Exclusion List,Record Audit Exclusion List          |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Add Edit Exclusion,Field Audit Exclusion List  | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Add Edit Exclusion,Field Audit Exclusion List  | Add,Edit,Field Audit  | Delete Exclusion,Download Exclusion List,Activities Exclusion List,Record Audit Exclusion List           |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Add Edit Exclusion,Record Audit Exclusion List | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Add Edit Exclusion,Record Audit Exclusion List | Add,Edit,Record Audit | Field Audit Exclusion List,Delete Exclusion,Download Exclusion List,Activities Exclusion List            |

  @UI @Regression @userRole @Admin @ManageExclusionListEntitlement @WithoutSaveBtn
  Scenario Outline: Check and Uncheck ManageExclusionListEntitlement  Entitlement
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
      | UserRoleName | EntitlementName                                                                                       | ApproverUser | ApproverPassword | MenuName | SubMenuName           | MainMenu          | MenuDropDown | SubMenu                                                | InnerMenu                | MultipleInnerMenu                                                                                   |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Delete Exclusion,Download Exclusion List               | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Delete Exclusion,Download Exclusion List               | Delete,Download          | Record Audit Exclusion List,Field Audit Exclusion List,Add Edit Exclusion,Activities Exclusion List |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Delete Exclusion,Activities Exclusion List             | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Delete Exclusion,Activities Exclusion List             | Delete,Activities        | Download Exclusion List,Record Audit Exclusion List,Field Audit Exclusion List,Add Edit Exclusion   |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Delete Exclusion,Field Audit Exclusion List            | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Delete Exclusion,Field Audit Exclusion List            | Delete,Field Audit       | Add Edit Exclusion,Download Exclusion List,Activities Exclusion List,Record Audit Exclusion List    |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Delete Exclusion,Record Audit Exclusion List           | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Delete Exclusion,Record Audit Exclusion List           | Delete,Record Audit      | Download Exclusion List,Activities Exclusion List,Add Edit Exclusion,Field Audit Exclusion List     |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Download Exclusion List,Activities Exclusion List      | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Download Exclusion List,Activities Exclusion List      | Download,Activities      | Add Edit Exclusion,Field Audit Exclusion List,Delete Exclusion,Record Audit Exclusion List          |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Download Exclusion List,Field Audit Exclusion List     | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Download Exclusion List,Field Audit Exclusion List     | Download,Field Audit     | Record Audit Exclusion List,Delete Exclusion,Add Edit Exclusion,Activities Exclusion List           |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Download Exclusion List,Record Audit Exclusion List    | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Download Exclusion List,Record Audit Exclusion List    | Download,Record Audit    | Delete Exclusion,Add Edit Exclusion,Activities Exclusion List,Field Audit Exclusion List            |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Record Audit Exclusion List,Activities Exclusion List  | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Record Audit Exclusion List,Activities Exclusion List  | Record Audit,Activities  | Delete Exclusion,Add Edit Exclusion,Field Audit Exclusion List,Download Exclusion List              |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Field Audit Exclusion List,Record Audit Exclusion List | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Field Audit Exclusion List,Record Audit Exclusion List | Field Audit,Record Audit | Download Exclusion List,Activities Exclusion List,Delete Exclusion,Add Edit Exclusion               |
      | Automation   | Access Admin Menu,Access Manage Exclusion List,Field Audit Exclusion List,Activities Exclusion List   | Rajesh2      | Rajesh@789       | Admin    | Manage Exclusion List | Access Admin Menu | Admin        | Field Audit Exclusion List,Activities Exclusion List   | Field Audit,Activities   | Download Exclusion List,Delete Exclusion,Add Edit Exclusion,Record Audit Exclusion List             |
