
Feature: UserRoleEntitlementsOperationforStaticData
   
@UI @Regression  @userRole @Staticdata(Level2) @StaticdataEntitlements 
Scenario Outline: Check and Uncheck Access staticdata Menu Entitlement
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
   And I UnCheck entitlement for user "<UserRoleName>" "<SubMenu>"
   And I Click Save Button
   And I Click SuccessMessage OK button
   And I click on Logout Button; from Home Page
   When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
   Then I Verify "<MenuDropDown>" single submenu "<SubMenu>" UnChecked Successfully
  
   
 @Test
Examples: 
   | UserRoleName      | EntitlementName                               |   ApproverUser | ApproverPassword | MenuName    |SubMenuName       | MainMenu 							 | MenuDropDown | SubMenu |
   | AutoTestUserRole  | Access Static Data Menu,Access Book Router    |   flevia2      |    Finzly@123    | Static Data |Book Router       |Access Static Data Menu | Static Data  | Access Book Router |
   | AutoTestUserRole  | Access Static Data Menu,Access Books          |   flevia2      |    Finzly@123    | Static Data | Books            |Access Static Data Menu | Static Data  | Access Books |
   | AutoTestUserRole  | Access Static Data Menu,Access Country        |   flevia2      |    Finzly@123    | Static Data | Country         |Access Static Data Menu | Static Data  | Access Country |
   | AutoTestUserRole  | Access Static Data Menu,Access Currency Pairs |   flevia2      |    Finzly@123    | Static Data | Currency Pairs  |Access Static Data Menu | Static Data  | Access Currency Pairs |
   | AutoTestUserRole  | Access Static Data Menu,Access Currency       |   flevia2      |    Finzly@123    | Static Data | Currency        |Access Static Data Menu | Static Data  | Access Currency |
   | AutoTestUserRole  | Access Static Data Menu,Access Fixing Source  |   flevia2      |    Finzly@123    | Static Data | Fixing Source   |Access Static Data Menu | Static Data  | Access Fixing Source |
   | AutoTestUserRole  | Access Static Data Menu,Access Holidays       |   flevia2      |    Finzly@123    | Static Data | Holidays        |Access Static Data Menu | Static Data  | Access Holidays |
   | AutoTestUserRole  | Access Static Data Menu,Access Rate Config    |   flevia2      |    Finzly@123    | Static Data | Rate Config     |Access Static Data Menu | Static Data  | Access Rate Config |
   | AutoTestUserRole  | Access Static Data Menu,Access Value Date     |   flevia2      |    Finzly@123    | Static Data | Value Date      |Access Static Data Menu | Static Data  | Access Value Date |


@UI @Regression  @userRole @Staticdata(Level2) @StaticData_RateConfig  
Scenario Outline: Check and Uncheck  Delete StaticData_RateConfig Entitlement settings
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
    | UserRoleName      | EntitlementName                                                   |   ApproverUser | ApproverPassword | MenuName       | SubMenuName     | MainMenu 							 | MenuDropDown | SubMenu            | InnerMenu     | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Static Data Menu,Access Rate Config,Delete Rate Config     |   flevia2      |    Finzly@123    | Static Data    | Rate Config     |Access Static Data Menu | Static Data  | Delete Rate Config  | Delete         | Add_Edit Rate Config|
    | AutoTestUserRole  | Access Static Data Menu,Access Rate Config,Add_Edit Rate Config   |   flevia2      |    Finzly@123    | Static Data    | Rate Config     |Access Static Data Menu | Static Data   | Add_Edit Rate Config|   New,Update         |  Delete Rate Config  |
    
    
   @UI @Regression  @userRole @Staticdata(Level2) @StaticData_Currency    
