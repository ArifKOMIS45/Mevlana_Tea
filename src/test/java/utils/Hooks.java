package utils;

import cucumber.api.Scenario;
import cucumber.api.java.*;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Hooks {
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration duration;
    private LocalDate date;

    @Before
    public void before() {
        startTime = LocalTime.now();
        if (Drivers.threadLanguage.get() == null) {
            Drivers.threadLanguage.set("DE");
        }
        Drivers.getDriver().manage().deleteAllCookies();
        Parent.navigateToUrl(Drivers.threadLanguage.get());
    }

    @After
    public void after(Scenario scenario) {
        endTime = LocalTime.now();
        duration = Duration.between(startTime, endTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        if (scenario.isFailed()) {
            date=LocalDate.now();
            TakesScreenshot screenshot = (TakesScreenshot) Drivers.getDriver();
            File file = screenshot.getScreenshotAs(OutputType.FILE);
            try {
                FileHandler.copy(file, new File("src/test/resources/screenShots/" + scenario.getId() + date.format(formatter) + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ExcelUtils.logScenarioToExcel(scenario, startTime, endTime, duration, Drivers.threadBrowserName.get());
        Drivers.quitDriver();
    }
}
