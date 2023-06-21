package stepDefinitions;

import hooks.TestConText;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

import java.io.IOException;

public class LoginSteps {
    private TestConText testContext;
    private LoginPage loginPage;

    public LoginSteps(TestConText context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("user navigate to login page {string}")
    public void userNavigateToLoginPage(String URL) throws IOException {
            loginPage.navigateToLoginPage();
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
        //Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }


}
