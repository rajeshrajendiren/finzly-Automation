
Feature: UserRoleEntitlementsOperationforStaticData
   
@UI @Regression  @userRole    @Entitymanager(level4)     @AccessEnttityManagerMenu
Scenario Outline: Check and Uncheck Access Enttity Manager  Menu Entitlement
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
   | UserRoleName      | EntitlementName                                    |   ApproverUser | ApproverPassword | MenuName    | SubMenuName      | MainMenu 							    | MenuDropDown   | SubMenu             |
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units  |   flevia2      |    Finzly@123    | Entity Manager | Business Units   | Access Enttity Manager Menu| Entity Manager |Access Business Units|
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Legal Entities  |   flevia2      |    Finzly@123    | Entity Manager | Legal Entities   | Access Enttity Manager Menu| Entity Manager |Access Legal Entities|            
   



@UI @Regression  @userRole  @EntityManager-BusinessUnit(Level5)  @AccessBusinessUnitMenu 
Scenario Outline: Check and Uncheck Access Enttity Manager-BusinessUnit Menu Entitlement
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
   Then I Verify "<MenuName>" single submenu "<SubMenuName>" and "<InnerMenu>" Checked Successfully
   
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
   Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and "<InnerMenu>" UnChecked Successfully
   
 @Test
Examples: 
   | UserRoleName      | EntitlementName                                                                 |   ApproverUser | ApproverPassword | MenuName       | SubMenuName      | MainMenu 							    | MenuDropDown   | SubMenu                    |InnerMenu            |  MultipleInnerMenu                                  |
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Message Announcements  |   flevia2      |    Finzly@123    | Entity Manager | Business Units   | Access Enttity Manager Menu| Entity Manager |Manage Message Announcements|Message Announcements| Manage GL Accounts,Manage Nostro Accounts           |
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage GL Accounts            |   flevia2      |    Finzly@123    | Entity Manager | Business Units   | Access Enttity Manager Menu| Entity Manager |Manage GL Accounts         | GL Accounts         | Manage Message Announcements,Manage Nostro Accounts |
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Nostro Accounts        |   flevia2      |    Finzly@123    | Entity Manager | Business Units   | Access Enttity Manager Menu| Entity Manager |Manage Nostro Accounts     |Nostro Accounts      | Manage Message Announcements,Manage GL Accounts |  
   
   @UI @Regression  @userRole @Admin(level3) @EntityManager_BusinessUnit_NostroEntitlement       
Scenario Outline: Check and Uncheck EntityManager_BusinessUnit_NostroEntitlement Menu  Entitlement 
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
      Then I click "<MenuName>" "<SubMenuName>" "<BusinessUnitOption>" and click "<InnerMenu>" and verify checked sucessfully
     # Then I Verify "<MenuName>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" Checked Successfully
   
        
   Given I login to the FXoffice with valid credentials 
   And I Click AdminTab
   And I Click UserRoleManagerButton
   And I Search the user "<UserRoleName>"
   And I Check entitlement for user "General Access"
   And I Check multiple entitlement "<MultipleInnerMenu>"
   And I Check entitlement for user "<MainMenu>"
   And I Check entitlement for user "<MenuDropDown>"
   And I UnCheck entitlement for user "<UserRoleName>" "<SubMenu>"
   And I Click Save Button
   And I Click SuccessMessage OK button
   And I click on Logout Button; from Home Page
   When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
   Then I click "<MenuName>" "<SubMenuName>" "<BusinessUnitOption>" and click "<InnerMenu>" and verify unchecked sucessfully
   #Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" UnChecked Successfully 
   
   
  @Test
Examples: 
    | UserRoleName      | EntitlementName                                                                                      |   ApproverUser | ApproverPassword | MenuName          | SubMenuName     | MainMenu 			            | MenuDropDown    | SubMenu                    | InnerMenu     | MultipleInnerMenu                                                                                                             |BusinessUnitOption|
    #| AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Nostro Accounts,Add_Edit Nostro Account     |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Add_Edit Nostro Account    | Add,Edit      | Field Audit Nostro Account,Suspend Nostro Account,Record Audit Nostro Account,Delete Nostro Account,Activate Nostro Account   |Nostro Accounts|
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Nostro Accounts,Field Audit Nostro Account  |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Field Audit Nostro Account | Field Audit   | Add_Edit Nostro Account,Suspend Nostro Account,Record Audit Nostro Account,Delete Nostro Account,Activate Nostro Account      |Nostro Accounts| 
    #| AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Nostro Accounts,Record Audit Nostro Account |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Record Audit Nostro Account| Record Audit  | Add_Edit Nostro Account,Suspend Nostro Account,Field Audit Nostro Account,Delete Nostro Account,Activate Nostro Account        |Nostro Accounts|
    #| AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Nostro Accounts,Suspend Nostro Account      |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Suspend Nostro Account     | Suspend       | Add_Edit Nostro Account,Record Audit Nostro Account,Record Audit Nostro Account,Delete Nostro Account,Activate Nostro Account  |Nostro Accounts|       
    #| AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Nostro Accounts,Delete Nostro Account       |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Delete Nostro Account      | Delete        | Add_Edit Nostro Account,Suspend Nostro Account,Record Audit Nostro Account,Field Audit Nostro Account,Activate Nostro Account  |Nostro Accounts|
    #| AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Nostro Accounts,Activate Nostro Account     |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Activate Nostro Account    | Activate      | Add_Edit Nostro Account,Field Audit Nostro Account,Suspend Nostro Account,Record Audit Nostro Account,Delete Nostro Account    |Nostro Accounts|
    
    