Scenario Outline: Check and Uncheck StaticData_currency Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                   |   ApproverUser | ApproverPassword | MenuName       | SubMenuName     | MainMenu 							| MenuDropDown| SubMenu                 | InnerMenu          | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Static Data Menu,Access Currency,Record Audit Currency     |   flevia2      |    Finzly@123    | Static Data    | Currency        |Access Static Data Menu | Static Data  | Record Audit Currency   | Record Audit       |Field Audit Currency,Add_Edit Currency,Delete Currency,Download Currency List|
    | AutoTestUserRole  | Access Static Data Menu,Access Currency,Field Audit Currency      |   flevia2      |    Finzly@123    | Static Data    | Currency        |Access Static Data Menu | Static Data  | Field Audit Currency   | Field Audit        |Record Audit Currency,Add_Edit Currency,Delete Currency,Download Currency List|
    | AutoTestUserRole  | Access Static Data Menu,Access Currency,Add_Edit Currency         |   flevia2      |    Finzly@123    | Static Data    | Currency        |Access Static Data Menu | Static Data  | Add_Edit Currency      | New,Edit         |Record Audit Currency,Field Audit Currency,Delete Currency,Download Currency List  |
    | AutoTestUserRole  | Access Static Data Menu,Access Currency,Delete Currency          |   flevia2      |    Finzly@123    | Static Data    | Currency        |Access Static Data Menu | Static Data   | Delete Currency        | Delete             |Record Audit Currency,Field Audit Currency,Add_Edit Currency,Download Currency List|
    | AutoTestUserRole  | Access Static Data Menu,Access Currency,Download Currency List   |   flevia2      |    Finzly@123    | Static Data    | Currency        |Access Static Data Menu | Static Data   | Download Currency List | Download as Excel  |Record Audit Currency,Field Audit Currency,Add_Edit Currency,Delete Currency  |
    
    
@UI @Regression  @userRole @Staticdata(Level2) @StaticData_Books    
Scenario Outline: Check and Uncheck StaticData_Books Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                             |   ApproverUser | ApproverPassword | MenuName       | SubMenuName  | MainMenu 							| MenuDropDown | SubMenu             | InnerMenu          | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Static Data Menu,Access Books,Record Audit Book     |   flevia2      |    Finzly@123    | Static Data    | Books        |Access Static Data Menu | Static Data  | Record Audit Book  | Record Audit       |Field Audit Book,Add_Edit Book,Delete Book      |
    | AutoTestUserRole  | Access Static Data Menu,Access Books,Field Audit Book      |   flevia2      |    Finzly@123    | Static Data    | Books        |Access Static Data Menu | Static Data  | Field Audit Book   | Field Audit        |Record Audit Book,Add_Edit Book,Delete Book     |
    | AutoTestUserRole  | Access Static Data Menu,Access Books,Add_Edit Book        |   flevia2      |    Finzly@123    | Static Data    | Books        |Access Static Data Menu | Static Data  | Add_Edit Book      | New,Edit           |Record Audit Book,Field Audit Book,Delete Book  |
    | AutoTestUserRole  | Access Static Data Menu,Access Books,Delete Book           |   flevia2      |    Finzly@123    | Static Data    | Books        |Access Static Data Menu | Static Data   | Delete Book       | Delete             |Record Audit Book,Field Audit Book,Add_Edit Book|
    
    
    
@UI @Regression  @userRole @Staticdata(Level2) @StaticData_BookRouter    
Scenario Outline: Check and Uncheck StaticData_ Book Router Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                   |   ApproverUser | ApproverPassword | MenuName       | SubMenuName   | MainMenu 							| MenuDropDown | SubMenu              | InnerMenu     | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Static Data Menu,Access Book Router,Add_Edit Book Router   |   flevia2      |    Finzly@123    | Static Data    | Book Router  |Access Static Data Menu | Static Data  | Add_Edit Book Router | New,Edit      |Delete Book Router  |
    | AutoTestUserRole  | Access Static Data Menu,Access Book Router,Delete Book Router     |   flevia2      |    Finzly@123    | Static Data    | Book Router  |Access Static Data Menu | Static Data  | Delete Book Router   | Delete        |Add_Edit Book Router|
    
    
    @UI @Regression  @userRole @Staticdata(Level2) @StaticData_FixingSource    
