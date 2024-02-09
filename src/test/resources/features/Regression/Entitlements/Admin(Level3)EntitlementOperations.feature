
Feature: UserRoleEntitlementsOperationforAdmin
   
@UI @Regression  @userRole @Admin(level3) @AdminEntitlements
Scenario Outline: Check and uncheck Access Admin Menu Entitlement
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
   Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" UnChecked Successfully
  
   
 @Test
Examples: 
   | UserRoleName      | EntitlementName                               |   ApproverUser | ApproverPassword | MenuName    |SubMenuName            | MainMenu 				 | MenuDropDown | SubMenu                  |
   | AutoTestUserRole  | Access Admin Menu,Access Branch Users         |   flevia2      |    Finzly@123    | Admin |  Branch User          | Access Admin Menu | Admin        |Access Branch Users       |
   | AutoTestUserRole  | Access Admin Menu,Access Cost Center Manager  |   flevia2      |    Finzly@123    |Admin  |  Cost Centers          | Access Admin Menu | Admin        |Access Cost Center Manager|
   | AutoTestUserRole  | Access Admin Menu,Access Custom Attributes    |   flevia2      |    Finzly@123    | Admin | Custom Attributes     | Access Admin Menu | Admin        |Access Custom Attributes  |
   | AutoTestUserRole  | Access Admin Menu,Access Data Importer        |   flevia2      |    Finzly@123    | Admin |  Data Importer         | Access Admin Menu | Admin        |Access Data Importer      |
   | AutoTestUserRole  | Access Admin Menu,Access Entitlement          |   flevia2      |    Finzly@123    | Admin |  Entitlement           | Access Admin Menu | Admin        |Access Entitlement        |
   | AutoTestUserRole  | Access Admin Menu,Access Process Monitor      |   flevia2      |    Finzly@123    | Admin |  Process Monitor       | Access Admin Menu | Admin        |Access Process Monitor    |
   | AutoTestUserRole  | Access Admin Menu,Access Queue Monitor        |   flevia2      |    Finzly@123    | Admin |  Queue Monitor         | Access Admin Menu | Admin        |Access Queue Monitor      |
   | AutoTestUserRole  | Access Admin Menu,Access Relationship Manager |   flevia2      |    Finzly@123    | Admin |  Relationship Manager  | Access Admin Menu | Admin        |Access Relationship Manager|
   | AutoTestUserRole  | Access Admin Menu,Access Report Builder       |   flevia2      |    Finzly@123    | Admin |  Report Builder        | Access Admin Menu | Admin        |Access Report Builder       |
   | AutoTestUserRole  | Access Admin Menu,Access System Alerts        |   flevia2      |    Finzly@123    | Admin |  System Alerts         | Access Admin Menu | Admin        |Access System Alerts      |
   | AutoTestUserRole  | Access Admin Menu,Access System Dates         |   flevia2      |    Finzly@123    | Admin |  System Dates          | Access Admin Menu | Admin        |Access System Dates       |
   | AutoTestUserRole  | Access Admin Menu,Access User Roles           |   flevia2      |    Finzly@123    | Admin |  User Roles            | Access Admin Menu | Admin        |Access User Roles         |
   | AutoTestUserRole  | Access Admin Menu,Access Users                |   flevia2      |    Finzly@123    | Admin|  Users                 | Access Admin Menu | Admin        |Access Users              |
   | AutoTestUserRole  | Access Admin Menu,Access Workflow Jobs        |   flevia2      |    Finzly@123    |Admin |  Workflow Jobs         | Access Admin Menu | Admin        |Access Workflow Jobs      |
   | AutoTestUserRole  | Access Admin Menu,Access Workflow Manager     |   flevia2      |    Finzly@123    | Admin |  Workflow Manager      | Access Admin Menu | Admin        |Access Workflow Manager  |
   #| AutoTestUserRole  | Access Admin Menu,Access Template Manager     |   flevia2      |    Finzly@123    | Admin |  Galaxy Reports      | Access Admin Menu | Admin        |Access Template Manager   |
   | AutoTestUserRole  | Access Admin Menu,Access Manage Exclusion List|   flevia2      |    Finzly@123    | Admin |  Manage Exclusion List | Access Admin Menu | Admin        |Access Manage Exclusion List|
   | AutoTestUserRole  | Access Admin Menu,Access Security Settings Manager |   flevia2      |    Finzly@123    | Admin |  Security Settings |Access Admin Menu | Admin        |Access Security Settings Manager |  
   
   
