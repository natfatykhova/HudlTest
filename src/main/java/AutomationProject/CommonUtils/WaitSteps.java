package AutomationProject.CommonUtils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static AutomationProject.CommonUtils.CommonConst.DEFAULT_TIMEOUT;
import static AutomationProject.Steps.BrowserSetUp.getWebDriver;

public class WaitSteps {

    private WebDriver driver;
    public WebDriverWait wait;
    private WebDriverWait waitFor;

    public WaitSteps() {
        driver = getWebDriver();
        wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public WebDriverWait waitUntilCondition(int seconds) {
        waitFor = new WebDriverWait(driver, seconds);
        return waitFor;
    }

    /**
     * Set sleep for number of seconds
     *
     * @param seconds
     */
    public void setSleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for element to be displayed
     *
     * @param element
     * @param seconds
     */
    public void waitForElementToBeVisible(WebElement element, int seconds) {
        try {
            waitUntilCondition(seconds).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception ex) {
            Assert.fail("Element is not displayed");
        }
    }

}
