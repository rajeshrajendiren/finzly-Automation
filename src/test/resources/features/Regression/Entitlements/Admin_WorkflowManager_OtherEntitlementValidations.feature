Feature: AdminWorkflowManagerOtherEntitlement

  @UI @Regression @userRole @Admin @AdminWorkflowManagerOtherEntitlement @WithoutSaveBtn
  Scenario Outline: Check and Uncheck AdminWorkflowManagerOtherEntitlement  Entitlement
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
      | UserRoleName | EntitlementName                                                                        | ApproverUser | ApproverPassword | MenuName | SubMenuName      | MainMenu          | MenuDropDown | SubMenu                                      | InnerMenu             | MultipleInnerMenu                                                     |
      | Automation   | Access Admin Menu,Access Workflow Manager,Delete Workflow,Add Workflow                 | Rajesh2      | Rajesh@789       | Admin    | Workflow Manager | Access Admin Menu | Admin        | Delete Workflow,Add Workflow                 | Delete,New            | Field Audit Workflow Manager,Modify Workflow,Creates New Workflow Job |
      | Automation   | Access Admin Menu,Access Workflow Manager,Add Workflow,Modify Workflow                 | Rajesh2      | Rajesh@789       | Admin    | Workflow Manager | Access Admin Menu | Admin        | Add Workflow,Modify Workflow                 | New,Modify            | Creates New Workflow Job,Delete Workflow,Field Audit Workflow Manager |
      | Automation   | Access Admin Menu,Access Workflow Manager,Add Workflow,Field Audit Workflow Manager    | Rajesh2      | Rajesh@789       | Admin    | Workflow Manager | Access Admin Menu | Admin        | Add Workflow,Field Audit Workflow Manager    | New,Field Audit       | Creates New Workflow Job,Delete Workflow,Modify Workflow              |
      | Automation   | Access Admin Menu,Access Workflow Manager,Add Workflow,Creates New Workflow Job        | Rajesh2      | Rajesh@789       | Admin    | Workflow Manager | Access Admin Menu | Admin        | Add Workflow,Creates New Workflow Job        | New,Create New Job    | Delete Workflow,Modify Workflow,Field Audit Workflow Manager          |
      | Automation   | Access Admin Menu,Access Workflow Manager,Modify Workflow,Creates New Workflow Job     | Rajesh2      | Rajesh@789       | Admin    | Workflow Manager | Access Admin Menu | Admin        | Modify Workflow,Creates New Workflow Job     | Modify,Create New Job | Delete Workflow,Add Workflow,Field Audit Workflow Manager             |
      | Automation   | Access Admin Menu,Access Workflow Manager,Modify Workflow,Field Audit Workflow Manager | Rajesh2      | Rajesh@789       | Admin    | Workflow Manager | Access Admin Menu | Admin        | Modify Workflow,Field Audit Workflow Manager | Modify,Field Audit    | Creates New Workflow Job,Delete Workflow,Add Workflow                 |
      | Automation   | Access Admin Menu,Access Workflow Manager,Delete Workflow,Modify Workflow              | Rajesh2      | Rajesh@789       | Admin    | Workflow Manager | Access Admin Menu | Admin        | Delete Workflow,Modify Workflow              | Delete,Modify         | Creates New Workflow Job,Add Workflow,Field Audit Workflow Manager    |
      | Automation   | Access Admin Menu,Access Workflow Manager,Delete Workflow,Field Audit Workflow Manager | Rajesh2      | Rajesh@789       | Admin    | Workflow Manager | Access Admin Menu | Admin        | Delete Workflow,Field Audit Workflow Manager | Delete,Field Audit    | Modify Workflow,Creates New Workflow Job,Add Workflow                 |
      | Automation   | Access Admin Menu,Access Workflow Manager,Delete Workflow,Creates New Workflow Job     | Rajesh2      | Rajesh@789       | Admin    | Workflow Manager | Access Admin Menu | Admin        | Delete Workflow,Creates New Workflow Job     | Delete,Create New Job | Field Audit Workflow Manager,Modify Workflow,Add Workflow             |
