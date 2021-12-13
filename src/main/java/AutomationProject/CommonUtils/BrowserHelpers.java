package AutomationProject.CommonUtils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class BrowserHelpers {

    /**
     * Set Chrome options for web testing
     * @param argList
     * @return
     */
    public ChromeOptions setAdditionalChromeOptions(String[] argList) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.addArguments(argList);
        return chromeOptions;
    }

    /**
     * Set Firefox options
     * @return
     */
    public FirefoxOptions setAdditionalFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        firefoxOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        firefoxOptions.setCapability("moz:firefoxOptions", firefoxOptions);
        return firefoxOptions;
    }
}
