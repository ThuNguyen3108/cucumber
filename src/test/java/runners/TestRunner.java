package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//@CucumberOptions(
//        features = "D:\\QC\\CucumberVibe\\src\\test\\java\\resources\\features\\Login.feature",
//        glue = "stepdefinitions",
//        plugin = {"pretty", "html:target/cucumber-html-report.html"}
//)
@CucumberOptions(features = "src/test/resources/features/Slide.feature",glue = "stepDefinitions",
        plugin= {"pretty",
                "html:target/cucumber-reports/TestRunnerCreateSlide.html",
                "json:target/cucumber-reports/TestRunnerCreateSlide.json",
               })


@Test
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setup() {
//        // Use PicoContainer as the dependency injection library
//        final PicoContainer container = new PicoBuilder().withCaching().build();
//
//        // Register the TestContext class to the container
//        ((MutablePicoContainer) container).addComponent(WebDriverSetup.class);
//
//        // Set the container to use as the object factory for step definitions
//        final PicoFactory picoFactory = new PicoFactory(container);
//        picoFactory.addClass(MyStepDefinitions.class);
//
//        // Set the object factory for Cucumber
//        final RuntimeOptions options = new RuntimeOptions(new HashMap<String, String>());
//        final BackendSupplier backendSupplier = () -> new Backend[]{new JavaBackend(picoFactory)};
//        final ResourceLoader resourceLoader = new ClasspathResourceLoader(Thread.currentThread().getContextClassLoader());
//        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        final Runtime runtime = new Runtime(resourceLoader, classLoader, backendSupplier, options);
//        runtime.run();
    }

}