Scenario Outline: Check and Uncheck StaticData_Fixing Source Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                          |   ApproverUser | ApproverPassword | MenuName       | SubMenuName    | MainMenu 							| MenuDropDown | SubMenu            | InnerMenu      | MultipleInnerMenu                                            |
    | AutoTestUserRole  | Access Static Data Menu,Access Fixing Source,Record Audit Fixing Source  |   flevia2      |    Finzly@123    | Static Data    | Fixing Source  |Access Static Data Menu | Static Data  | Record Audit       |Record Audit   |Field Audit Fixing Source,Add_Edit Fixing Source,Delete Fixing Source |
    | AutoTestUserRole  | Access Static Data Menu,Access Fixing Source,Field Audit Fixing Source   |   flevia2      |    Finzly@123    | Static Data    | Fixing Source  |Access Static Data Menu | Static Data  | Field Audit Book   | Field Audit   |Record Audit Fixing Source,Add_Edit Fixing Source,Delete Fixing Source |
    | AutoTestUserRole  | Access Static Data Menu,Access Fixing Source,Add_Edit Fixing Source      |   flevia2      |    Finzly@123    | Static Data    | Fixing Source  |Access Static Data Menu | Static Data  | Add_Edit Book      | New,Edit      |Record Audit Fixing Source,Field Audit Fixing Source,Delete Fixing Source |
    | AutoTestUserRole  | Access Static Data Menu,Access Fixing Source,Delete Fixing Source        |   flevia2      |    Finzly@123    | Static Data    | Fixing Source  |Access Static Data Menu | Static Data  | Delete Book        | Delete        |Record Audit Fixing Source,Field Audit Fixing Source,Add_Edit Fixing Source|
     
   
   @UI @Regression  @userRole @Staticdata(Level2) @StaticData_ValueDate    
Scenario Outline: Check and Uncheck StaticData_ ValueDate Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                  |   ApproverUser | ApproverPassword | MenuName       | SubMenuName | MainMenu 							| MenuDropDown | SubMenu              | InnerMenu     | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Static Data Menu,Access Value Date,Add_Edit Value Date  |   flevia2      |    Finzly@123     | Static Data     | Value Date  |Access Static Data Menu | Static Data  | Add_Edit Value Date | New,Edit      |Delete Value Date  |
    | AutoTestUserRole  | Access Static Data Menu,Access Value Date,Delete Value Date     |   flevia2      |    Finzly@123    | Static Data     | Value Date  |Access Static Data Menu | Static Data  | Delete Value Date   | Delete        |Add_Edit Value Date|
    
    @UI @Regression  @userRole @Staticdata(Level2) @StaticData_CurrencyPair    
