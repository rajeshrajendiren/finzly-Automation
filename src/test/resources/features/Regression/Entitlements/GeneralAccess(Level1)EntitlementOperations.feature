@AdminMenuEntitlement
Feature: UserRoleEntitlementsOperationforGeneralAccess


@UI @Regression  @userRole @GeneralAccess(level1) @GeneralAccessEntitlements
Scenario Outline: Check and uncheck General Access Entitlements
   Given I login to the FXoffice with valid credentials 
   And I Click AdminTab
   And I Click UserRoleManagerButton
   And I Create user role "<UserRoleName>"
   And I Search the user "<UserRoleName>"
   And I Uncheck all roles
   And I Check entitlement for user "<EntitlementName>"
   And I Click Save Button
   And I Click SuccessMessage OK button
   And I click on Logout Button; from Home Page
   When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
   Then I verify the entitlement displayed for the user "<MenuName>"
   And I click on Logout Button; from Home Page
   
   
   #Given I login to the FXoffice with valid credentials 
   #And I Click AdminTab
   #And I Click UserRoleManagerButton
   #And I Create user role "<UserRoleName>"  
   #And I Search the user "<UserRoleName>" 
   #And I Check entitlement for user "<MainMenu>"
   #And I UnCheck entitlement for user "<UserRoleName>" "<EntitlementName>"
   #And I Click Save Button
   #And I Click SuccessMessage OK button
   #And I click on Logout Button; from Home Page
   #When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
   #Then I verify the entitlement not displayed for the user "<MenuName>"
   
 @Test
Examples: 
   | UserRoleName      | EntitlementName             |   ApproverUser | ApproverPassword | MenuName          | MainMenu       |
   | AutoTestUserRole  | Access Admin Menu           |   flevia2      |    Finzly@123    | Admin             | General Access |
   #| AutoTestUserRole  | Access Back Office Menu     |   flevia2      |    Finzly@123    | Back Office       | General Access |
   #| AutoTestUserRole  | Access Dashboard Menu       |   flevia2      |    Finzly@123    | Dashboard         | General Access |
   #| AutoTestUserRole  | Access Document Center Menu |   flevia2      |    Finzly@123    | Document Center   | General Access |
   #| AutoTestUserRole  | Access Enttity Manager Menu |   flevia2      |    Finzly@123    | Entity Manager    | General Access |
   #| AutoTestUserRole  | Access MCA Menu             |   flevia2      |    Finzly@123    | MCA               | General Access |
   #| AutoTestUserRole  | Access Nostro Menu          |   flevia2      |    Finzly@123    | Nostro            | General Access |
   #| AutoTestUserRole  | Access Retail Menu          |   flevia2      |    Finzly@123    | Retail            | General Access |
  # | AutoTestUserRole  | Access Static Data Menu     |   flevia2      |    Finzly@123    | Static Data       | General Access |
  # | AutoTestUserRole  | Access Chat Manager Menu    |   flevia2      |    Finzly@123    | Chat Manager      | General Access |
   #| AutoTestUserRole  | Access Task Manager Menu    |   flevia2      |    Finzly@123    | Task Manager      | General Access |
  # | AutoTestUserRole  | Access General FXRetail Apis|   flevia2      |    Finzly@123    | General FXRetail Apis | General Access |
     

   

    
    