@UI @Regression  @userRole @Admin(level3) @EntityManager_BusinessUnit_GLAccountEntitlement       
Scenario Outline: Check and Uncheck EntityManager_BusinessUnit_GLAccountEntitlement Menu  Entitlement 
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
      Then I click "<MenuName>" "<SubMenuName>" "<BusinessUnitOption>" and click "<InnerMenu>" and verify checked sucessfully
     # Then I Verify "<MenuName>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" Checked Successfully
   
        
   Given I login to the FXoffice with valid credentials 
   And I Click AdminTab
   And I Click UserRoleManagerButton
   And I Search the user "<UserRoleName>"
   And I Check entitlement for user "General Access"
   And I Check multiple entitlement "<MultipleInnerMenu>"
   And I Check entitlement for user "<MainMenu>"
   And I Check entitlement for user "<MenuDropDown>"
   And I UnCheck entitlement for user "<UserRoleName>" "<SubMenu>"
   And I Click Save Button
   And I Click SuccessMessage OK button
   And I click on Logout Button; from Home Page
   When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
   Then I click "<MenuName>" "<SubMenuName>" "<BusinessUnitOption>" and click "<InnerMenu>" and verify unchecked sucessfully
   #Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" UnChecked Successfully 
   
   
  @Test
Examples: 
    | UserRoleName      | EntitlementName                                                                              |   ApproverUser | ApproverPassword | MenuName          | SubMenuName     | MainMenu 			            | MenuDropDown    | SubMenu                | InnerMenu     | MultipleInnerMenu                                                                                         |BusinessUnitOption|
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage GL Accounts,Add_Edit GL Account     |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Add_Edit GL Account    | Add,Edit      | Field Audit GL Account,Suspend GL Account,Record Audit GL Account,Delete GL Account,Activate GL Account   |GL Accounts       |
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage GL Accounts,Field Audit GL Account  |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Field Audit GL Account | Field Audit   | Add_Edit GL Account,Suspend GL Account,Record Audit GL Account,Delete GL Account,Activate GL Account      |GL Accounts| 
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage GL Accounts,Record Audit GL Account |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Record Audit GL Account| Record Audit  | Add_Edit GL Account,Suspend GL Account,Field Audit GL Account,Delete GL Account,Activate GL Account        |GL Accounts|
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage GL Accounts,Suspend GL Account      |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Suspend GL Account     | Suspend       | Add_Edit GL Account,Record Audit GL Account,Record Audit GL Account,Delete GL Account,Activate GL Account  |GL Accounts|       
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage GL Accounts,Delete GL Account       |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Delete GL Account      | Delete        | Add_Edit GL Account,Suspend GL Account,Record Audit GL Account,Field Audit GL Account,Activate GL Account  |GL Accounts|
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage GL Accounts,Activate GL Account     |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Activate GL Account    | Activate      | Add_Edit GL Account,Field Audit GL Account,Suspend GL Account,Record Audit GL Account,Delete GL Account    |GL Accounts|
    
    
@UI @Regression  @userRole @Admin(level3) @EntityManager_BusinessUnit_MessageAnnouncementEntitlement       
Scenario Outline: Check and Uncheck EntityManager_BusinessUnit_MessageAnnouncementEntitlement Menu  Entitlement 
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
      Then I click "<MenuName>" "<SubMenuName>" "<BusinessUnitOption>" and click "<InnerMenu>" and verify checked sucessfully
     # Then I Verify "<MenuName>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" Checked Successfully
   
        
   Given I login to the FXoffice with valid credentials 
   And I Click AdminTab
   And I Click UserRoleManagerButton
   And I Search the user "<UserRoleName>"
   And I Check entitlement for user "General Access"
   And I Check multiple entitlement "<MultipleInnerMenu>"
   And I Check entitlement for user "<MainMenu>"
   And I Check entitlement for user "<MenuDropDown>"
   And I UnCheck entitlement for user "<UserRoleName>" "<SubMenu>"
   And I Click Save Button
   And I Click SuccessMessage OK button
   And I click on Logout Button; from Home Page
   When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
   Then I click "<MenuName>" "<SubMenuName>" "<BusinessUnitOption>" and click "<InnerMenu>" and verify unchecked sucessfully
   #Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" UnChecked Successfully 
   
   
  @Test
