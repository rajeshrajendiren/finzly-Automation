Feature: UserRoleEntitlementsOperationforStaticData


  @UI @Regression @userRole @BackOffice @fees
  Scenario Outline: Check and Uncheck BackOffice_Fees Menu  Entitlement
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
    Given I login to the FXoffice with valid credentials
    And I Click AdminTab
    And I Click UserRoleManagerButton
    And I Search the user "<UserRoleName>"
    And I Check entitlement for user "General Access"
    And I Check multiple entitlement "<EntitlementName>"
    And I Check multiple entitlement "<MultipleInnerMenu>"
    And I Check entitlement for user "<MainMenu>"
    And I Check entitlement for user "<MenuDropDown>"
    And I UnCheck entitlement for user "<UserRoleName>" "<SubMenu>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" UnChecked Successfully

    @Test
    Examples: 
      | UserRoleName     | EntitlementName                                               | ApproverUser | ApproverPassword | MenuName    | SubMenuName | MainMenu                | MenuDropDown | SubMenu                   | InnerMenu    | MultipleInnerMenu                                               |
      | AutoTestUserRole | Access Back Office Menu,Access Fees,Add_Edit Fee              | Rajesh2      | Rajesh@789       | Back Office | Fees        | Access Back Office Menu | Back Office  | Add_Edit Fee              | Add,Edit     | Cancel Fee,Fxoffice Fee record audit,Fxoffice Fee Field Audit   |
      | AutoTestUserRole | Access Back Office Menu,Access Fees,Cancel Fee                | Rajesh2      | Rajesh@789       | Back Office | Fees        | Access Back Office Menu | Back Office  | Cancel Fee                | Cancel       | Add_Edit Fee,Fxoffice Fee record audit,Fxoffice Fee Field Audit |
      | AutoTestUserRole | Access Back Office Menu,Access Fees,Fxoffice Fee record audit | Rajesh2      | Rajesh@789       | Back Office | Fees        | Access Back Office Menu | Back Office  | Fxoffice Fee record audit | Record Audit | Cancel Fee,Add_Edit Fee,Fxoffice Fee Field Audit                |
      | AutoTestUserRole | Access Back Office Menu,Access Fees,Fxoffice Fee Field Audit  | Rajesh2      | Rajesh@789       | Back Office | Fees        | Access Back Office Menu | Back Office  | Fxoffice Fee Field Audit  | Field Audit  | Cancel Fee,Fxoffice Fee record audit,Add_Edit Fee               |

  @UI @Regression @userRole @BackOffice @Accounting @GL_Balances
  Scenario Outline: Check and Uncheck BackOffice_Accounting_GL_Balances Menu  Entitlement
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
    And I Click "<MenuName>" and "<SubMenuName>" with "<Option>"
    Then I Verify "<InnerMenu>" Checked Successfully
    Given I login to the FXoffice with valid credentials
    And I Click AdminTab
    And I Click UserRoleManagerButton
    And I Search the user "<UserRoleName>"
    And I Check entitlement for user "General Access"
    And I Check multiple entitlement "<EntitlementName>"
    And I Check entitlement for user "<MainMenu>"
    And I Check entitlement for user "<MenuDropDown>"
    And I UnCheck entitlement for user "<UserRoleName>" "<SubMenu>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    And I Click "<MenuName>" and "<SubMenuName>" with "<Option>"
    Then I Verify "<InnerMenu>" UnChecked Successfully

    @Test
    Examples: 
      | UserRoleName     | EntitlementName                                                               | ApproverUser | ApproverPassword | MenuName    | SubMenuName | MainMenu                | MenuDropDown | SubMenu                     | InnerMenu        | Option        |
      | AutoTestUserRole | Access Back Office Menu,Access GL Account Balance,Download GL Account Balance | Rajesh2      | Rajesh@789       | Back Office | Accounting  | Access Back Office Menu | Back Office  | Download GL Account Balance | Download         | GL Balances   |
      

  @UI @Regression @userRole @BackOffice @Accounting @Journal_Entry
  Scenario Outline: Check and Uncheck BackOffice_Accounting_Journal_Entry  Menu  Entitlement
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
    And I Click "<MenuName>" and "<SubMenuName>" with "<Option>"
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
    And I UnCheck entitlement for user "<UserRoleName>" "<SubMenu>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    And I Click "<MenuName>" and "<SubMenuName>" with "<Option>"
    Then I Verify "<InnerMenu>" UnChecked Successfully

    @Test
    Examples: 
      | UserRoleName     | EntitlementName                                                         | ApproverUser | ApproverPassword | MenuName    | SubMenuName | MainMenu                | MenuDropDown | SubMenu                    | InnerMenu        | MultipleInnerMenu                                                                               | Option        |
      | AutoTestUserRole | Access Back Office Menu,Access Journal Entry,Add Manual Entry           | Rajesh2      | Rajesh@789       | Back Office | Accounting  | Access Back Office Menu | Back Office  | Add Manual Entry           | Add Manual Entry | Download Journal entries,Record Audit Journal Entry,Reverse Journal Entry,Approve Journal Entry | Journal Entry |
      | AutoTestUserRole | Access Back Office Menu,Access Journal Entry,Download Journal entries   | Rajesh2      | Rajesh@789       | Back Office | Accounting  | Access Back Office Menu | Back Office  | Download Journal entries   | Download         | Add Manual Entry,Record Audit Journal Entry,Reverse Journal Entry,Approve Journal Entry         | Journal Entry |
      | AutoTestUserRole | Access Back Office Menu,Access Journal Entry,Reverse Journal Entry      | Rajesh2      | Rajesh@789       | Back Office | Accounting  | Access Back Office Menu | Back Office  | Reverse Journal Entry      | Reverse          | Download Journal entries,Record Audit Journal Entry,Add Manual Entry,Approve Journal Entry      | Journal Entry |
      | AutoTestUserRole | Access Back Office Menu,Access Journal Entry,Approve Journal Entry      | Rajesh2      | Rajesh@789       | Back Office | Accounting  | Access Back Office Menu | Back Office  | Approve Journal Entry      | Approve          | Download Journal entries,Record Audit Journal Entry,Reverse Journal Entry,Add Manual Entry      | Journal Entry |
      | AutoTestUserRole | Access Back Office Menu,Access Journal Entry,Record Audit Journal Entry | Rajesh2      | Rajesh@789       | Back Office | Accounting  | Access Back Office Menu | Back Office  | Record Audit Journal Entry | Record Audit     | Download Journal entries,Add Manual Entry,Reverse Journal Entry,Approve Journal Entry           | Journal Entry |
      
      
      
      
   
