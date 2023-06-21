package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageObjectManager;
import manager.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LoginPage;

import java.io.IOException;

public class LoginSteps {
    LoginPage loginPage;
    WebDriverSetup webDriverSetup;
    PageObjectManager pageObject;
    WebDriver driver;

    @Given("user navigate to login page {string}")
    public void userNavigateToLoginPage(String URL) throws IOException {
        webDriverSetup = new WebDriverSetup();
        driver = webDriverSetup.getDriver();
        pageObject = new PageObjectManager(driver);
        loginPage = pageObject.getLoginPage();
        driver.get(URL);
    }

    @When("user enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String email, String password) {
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        loginPage.clickButton();
    }

    @Then("user redirect to slide page {string}")
    public void userRedirectToSlidePage(String expectedURL) {
        loginPage.verifyLoginSuccess();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }


}
