package pageObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage {
    private static final Logger Log = LogManager.getLogger(LoginPage.class);
    private WebDriver driver;

    @FindBy(id = "ctl01_cPC_ctl00_UserName")
    private WebElement usernameField;

    @FindBy(id = "ctl01_cPC_ctl00_Password")
    private WebElement passwordField;

    @FindBy(id = "ctl01_cPC_ctl00_ibLogin")
    private WebElement submitButton;

    private String expectedURL = "https://dstest.vibe.fyi/portal/slide-editor";

    public void navigateToLoginPage() {
        // Thực hiện điều hướng đến trang đăng nhập
        driver.get("https://dstest.vibe.fyi");
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
        Log.info("Enter username: " + username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        Log.info("Enter password: " + password);
    }

    public void clickButton() {
        submitButton.click();
        Log.info("Click login button");
    }

    public void verifyLoginSuccess() {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Log.info("Actual URL: " + actualURL);
        Log.info("Expected URL: " + expectedURL);
        Log.info("Verify login success");
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickButton();
        verifyLoginSuccess();
    }
}
