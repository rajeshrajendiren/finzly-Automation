
Feature: Boss Portal Login
 
 
   
@UI @Regression  @userRole  @boss
Scenario Outline: Check and uncheck Access Admin Menu Entitlement
  Given I navigate to the Boss Portal login page
  
  
@QA3
Examples:
   | UserRoleName      | EntitlementName                               |   ApproverUser | ApproverPassword | MenuName    |SubMenuName            | MainMenu 				 | MenuDropDown | SubMenu                  |
   | AutoTestUserRole  | Access Admin Menu,Access Branch Users         |   flevia2      |    Finzly@123    | Admin |  Branch User          | Access Admin Menu | Admin        |Access Branch Users       |
   