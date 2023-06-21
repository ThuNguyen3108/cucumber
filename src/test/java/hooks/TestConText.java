package hooks;

import manager.PageObjectManager;
import manager.WebDriverSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.SlidePage;
import pageObjects.WaitForLoadingPage;

import java.io.IOException;

public class TestConText {
    private static final Logger Log =  LogManager.getLogger(TestConText.class);
    private WebDriver driver;
    private LoginPage loginPage;
    private SlidePage slidePage;
    private WaitForLoadingPage waitForLoadingPage;

    private WebDriverSetup webDriverSetup;
    private PageObjectManager pageObjectManager;

    public TestConText() throws IOException {
        webDriverSetup = new WebDriverSetup();
        pageObjectManager = new PageObjectManager(webDriverSetup.getDriver());
    }

        public WebDriverSetup getwebDriverSetup() {
            return webDriverSetup;
        }

        public PageObjectManager getPageObjectManager() {
            return pageObjectManager;
        }
//        public LoginPage getLoginPage() {
//            if (loginPage == null) {
//                loginPage = new LoginPage(driver);
//            }
//            return loginPage;
//        }
//
//    public SlidePage getSlidePage(){
//      if(slidePage == null){
//            slidePage = new SlidePage(driver);
//        }
//     return slidePage;
//    }
}








