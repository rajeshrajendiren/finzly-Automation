
Feature: Legal Enity Creation for Corporate


@UI @Regression  @createCostCenter
Scenario Outline: Verify Add Costcenter
   Given I login to the FXoffice with valid credentials
   And I Create and verify the Cost Centre with "<MarketSector>" "<GeographicRegion>" "<CostCenter>"
   
  
  
 @Test
Examples: 
   | MarketSector | GeographicRegion | CostCenter |               
   | Northern MD  | Blakehurst       | 53022009   |
  
  
@UI @Regression @SearchCc
Scenario Outline: Verify search Costcenter
 	 Given I login to the FXoffice with valid credentials
   When I Search Created Costcenter "<CostCenter>"
   Then I verify Cost Center "<CostCenter>"
   
 @Test
Examples: 
   | MarketSector | GeographicRegion | CostCenter |               
   | Northern MD  | Blakehurst       | 53022009   |
   
@UI @Regression @Editcc
Scenario Outline: Verify Edit Costcenter
 	 Given I login to the FXoffice with valid credentials
   When I Search Created Costcenter "<CostCenter>"
   And I Select and edit cost center "<CostCenter>" "<MarketSectorUpdate>"
   Then I verify updated cost center "<MarketSectorUpdate>"
   
  @Test
Examples: 
   | MarketSector | GeographicRegion | CostCenter |   MarketSectorUpdate |              
   | Northern MD  | Blakehurst       | 53022009   | Northern MD Updated|
   

     
@UI @Regression @DeleteCC
Scenario Outline: Verify Delete Costcenter
 	 Given I login to the FXoffice with valid credentials
   When I Search Created Costcenter "<CostCenter>"
   And I Select the cost center "<CostCenter>"
   Then I Delete and verify the user "<CostCenter>"
     
       @Test
Examples: 
  | CostCenter |          
  | 53022009   |
   