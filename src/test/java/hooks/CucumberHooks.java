package hooks;

import io.cucumber.java.*;
import manager.WebDriverSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

public class CucumberHooks {
    private static final Logger Log = LogManager.getLogger(LoginPage.class);
    private static WebDriver driver;
    @BeforeAll
    public static void beforeAll() {
        Log.info("================ beforeAll ================");
        //PropertiesHelpers.loadAllFiles();
        //Khởi chạy Report
    }

    @AfterAll
    public static void afterAll() {
        Log.info("================ afterAll ================");

    }

    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        Log.info("================ beforeScenario ================");
        driver = WebDriverSetup.getDriver();
        //WebDriverSetup.setDriver();
        //Record video
    }

    @After
    public void afterScenario(Scenario scenario) {
        Log.info("================ afterScenario ================");
        WebDriverSetup.tearDown();
        //BaseTest.closeDriver();
    }

//    @BeforeStep
//    public void beforeStep(Scenario scenario) {
//        Log.info("================ beforeStep ================");
//        Log.info(scenario.getName());
//        //Ghi file log4j
//        //Ghi log step vào report
//    }
//
//    @AfterStep
//    public void afterStep(Scenario scenario) {
//        Log.info("================ afterStep ================");
//        //validate if scenario has failed then Screenshot
//        if (scenario.isFailed()) {
//            //CaptureHelpers.takeScreenshot(scenario.getName());
//        }
//    }
    public static WebDriver getDriver() {
        return driver;
    }
}