package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.Drivers;
import utils.ExcelUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@CucumberOptions(
        features = {"src/test/resources/featureFiles"},
        glue = {"stepDefinitions", "utils"},
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/RegressionReport.html"
        }
)
public class RegressionRunner extends AbstractTestNGCucumberTests {
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration duration;
    private LocalDate startDate;
    private LocalDate endDate;

    @BeforeClass
    @Parameters({"browser", "language"})
    public void initiate(String browser, String language) {
        startTime = LocalTime.now();
        startDate = LocalDate.now();
        Drivers.threadBrowserName.set(browser);
        Drivers.threadLanguage.set(language);
    }

    @AfterClass
    public void terminate() {
        endTime = LocalTime.now();
        endDate = LocalDate.now();
        duration = Duration.between(startTime, endTime);
        Reporter.loadXMLConfig("src/test/java/XMLFiles/ExtendReportSet.xml");

        Reporter.setSystemInfo("User Name", "EuroTech Testing Team");
        Reporter.setSystemInfo("Application Name", "Mevlana Tea");
        Reporter.setSystemInfo("Operating System Info", System.getProperty("os.name"));
        Reporter.setSystemInfo("Department", "QA");

        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
        ExcelUtils.logTestToExcel(this.getClass().getSimpleName(), startDate, endDate, startTime, endTime, duration);
    }
}