@UI @Regression  @userRole @Admin(level3) @Admin_CostCenter     
Scenario Outline: Check and Uncheck Admin_CostCenter Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                   |   ApproverUser | ApproverPassword | MenuName | SubMenuName   | MainMenu 			  | MenuDropDown | SubMenu              | InnerMenu     | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Admin Menu,Access Cost Center Manager,Add Edit Cost Center |   flevia2      |    Finzly@123    | Admin    | Cost Centers  |Access Admin Menu | Admin        | Add Edit Cost Center | New,Update      |Delete Cost Center  |
    | AutoTestUserRole  | Access Admin Menu,Access Cost Center Manager,Delete Cost Center   |   flevia2      |    Finzly@123    | Admin    | Cost Centers  |Access Admin Menu | Admin        | Delete Cost Center   | Delete        |Add Edit Cost Center| 
    
    
 @UI @Regression  @userRole @Admin(level3) @Admin_RelationshipManager     
Scenario Outline: Check and Uncheck Admin_ Relationship Manager Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                             |   ApproverUser | ApproverPassword | MenuName | SubMenuName           | MainMenu 			  | MenuDropDown | SubMenu                       | InnerMenu     | MultipleInnerMenu           |
    | AutoTestUserRole  | Access Admin Menu,Access Relationship Manager,Add_Edit Relationship Manager |   flevia2      |    Finzly@123    | Admin    | Relationship Manager  |Access Admin Menu | Admin        | Add_Edit Relationship Manager | New,Update    |Delete Relationship Manager  |
    | AutoTestUserRole  | Access Admin Menu,Access Relationship Manager,Delete Relationship Manager   |   flevia2      |    Finzly@123    | Admin    | Relationship Manager  |Access Admin Menu | Admin        | Delete Relationship Manager   | Delete        |Add_Edit Relationship Manager|       


@UI @Regression  @userRole @Admin(level3) @Admin_ManageExclusionList 
Scenario Outline: Check and Uncheck Admin_ Manage Exclusion List Menu  Entitlement 
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
    And I Check entitlement for user "<MainMenu>"
   And I Check entitlement for user "<MenuDropDown>"
   And I Check entitlement for user "General Access"
   And I Check multiple entitlement "<EntitlementName>"
   And I UnCheck entitlement "<SubMenu>"
   And I Click Save Button
   And I Click SuccessMessage OK button
   And I click on Logout Button; from Home Page
   When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
   Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" UnChecked Successfully 
   
   
  @Test
Examples: 
    | UserRoleName      | EntitlementName                                                             |   ApproverUser | ApproverPassword | MenuName | SubMenuName           | MainMenu 			  | MenuDropDown | SubMenu                       | InnerMenu              | MultipleInnerMenu           |
    | AutoTestUserRole  | Access Admin Menu,Access Manage Exclusion List,Record Audit Exclusion List  |   flevia2      |    Finzly@123    | Admin    | Manage Exclusion List  |Access Admin Menu | Admin        | Record Audit Exclusion List  | Record Audit           |Field Audit Exclusion List,Activities Exclusion List,Add Edit Exclusion,Delete Exclusion,Download Exclusion List |
    | AutoTestUserRole  | Access Admin Menu,Access Manage Exclusion List,Field Audit Exclusion List   |   flevia2      |    Finzly@123    | Admin    | Manage Exclusion List  |Access Admin Menu | Admin        | Field Audit Exclusion List   | Field Audit            |Record Audit Exclusion List,Activities Exclusion List,Add Edit Exclusion,Delete Exclusion,Download Exclusion List |  
    | AutoTestUserRole  | Access Admin Menu,Access Manage Exclusion List,Activities Exclusion List    |   flevia2      |    Finzly@123    | Admin    | Manage Exclusion List  |Access Admin Menu | Admin        | Activities Exclusion List   | Activities              |Record Audit Exclusion List,Field Audit Exclusion List,Add Edit Exclusion,Delete Exclusion,Download Exclusion List  |
    | AutoTestUserRole  | Access Admin Menu,Access Manage Exclusion List,Add Edit Exclusion           |   flevia2      |    Finzly@123    | Admin    | Manage Exclusion List  |Access Admin Menu | Admin        | Add Edit Exclusion          | Add,Edit                |Record Audit Exclusion List,Field Audit Exclusion List,Activities Exclusion List,Delete Exclusion,Download Exclusion List |       
    | AutoTestUserRole  | Access Admin Menu,Access Manage Exclusion List,Delete Exclusion             |   flevia2      |    Finzly@123    | Admin    | Manage Exclusion List  |Access Admin Menu | Admin        | Delete Exclusion            | Delete        |Record Audit Exclusion List,Field Audit Exclusion List,Activities Exclusion List,Add Edit Exclusion,Download Exclusion List   |
    | AutoTestUserRole  | Access Admin Menu,Access Manage Exclusion List,Download Exclusion List      |   flevia2      |    Finzly@123    | Admin    | Manage Exclusion List  |Access Admin Menu | Admin        | Download Exclusion List     | Download |Record Audit Exclusion List,Field Audit Exclusion List,Activities Exclusion List,Add Edit Exclusion,Delete Exclusion |       
         

