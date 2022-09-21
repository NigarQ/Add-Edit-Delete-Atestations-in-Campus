Feature: Add Attestation under Human Resources Setup

Background:
  Given User is on login page
  When User enter admin credentials
  Then User should login successfully


  Scenario Outline: Add Attestation name
    And Navigate to Attestations page
    When User creates new name "<attestationName>"
    Then User should see successful message

    Examples:
    |attestationName|
    |nigar          |

    Scenario Outline: Add same Attestation name
      And Navigate to Attestations page
      When User creates same name "<sameAttestationName>"
      Then User should see unsuccessful message

      Examples:
      |sameAttestationName|
      |nigar              |

