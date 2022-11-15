@RMMLogin

  Feature: RMM login

    Scenario: As a user i want to be able to log into RMM system
      Given i have launched the browser and validate RMM default page
      When i capture username and the password
      And i click on login button
      Then i validate if the user able to login