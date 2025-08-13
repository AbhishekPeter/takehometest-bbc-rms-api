package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/bbcApi.feature", // Cucumber reads these files and identifies scenarios to execute

        //"glue" specifies the package(s) containing - Step definition classes and Hook classes
        glue = {"steps", "hooks"},

        // "plugin" defines how test results are reported
        plugin = {"pretty", "summary", "html:target/cucumber-report.html"},
        monochrome = true
)
public class TestRunner {
    //This class is empty because configuration and behavior are fully controlled by annotations
}


