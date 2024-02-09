Feature: StaticData_Case1

  @UI @Regression @StaticData @Holiday @Case1
  Scenario Outline: Booking Trade
    Given I login to the FXoffice with valid credentials
    And I Click AdminTab
    And I get Trade Date from systems Date
    Given launch the url "https://uat1.swapstech.net/bossPortal/"
    And I Enter Credentials in Login Page "<UserName>" "<Password>" for Boss Portal
    Then I Verify Boss Home Page Loaded Successfully
    And I click New Trade Tab
    Then I verify New Trade Page
    And I Book FX Spot trade "<currencyPair>" "<Tenor>" "<Amount>" "<Currency>" "<Option>"
    And I click Manage Trade Tab
    Then I verify Manage Trade Tab
    And I Checked Booked Data
    And I Navigate to Awaiting Instruction
    And I Checked Booked Data
    And I click instruct button from Awaiting Instruction
    Then I Verify Settlement Details
    And I Navigate to Awaiting Authorization
    Then I Verify No Trade is Present
    And I Navigate to Awaiting Confirmation
    Then I Verify No Trade is Eligible
    And I Navigate to Position Blotter
    Then I Verify Position Blotter Details
   # And I click Manage Trade Tab
    #Then I verify Manage Trade Tab
   # And I Navigate to Awaiting Instruction
   # And I click instruct button from Awaiting Instruction
   # Then I Verify Settlement Details
   # And I click instruct on receives
   # Then I Verify Settlement Instruction PopUp Loaded Successfully
    # And I Select Account for Receives from Settlement Instruction Using "<DDA AccountName>","<DDAAccountNumber>","<BeneficiaryName>" and "<BeneficiaryAccountNumber>"
    #And I Click Instruct Button from Instruction Settlement PopUp
   # And I click instruct on pays
   # Then I Verify Settlement Instruction PopUp Loaded Successfully
    #And I Select Account for Pays from Settlement Instruction Using "<DDA AccountName>","<DDAAccountNumber>","<BeneficiaryName>" and "<BeneficiaryAccountNumber>"
    #And I Click Instruct Button from Instruction Settlement PopUp

    #And I Click "<MenuName>" and single submenu "<SubMenuName2>"
    #And I Search "<Currency>" in Static Data Currency
    #And I update the static Data currency "<precision>" for "<Currency>"
    @Test
    Examples: 
      | MenuName    | SubMenuName1 | Currency | SubMenuName2 | precision | SubMenuName3   | currencyPair | UserName | Password  | Option | Amount | Tenor | DDA AccountName | DDAAccountNumber | BeneficiaryName         | BeneficiaryAccountNumber |
      | Static Data | Holidays     | HKD      | Currency     |         2 | Currency Pairs | USDHKD       | Raj1     | Raj!12345 | BUY    |   1000 | SPOT  | DDA34425656     |         34425656 | Chu Hon Auto Kit Credit |                172839405 |
      #| Static Data | Holidays     | HKD      | Currency     |         2 | Currency Pairs | USDHKD       | Raj1     | Raj!12345 | SELL   |   450.78 | SPOT  |
     #And I click instruct button from Awaiting Instruction
   #And I Verify Settlement Details
