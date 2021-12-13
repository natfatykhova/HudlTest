package AutomationProject.Steps;

import AutomationProject.Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @And("^I enter (email|password) \"([^\"]*)\" to login form$")
    public void enterEmail(String input, String text) {
        loginPage.enterEmailPwdValue(input, text);
    }

    @When("I click {string} button on login page")
    public void iClickButtonOnLoginForm(String button) {
        loginPage.clickLoginPageButton(button);
    }

    @Then("I should see user name {string} in profile menu")
    public void iShouldSeeUserProfile(String username) {
        loginPage.shouldSeeUsername(username);
    }

    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String errorMsg) {
        loginPage.shouldSeeErrorMsg(errorMsg);
    }

    @And("I check Remember me checkbox")
    public void iCheckRememberMeCheckbox() {
        loginPage.checkRememberMe();
    }

    @And("I click log out button in user profile")
    public void iClickLogOutButtonInUserProfile() {
        loginPage.clickLogOutButton();
    }

    @And("I should see user data saved in login form")
    public void iShouldSeeUserDataSavedInLoginForm(DataTable data) {
        loginPage.shouldSeeUserData(data.asMap(String.class, String.class));
    }

    @And("I should see login form")
    public void iShouldSeeLoginForm() {
        loginPage.shouldSeeLoginForm();
    }

    @And("I should see Hudl logo on login page")
    public void iShouldSeeHudlLogoOnLoginPage() {
        loginPage.logoIsDisplayed();
    }

    @Then("I should be taken to Reset password page")
    public void iShouldBeTakenToResetPasswordPage() {
        loginPage.shouldSeeResetPassword();
    }

    @Then("I should be taken to Join as organisation page")
    public void iShouldBeTakenToJoinAsOrganisationPage() {
        loginPage.shouldSeeJoinAsOrganisation();
    }

    @Then("I should be taken to Request a demo page")
    public void iShouldBeTakenToRequestADemoPage() {
        loginPage.shouldSeeRequestDemoPage();
    }
}
