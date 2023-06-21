package manager;
import logPackage.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverSetup {
    private static WebDriver driver;
    private Properties prop = new Properties();
    private InputStream inputStream = null;

    public static WebDriver getDriver() throws IOException {
        if (driver == null) {
            Log.info("Get webdriver setup");
            driver = setDriver();
        }
        return driver;
    }

    private static WebDriver setDriver() throws IOException {
        WebDriver driver;
        InputStream inputStream = new FileInputStream("src/test/resources/config.properties");
        Properties prop = new Properties();
        prop.load(inputStream);

        String browserType = prop.getProperty("browser");
        String appURL = prop.getProperty("appUrl");
        int implicitWait = prop.getProperty("implicitWait") == null ? 30 : Integer.parseInt(prop.getProperty("implicitWait"));
        int pageLoadTimeout = prop.getProperty("pageLoadTimeout") == null ? 30 : Integer.parseInt(prop.getProperty("pageLoadTimeout"));

        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                Log.info("Launch chrome browser");
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                Log.info("Launch firefox browser");
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL);
        }

        driver.manage().window().maximize();
        Log.info("Maximize browser window");
        driver.navigate().to(appURL);
        Log.info("Navigate to app " + appURL);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

        return driver;
    }

    private static WebDriver initChromeDriver(String appURL) {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
