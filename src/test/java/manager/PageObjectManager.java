package manager;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.SlidePage;

public class PageObjectManager {
    private WebDriver driver;
    private LoginPage loginPage;

    private SlidePage slidePage;



    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage getLoginPage(){
        return (loginPage == null)? loginPage = new LoginPage(driver): loginPage;
    }


    public SlidePage getSlidePage(){
        return (slidePage == null)? slidePage = new SlidePage(driver): slidePage;
    }

}
