Feature: StaticData_Country_OtherEntitlement

  @UI @Regression @userRole @StaticData @Country_OtherEntitlement @WithoutSaveBtn
  Scenario Outline: Check and Uncheck Static Data Country without Save Button Entitlement
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
      | UserRoleName | EntitlementName                                                                                    | ApproverUser | ApproverPassword | MenuName    | SubMenuName | MainMenu                | MenuDropDown | SubMenu                                                     | InnerMenu                          | MultipleInnerMenu                                              |
      | Automation   | Access Static Data Menu,Access Country,Add_EDIT Country,Record Audit Country                       | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Add_EDIT Country,Record Audit Country                       | New,Edit,Record Audit              | Delete Country,Field Audit Country,Download Country List       |
      | Automation   | Access Static Data Menu,Access Country,Add_EDIT Country,Field Audit Country                        | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Add_EDIT Country,Field Audit Country                        | New,Edit,Field Audit               | Delete Country,Download Country List,Record Audit Country      |
      | Automation   | Access Static Data Menu,Access Country,Add_EDIT Country,Delete Country                             | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Add_EDIT Country,Delete Country                             | New,Edit,Delete                    | Field Audit Country,Download Country List,Record Audit Country |
      | Automation   | Access Static Data Menu,Access Country,Add_EDIT Country,Download Country List                      | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Add_EDIT Country,Download Country List                      | New,Edit,Download as Excel         | Delete Country,Field Audit Country,Record Audit Country        |
      | Automation   | Access Static Data Menu,Access Country,Delete Country,Download Country List                        | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Delete Country,Download Country List                        | Delete,Download as Excel           | Add_EDIT Country,Field Audit Country,Record Audit Country      |
      | Automation   | Access Static Data Menu,Access Country,Delete Country,Field Audit Country                          | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Delete Country,Field Audit Country                          | Delete,Field Audit                 | Download Country List,Add_EDIT Country,Record Audit Country    |
      | Automation   | Access Static Data Menu,Access Country,Delete Country,Record Audit Country                         | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Delete Country,Record Audit Country                         | Delete,Record Audit                | Field Audit Country,Download Country List,Add_EDIT Country     |
      | Automation   | Access Static Data Menu,Access Country,Download Country List,Record Audit Country                  | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Download Country List,Record Audit Country                  | Download as Excel,Record Audit     | Field Audit Country,Add_EDIT Country,Delete Country            |
      | Automation   | Access Static Data Menu,Access Country,Download Country List,Field Audit Country                   | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Download Country List,Field Audit Country                   | Download as Excel,Field Audit      | Add_EDIT Country,Delete Country,Record Audit Country           |
      | Automation   | Access Static Data Menu,Access Country,Field Audit Country,Record Audit Country                    | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Field Audit Country,Record Audit Country                    | Field Audit,Record Audit           | Add_EDIT Country,Delete Country,Record Audit Country           |
      | Automation   | Access Static Data Menu,Access Country,Add_EDIT Country,Download Country List,Record Audit Country | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Add_EDIT Country,Download Country List,Record Audit Country | New,Download as Excel,Record Audit | Add_EDIT Country,Delete Country,Download Country List          |
      | Automation   | Access Static Data Menu,Access Country,Add_EDIT Country,Download Country List,Field Audit Country  | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Add_EDIT Country,Download Country List,Field Audit Country  | Field Audit,New,Edit,Download as Excel  | Delete Country,Field Audit Country                             |
      | Automation   | Access Static Data Menu,Access Country,Add_EDIT Country,Delete Country,Field Audit Country         | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Add_EDIT Country,Delete Country,Field Audit Country         | Field Audit,New,Edit,Delete        | Delete Country,Record Audit Country                            |
      | Automation   | Access Static Data Menu,Access Country,Add_EDIT Country,Delete Country,Record Audit Country        | Rajesh2      | Rajesh@789       | Static Data | Country     | Access Static Data Menu | Static Data  | Add_EDIT Country,Delete Country,Record Audit Country        | New,Edit,Delete,Record Audit       | Download Country List,Field Audit Country                      |
