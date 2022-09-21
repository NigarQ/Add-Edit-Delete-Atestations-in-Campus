Feature: Delete Attestation functionality

  Background:
    Given User is on login page
    When User enter admin credentials
    Then User should login successfully


    Scenario Outline: Delete Attestation positive
      Given User navigates to Attestations page
      When User delete attestation "<name>"
      Then Successfully deleted message should be displayed

      Examples:
      |name|
      |nasker|

    Scenario Outline: Delete Attestation negative
      Given User navigates to Attestations page
      When User delete attestation "<name>"
      Then There is no data should be displayed

      Examples:
      |name|
      |nasker|