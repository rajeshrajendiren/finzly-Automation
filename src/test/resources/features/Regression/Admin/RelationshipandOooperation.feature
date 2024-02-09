
Feature: Legal Enity Creation for Corporate


@UI @Regression  @createRelationshipmanagerandOo 
Scenario Outline: Verify RM,OO Add
   Given I login to the FXoffice with valid credentials
   When I Create RM with "<Username>" "<Type>" "<RespCode>"
   Then I verify RM "<Username>" "<Type>"
  
  
 @Test
Examples: 
   | Username        | Type                | RespCode  |               
   | TestAutomation  | RM                  | 61342     | 
   | AutoTest        | Originating Officer | 61343     | 

@UI @Regression @SearchRMandOo
Scenario Outline: Verify RM,Oo search
 	 Given I login to the FXoffice with valid credentials
   When I Search Created RM "<Username>"
   Then I verify RM "<Username>" "<Type>"
  
 @Test
Examples: 
   | Username        |Type                 | 
   | TestAutomation  | RM                  |
   |  AutoTest       | Originating Officer |
   
@UI @Regression @EditRMandOo
Scenario Outline: Verify RM,Oo Edit
 	 Given I login to the FXoffice with valid credentials
   When I Search Created RM "<Username>"
   Then Select RM "<Username>" "<Type>" "<RespCode>"
   And I Click Upade Button
   When I Edit RM with "<Username2>" "<Type>" "<RespCode>" and verify "<Username>" message
   Then I verify RM "<Username2>" "<Type>"
   
   
 @Test
Examples: 
   | Username        |Type                 | RespCode | Username2       |
   | TestAutomation  | RM                  | 61342    | TestAutomation2 |
   |  AutoTest       | Originating Officer | 61343    |  AutoTest2      |   
   
   
     
@UI @Regression @DeleteRMandOo
Scenario Outline: Verify RM,Oo delete
 	 Given I login to the FXoffice with valid credentials
   When I Search Created RM "<Username>"
   Then Select RM "<Username>" "<Type>" "<RespCode>"
   And I Delete and verify the user "<Username2>"
 
   
 @Test
Examples: 
   | Username        |Type                 | RespCode | Username2       |
   | TestAutomation  | RM                  | 61342    | TestAutomation2 |
   |  AutoTest       | Originating Officer | 61343    |  AutoTest2      |   