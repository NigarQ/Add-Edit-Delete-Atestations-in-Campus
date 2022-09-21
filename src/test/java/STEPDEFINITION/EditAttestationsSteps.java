package STEPDEFINITION;

import POM.DialogContentElements;
import POM.NavigationBarElements;
import io.cucumber.java.en.*;

public class EditAttestationsSteps {

    NavigationBarElements navigationBarElements;
    DialogContentElements dialogContentElements;

    @Given("User navigates to Attestations page")
    public void user_navigates_to_attestations_page() {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        navigationBarElements.navigateToAttestationsPage();
    }


    @When("User click edit")
    public void user_click_edit() {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.editAttestation();
    }


    @When("User enter new name and click save")
    public void user_enter_new_name_and_click_save() {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.editButton();
    }

    @Then("User should see successfully updated message")
    public void user_should_see_successfully_updated_message() {
        navigationBarElements = new NavigationBarElements();
        dialogContentElements = new DialogContentElements();

        dialogContentElements.validateSuccessfullyUpdatedMessage();
    }

}
