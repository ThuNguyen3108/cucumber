package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

//@CucumberOptions(
//        features = "D:\\QC\\CucumberVibe\\src\\test\\java\\resources\\features\\Login.feature",
//        glue = "stepdefinitions",
//        plugin = {"pretty", "html:target/cucumber-html-report.html"}
//)
@CucumberOptions(features = "src/test/resources/features/Slide.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin= {"pretty",
                "html:target/cucumber-reports/TestRunnerCreateSlide.html",
                "json:target/cucumber-reports/TestRunnerCreateSlide.json",
               })


@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}