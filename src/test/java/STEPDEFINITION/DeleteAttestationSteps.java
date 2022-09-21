package STEPDEFINITION;

import POM.DialogContentElements;
import POM.NavigationBarElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteAttestationSteps {


    NavigationBarElements navigationBarElements;
    DialogContentElements dialogContentElements;


    @When("User delete attestation {string}")
    public void user_delete_attestation(String name) {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.deleteAttestation(name);
    }


    @Then("Successfully deleted message should be displayed")
    public void successfully_deleted_message_should_be_displayed() {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.successfullyDeleted();

    }

    @Then("There is no data should be displayed")
    public void there_is_no_data_should_be_displayed() {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.noDataDisplayed();

    }

}
