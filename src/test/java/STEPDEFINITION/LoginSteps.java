package STEPDEFINITION;

import POM.LoginPageElements;
import io.cucumber.java.en.*;

public class LoginSteps {


    LoginPageElements loginPage;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPageElements();
        loginPage.validateUserOnLoginPage();
    }

    @When("User enter admin credentials")
    public void user_enter_admin_credentials() {
        loginPage = new LoginPageElements();
        loginPage.userEnterAdminCredentials();
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {
        loginPage = new LoginPageElements();
        loginPage.validateUserSuccessfullyLoggedIn();
    }


}
