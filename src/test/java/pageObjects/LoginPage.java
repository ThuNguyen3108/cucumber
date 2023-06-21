package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {
    private static final Logger Log =  LogManager.getLogger(LoginPage.class);
    private WebDriver driver;
    @FindBy (id = "ctl01_cPC_ctl00_UserName")
    public WebElement username_Field;

    @FindBy (id = "ctl01_cPC_ctl00_Password")
    public WebElement password_Field;

    @FindBy (id = "ctl01_cPC_ctl00_ibLogin")
    public WebElement submit_Field;

    @FindBy (id = "ctl01_Logo_ctl00_ibBannerImage")
    public WebElement verifyLogin;

    String expectedURL = "https://dstest.vibe.fyi/portal/slide-editor";


//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver,this);
//    }
//
//    public LoginPage() {
//
//    }

    public void Enter_username(String username){
        username_Field.sendKeys(username);
        Log.info("Enter username successful");
    }

    public void Enter_password(String password){
        password_Field.sendKeys(password);
        Log.info("Enter password successful");
    }


    public void Click_button(){
        submit_Field.click();
        Log.info("Click button login successful");

    }

    public void verifyLoginSucess(){
        String  actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Log.info("actualURL: " + actualURL);
        Log.info("expectedURL: " + expectedURL);
        Log.info("Verify Success");
    }


    public void login(String name, String pass) {
        Enter_username(name);
        Enter_password(pass);
        Click_button();
        verifyLoginSucess();
    }
}



