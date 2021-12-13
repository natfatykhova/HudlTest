import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "AutomationProject/Steps",
        tags = "@login",
        plugin = {
                "pretty",
                "json:target/chrome/cucumber-report/cucumber.json",
                "html:target/chrome/cucumber-report/cucumber.html",
                "junit:target/chrome/cucumber-report/cucumber.xml"
        }
)
public class runChromeTests {

}

