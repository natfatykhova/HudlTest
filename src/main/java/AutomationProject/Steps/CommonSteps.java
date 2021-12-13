package AutomationProject.Steps;

import AutomationProject.Pages.CommonPage;
import io.cucumber.java.en.And;

public class CommonSteps {

    @And("I open {string} page")
    public void goToPage(String pageTitle) {
        new CommonPage().goToPage(pageTitle);
    }
}