@UI @Regression  @userRole @Admin(level3) @Admin_CustomAttributes     
Scenario Outline: Check and Uncheck Admin_ Custom Attributes Manager Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                       |   ApproverUser | ApproverPassword | MenuName | SubMenuName         | MainMenu 		   | MenuDropDown | SubMenu                    | InnerMenu    | MultipleInnerMenu           |
    | AutoTestUserRole  | Access Admin Menu,Access Custom Attributes,Add_Edit Custom Attributes |   flevia2      |    Finzly@123    | Admin    | Custom Attributes  |Access Admin Menu | Admin        | Add_Edit Custom Attributes | Add,Edit      |Delete Custom Attributes  |
    | AutoTestUserRole  | Access Admin Menu,Access Custom Attributes,Delete Custom Attributes   |   flevia2      |    Finzly@123    | Admin    | Custom Attributes  |Access Admin Menu | Admin        | Delete Custom Attributes   | Delete        |Add_Edit Custom Attributes|       
   
   
@UI @Regression  @userRole @Admin(level3) @Admin_WorkflowManager      
Scenario Outline: Check and Uncheck Admin_WorkflowManager List Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                        |   ApproverUser | ApproverPassword | MenuName | SubMenuName       | MainMenu 			   | MenuDropDown | SubMenu                       | InnerMenu       | MultipleInnerMenu                                                                     |
    | AutoTestUserRole  | Access Admin Menu,Access Workflow Manager,Field Audit Workflow Manager |   flevia2      |    Finzly@123    | Admin    | Workflow Manager  |Access Admin Menu | Admin        | Field Audit Workflow Manager  | Field Audit     | Add Workflow,Modify Workflow,Delete Workflow,Creates New Workflow Job                 |
    | AutoTestUserRole  | Access Admin Menu,Access Workflow Manager,Add Workflow                 |   flevia2      |    Finzly@123    | Admin    | Workflow Manager  |Access Admin Menu | Admin        | Add Workflow                  | New             | Field Audit Workflow Manager,Modify Workflow,Delete Workflow,Creates New Workflow Job | 
    | AutoTestUserRole  | Access Admin Menu,Access Workflow Manager,Modify Workflow              |   flevia2      |    Finzly@123    | Admin    | Workflow Manager  |Access Admin Menu | Admin        | Modify Workflow               | Modify          | Field Audit Workflow Manager,Add Workflow,Delete Workflow,Creates New Workflow Job    |
    | AutoTestUserRole  | Access Admin Menu,Access Workflow Manager,Delete Workflow              |   flevia2      |    Finzly@123    | Admin    | Workflow Manager  |Access Admin Menu | Admin        | Delete Workflow               | Delete          | Field Audit Workflow Manager,Modify Workflow,Add Workflow,Creates New Workflow Job    |       
    | AutoTestUserRole  | Access Admin Menu,Access Workflow Manager,Creates New Workflow Job     |   flevia2      |    Finzly@123    | Admin    | Workflow Manager  |Access Admin Menu | Admin        | Creates New Workflow Job      | Create New Job  | Field Audit Workflow Manager,Add Workflow,Modify Workflow,Delete Workflow             |
    
    
@UI @Regression  @userRole @Admin(level3) @Admin_DataImporter     
Scenario Outline: Check and Uncheck Admin_DataImporter Menu  Entitlement 
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
      Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" Checked Successfully
   
        
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
    | UserRoleName      | EntitlementName                                    |   ApproverUser | ApproverPassword | MenuName | SubMenuName    | MainMenu 		    | MenuDropDown | SubMenu     | InnerMenu     | MultipleInnerMenu |
    | AutoTestUserRole  | Access Admin Menu,Access Data Importer,Import Data |   flevia2      |    Finzly@123    | Admin    | Data Importer  |Access Admin Menu | Admin        | Import Data | Import | Import Data     |
    
    @UI @Regression  @userRole @Admin(level3) @Admin_QueueMonitor     
