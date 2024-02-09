Feature: MCA_Product_OtherEntitlement

  @UI @Regression @userRole @MCA @Product_OtherEntitlement @WithoutSaveBtn
  Scenario Outline: Check and Uncheck MCA Products without Save Button Entitlement
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
      | UserRoleName | EntitlementName                                                                                | ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu        | MenuDropDown | SubMenu                                                        | InnerMenu                              | MultipleInnerMenu                                                 |
      | Automation   | Access MCA Menu,Access Products,Add_EDIT Products,Record Audit Products                        | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Add_EDIT Products,Record Audit Products                        | New,Edit,Record Audit                  | Delete Products,Field Audit Products,Download Products List       |
      | Automation   | Access MCA Menu,Access Products,Add_EDIT Products,Field Audit Products                         | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Add_EDIT Products,Field Audit Products                         | New,Edit,Field Audit                   | Delete Products,Download Products List,Record Audit Products      |
      | Automation   | Access MCA Menu,Access Products,Add_EDIT Products,Delete Products                              | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Add_EDIT Products,Delete Products                              | New,Edit,Delete                        | Field Audit Products,Download Products List,Record Audit Products |
      | Automation   | Access MCA Menu,Access Products,Add_EDIT Products,Download Products List                       | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Add_EDIT Products,Download Products List                       | New,Edit,Download as Excel             | Delete Products,Field Audit Products,Record Audit Products        |
      | Automation   | Access MCA Menu,Access Products,Delete Products,Download Products List                         | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Delete Products,Download Products List                         | Delete,Download as Excel               | Add_EDIT Products,Field Audit Products,Record Audit Products      |
      | Automation   | Access MCA Menu,Access Products,Delete Products,Field Audit Products                           | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Delete Products,Field Audit Products                           | Delete,Field Audit                     | Download Products List,Add_EDIT Products,Record Audit Products    |
      | Automation   | Access MCA Menu,Access Products,Delete Products,Record Audit Products                          | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Delete Products,Record Audit Products                          | Delete,Record Audit                    | Field Audit Products,Download Products List,Add_EDIT Products     |
      | Automation   | Access MCA Menu,Access Products,Download Products List,Record Audit Products                   | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Download Products List,Record Audit Products                   | Download as Excel,Record Audit         | Field Audit Products,Add_EDIT Products,Delete Products            |
      | Automation   | Access MCA Menu,Access Products,Download Products List,Field Audit Products                    | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Download Products List,Field Audit Products                    | Download as Excel,Field Audit          | Add_EDIT Products,Delete Products,Record Audit Products           |
      | Automation   | Access MCA Menu,Access Products,Field Audit Products,Record Audit Products                     | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Field Audit Products,Record Audit Products                     | Field Audit,Record Audit               | Add_EDIT Products,Delete Products,Record Audit Products           |
      | Automation   | Access MCA Menu,Access Products,Add_EDIT Products,Download Products List,Record Audit Products | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Add_EDIT Products,Download Products List,Record Audit Products | New,Download as Excel,Record Audit     | Add_EDIT Products,Delete Products,Download Products List          |
      | Automation   | Access MCA Menu,Access Products,Add_EDIT Products,Download Products List,Field Audit Products  | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Add_EDIT Products,Download Products List,Field Audit Products  | Field Audit,New,Edit,Download as Excel | Delete Products,Field Audit Products                              |
      | Automation   | Access MCA Menu,Access Products,Add_EDIT Products,Delete Products,Field Audit Products         | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Add_EDIT Products,Delete Products,Field Audit Products         | Field Audit,New,Edit,Delete            | Delete Products,Record Audit Products                             |
      | Automation   | Access MCA Menu,Access Products,Add_EDIT Products,Delete Products,Record Audit Products        | Rajesh2      | Rajesh@789       | MCA      | Products    | Access MCA Menu | MCA          | Add_EDIT Products,Delete Products,Record Audit Products        | New,Edit,Delete,Record Audit           | Download Products List,Field Audit Products                       |
