package AutomationProject.Steps;

import AutomationProject.CommonUtils.BrowserHelpers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.pramcharan.wd.binary.downloader.WebDriverBinaryDownloader;
import io.github.pramcharan.wd.binary.downloader.enums.Browser;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static AutomationProject.CommonUtils.CommonConst.*;
import static io.github.pramcharan.wd.binary.downloader.enums.Browser.CHROME;
import static io.github.pramcharan.wd.binary.downloader.enums.Browser.FIREFOX;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BrowserSetUp {
    private static WebDriver webDriver;
    public static String browserType;
    public static String[] CHROME_ARG = {"--no-sandbox", "--allow-file-access-from-files", "--allow-file-access",
            "--disable-gpu", "--use-fake-device-for-media-stream", "--use-fake-ui-for-media-stream"};
    BrowserHelpers browserHelpers = new BrowserHelpers();

    @Before
    public void before() {
        setBrowserType();
        setTimeout(DEFAULT_TIMEOUT);
        setFullScreenMode();
    }

    /**
     * Set browser type sample for cross browser automation
     */
    private void setBrowserType() {
        browserType = System.getProperty(BROWSER_PROP, CHROME_BROWSER);
        switch (browserType) {
            case CHROME_BROWSER:
                downloadAndConfigure(CHROME);
                webDriver = new ChromeDriver(browserHelpers.setAdditionalChromeOptions(CHROME_ARG));
                break;
            case GECKO_BROWSER:
                downloadAndConfigure(FIREFOX);
                webDriver = new FirefoxDriver(browserHelpers.setAdditionalFirefoxOptions());
                break;
            default:
                Assert.fail("Browser type not recognised");
        }
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot finalScreenshot = (TakesScreenshot) webDriver;
            scenario.attach(
                    finalScreenshot.getScreenshotAs(OutputType.BYTES),
                    "image/png",
                    scenario.getName()
            );
        }
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    /**
     * Set wait timeouts
     *
     * @param timeout
     */
    private void setTimeout(int timeout) {
        webDriver.manage().timeouts().implicitlyWait(timeout, SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(timeout, SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(DRIVER_TIMEOUT, TimeUnit.SECONDS);
    }

    /**
     * Set browser full screen
     */
    private void setFullScreenMode() {
        webDriver.manage().window().maximize();
    }

    /**
     * Download webdriver
     *
     * @param browser
     */
    private void downloadAndConfigure(Browser browser) {
        WebDriverBinaryDownloader.create().downloadLatestBinaryAndConfigure(browser);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}
