Feature: StaticData_Currency_OtherEntitlement

  @UI @Regression @userRole @StaticData @Currency_OtherEntitlement @SaveBtn
  Scenario Outline: Check and Uncheck Static Data Currency with Save Button OtherEntitlement
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
    When I Click on One of the Existing Currency Data
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
    When I Click on One of the Existing Currency Data
    Then I Verify Save Button Disabled SuccessFully
    And I click on Logout Button; from Home Page

    @Test
    Examples: 
      | UserRoleName | EntitlementName                                                                  | ApproverUser | ApproverPassword | MenuName    | SubMenuName | MainMenu                | MenuDropDown | SubMenu                                  | InnerMenu                  | MultipleInnerMenu                                                 |
      | Automation   | Access Static Data Menu,Access Currency,Add_Edit Currency,Delete Currency        | Rajesh2      | Rajesh@789       | Static Data | Currency    | Access Static Data Menu | Static Data  | Add_Edit Currency,Delete Currency        | New,Edit,Delete            | Download Currency List,Field Audit Currency,Record Audit Currency |
      | Automation   | Access Static Data Menu,Access Currency,Add_Edit Currency,Download Currency List | Rajesh2      | Rajesh@789       | Static Data | Currency    | Access Static Data Menu | Static Data  | Add_Edit Currency,Download Currency List | New,Edit,Download as Excel | Delete Currency,Field Audit Currency,Record Audit Currency        |
      | Automation   | Access Static Data Menu,Access Currency,Add_Edit Currency,Field Audit Currency   | Rajesh2      | Rajesh@789       | Static Data | Currency    | Access Static Data Menu | Static Data  | Add_Edit Currency,Field Audit Currency   | New,Edit,Field Audit       | Delete Currency,Download Currency List,Record Audit Currency      |
      | Automation   | Access Static Data Menu,Access Currency,Add_Edit Currency,Record Audit Currency  | Rajesh2      | Rajesh@789       | Static Data | Currency    | Access Static Data Menu | Static Data  | Add_Edit Currency,Record Audit Currency  | New,Edit,Record Audit      | Delete Currency,Download Currency List,Field Audit Currency       |

  @UI @Regression @userRole @StaticData @Currency_OtherEntitlement @WithoutSaveBtn
  Scenario Outline: Check and Uncheck Static Data Currency without Save Button Entitlement
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
      | UserRoleName | EntitlementName                                                                      | ApproverUser | ApproverPassword | MenuName    | SubMenuName | MainMenu                | MenuDropDown | SubMenu                                      | InnerMenu                      | MultipleInnerMenu                                              |
      | Automation   | Access Static Data Menu,Access Currency,Delete Currency,Download Currency List       | Rajesh2      | Rajesh@789       | Static Data | Currency    | Access Static Data Menu | Static Data  | Delete Currency,Download Currency List       | Delete,Download as Excel       | Add_Edit Currency,Field Audit Currency,Record Audit Currency   |
      | Automation   | Access Static Data Menu,Access Currency,Delete Currency,Field Audit Currency         | Rajesh2      | Rajesh@789       | Static Data | Currency    | Access Static Data Menu | Static Data  | Delete Currency,Field Audit Currency         | Delete,Field Audit             | Add_Edit Currency,Download Currency List,Record Audit Currency |
      | Automation   | Access Static Data Menu,Access Currency,Delete Currency,Record Audit Currency        | Rajesh2      | Rajesh@789       | Static Data | Currency    | Access Static Data Menu | Static Data  | Delete Currency,Record Audit Currency        | Delete,Record Audit            | Add_Edit Currency,Download Currency List,Field Audit Currency  |
      | Automation   | Access Static Data Menu,Access Currency,Download Currency List,Field Audit Currency  | Rajesh2      | Rajesh@789       | Static Data | Currency    | Access Static Data Menu | Static Data  | Download Currency List,Field Audit Currency  | Download as Excel,Field Audit  | Record Audit Currency,Delete Currency,Add_Edit Currency        |
      | Automation   | Access Static Data Menu,Access Currency,Download Currency List,Record Audit Currency | Rajesh2      | Rajesh@789       | Static Data | Currency    | Access Static Data Menu | Static Data  | Download Currency List,Record Audit Currency | Download as Excel,Record Audit | Record Audit Currency,Delete Currency,Add_Edit Currency        |
#Add_Edit Currency,Delete Currency
#Add_Edit Currency,Download Currency List
#Add_Edit Currency,Field Audit Currency
#Add_Edit Currency,Record Audit Currency
#Delete Currency,Download Currency List
#Delete Currency,Field Audit Currency
#Delete Currency,Record Audit Currency
#Download Currency List,Field Audit Currency
#Download Currency List,Record Audit Currency
#
#
#Download Currency List,Field Audit Currency,Record Audit Currency
#Delete Currency,Field Audit Currency,Record Audit Currency
#Delete Currency,Download Currency List,Record Audit Currency
#Delete Currency,Download Currency List,Field Audit Currency
#
#
#Add_Edit Currency,Field Audit Currency,Record Audit Currency
#Add_Edit Currency,Download Currency List,Record Audit Currency
#Add_Edit Currency,Download Currency List,Field Audit Currency
#
#Record Audit Currency,Delete Currency,Add_Edit Currency
#Delete Currency,Add_Edit Currency,Field Audit Currency