Scenario Outline: Check and Uncheck Admin_ QueueMonitor Menu  Entitlement 
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
      Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and "<InnerMenu>" Checked Successfully
   
        
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
    | UserRoleName      | EntitlementName                                                            |   ApproverUser | ApproverPassword | MenuName | SubMenuName    | MainMenu 		    | MenuDropDown | SubMenu                             | InnerMenu                         | MultipleInnerMenu                   |
    | AutoTestUserRole  | Access Admin Menu,Access Queue Monitor,Release All Workflow Stuck Requests |   flevia2      |    Finzly@123    | Admin    | Queue Monitor  |Access Admin Menu | Admin        | Release All Workflow Stuck Requests | Requestes Stuck In Workflow Queue | Release All Workflow Stuck Requests |
    
    @UI @Regression  @userRole @Admin(level3) @Admin_BranchUser       
Scenario Outline: Check and Uncheck Admin_BranchUser Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                         |   ApproverUser | ApproverPassword | MenuName | SubMenuName  | MainMenu 			   | MenuDropDown | SubMenu                           | InnerMenu     | MultipleInnerMenu                                                                     |
    | AutoTestUserRole  | Access Admin Menu,Access Branch Users,Activate FX STAR Branch User      |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Activate FX STAR Branch User      | Activate      | Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User |
    | AutoTestUserRole  | Access Admin Menu,Access Branch Users,Add Edit FX STAR Branch User      |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Add Edit FX STAR Branch User      | Add,Edit      | Activate FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User | 
    | AutoTestUserRole  | Access Admin Menu,Access Branch Users,Delete FX STAR Branch User        |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Delete FX STAR Branch User        | Delete        | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User |
    | AutoTestUserRole  | Access Admin Menu,Access Branch Users,Download FX STAR Branch User List |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Download FX STAR Branch User List | Download      | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User |       
    | AutoTestUserRole  | Access Admin Menu,Access Branch Users,Entitlements FX STAR Branch User  |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Entitlements FX STAR Branch User  | Entitlements  | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User |
    | AutoTestUserRole  | Access Admin Menu,Access Branch Users,Field Audit FX STAR Branch User   |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Field Audit FX STAR Branch User   | Field Audit   | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User |
    | AutoTestUserRole  | Access Admin Menu,Access Branch Users,Record Audit FX STAR Branch User  |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Record Audit FX STAR Branch User  | Record Audit  | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Suspend FX STAR Branch User,Activities FX STAR Branch User |
    | AutoTestUserRole  | Access Admin Menu,Access Branch Users,Suspend FX STAR Branch User       |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Suspend FX STAR Branch User       | Suspend       | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Activities FX STAR Branch User |
    | AutoTestUserRole  | Access Admin Menu,Access Branch Users,Activities FX STAR Branch User    |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Activities FX STAR Branch User    | Activities    | Activate FX STAR Branch User,Add Edit FX STAR Branch User,Delete FX STAR Branch User,Download FX STAR Branch User List,Entitlements FX STAR Branch User,Field Audit FX STAR Branch User,Record Audit FX STAR Branch User,Suspend FX STAR Branch User |
    
    
 @UI @Regression  @userRole @Admin(level3) @Admin_UserRole      
Scenario Outline: Check and Uncheck Admin_UserRole Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                                |   ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu 		    | MenuDropDown | SubMenu                    | InnerMenu    | MultipleInnerMenu         |
    | AutoTestUserRole  | Access Admin Menu,Access User Roles,Add_Edit FX STAR User Role |   flevia2      |    Finzly@123    | Admin    | User Roles  |Access Admin Menu | Admin        | Add_Edit FX STAR User Role | New,Save      |Delete FX STAR User Role  |
    | AutoTestUserRole  | Access Admin Menu,Access User Roles,Delete FX STAR User Role   |   flevia2      |    Finzly@123    | Admin    | User Roles  |Access Admin Menu | Admin        | Delete FX STAR User Role   | Delete        |Add_Edit FX STAR User Role|       

    
#@UI @Regression  @userRole @Admin(level3) @Admin_Users      
Scenario Outline: Check and Uncheck Admin_ Users  Menu  Entitlement 
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
    And I Check entitlement for user "<MainMenu>"
   And I Check entitlement for user "<MenuDropDown>"
   And I Check entitlement for user "General Access"
   And I Check multiple entitlement "<EntitlementName>"
   And I UnCheck entitlement "<SubMenu>"
   And I Click Save Button
   And I Click SuccessMessage OK button
   And I click on Logout Button; from Home Page
   When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
   Then I Verify "<MenuDropDown>" single submenu "<SubMenuName>" and multiple "<InnerMenu>" UnChecked Successfully 
   
   
  @Test
