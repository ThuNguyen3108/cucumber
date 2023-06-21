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
    static WebDriver driver;
    Properties prop = new Properties();
    InputStream inputStream = null;



//    public static WebDriver getDriver() {
//    }
    //đọc các dữ liệu khác nhau từ nguồn ầu vào

    public static WebDriver getDriver() throws IOException {
        if(driver == null) {
            Log.info("Get webdriver setup");
            //driver = setDriver();
        };
        return driver;
    }

    public WebDriver setDriver() throws IOException {
        inputStream = new FileInputStream("src/test/resources/config.properties");
        prop.load(inputStream);
        String browserType = prop.getProperty("browser");
        //trả về giá trị của thuộc tính "browser" trong tập tin cấu hình
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
        Log.info("Navigate to app "+appURL);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver initChromeDriver(String appURL) {
//        System.out.println("Launching Chrome browser...");
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        //được dùng để tải và cài phiên bản ChromeDriver tương thích.
        WebDriver driver = new ChromeDriver();
        return driver;
        //Phương thức trả về đối tượng 'webdriver' đã được khởi tạo để có thể sử dụng
        //cho việc điều khiển trình duyệt Chrome
    }


    public WebDriver initFirefoxDriver(String appURL) {
//        System.out.println("Launching Firefox browser...");
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}

