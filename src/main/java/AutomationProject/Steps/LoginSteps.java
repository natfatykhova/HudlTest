package AutomationProject.Steps;

import AutomationProject.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @And("^I enter (email|password) for user \"([^\"]*)\" to login form$")
    public void iEnterEmailForUserToLoginForm(String input, String username) {
        loginPage.enterEmailPwdForUser(input, username);
    }

    @And("^I enter (email|password) \"([^\"]*)\" to login form$")
    public void enterEmail(String input, String text) {
        loginPage.enterEmailPwdValue(input, text);
    }

    @When("I click {string} button on login page")
    public void iClickButtonOnLoginForm(String button) {
        loginPage.clickLoginPageButton(button);
    }

    @Then("I should see user name {string} in profile menu")
    public void iShouldSeeUserProfile(String user) {
        loginPage.shouldSeeUsername(user);
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

    @And("I should see user {string} email saved in login form")
    public void iShouldSeeUserDataSavedInLoginForm(String username) {
        loginPage.shouldSeeUserEmail(username);
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
