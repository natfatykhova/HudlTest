package AutomationProject.Pages;

import AutomationProject.CommonUtils.CommonClicks;
import AutomationProject.CommonUtils.WaitSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

import static AutomationProject.CommonUtils.CommonConst.JOIN_AS_ORG_URL;
import static AutomationProject.CommonUtils.CommonConst.SIGN_UP_URL;
import static AutomationProject.Steps.BrowserSetUp.getWebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.How.CSS;

public class LoginPage {
    CommonClicks commonClicks = new CommonClicks();
    WaitSteps waitSteps = new WaitSteps();

    @FindBy(how = CSS, using = ".login-fields")
    public WebElement LoginForm;
    @FindBy(how = CSS, using = ".icon-logomark")
    public WebElement HudlLogo;
    @FindBy(how = CSS, using = "input[id='email']")
    public WebElement EmailInput;
    @FindBy(how = CSS, using = "input[id='password']")
    public WebElement PasswordInput;
    @FindBy(how = CSS, using = "#logIn")
    public WebElement LoginButton;
    @FindBy(how = CSS, using = "#remember-me")
    public WebElement RememberMeCheckbox;
    @FindBy(how = CSS, using = "#forgot-password-link")
    public WebElement NeedHelpLink;
    @FindBy(how = CSS, using = ".login-error-container .need-help")
    public WebElement NeedHelpErrorLink;
    @FindBy(how = CSS, using = ".login-error-container")
    public WebElement ErrorMessage;
    @FindBy(how = CSS, using = ".sign-up-trial")
    public WebElement SignUpLink;
    @FindBy(how = CSS, using = "#logInWithOrganization")
    public WebElement LogInAsOrganisation;
    @FindBy(how = CSS, using = "#forgot-email")
    public WebElement ResetPasswordEmailInput;
    @FindBy(how = CSS, using = "#resetBtn")
    public WebElement ResetPasswordBtn;
    @FindBy(how = CSS, using = ".uni-input")
    public WebElement JoinAsOrganisationEmailInput;
    @FindBy(how = CSS, using = "[data-qa-id=log-in-with-sso]")
    public WebElement JoinAsOrganisationLoginBtn;
    @FindBy(how = CSS, using = "#register_demo")
    public WebElement RequestDemoHighSchoolBtn;
    @FindBy(how = CSS, using = ".hui-globaluseritem__display-name")
    public WebElement UsernameProfile;
    @FindBy(how = CSS, using = "[data-qa-id='webnav-usermenu-logout']")
    public WebElement LogoutButton;

    public LoginPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    /**
     * Login page buttons map
     *
     * @param buttonName
     * @return
     */
    private WebElement getLoginPageButton(String buttonName) {
        HashMap<String, WebElement> elementMap = new HashMap<>();
        elementMap.put("Log in", LoginButton);
        elementMap.put("Sign up", SignUpLink);
        elementMap.put("Need help?", NeedHelpLink);
        elementMap.put("Need help? in error", NeedHelpErrorLink);
        elementMap.put("Log in with an Organisation", LogInAsOrganisation);
        return elementMap.get(buttonName);
    }

    /**
     * Enter text in email / password input
     *
     * @param input
     * @param text
     */
    public void enterEmailPwdValue(String input, String text) {
        commonClicks.sendKeys(
                (input.equals("email")) ? EmailInput : PasswordInput, text
        );
    }

    /**
     * Click on login page button
     *
     * @param button
     */
    public void clickLoginPageButton(String button) {
        waitSteps.waitForElementToBeVisible(getLoginPageButton(button), 3);
        commonClicks.clickOn(getLoginPageButton(button));
    }

    /**
     * Verify login error message
     *
     * @param errorMsg
     */
    public void shouldSeeErrorMsg(String errorMsg) {
        waitSteps.waitForElementToBeVisible(ErrorMessage, 5);
        commonClicks.shouldSeeElementTextMatch(ErrorMessage, errorMsg);
    }

    /**
     * Mark remember me checkbox
     */
    public void checkRememberMe() {
        commonClicks.clickUsingJs(RememberMeCheckbox);
    }

    /**
     * Click log out button in profile
     */
    public void clickLogOutButton() {
        commonClicks.clickOn(UsernameProfile);
        waitSteps.waitForElementToBeVisible(LogoutButton, 1);
        commonClicks.clickOn(LogoutButton);
    }

    /**
     * Check user data is filled
     *
     * @param asMap
     */
    public void shouldSeeUserData(Map<String, String> asMap) {
        waitSteps.setSleepFor(2);
        assertEquals(asMap.get("email"), EmailInput.getAttribute("value"));
        assertTrue(PasswordInput.getAttribute("value").isEmpty());
    }

    /**
     * Should see login form on login page
     */
    public void shouldSeeLoginForm() {
        waitSteps.waitForElementToBeVisible(LoginForm, 5);
    }

    /**
     * Should see Hudl logo
     */
    public void logoIsDisplayed() {
        commonClicks.shouldSeeElement(HudlLogo);
    }

    /**
     * Should see reset password form
     */
    public void shouldSeeResetPassword() {
        waitSteps.waitForElementToBeVisible(ResetPasswordBtn, 5);
        commonClicks.shouldSeeElement(ResetPasswordEmailInput);
    }

    /**
     * Should see join as organisation login form
     */
    public void shouldSeeJoinAsOrganisation() {
        commonClicks.shouldBeOnUrl(JOIN_AS_ORG_URL);
        waitSteps.waitForElementToBeVisible(JoinAsOrganisationLoginBtn, 5);
        commonClicks.shouldSeeElement(JoinAsOrganisationEmailInput);
    }

    /**
     * Should see request a demo page
     */
    public void shouldSeeRequestDemoPage() {
        commonClicks.shouldBeOnUrl(SIGN_UP_URL);
        waitSteps.waitForElementToBeVisible(RequestDemoHighSchoolBtn, 5);
    }

    /**
     * Shove see username in profile
     *
     * @param username
     */
    public void shouldSeeUsername(String username) {
        waitSteps.setSleepFor(5);
        commonClicks.shouldSeeElementTextMatch(UsernameProfile, username);
    }
}
