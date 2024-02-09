Feature: UserRoleEntitlementsOperation

  @UI @Regression @userRole @MCA
  Scenario Outline: Check and uncheck Access MCA Menu Entitlement
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
    And I UnCheck multiple entitlement for user "<UserRoleName>" "<SubMenu>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" UnChecked Successfully

    @Test
    Examples: 
      | UserRoleName     | EntitlementName                        | ApproverUser | ApproverPassword | MenuName | SubMenuName     | MainMenu        | MenuDropDown | SubMenu                |
      | AutoTestUserRole | Access MCA Menu,Access Products        | Rajesh2      | Rajesh@789       | MCA      | Products        | Access MCA Menu | MCA          | Access Products        |
      | AutoTestUserRole | Access MCA Menu,Access Master Accounts | Rajesh2      | Rajesh@789       | MCA      | Master Accounts | Access MCA Menu | MCA          | Access Master Accounts |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Access Client Accounts |
      | AutoTestUserRole | Access MCA Menu,Access Transactions    | Rajesh2      | Rajesh@789       | MCA      | Transactions    | Access MCA Menu | MCA          | Access Transactions    |

  @UI @Regression @userRole @MCA @MCA_Products
  Scenario Outline: Check and Uncheck MCA_Products Menu  Entitlement
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
    And I UnCheck multiple entitlement for user "<UserRoleName>" "<SubMenu>"
    And I Click Save Button
    And I Click SuccessMessage OK button
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" UnChecked Successfully

    @Test
    Examples: 
      | UserRoleName     | EntitlementName                                       | ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu        | MenuDropDown | SubMenu               | InnerMenu    | MultipleInnerMenu                                          |
      | AutoTestUserRole | Access MCA Menu,Access Products,Add_Edit              | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Add_Edit              | Add,Edit     | Delete Products,Field Audit Products,Record Audit Products |
      | AutoTestUserRole | Access MCA Menu,Access Products,Delete Products       | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Delete Products       | Delete       | Add_Edit,Field Audit Products,Record Audit Products        |
      | AutoTestUserRole | Access MCA Menu,Access Products,Field Audit Products  | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Field Audit Products  | Field Audit  | Add_Edit,Delete Products,Record Audit Products             |
      | AutoTestUserRole | Access MCA Menu,Access Products,Record Audit Products | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Record Audit Products | Record Audit | Add_Edit,Delete Products,Field Audit Products              |

  @UI @Regression @userRole @MCA @MCA_Master_Accounts
  Scenario Outline: Check and Uncheck MCA_Master_Accounts Menu  Entitlement
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
      | UserRoleName     | EntitlementName                                                       | ApproverUser | ApproverPassword | MenuName | SubMenuName     | MainMenu        | MenuDropDown | SubMenu                        | InnerMenu   | MultipleInnerMenu                                                                    |
      | AutoTestUserRole | Access MCA Menu,Access Master Accounts,Add_Edit MCA Master Account    | Rajesh2      | Rajesh@789       | MCA      | Master Accounts | Access MCA Menu | MCA          | Add_Edit MCA Master Account    | New,Edit    | Delete MCA Master Account,Download as Excel,Field Audit MCA Master Account           |
      | AutoTestUserRole | Access MCA Menu,Access Master Accounts,Delete MCA Master Account      | Rajesh2      | Rajesh@789       | MCA      | Master Accounts | Access MCA Menu | MCA          | Delete MCA Master Account      | Delete      | Add_Edit MCA Master Account,Download as Excel,Field Audit MCA Master Account         |
      | AutoTestUserRole | Access MCA Menu,Access Master Accounts,Download as Excel              | Rajesh2      | Rajesh@789       | MCA      | Master Accounts | Access MCA Menu | MCA          | Download as Excel              | Download    | Delete MCA Master Account,Add_Edit MCA Master Account,Field Audit MCA Master Account |
      | AutoTestUserRole | Access MCA Menu,Access Master Accounts,Field Audit MCA Master Account | Rajesh2      | Rajesh@789       | MCA      | Master Accounts | Access MCA Menu | MCA          | Field Audit MCA Master Account | Field Audit | Delete MCA Master Account,Download as Excel,Add_Edit MCA Master Account              |

  @UI @Regression @userRole @MCA @MCA_Client_Accounts
  Scenario Outline: Check and Uncheck MCA_Client_Accounts Menu  Entitlement
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
      | UserRoleName     | EntitlementName                                                        | ApproverUser | ApproverPassword | MenuName | SubMenuName     | MainMenu        | MenuDropDown | SubMenu                         | InnerMenu                | MultipleInnerMenu                                                                                                                                                                                                                                     |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Activate MCA Client Account     | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Activate MCA Client Account     | Activate Account         | Add_Edit MCA Client Account,Manual Debit Transaction,Manual Credit Transaction,Download as Excel,Delete MCA Client Account,Field Audit MCA Client Account,Generate MCA Statement,Record Audit MCA Client Account,Suspend MCA Client Account           |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Add_Edit MCA Client Account     | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Add_Edit MCA Client Account     | New Account,Edit Account | Activate MCA Client Account,Manual Debit Transaction,Manual Credit Transaction,Download as Excel,Delete MCA Client Account,Field Audit MCA Client Account,Generate MCA Statement,Record Audit MCA Client Account,Suspend MCA Client Account           |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Manual Debit Transaction        | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Manual Debit Transaction        | Manual Debit             | Activate MCA Client Account,Add_Edit MCA Client Account,Manual Credit Transaction,Download as Excel,Delete MCA Client Account,Field Audit MCA Client Account,Generate MCA Statement,Record Audit MCA Client Account,Suspend MCA Client Account        |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Manual Credit Transaction       | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Manual Credit Transaction       | Manual Credit            | Activate MCA Client Account,Add_Edit MCA Client Account,Manual Debit Transaction,Download as Excel,Delete MCA Client Account,Field Audit MCA Client Account,Generate MCA Statement,Record Audit MCA Client Account,Suspend MCA Client Account         |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Download as Excel               | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Download as Excel               | Download                 | Activate MCA Client Account,Add_Edit MCA Client Account,Manual Debit Transaction,Manual Credit Transaction,Delete MCA Client Account,Field Audit MCA Client Account,Generate MCA Statement,Record Audit MCA Client Account,Suspend MCA Client Account |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Delete MCA Client Account       | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Delete MCA Client Account       | Delete Account           | Activate MCA Client Account,Add_Edit MCA Client Account,Manual Debit Transaction,Manual Credit Transaction,Download as Excel,Field Audit MCA Client Account,Generate MCA Statement,Record Audit MCA Client Account,Suspend MCA Client Account         |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Field Audit MCA Client Account  | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Field Audit MCA Client Account  | Field Audit              | Activate MCA Client Account,Add_Edit MCA Client Account,Manual Debit Transaction,Manual Credit Transaction,Download as Excel,Delete MCA Client Account,Generate MCA Statement,Record Audit MCA Client Account,Suspend MCA Client Account              |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Generate MCA Statement          | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Generate MCA Statement          | MCA Statement            | Activate MCA Client Account,Add_Edit MCA Client Account,Manual Debit Transaction,Manual Credit Transaction,Download as Excel,Delete MCA Client Account,Field Audit MCA Client Account,Record Audit MCA Client Account,Suspend MCA Client Account      |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Record Audit MCA Client Account | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Record Audit MCA Client Account | Record Audit             | Activate MCA Client Account,Add_Edit MCA Client Account,Manual Debit Transaction,Manual Credit Transaction,Download as Excel,Delete MCA Client Account,Field Audit MCA Client Account,Generate MCA Statement,Suspend MCA Client Account               |
      | AutoTestUserRole | Access MCA Menu,Access Client Accounts,Suspend MCA Client Account      | Rajesh2      | Rajesh@789       | MCA      | Client Accounts | Access MCA Menu | MCA          | Suspend MCA Client Account      | Suspend Account          | Activate MCA Client Account,Add_Edit MCA Client Account,Manual Debit Transaction,Manual Credit Transaction,Download as Excel,Delete MCA Client Account,Field Audit MCA Client Account,Generate MCA Statement,Record Audit MCA Client Account          |

  #Activate MCA Client Account,Add_Edit MCA Client Account,Manual Debit Transaction,Manual Credit Transaction,Download as Excel,Delete MCA Client Account,Field Audit MCA Client Account,Generate MCA Statement,Record Audit MCA Client Account,Suspend MCA Client Account
  @UI @Regression @userRole @MCA @MCA_Transaction
  Scenario Outline: Check and Uncheck MCA_Transaction Menu  Entitlement
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
    And I Check entitlement for user "<MultipleInnerMenu>"
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
      | UserRoleName     | EntitlementName                                          | ApproverUser | ApproverPassword | MenuName | SubMenuName  | MainMenu        | MenuDropDown | SubMenu              | InnerMenu | MultipleInnerMenu    |
      | AutoTestUserRole | Access MCA Menu,Access Transactions,Download Transaction | Rajesh2      | Rajesh@789       | MCA      | Transactions | Access MCA Menu | MCA          | Download Transaction | Download  | Download Transaction |
