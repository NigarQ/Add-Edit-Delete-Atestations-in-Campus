package STEPDEFINITION;

import POM.DialogContentElements;
import POM.NavigationBarElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAttestationSteps {

    NavigationBarElements navigationBarElements;
    DialogContentElements dialogContentElements;

    @Given("Navigate to Attestations page")
    public void navigate_to_attestations_page(){
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        navigationBarElements.navigateToAttestationsPage();
    }

    @When("User creates new name {string}")
    public void user_creates_new_name(String attestationName) {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.addAttestation(attestationName);

    }

    @Then("User should see successful message")
    public void user_should_see_successful_message() {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.validateSuccessMessage();

    }


    @When("User creates same name {string}")
    public void userCreatesSameName(String sameAttestationName) {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.addSameAttestationName(sameAttestationName);

    }

    @Then("User should see unsuccessful message")
    public void userShouldSeeUnsuccessfulMessage() {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.validateUnsuccessfulMessage();
    }
}