Examples: 
    | UserRoleName      | EntitlementName                                               |   ApproverUser | ApproverPassword | MenuName | SubMenuName  | MainMenu 			   | MenuDropDown | SubMenu                    | InnerMenu     | MultipleInnerMenu                                                                     |
    | AutoTestUserRole  | Access Admin Menu,Access Users,Activate FX STAR User          |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Activate FX STAR User      | Activate      | Add_Edit FX STAR User,Delete FX STAR User,Download User List,Field Audit FX STAR User,Record Audit FX STAR User,Suspend FX STAR User,Activities FX STAR User |
    | AutoTestUserRole  | Access Admin Menu,Access Users,Add_Edit FX STAR User          |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Add_Edit FX STAR User      | Add,Edit      | Activate FX STAR User,Delete FX STAR User,Download User List,Field Audit FX STAR User,Record Audit FX STAR User,Suspend FX STAR User,Activities FX STAR User | 
    | AutoTestUserRole  | Access Admin Menu,Access Users,Delete FX STAR User            |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Delete FX STAR User        | Delete        | Activate FX STAR User,Add_Edit FX STAR User,Download User List,Field Audit FX STAR User,Record Audit FX STAR User,Suspend FX STAR User,Activities FX STAR User |
    | AutoTestUserRole  | Access Admin Menu,Access Users,Download User List             |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Download User List         | Download      | Activate FX STAR User,Add_Edit FX STAR User,Delete FX STAR User,Field Audit FX STAR User,Record Audit FX STAR User,Suspend FX STAR User,Activities FX STAR User |       
    | AutoTestUserRole  | Access Admin Menu,Access Users,Field Audit FX STAR User       |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Field Audit FX STAR User   | Field Audit   | Activate FX STAR User,Add_Edit FX STAR User,Delete FX STAR User,Download User List,Record Audit FX STAR User,Suspend FX STAR User,Activities FX STAR User |
    | AutoTestUserRole  | Access Admin Menu,Access Users,Record Audit FX STAR User      |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Record Audit FX STAR User  | Record Audit  | Activate FX STAR User,Add_Edit FX STAR User,Delete FX STAR User,Download User List,Field Audit FX STAR User,Suspend FX STAR User,Activities FX STAR User |
    | AutoTestUserRole  | Access Admin Menu,Access Users,Suspend FX STAR Branch User    |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Suspend FX STAR User       | Suspend       | Activate FX STAR User,Add_Edit FX STAR User,Delete FX STAR User,Download User List,Field Audit FX STAR User,Record Audit FX STAR User,Activities FX STAR User |
    | AutoTestUserRole  | Access Admin Menu,Access Users,Activities FX STAR Branch User |   flevia2      |    Finzly@123    | Admin    | Branch User  |Access Admin Menu | Admin        | Activities FX STAR User    | Activities    | Activate FX STAR User,Add_Edit FX STAR User,Delete FX STAR User,Download User List,Field Audit FX STAR User,Record Audit FX STAR User,Suspend FX STAR User |
    
    @UI @Regression  @userRole @Admin(level3) @Admin_WorkflowJobs       
Scenario Outline: Check and Uncheck Admin_WorkflowJobs Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                             |   ApproverUser | ApproverPassword | MenuName | SubMenuName   | MainMenu 		    | MenuDropDown | SubMenu              | InnerMenu    | MultipleInnerMenu         |
    | AutoTestUserRole  | Access Admin Menu,Access Workflow Jobs,Execute Workflow Job |   flevia2      |    Finzly@123    | Admin    | Workflow Jobs |Access Admin Menu | Admin        | Execute Workflow Job | Execute      |Delete FX STAR User Role  |
    
    
 @UI @Regression  @userRole @Admin(level3) @Admin_Entitlements      
Scenario Outline: Check and Uncheck Admin_Entitlements Menu  Entitlement 
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
    | UserRoleName      | EntitlementName                                           |   ApproverUser | ApproverPassword | MenuName | SubMenuName | MainMenu 		    | MenuDropDown | SubMenu               | InnerMenu    | MultipleInnerMenu  |
    | AutoTestUserRole  | Access Admin Menu,Access Entitlement,Add_Edit Entitlement |   flevia2      |    Finzly@123    | Admin    | Entitlement  |Access Admin Menu | Admin        | Add_Edit Entitlement | New,Edit     |Delete Entitlement  |
    | AutoTestUserRole  | Access Admin Menu,Access Entitlement,Delete Entitlement   |   flevia2      |    Finzly@123    | Admin    | Entitlement  |Access Admin Menu | Admin        | Delete Entitlement   | Delete        |Add_Edit Entitlement|       
    
       