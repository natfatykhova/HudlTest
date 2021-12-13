package AutomationProject.CommonUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static AutomationProject.Steps.BrowserSetUp.getWebDriver;
import static org.junit.Assert.*;

public class CommonClicks {

    private final WebDriver driver;
    WaitSteps waitSteps = new WaitSteps();

    public CommonClicks() {
        this.driver = getWebDriver();
    }

    /**
     * Click on element
     *
     * @param element
     */
    public void clickOn(WebElement element) {
        shouldSeeElement(element);
        element.click();
    }

    /**
     * Enter text in element
     *
     * @param element
     * @param text
     */
    public void sendKeys(WebElement element, String text) {
        element.click();
        waitSteps.setSleepFor(1);
        element.sendKeys(text);
    }

    /**
     * Should see element
     *
     * @param element
     */
    public void shouldSeeElement(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    /**
     * Should not see element
     *
     * @param element
     */
    public void shouldNotSeeElement(WebElement element) {
        try {
            assertFalse(element.isDisplayed());
        } catch (NoSuchElementException e) {
            //NoSuchElementException means no element is displayed
        }
    }

    /**
     * Should see text on element match expected
     *
     * @param element
     * @param expectedValue
     */
    public void shouldSeeElementTextMatch(WebElement element, String expectedValue) {
        assertEquals(expectedValue, element.getText().trim());
    }

    /**
     * Open url
     *
     * @param url
     */
    public void openPage(String url) {
        driver.get(url);
    }

    /**
     * Should be on url
     *
     * @param url
     * @return
     */
    public boolean shouldBeOnUrl(String url) {
        return getWebDriver().getCurrentUrl().contains(url);
    }

    /**
     * Click on element using js
     *
     * @param element
     */
    public void clickUsingJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

}
