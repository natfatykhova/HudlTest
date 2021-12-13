package AutomationProject.Pages;

import AutomationProject.CommonUtils.CommonClicks;
import org.junit.Assert;

import static AutomationProject.CommonUtils.CommonConst.BASE_URL;

public class CommonPage {

    CommonClicks commonClicks = new CommonClicks();

    /**
     * Go to page
     *
     * @param pageTitle
     */
    public void goToPage(String pageTitle) {
        switch (pageTitle) {
            case "Home":
                commonClicks.openPage(BASE_URL);
                break;
            case "Login":
                commonClicks.openPage(BASE_URL + "/login");
                break;
            default:
                Assert.fail("No such page");
        }
    }
}
