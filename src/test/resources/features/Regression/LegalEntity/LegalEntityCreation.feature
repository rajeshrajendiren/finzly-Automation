Feature: Legal Enity Creation for Corporate Version 8.2.7

  @UI @Regression @createRM,Oo,Cc @8.2.7
  Scenario Outline: Verify Legal Entity Creation - Corporate
    Given I login to the FXoffice with valid credentials
    When I Create and verify the RM with "<Username>" "<Type1>" "<RespCode1>"
    And I Create and verify the RM with "<Username>" "<Type2>" "<RespCode2>"
    And I Create and verify the Cost Centre with "<MarketSector>" "<GeographicRegion>" "<CostCenter>"
    And I click on Logout Button; from Home Page

    @UAT
    Examples: 
      | Username        | Type1 | RespCode1 | Type2               | RespCode2 | MarketSector | GeographicRegion | CostCenter |
      | Test Automation | RM    |     61342 | Originating Officer |     61343 | Northern MD  | Blakehurst       |   53022009 |

  @UI @Regression @createLegalEntitycredit
  Scenario Outline: Verify Legal Entity Creation - Corporate
    Given I login to the FXoffice with valid credentials
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter Legal Entity general details for credit "<LegalName>" "<ShortName>" "<ProcessingOrg>" "<EntityType>" "<Relationship>" "<OriginatingOfficer>" "<CostCenter>" "<Credit>"
    And I Enter Legal Entity address details "<Address>" "<City>" "<State>" "<PostalCode>" "<Country>"
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    Then I Verify Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Typeand "<Status>" as Status; in Entity Manager tab Successfully
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<Status>" as Status
    Then I validate the Record Audit and Activities "<EntityType>" "<LegalName>"
    And I click on Logout Button; from Home Page

    @UAT
    Examples: 
      | Relationship   | Type1 | RespCode1 | OriginatingOfficer | RespCode2 | MarketSector | GeographicRegion | CostCenter | LegalName  | ShortName | ProcessingOrg | EntityType | Address                          | City        | State      | PostalCode | Country                  | Status | Client |
      | TestAutomation | RM    |     61342 | AutoTest           |     61343 | Northern MD  | Blakehurst       |   53022009 | Autocredit | Autocr    | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Credit |

  @UI @Regression @createLegalEntitycash
  Scenario Outline: Verify Legal Entity Creation - Corporate
    Given I login to the FXoffice with valid credentials
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter Legal Entity general details for cash "<LegalName>" "<ShortName>" "<ProcessingOrg>" "<EntityType>" "<Relationship>" "<OriginatingOfficer>" "<CostCenter>" "<Credit>"
    And I Enter Legal Entity address details "<Address>" "<City>" "<State>" "<PostalCode>" "<Country>"
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    Then I Verify Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Typeand "<Status>" as Status; in Entity Manager tab Successfully
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<Status>" as Status
    Then I validate the Record Audit and Activities "<EntityType>" "<LegalName>"
    And I click on Logout Button; from Home Page

    @UAT
    Examples: 
      | Relationship   | Type1 | RespCode1 | OriginatingOfficer | RespCode2 | MarketSector | GeographicRegion | CostCenter | LegalName | ShortName | ProcessingOrg | EntityType | Address                          | City        | State      | PostalCode | Country                  | Status | Client |
      | TestAutomation | RM    |     61342 | AutoTest           |     61343 | Northern MD  | Blakehurst       |   53022009 | Autocash  | Autoca    | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Cash   |

  @UI @Regression @AddEntitlementslefttoright
  Scenario Outline: actiavte user left to right
    Given I login to the FXoffice with valid credentials
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<Status>" as Status
    And I click on Entitlements; move permission from left to right
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<Status>" as Status
    Then I validate the Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" left to right
    And I click on Logout Button; from Home Page
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<Status>" as Status
    And I Click on Edit button and activate LE
    Then I Verified Legal Entity Activated for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status successfully
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status
    Then I validate the Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" left to right
    And I click on Logout Button; from Home Page

    @UAT
    Examples: 
      | Relationship   | Type1 | RespCode1 | OriginatingOfficer | RespCode2 | MarketSector | GeographicRegion | CostCenter | LegalName  | ShortName | ProcessingOrg | EntityType | Address                          | City        | State      | PostalCode | Country                  | Status | ActiveStatus | PendingStatus | ApproverUser | ApproverPassword |
      | TestAutomation | RM    |     61342 | AutoTest           |     61343 | Northern MD  | Blakehurst       |   53022009 | Autocredit | Autocr    | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Active       | Pending       | flevia2      | Finzly#123       |
      | TestAutomation | RM    |     61342 | AutoTest           |     61343 | Northern MD  | Blakehurst       |   53022009 | Autocash   | Autoca    | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Active       | Pending       | flevia2      | Finzly#123       |

  @UI @Regression @AddEntitlementsrighttoleft
  Scenario Outline: actiavte user right to left
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status
    And I click on Entitlements; Move Right to Left Active Notification Preference Button
    When I Verified Legal Entity Pending for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status successfully
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status
    Then I validate the Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" after right to left
    And I click on Logout Button; from Home Page
    Given I Enter Approver Credentials in Login Page "<NormalUser>" "<NormalPassword>"
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status
    And I Click on Edit button and activate LE
    Then I Verified Legal Entity Activated for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status successfully
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status
    Then I validate the Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" after right to left
    And I click on Logout Button; from Home Page

    @UAT
    Examples: 
      | Username        | Type1 | RespCode1 | Type2               | RespCode2 | MarketSector | GeographicRegion | CostCenter | LegalName    | ShortName    | ProcessingOrg | EntityType | Address                          | City        | State      | PostalCode | Country                  | Status | ActiveStatus | PendingStatus | FirstName1 | LastName1 | UserId1  | Password | EmailAddress                    | PhoneNumber | CellNumber    | FirstName2 | LastName2 | UserId2 | ApproverUser | ApproverPassword | NormalUser | NormalPassword |
      | Test Automation | RM    |     61342 | Originating Officer |     61343 | Northern MD  | Blakehurst       |   53022009 | Automation67 | Automation67 | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Active       | Pending       | flevia     | Dharshni  | divpriya | Amir@123 | flevia.priyadharshni@finzly.com |  8925227991 | +918925227991 | haripriya  | dhar      | ashu    | flevia2      | Finzly@123       | flevia     | Levin@10       |

  @UI @Regression @AddEntitlementslefttoright123
  Scenario Outline: actiavte user left to right
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status
    And I click on Entitlements; move permission from left to right
    When I Verified Legal Entity Pending for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status successfully
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status
    Then I validate the Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" after right to left
    And I click on Logout Button; from Home Page
    Given I Enter Approver Credentials in Login Page "<NormalUser>" "<NormalPassword>"
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status
    And I Click on Edit button and activate LE
    Then I Verified Legal Entity Activated for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status successfully
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status
    Then I validate the Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" after right to left
    And I click on Logout Button; from Home Page

    @UAT
    Examples: 
      | Username        | Type1 | RespCode1 | Type2               | RespCode2 | MarketSector | GeographicRegion | CostCenter | LegalName | ShortName | ProcessingOrg | EntityType | Address                          | City        | State      | PostalCode | Country                  | Status | ActiveStatus | PendingStatus | FirstName1 | LastName1 | UserId1  | Password | EmailAddress                    | PhoneNumber | CellNumber    | FirstName2 | LastName2 | UserId2 | ApproverUser | ApproverPassword | NormalUser | NormalPassword |
      | Test Automation | RM    |     61342 | Originating Officer |     61343 | Northern MD  | Blakehurst       |   53022009 | Myntra2   | Myntra2   | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Active       | Pending       | flevia     | Dharshni  | divpriya | Amir@123 | flevia.priyadharshni@finzly.com |  8925227991 | +918925227991 | haripriya  | dhar      | ashu    | flevia2      | Finzly@123       | flevia     | Levin@10       |

  @UI @Regression @contactcreation
  Scenario Outline: 
    When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status
    And I click on Contact; from Entity Manager tab
    And I click on Add button; from contact Popup
    And I Enter Details "<FirstName1>" "<LastName1>" "<UserId1>" "<Password>" "<EmailAddress>" "<PhoneNumber>" "<CellNumber>" for contact
    Then I Verify Contact Created "<UserId1>" "<FirstName1>" "<LastName1>" "<EmailAddress>" "<PhoneNumber>" "<Status>" successfully
    And I click on Add button; from contact Popup
    And I Enter Details "<FirstName2>" "<LastName2>" "<UserId2>" "<Password>" "<EmailAddress>" "<PhoneNumber>" "<CellNumber>" for contact
    Then I Verify Contact Created "<UserId2>" "<FirstName2>" "<LastName2>" "<EmailAddress>" "<PhoneNumber>" "<Status>" successfully
    And I click on Close Button; from contact Popup
    And I click on Logout Button; from Home Page
    Given I Enter Approver Credentials in Login Page "<NormalUser>" "<NormalPassword>"
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status
    And I click on Contact; from Entity Manager tab
    And I Select Contact Created "<UserId1>" "<FirstName1>" "<LastName1>" "<EmailAddress>" "<PhoneNumber>" "<Status>"
    And I click Activate; from contact popup
    Then I Verify Contact Created "<UserId1>" "<FirstName1>" "<LastName1>" "<EmailAddress>" "<PhoneNumber>" "<ActiveStatus>" successfully
    And I Select Contact Created "<UserId2>" "<FirstName2>" "<LastName2>" "<EmailAddress>" "<PhoneNumber>" "<Status>"
    And I click Activate; from contact popup
    Then I Verify Contact Created "<UserId2>" "<FirstName2>" "<LastName2>" "<EmailAddress>" "<PhoneNumber>" "<ActiveStatus>" successfully
    And I click on Close Button; from contact Popup
    And I click on Logout Button; from Home Page

    @UAT
    Examples: 
      | Relationship   | Type1 | RespCode1 | OriginatingOfficer | RespCode2 | MarketSector | GeographicRegion | CostCenter | LegalName          | ShortName    | ProcessingOrg | EntityType | Address                          | City        | State      | PostalCode | Country                  | Status | ActiveStatus | PendingStatus | FirstName1 | LastName1 | UserId1 | Password  | EmailAddress        | PhoneNumber | CellNumber    | FirstName2 | LastName2 | UserId2 | ApproverUser | ApproverPassword | NormalUser | NormalPassword |
      | TestAutomation | RM    |     61342 | AutoTest           |     61343 | Northern MD  | Blakehurst       |   53022009 | AutomationcreditLE | AutoCreditLE | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Active       | Pending       | Rajesh1    | BOSS1     | Raj1    | Raj@12345 | rajesh.r@finzly.com |  8925227991 | +918925227991 | Rajesh2    | BOSS2     | Raj2    | Rajesh2      | Raj@1234         | Rajesh1    | Raj@12345      |

  # | TestAutomation  | RM    | 61342     | AutoTest              | 61343     | Northern MD  | Blakehurst      | 53022009   | Autocash    | Autoca       | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Active       | Pending       | flevia     | Dharshni  | prigasparwq | Amir@123 | flevia.priyadharshni@finzly.com | 8925227991  | +918925227991 | haripriya  |  dhar     | priyaashli  |flevia2     |Finzly#123      |flevia    |Finzly#123      |
  @UI @Regression @AddEntitlementsforcontacts
  Scenario Outline: Add Entitlements create contact
    #When I Enter Approver Credentials in Login Page "<ApproverUser>" "<ApproverPassword>"
    #And I Click on Legal Entities from Entity Manager Tab; in Home Page
    #And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    #And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status
    #And I click on Contact; from Entity Manager tab
    #And I Select Contact Created "<UserId1>" "<FirstName1>" "<LastName1>" "<EmailAddress>" "<PhoneNumber>" "<ActiveStatus>"
    #And I click on Entitlements for contact; move permission from left to right
    #And I Select Contact Created "<UserId2>" "<FirstName2>" "<LastName2>" "<EmailAddress>" "<PhoneNumber>" "<ActiveStatus>"
    #And I click on Entitlements for contact; move permission from left to right
    #And I click on Close Button; from contact Popup
    #And I click on Logout Button; from Home Page
    Given I Enter Approver Credentials in Login Page "<NormalUser>" "<NormalPassword>"
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status
    And I click on Contact; from Entity Manager tab
    And I Select Contact Created "<UserId1>" "<FirstName1>" "<LastName1>" "<EmailAddress>" "<PhoneNumber>" "<PendingStatus>"
    And I click Activate; from contact popup
    Then I Verify Contact Created "<UserId1>" "<FirstName1>" "<LastName1>" "<EmailAddress>" "<PhoneNumber>" "<ActiveStatus>" successfully
    And I Select Contact Created "<UserId2>" "<FirstName2>" "<LastName2>" "<EmailAddress>" "<PhoneNumber>" "<PendingStatus>"
    And I click Activate; from contact popup
    Then I Verify Contact Created "<UserId2>" "<FirstName2>" "<LastName2>" "<EmailAddress>" "<PhoneNumber>" "<ActiveStatus>" successfully
    And I Select Contact Created "<UserId1>" "<FirstName1>" "<LastName1>" "<EmailAddress>" "<PhoneNumber>" "<ActiveStatus>"
    Then I validate the Contact Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" for contact
    And I Select Contact Created "<UserId2>" "<FirstName2>" "<LastName2>" "<EmailAddress>" "<PhoneNumber>" "<ActiveStatus>"
    Then I validate the Contact Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" for contact
    And I click on Close Button; from contact Popup
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status
    Then I validate the Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" for contact
    And I click on Logout Button; from Home Page

    @UAT
    Examples: 
      | Relationship   | Type1 | RespCode1 | OriginatingOfficer | RespCode2 | MarketSector | GeographicRegion | CostCenter | LegalName          | ShortName    | ProcessingOrg | EntityType | Address                          | City        | State      | PostalCode | Country                  | Status | ActiveStatus | PendingStatus | FirstName1 | LastName1 | UserId1 | Password  | EmailAddress        | PhoneNumber | CellNumber    | FirstName2 | LastName2 | UserId2 | ApproverUser | ApproverPassword | NormalUser | NormalPassword |
      | TestAutomation | RM    |     61342 | AutoTest           |     61343 | Northern MD  | Blakehurst       |   53022009 | AutomationcreditLE | AutoCreditLE | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Active       | Pending       | Rajesh1    | BOSS1     | Raj1    | Raj@12345 | rajesh.r@finzly.com |  8925227991 | +918925227991 | Rajesh2    | BOSS2     | Raj2    | Rajesh2      | Raj@1234         | Rajesh1    | Raj@12345      |

  @UI @Regression @ActivateLE
  Scenario Outline: actiavte LE
    Given I Enter Approver Credentials in Login Page "<NormalUser>" "<NormalPassword>"
    And I Click on Legal Entities from Entity Manager Tab; in Home Page
    And I Enter "<ShortName>" as Short name and "<EntityType>" as Entity Type; in Legal Entity Browser Search Panel
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<PendingStatus>" as Status
    And I Click on Edit button and activate LE
    Then I Verified Legal Entity Activated for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status successfully
    And I Click Legal Entity Created for "<ShortName>" with "<EntityType>" as Entity Type and "<ActiveStatus>" as Status
    Then I validate the Field Audit and Record Audit and Activities "<EntityType>" "<LegalName>" after right to left
    And I click on Logout Button; from Home Page

    @UAT
    Examples: 
      | Relationship   | Type1 | RespCode1 | OriginatingOfficer | RespCode2 | MarketSector | GeographicRegion | CostCenter | LegalName          | ShortName    | ProcessingOrg | EntityType | Address                          | City        | State      | PostalCode | Country                  | Status | ActiveStatus | PendingStatus | FirstName1 | LastName1 | UserId1 | Password  | EmailAddress        | PhoneNumber | CellNumber    | FirstName2 | LastName2 | UserId2 | ApproverUser | ApproverPassword | NormalUser | NormalPassword |
      | TestAutomation | RM    |     61342 | AutoTest           |     61343 | Northern MD  | Blakehurst       |   53022009 | AutomationcreditLE | AutoCreditLE | FULTON        | Corporate  | 11661 San Vicente Blvd Suite 800 | Los Angeles | California | 90049-5116 | UNITED STATES OF AMERICA | New    | Active       | Pending       | Rajesh1    | BOSS1     | Raj1    | Raj@12345 | rajesh.r@finzly.com |  8925227991 | +918925227991 | Rajesh2    | BOSS2     | Raj2    | Rajesh2      | Raj@1234         | Rajesh1    | Raj@12345      |