Scenario Outline: Check and Uncheck StaticData_Currency Pair Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                                     |   ApproverUser | ApproverPassword | MenuName       | SubMenuName     | MainMenu 							| MenuDropDown | SubMenu                              |    InnerMenu       | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Static Data Menu,Access Currency Pairs,Record Audit Currency pairs           |   flevia2      |    Finzly@123    | Static Data    | Currency Pairs  |Access Static Data Menu | Static Data  | Record Audit Currency pairs          | Record Audit       |Field Audit Currency pairs,Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration,Download Currency Pair List|
    | AutoTestUserRole  | Access Static Data Menu,Access Currency Pairs,Field Audit Currency pairs           |   flevia2      |    Finzly@123    | Static Data    | Currency Pairs  |Access Static Data Menu | Static Data  | Field Audit Currency pairs           | Field Audit        |Record Audit Currency pairs,Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration,Download Currency Pair List|
    | AutoTestUserRole  | Access Static Data Menu,Access Currency Pairs,Add_Edit Currency Pair Configuration |   flevia2      |    Finzly@123    | Static Data    | Currency Pairs  |Access Static Data Menu | Static Data  | Add_Edit Currency Pair Configuration | New,Update          |Record Audit Currency pairs,Field Audit Currency pairs,Delete Currency Pair Configuration,Download Currency Pair List  |
    | AutoTestUserRole  | Access Static Data Menu,Access Currency Pairs,Delete Currency Pair Configuration   |   flevia2      |    Finzly@123    | Static Data    | Currency Pairs |Access Static Data Menu | Static Data  | Delete Currency Pair Configuration   | Delete             |Record Audit Currency pairs,Field Audit Currency pairs,Add_Edit Currency Pair Configuration,Download Currency Pair List|
    | AutoTestUserRole  | Access Static Data Menu,Access Currency Pairs,Download Currency Pair List          |   flevia2      |    Finzly@123    | Static Data    | Currency Pairs  |Access Static Data Menu | Static Data  | Download Currency Pair List          | Download as Excel  |Record Audit Currency pairs,Field Audit Currency pairs,Add_Edit Currency Pair Configuration,Delete Currency Pair Configuration  |
    
    
@UI @Regression  @userRole @Staticdata(Level2) @StaticData_Holidays     
Scenario Outline: Check and Uncheck StaticData_Holidays  Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                            |   ApproverUser | ApproverPassword | MenuName       | SubMenuName | MainMenu 							| MenuDropDown | SubMenu            | InnerMenu     | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Static Data Menu,Access Holidays,Add_Edit Holidays  |   flevia2      |    Finzly@123    | Static Data    | Holidays    |Access Static Data Menu | Static Data  | Add_Edit Holidays | New,Update     | Delete Holidays    |
    | AutoTestUserRole  | Access Static Data Menu,Access Holidays,Delete Holidays    |   flevia2      |    Finzly@123    | Static Data    | Holidays    |Access Static Data Menu | Static Data  | Delete Holidays   | Delete        | Add_Edit Holidays  |
    
    
 @UI @Regression  @userRole @Staticdata(Level2) @StaticData_Country     
Scenario Outline: Check and Uncheck StaticData_Country  Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                   |   ApproverUser | ApproverPassword | MenuName       | SubMenuName     | MainMenu 							| MenuDropDown| SubMenu                 | InnerMenu       | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Static Data Menu,Access Country,Record Audit Country     |   flevia2      |    Finzly@123    | Static Data    | Country        |Access Static Data Menu | Static Data  | Record Audit Country   | Record Audit       |Field Audit Country,Add_EDIT Country,Delete Country,Download Country List|
    | AutoTestUserRole  | Access Static Data Menu,Access Country,Field Audit Country      |   flevia2      |    Finzly@123    | Static Data    | Country        |Access Static Data Menu | Static Data  | Field Audit Country   | Field Audit        |Record Audit Country,Add_EDIT Country,Delete Country,Download Country List|
    | AutoTestUserRole  | Access Static Data Menu,Access Country,Add_EDIT Country         |   flevia2      |    Finzly@123    | Static Data    | Country        |Access Static Data Menu | Static Data  | Add_EDIT Country      | New,Edit           |Record Audit Country,Field Audit Country,Delete Country,Download Country List  |
    | AutoTestUserRole  | Access Static Data Menu,Access Country,Delete Country          |   flevia2      |    Finzly@123    | Static Data    | Country        |Access Static Data Menu | Static Data   | Delete Country        | Delete             |Record Audit Country,Field Audit Country,Add_EDIT Country,Download Country List|
    | AutoTestUserRole  | Access Static Data Menu,Access Country,Download Country List   |   flevia2      |    Finzly@123    | Static Data    | Country        |Access Static Data Menu | Static Data   | Download Country List | Download as Excel  |Record Audit Country,Field Audit Country,Add_EDIT Country,Delete Country  |