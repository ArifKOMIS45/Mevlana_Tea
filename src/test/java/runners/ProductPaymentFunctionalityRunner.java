package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;
import utils.Drivers;

@CucumberOptions(
        features = {"src/test/resources/featureFiles/ProductPaymentFunctionality.feature"},
        glue = {"stepDefinitions", "utils"}
        )



public class ProductPaymentFunctionalityRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"browser", "language"})
    public void start(String browser,String language){
        Drivers.threadBrowserName.set(browser);
        Drivers.threadLanguage.set(language);


    }



    @AfterMethod
    public void tearDown(){Drivers.quitDriver();}


}
