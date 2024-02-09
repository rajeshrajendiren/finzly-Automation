Feature: StaticData_Book_OtherEntitlement

  @UI @Regression @userRole @StaticData @Book_OtherEntitlement @SaveBtn
  Scenario Outline: Check and Uncheck Static Data Book with Save Button OtherEntitlement
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
      | UserRoleName | EntitlementName                                                      | ApproverUser | ApproverPassword | MenuName    | SubMenuName | MainMenu                | MenuDropDown | SubMenu                         | InnerMenu             | MultipleInnerMenu                  |
      | Automation   | Access Static Data Menu,Access Books,Add_Edit Book,Delete Book       | Rajesh2      | Rajesh@789       | Static Data | Books       | Access Static Data Menu | Static Data  | Add_Edit Book,Delete Book       | New,Edit,Delete       | Field Audit Book,Record Audit Book |
      | Automation   | Access Static Data Menu,Access Books,Add_Edit Book,Field Audit Book  | Rajesh2      | Rajesh@789       | Static Data | Books       | Access Static Data Menu | Static Data  | Add_Edit Book,Field Audit Book  | New,Edit,Field Audit  | Delete Book,Record Audit Book      |
      | Automation   | Access Static Data Menu,Access Books,Add_Edit Book,Record Audit Book | Rajesh2      | Rajesh@789       | Static Data | Books       | Access Static Data Menu | Static Data  | Add_Edit Book,Record Audit Book | New,Edit,Record Audit | Delete Book,Field Audit Book       |

  @UI @Regression @userRole @StaticData @Book_OtherEntitlement @WithoutSaveBtn
  Scenario Outline: Check and Uncheck Static Data Book without Save Button Entitlement
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
      | UserRoleName | EntitlementName                                                         | ApproverUser | ApproverPassword | MenuName    | SubMenuName | MainMenu                | MenuDropDown | SubMenu                            | InnerMenu                | MultipleInnerMenu               |
      | Automation   | Access Static Data Menu,Access Books,Delete Book,Record Audit Book      | Rajesh2      | Rajesh@789       | Static Data | Books       | Access Static Data Menu | Static Data  | Delete Book,Record Audit Book      | Delete,Record Audit      | Add_Edit Book,Field Audit Book  |
      | Automation   | Access Static Data Menu,Access Books,Delete Book,Field Audit Book       | Rajesh2      | Rajesh@789       | Static Data | Books       | Access Static Data Menu | Static Data  | Delete Book,Field Audit Book       | Delete,Field Audit       | Add_Edit Book,Record Audit Book |
      | Automation   | Access Static Data Menu,Access Books,Field Audit Book,Record Audit Book | Rajesh2      | Rajesh@789       | Static Data | Books       | Access Static Data Menu | Static Data  | Field Audit Book,Record Audit Book | Field Audit,Record Audit | Add_Edit Book,Delete Book       |
