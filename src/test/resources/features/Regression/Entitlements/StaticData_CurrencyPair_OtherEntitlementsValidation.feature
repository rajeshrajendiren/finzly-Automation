Feature: StaticData_CurrencyPair_OtherEntitlement

  @UI @Regression @userRole @StaticData @CurrencyPair_OtherEntitlement @SaveBtn
  Scenario Outline: Check and Uncheck Static Data CurrencyPair with Save Button OtherEntitlement
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
    When I Click on One of the Existing Currency Pair
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
    When I Click on One of the Existing Currency Pair
    Then I Verify Save Button Disabled SuccessFully
    And I click on Logout Button; from Home Page

    @Test
    Examples: 
      | UserRoleName | EntitlementName                                                                                                                                   | ApproverUser | ApproverPassword | MenuName    | SubMenuName    | MainMenu                | MenuDropDown | SubMenu                                                                                             | InnerMenu                                 | MultipleInnerMenu                                                                          |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration                             | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration                             | New,Update,Delete                         | Download Currency Pair List,Field Audit Currency pairs,Record Audit Currency pairs         |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Download Currency Pair List                                    | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Download Currency Pair List                                    | New,Update,Download as Excel              | Delete Currency Pair Configuration,Field Audit Currency pairs,Record Audit Currency pairs  |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Field Audit Currency pairs                                     | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Field Audit Currency pairs                                     | New,Update,Field Audit                    | Delete Currency Pair Configuration,Record Audit Currency pairs,Download Currency Pair List |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Record Audit Currency pairs                                    | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Record Audit Currency pairs                                    | New,Update,Record Audit                   | Delete Currency Pair Configuration,Field Audit Currency pairs,Download Currency Pair List  |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Record Audit Currency pairs,Delete Currency Pair Configuration | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Record Audit Currency pairs,Delete Currency Pair Configuration | New,Update,Delete,Record Audit            | Field Audit Currency pairs,Download Currency Pair List                                     |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration,Field Audit Currency pairs  | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration,Field Audit Currency pairs  | New,Update,Delete,Field Audit             | Record Audit Currency pairs,Download Currency Pair List                                    |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration,Download Currency Pair List | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration,Download Currency Pair List | New,Update,Delete,Download as Excel       | Record Audit Currency pairs,Field Audit Currency pairs                                     |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Field Audit Currency pairs,Download Currency Pair List         | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Field Audit Currency pairs,Download Currency Pair List         | New,Update,Field Audit,Download as Excel  | Record Audit Currency pairs,Delete Currency Pair Configuration                             |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Record Audit Currency pairs,Download Currency Pair List        | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Record Audit Currency pairs,Download Currency Pair List        | New,Update,Record Audit,Download as Excel | Delete Currency Pair Configuration,Field Audit Currency pairs                              |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration,Record Audit Currency pairs,Field Audit Currency pairs         | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration,Record Audit Currency pairs,Field Audit Currency pairs         | New,Update,Record Audit,Field Audit       | Delete Currency Pair Configuration,Download Currency Pair List                             |

  @UI @Regression @userRole @StaticData @CurrencyPair_OtherEntitlement @WithoutSaveBtn
  Scenario Outline: Check and Uncheck Static Data CurrencyPair without Save Button Entitlement
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
      | UserRoleName | EntitlementName                                                                                              | ApproverUser | ApproverPassword | MenuName    | SubMenuName    | MainMenu                | MenuDropDown | SubMenu                                                        | InnerMenu                      | MultipleInnerMenu                                                                                   |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Delete Currency Pair Configuration,Record Audit Currency pairs | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Delete Currency Pair Configuration,Record Audit Currency pairs | Delete,Record Audit            | Add_Edit Currency Pair Configuration,Field Audit Currency pairs,Download Currency Pair List         |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Delete Currency Pair Configuration,Field Audit Currency pairs  | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Delete Currency Pair Configuration,Field Audit Currency pairs  | Delete,Field Audit             | Record Audit Currency pairs,Add_Edit Currency Pair Configuration,Download Currency Pair List        |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Delete Currency Pair Configuration,Download Currency Pair List | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Delete Currency Pair Configuration,Download Currency Pair List | Delete,Download as Excel       | Record Audit Currency pairs,Add_Edit Currency Pair Configuration,Field Audit Currency pairs         |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Download Currency Pair List,Field Audit Currency pairs         | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Download Currency Pair List,Field Audit Currency pairs         | Download as Excel,Field Audit  | Record Audit Currency pairs,Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration |
      | Automation   | Access Static Data Menu,Access Currency Pairs,Download Currency Pair List,Record Audit Currency pairs        | Rajesh2      | Rajesh@789       | Static Data | Currency Pairs | Access Static Data Menu | Static Data  | Download Currency Pair List,Record Audit Currency pairs        | Download as Excel,Record Audit | Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration,Field Audit Currency pairs  |
