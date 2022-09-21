Feature: Edit Attestations functionality

  Background:
    Given User is on login page
    When User enter admin credentials
    Then User should login successfully

    Scenario:
      Given User navigates to Attestations page
      When User click edit
      And User enter new name and click save
      Then User should see successfully updated message