Examples: 
    | UserRoleName      | EntitlementName                                                                                                  |   ApproverUser | ApproverPassword | MenuName          | SubMenuName     | MainMenu 			            | MenuDropDown    | SubMenu                          | InnerMenu                 | MultipleInnerMenu                                               |BusinessUnitOption|
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Message Announcements,Add FX STAR Branch Announcements  |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Add FX STAR Branch Announcements | FX Branch Announcements   | Add FX STAR Web Announcements,Add FX STAR Market Commentary      |Manage Message Announcements       |
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Message Announcements,Add FX STAR Web Announcements     |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Add FX STAR Web Announcements    | FX Web Announcements      | Add FX STAR Branch Announcements,Add FX STAR Market Commentary   |Manage Message Announcements       |
    | AutoTestUserRole  | Access Enttity Manager Menu,Access Business Units,Manage Message Announcements,Add FX STAR Market Commentary     |   flevia2      |    Finzly@123    | Entity Manager    | Business Units  |Access Enttity Manager Menu | Entity Manager  | Add FX STAR Market Commentary    | FX Market Commentary      | Add FX STAR Branch Announcements,Add FX STAR Web Announcements   |Manage Message Announcements       |
    
    
   
   
   
   
   
   
   
   
   
   
   
   
 @UI @Regression  @userRole  @EntityManager-LegalEntity(Level6)  @AccessLegalEntitiesMenu 
Scenario Outline: Check and Uncheck Access Enttity Manager-LegalEntities Menu Entitlement
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
   Then I Verify "<MenuName>" single submenu "<SubMenuName>" and "<InnerMenu>" Checked Successfully
   
   
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
   Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and "<InnerMenu>" UnChecked Successfully
  
   
 @Test
Examples: 
   | UserRoleName      | EntitlementName                                                                      |   ApproverUser | ApproverPassword | MenuName       | SubMenuName     | MainMenu 							    | MenuDropDown   | SubMenu                          | InnerMenu              | MultipleInnerMenu |   
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Legal Entities,Access LE SSI                      |   flevia2      |    Finzly@123    | Entity Manager | Legal Entities  | Access Enttity Manager Menu| Entity Manager | Access LE SSI                    | SSI                    | Access LE Documents,Access LE Bank Accounts,Access LE Beneficiaries,Access LE Notification Preference,Access LE Contacts,Manage LE Entitlements |
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Legal Entities,Access LE Documents               |   flevia2      |    Finzly@123    | Entity Manager | Legal Entities  | Access Enttity Manager Menu| Entity Manager | Access LE Documents               | Documents              | Access LE SSI,Access LE Bank Accounts,Access LE Beneficiaries,Access LE Notification Preference,Access LE Contacts,Manage LE Entitlements       |
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Legal Entities,Access LE Bank Accounts           |   flevia2      |    Finzly@123    | Entity Manager | Legal Entities  | Access Enttity Manager Menu| Entity Manager  | Access LE Bank Accounts          | Bank Accounts          | Access LE SSI,Access LE Documents,Access LE Beneficiaries,Access LE Notification Preference,Access LE Contacts,Manage LE Entitlements          |
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Legal Entities,Access LE Beneficiaries           |   flevia2      |    Finzly@123    | Entity Manager | Legal Entities  | Access Enttity Manager Menu| Entity Manager | Access LE Beneficiaries           | Beneficiaries          | Access LE SSI,Access LE Documents,Access LE Bank Accounts,Access LE Notification Preference,Access LE Contacts,Manage LE Entitlements          |
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Legal Entities,Access LE Notification Preference |   flevia2      |    Finzly@123    | Entity Manager | Legal Entities  | Access Enttity Manager Menu| Entity Manager | Access LE Notification Preference | Notifications           | Access LE SSI,Access LE Documents,Access LE Bank Accounts,Access LE Beneficiaries,Access LE Contacts,Manage LE Entitlements                   |
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Legal Entities,Access LE Contacts                |   flevia2      |    Finzly@123    | Entity Manager | Legal Entities  | Access Enttity Manager Menu| Entity Manager | Access LE Contacts                | Contacts               | Access LE SSI,Access LE Documents,Access LE Bank Accounts,Access LE Beneficiaries,Access LE Notification Preference,Manage LE Entitlements    |     
   | AutoTestUserRole  | Access Enttity Manager Menu,Access Legal Entities,Manage LE Entitlements            |   flevia2      |    Finzly@123    | Entity Manager | Legal Entities  | Access Enttity Manager Menu| Entity Manager | Manage LE Entitlements            |  Entitlements          | Access LE SSI,Access LE Documents,Access LE Bank Accounts,Access LE Beneficiaries,Access LE Notification Preference,Access LE Contacts        |     