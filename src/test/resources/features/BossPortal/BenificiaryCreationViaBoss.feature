Feature: Beneficiaries

  @UI @Regression @Beneficiaries @Case1
  Scenario Outline: Booking Trade
    Given launch the url "https://uat1.swapstech.net/bossPortal/"
    And I Enter Credentials in Login Page "<UserName>" "<Password>" for Boss Portal
    Then I Verify Boss Home Page Loaded Successfully
    And I Close Announcement PopUp
    And I Click on Beneficiary Tab
    Then I verify Beneficiaries Tab
    And I Navigate to Add International Beneficiaries
    And I Fill The Beneficiary Details Using "<BeneficiaryName>","<TemplateName>","<Address1>","<Country>","<City>","<EmailAddress>","<CountryCode>","<PhoneNumber>","<BankLocation>","<AccountCurrency>","<LookUp>","<BIC>" and "<ACCNO>"
    And I Click Confirm Button to Beneficiary

    @Test
    Examples: 
      | UserName | Password  | BeneficiaryName                   | TemplateName                      | Address1            | Country        | City       | EmailAddress        | CountryCode | PhoneNumber | BankLocation   | AccountCurrency | LookUp   | BIC         | ACCNO    |
      #| Raj1     | Raj!12345 | Chu Hon Auto Kit Credit     | Chu Hon Auto Kit Credit     | Flat E 11/F Block 18              | CHINA     | Tai Po Hong Kong | rajesh.r@finzly.com | India       |  8925522799 | HONG KONG                | HKD             | BY SWIFT | HSBCHKHHHKH | 172839405 |
      #| Raj1     | Raj!12345 | HONG KONG AUTOMATION CREDIT | HONG KONG AUTOMATION CREDIT | FLAT C 8F HENFA COMM BLDG 348 350 | HONG KONG | WAN CHAI         | rajesh.r@finzly.com | India       |  8925522799 | UNITED STATES OF AMERICA | USD             | BY SWIFT | FLBKUS33XXX |  90807060 |
      | Raj1     | Raj!12345 | CALSIGI AUTOMATION CREDIT LIMITED | CALSIGI AUTOMATION CREDIT LIMITED | ONE VICTORIA SQUARE | UNITED KINGDOM | BIRMINGHAM | rajesh.r@finzly.com | India       |  8925227991 | UNITED KINGDOM | GBP             | BY SWIFT | LOYDGB21054 | 91817161 |
