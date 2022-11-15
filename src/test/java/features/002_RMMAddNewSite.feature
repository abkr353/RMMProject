@RMMAddNewSite

Feature: RMM Add new site

  Scenario: As a user i want to be able to add new site
    Given i have launched the browser with RMM system
    When i capture username and the password of an administrator
    And i click on login button to login as an admin
    Then i validate if the user able to login as an admin
    And i click on Administration dashboard tab
    And i click on Sites configuration
    And i click on Sites
    And i click on Add new site tab
    And i capture sites details
    And i click on continue to go to Operating details
    And i complete Operating Details
    And i click on continue to go to contact details
    And i capture contact details

