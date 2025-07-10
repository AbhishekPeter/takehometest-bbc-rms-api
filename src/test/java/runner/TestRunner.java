package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/bbcApi.feature",
        glue = {"steps", "hooks"},
        plugin = {"pretty", "summary", "html:target/cucumber-report.html"},
        monochrome = true
)
public class TestRunner { }
// Test runner code

