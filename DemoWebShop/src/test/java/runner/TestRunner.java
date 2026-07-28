package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestRunner - Cucumber TestNG runner class for executing feature files.
 * Configures feature file location, step definitions, and report plugins.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-report.html",
                "json:target/cucumber-reports/cucumber-report.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true,
        tags = "@Smoke or @Regression or @DataDriven"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    /**
     * Provides scenarios as data for parallel execution.
     *
     * @return Object array of scenarios
     */
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
