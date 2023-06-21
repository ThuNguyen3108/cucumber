package hooks;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.SlidePage;
import pageObjects.WaitForLoadingPage;

public class TestConText {
    private WebDriver driver;
    private LoginPage loginPage;
    private SlidePage slidePage;
    private WaitForLoadingPage waitForLoadingPage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


}
