Feature: AdminBranchUserCrossCombinationsEntitlement

  @UI @Regression @userRole @BackOffice @Admin @BranchUser_Cross_Combinations_Entitlement @SaveBtn1
  Scenario Outline: Check and Uncheck AdminBranchUser_Cross_Combination  Save Button Entitlement
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
    When I Click on One of the Existing Branch users
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
    When I Click on One of the Existing Branch users
    Then I Verify Save Button Disabled SuccessFully
    And I click on Logout Button; from Home Page

    @Test
    Examples: 
      | UserRoleName | EntitlementName                                                                                                                       | ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu          | MenuDropDown | SubMenu                                                                                         | InnerMenu                          | MultipleInnerMenu                                                                                                                                                                                                                                        |
      | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Add Edit FX STAR Branch User                                       | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Add Edit FX STAR Branch User                                       | Add,Edit,Activate                  | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User   |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Branches FX STAR Branch User                                       | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Branches FX STAR Branch User                                       | Add,Edit,Branches                  | Activate FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User   |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Delete FX STAR Branch User                                         | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Delete FX STAR Branch User                                         | Add,Edit,Delete                    | Branches FX STAR Branch User,Activate FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Download FX STAR Branch User List                                  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Download FX STAR Branch User List                                  | Add,Edit,Download                  | Branches FX STAR Branch User,Delete FX STAR Branch User,Activate FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Entitlements FX STAR Branch User                                   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Entitlements FX STAR Branch User                                   | Add,Edit,Entitlements              | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Activate FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User       |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Field Audit FX STAR Branch User                                    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Field Audit FX STAR Branch User                                    | Add,Edit,Field Audit               | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Activate FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Record Audit FX STAR Branch User                                   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Record Audit FX STAR Branch User                                   | Add,Edit,Record Audit              | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Activate FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User       |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Suspend FX STAR Branch User                                        | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Suspend FX STAR Branch User                                        | Add,Edit,Suspend                   | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User  |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Activities FX STAR Branch User                                     | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Activities FX STAR Branch User                                     | Add,Edit,Activate                  | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User     |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User   | Add,Edit,Field Audit,Entitlements  | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User                                       |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User  | Add,Edit,Entitlements,Record Audit | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User                                        |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Entitlements FX STAR Branch User,Activities FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Entitlements FX STAR Branch User,Activities FX STAR Branch User    | Add,Edit,Entitlements,Activities   | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User                                      |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Download FX STAR Branch User List,Activities FX STAR Branch User   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Download FX STAR Branch User List,Activities FX STAR Branch User   | Add,Edit,Download,Activities       | Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User                                       |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Download FX STAR Branch User List,Record Audit FX STAR Branch User | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Download FX STAR Branch User List,Record Audit FX STAR Branch User | Add,Edit,Download,Record Audit     | Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User                                         |

  @UI @Regression @userRole @BackOffice @Admin @BranchUser_Cross_Combinations_Entitlement @SaveBtn2
  Scenario Outline: Check and Uncheck AdminBranchUser_Cross_Combination  Save Button Entitlement
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
    When I Click on One of the Existing Branch users
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
    When I Click on One of the Existing Branch users
    Then I Verify Save Button Disabled SuccessFully
    And I click on Logout Button; from Home Page

    @Test
    Examples: 
      | UserRoleName | EntitlementName                                                                                                                       | ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu          | MenuDropDown | SubMenu                                                                                         | InnerMenu                      | MultipleInnerMenu                                                                                                                                                                                                          |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User  | Add,Edit,Download,Field Audit  | Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User          |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User | Add,Edit,Download,Entitlements | Branches FX STAR Branch User,Delete FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User           |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Download FX STAR Branch User List     | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Download FX STAR Branch User List     | Add,Edit,Download,Branches     | Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User       |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Entitlements FX STAR Branch User      | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Entitlements FX STAR Branch User      | Add,Edit,Branches,Entitlements | Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Field Audit FX STAR Branch User       | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Field Audit FX STAR Branch User       | Add,Edit,Branches,Field Audit  | Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User     |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Record Audit FX STAR Branch User      | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Record Audit FX STAR Branch User      | Add,Edit,Branches,Record Audit | Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Activities FX STAR Branch User        | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Activities FX STAR Branch User        | Add,Edit,Branches,Activities   | Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User    |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User         | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User         | Add,Edit,Suspend,Activities    | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Record Audit FX STAR Branch User       | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Record Audit FX STAR Branch User       | Add,Edit,Suspend,Record Audit  | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User     |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Field Audit FX STAR Branch User        | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Field Audit FX STAR Branch User        | Add,Edit,Suspend,Field Audit   | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User    |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Entitlements FX STAR Branch User       | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Entitlements FX STAR Branch User       | Add,Edit,Suspend,Entitlements  | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User     |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Download FX STAR Branch User List      | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Download FX STAR Branch User List      | Add,Edit,Suspend,Download      | Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Branches FX STAR Branch User           | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Suspend FX STAR Branch User,Branches FX STAR Branch User           | Add,Edit,Suspend,Branches      | Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Activate FX STAR Branch User,Suspend FX STAR Branch User           | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Activate FX STAR Branch User,Suspend FX STAR Branch User           | Add,Edit,Activate,Suspend      | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User |

  @UI @Regression @userRole @BackOffice @Admin @BranchUser_Cross_Combinations_Entitlement @SaveBtn3
  Scenario Outline: Check and Uncheck AdminBranchUser_Cross_Combination  Save Button Entitlement
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
    When I Click on One of the Existing Branch users
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
    When I Click on One of the Existing Branch users
    Then I Verify Save Button Disabled SuccessFully
    And I click on Logout Button; from Home Page

    @Test
    Examples: 
      | UserRoleName | EntitlementName                                                                                                                   | ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu          | MenuDropDown | SubMenu                                                                                     | InnerMenu                      | MultipleInnerMenu                                                                                                                                                                                                            |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Activate FX STAR Branch User,Branches FX STAR Branch User      | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Activate FX STAR Branch User,Branches FX STAR Branch User      | Add,Edit,Activate,Branches     | Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User    |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Activate FX STAR Branch User,Download FX STAR Branch User List | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Activate FX STAR Branch User,Download FX STAR Branch User List | Add,Edit,Activate,Download     | Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User         |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Activate FX STAR Branch User,Entitlements FX STAR Branch User  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Activate FX STAR Branch User,Entitlements FX STAR Branch User  | Add,Edit,Activate,Entitlements | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User    | Add,Edit,Activate,Activities   | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Activate FX STAR Branch User,Record Audit FX STAR Branch User  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Activate FX STAR Branch User,Record Audit FX STAR Branch User  | Add,Edit,Activate,Record Audit | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Activate FX STAR Branch User,Field Audit FX STAR Branch User   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Activate FX STAR Branch User,Field Audit FX STAR Branch User   | Add,Edit,Activate,Field Audit  | Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User       |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Activities FX STAR Branch User      | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Activities FX STAR Branch User      | Add,Edit,Delete,Activities     | Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User    |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Record Audit FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Record Audit FX STAR Branch User    | Add,Edit,Delete,Record Audit   | Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Field Audit FX STAR Branch User     | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Field Audit FX STAR Branch User     | Add,Edit,Delete,Field Audit    | Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User     |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User    | Add,Edit,Delete,Entitlements   | Branches FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List   | Add,Edit,Delete,Download       | Branches FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Branches FX STAR Branch User        | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Branches FX STAR Branch User        | Add,Edit,Delete,Branches       | Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User  |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Suspend FX STAR Branch User         | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Suspend FX STAR Branch User         | Add,Edit,Delete,Suspend        | Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activate FX STAR Branch User,Activities FX STAR Branch User |
      | Automation   | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Activate FX STAR Branch User        | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Activate FX STAR Branch User        | Add,Edit,Activate,Delete       | Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User  |

  @UI @Regression @userRole @BackOffice @Admin @BranchUser_Cross_Combinations_Entitlement @WithoutSaveBtn1
  Scenario Outline: Check and Uncheck Admin_Client_Accounts Menu  Entitlement
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
      | UserRoleName | EntitlementName                                                                                      | ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu          | MenuDropDown | SubMenu                                                        | InnerMenu             | MultipleInnerMenu                                                                                                                                                                                                                                         |
      | Automation   | Access Admin Menu,Access Branch Users,Branches FX STAR Branch User,Delete FX STAR Branch User        | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Branches FX STAR Branch User,Delete FX STAR Branch User        | Branches,Delete       | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User  |
      | Automation   | Access Admin Menu,Access Branch Users,Branches FX STAR Branch User,Download FX STAR Branch User List | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Branches FX STAR Branch User,Download FX STAR Branch User List | Branches,Download     | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User         |
      | Automation   | Access Admin Menu,Access Branch Users,Branches FX STAR Branch User,Entitlements FX STAR Branch User  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Branches FX STAR Branch User,Entitlements FX STAR Branch User  | Branches,Entitlements | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |
      | Automation   | Access Admin Menu,Access Branch Users,Branches FX STAR Branch User,Field Audit FX STAR Branch User   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Branches FX STAR Branch User,Field Audit FX STAR Branch User   | Branches,Field Audit  | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User       |
      | Automation   | Access Admin Menu,Access Branch Users,Branches FX STAR Branch User,Record Audit FX STAR Branch User  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Branches FX STAR Branch User,Record Audit FX STAR Branch User  | Branches,Record Audit | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |
      | Automation   | Access Admin Menu,Access Branch Users,Branches FX STAR Branch User,Suspend FX STAR Branch User       | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Branches FX STAR Branch User,Suspend FX STAR Branch User       | Branches,Suspend      | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User   |
      | Automation   | Access Admin Menu,Access Branch Users,Branches FX STAR Branch User,Activities FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Branches FX STAR Branch User,Activities FX STAR Branch User    | Branches,Activities   | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Delete FX STAR Branch User,Download FX STAR Branch User List   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Delete FX STAR Branch User,Download FX STAR Branch User List   | Delete,Download       | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User       |
      | Automation   | Access Admin Menu,Access Branch Users,Delete FX STAR Branch User,Entitlements FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Delete FX STAR Branch User,Entitlements FX STAR Branch User    | Delete,Entitlements   | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Delete FX STAR Branch User,Field Audit FX STAR Branch User     | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Delete FX STAR Branch User,Field Audit FX STAR Branch User     | Delete,Field Audit    | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User     |
      | Automation   | Access Admin Menu,Access Branch Users,Delete FX STAR Branch User,Record Audit FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Delete FX STAR Branch User,Record Audit FX STAR Branch User    | Delete,Record Audit   | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Delete FX STAR Branch User,Suspend FX STAR Branch User         | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Delete FX STAR Branch User,Suspend FX STAR Branch User         | Delete,Suspend        | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User |

 
  @UI @Regression @userRole @BackOffice @Admin @BranchUser_Cross_Combinations_Entitlement @WithoutSaveBtn2
  Scenario Outline: Check and Uncheck Admin_Client_Accounts Menu  Entitlement
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
      | UserRoleName | EntitlementName                                                                                          | ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu          | MenuDropDown | SubMenu                                                            | InnerMenu                 | MultipleInnerMenu                                                                                                                                                                                                                                      |
      | Automation   | Access Admin Menu,Access Branch Users,Delete FX STAR Branch User,Activities FX STAR Branch User          | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Delete FX STAR Branch User,Activities FX STAR Branch User          | Delete,Activities         | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User |
      | Automation   | Access Admin Menu,Access Branch Users,Download FX STAR Branch User List,Entitlements FX STAR Branch User | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Download FX STAR Branch User List,Entitlements FX STAR Branch User | Download,Entitlements     | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User          |
      | Automation   | Access Admin Menu,Access Branch Users,Download FX STAR Branch User List,Field Audit FX STAR Branch User  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Download FX STAR Branch User List,Field Audit FX STAR Branch User  | Download,Field Audit      | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User         |
      | Automation   | Access Admin Menu,Access Branch Users,Download FX STAR Branch User List,Record Audit FX STAR Branch User | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Download FX STAR Branch User List,Record Audit FX STAR Branch User | Download,Record Audit     | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User          |
      | Automation   | Access Admin Menu,Access Branch Users,Download FX STAR Branch User List,Suspend FX STAR Branch User      | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Download FX STAR Branch User List,Suspend FX STAR Branch User      | Download,Suspend          | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User     |
      | Automation   | Access Admin Menu,Access Branch Users,Download FX STAR Branch User List,Activities FX STAR Branch User   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Download FX STAR Branch User List,Activities FX STAR Branch User   | Download,Activities       | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User        |
      | Automation   | Access Admin Menu,Access Branch Users,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Entitlements FX STAR Branch User,Field Audit FX STAR Branch User   | Entitlements,Field Audit  | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |
      | Automation   | Access Admin Menu,Access Branch Users,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Entitlements FX STAR Branch User,Record Audit FX STAR Branch User  | Entitlements,Record Audit | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User         |
      | Automation   | Access Admin Menu,Access Branch Users,Entitlements FX STAR Branch User,Suspend FX STAR Branch User       | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Entitlements FX STAR Branch User,Suspend FX STAR Branch User       | Entitlements,Suspend      | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User    |
      | Automation   | Access Admin Menu,Access Branch Users,Entitlements FX STAR Branch User,Activities FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Entitlements FX STAR Branch User,Activities FX STAR Branch User    | Entitlements,Activities   | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User       |
      | Automation   | Access Admin Menu,Access Branch Users,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Field Audit FX STAR Branch User,Record Audit FX STAR Branch User   | Field Audit,Record Audit  | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |

  @UI @Regression @userRole @BackOffice @Admin @BranchUser_Cross_Combinations_Entitlement @WithoutSaveBtn3
  Scenario Outline: Check and Uncheck Admin_Client_Accounts Menu  Entitlement
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
      | UserRoleName | EntitlementName                                                                                      | ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu          | MenuDropDown | SubMenu                                                        | InnerMenu              | MultipleInnerMenu                                                                                                                                                                                                                                        |
      | Automation   | Access Admin Menu,Access Branch Users,Field Audit FX STAR Branch User,Suspend FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Field Audit FX STAR Branch User,Suspend FX STAR Branch User    | Field Audit,Suspend    | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User     |
      | Automation   | Access Admin Menu,Access Branch Users,Field Audit FX STAR Branch User,Activities FX STAR Branch User | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Field Audit FX STAR Branch User,Activities FX STAR Branch User | Field Audit,Activities | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User        |
      | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Branches FX STAR Branch User      | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Branches FX STAR Branch User      | Activate,Branches      | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User   |
      | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Delete FX STAR Branch User        | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Delete FX STAR Branch User        | Activate,Delete        | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User |
      | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Download FX STAR Branch User List | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Download FX STAR Branch User List | Activate,Download      | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |
      | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Entitlements FX STAR Branch User  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Entitlements FX STAR Branch User  | Activate,Entitlements  | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User       |
      | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Field Audit FX STAR Branch User   | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Field Audit FX STAR Branch User   | Activate,Field Audit   | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User      |
      | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Record Audit FX STAR Branch User  | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Record Audit FX STAR Branch User  | Activate,Record Audit  | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User       |
      | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Suspend FX STAR Branch User       | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Suspend FX STAR Branch User       | Activate,Suspend       | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User  |
      | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Activities FX STAR Branch User    | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Activities FX STAR Branch User    | Activities,Activate    | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User     |
      
      
      
      
      
      
      
      
      
      
       #| Automation   | Access Admin Menu,Access Branch Users,Field Audit FX STAR Branch User,Suspend FX STAR Branch User        | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Field Audit FX STAR Branch User,Suspend FX STAR Branch User        | Field Audit,Suspend       | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User      |
  #| Automation   | Access Admin Menu,Access Branch Users,Field Audit FX STAR Branch User,Activities FX STAR Branch User     | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Field Audit FX STAR Branch User,Activities FX STAR Branch User     | Field Audit,Activities    | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User         |
  #| Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Branches FX STAR Branch User          | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Branches FX STAR Branch User          | Activate,Branches         | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User    |
  #| Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Delete FX STAR Branch User            | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Delete FX STAR Branch User            | Activate,Delete           | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User  |
  #| Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Download FX STAR Branch User List     | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Download FX STAR Branch User List     | Activate,Download         | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User         |
  #| Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Entitlements FX STAR Branch User      | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Entitlements FX STAR Branch User     | Activate,Entitlements     | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |
  # | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Field Audit FX STAR Branch User       | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Field Audit FX STAR Branch User       | Activate,Field Audit      | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User       |
  # | Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Record Audit FX STAR Branch User      | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Record Audit FX STAR Branch User      | Activate,Record Audit     | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User        |
  #| Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Suspend FX STAR Branch User           | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Suspend FX STAR Branch User           | Activate,Suspend          | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User   |
  #| Automation   | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User,Activities FX STAR Branch User        | Rajesh2      | Rajesh@789       | Admin    | Branch User | Access Admin Menu | Admin        | Activate FX STAR Branch User,Activities FX STAR Branch User        | Activities,Activate       | Add Edit FX STAR Branch User,Branches FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User      |
