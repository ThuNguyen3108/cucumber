package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageObjectManager;
import manager.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.SlidePage;

import java.io.IOException;

public class SlideSteps {
    LoginPage loginPage;
    WebDriverSetup webDriverSetup;
    PageObjectManager pageObject;
    WebDriver driver;
    private SlidePage slidePage;
    //private BaseClass baseClass;

//    public SlideSteps(BaseClass baseClass){
//        this.baseClass = baseClass;
//    }

    @Given("user navigates to login page {string}")
    public void userNavigatesToLoginPage(String url) throws IOException {
        webDriverSetup = new WebDriverSetup();
        driver = webDriverSetup.getDriver();
        pageObject = new PageObjectManager(driver);
        loginPage = pageObject.getLoginPage();
        slidePage = pageObject.getSlidePage();


    }

    @When("user enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.clickButton();
    }

    @Then("user is redirected to slide page {string}")
    public void userIsRedirectedToSlidePage(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(expectedUrl);
    }

    @When("user clicks create slide button")
    public void userClicksCreateSlideButton() throws InterruptedException {
        Thread.sleep(7000);
        slidePage.button_CreatSlide();
    }

    @And("user enters title template slide {string}")
    public void userEntersTitleTemplateSlide(String title) {
        slidePage.Enter_TitleTemplateSlide(title);
    }

    @And("user selects this template")
    public void userSelectsThisTemplate() {
        slidePage.Select_ThisTemplate();
    }

    @And("user enters title slide {string}")
    public void userEntersTitleSlide(String title) {
        slidePage.Enter_TitleSlide(title);
    }

    @And("user clicks create slide button template")
    public void userClicksCreateSlideButtonTemplate() {
        slidePage.Button_CreatSlideTemplate();
    }

    @Then("create slide is verified")
    public void createSlideIsVerified() {
        slidePage.verifyCreateSlide();
    }

    @And("user clicks add item button")
    public void userClicksAddItemButton() throws InterruptedException {
        slidePage.setAddItemButton();
    }

    @And("user drags image of item")
    public void userDragsImageOfItem() {
        slidePage.setDragImageOfItem();
    }

    @And("user adds image of item")
    public void userAddsImageOfItem() {
        slidePage.addImageOfItem();
    }

    @And("user updates list item")
    public void userUpdatesListItem() {
        slidePage.setUpdateListItem();
    }

    @And("user enters title of add item {string}")
    public void userEntersTitleOfAddItem(String title) {
        slidePage.enter_titleAddItem(title);
    }

    @And("user enters summary of add item {string}")
    public void userEntersSummaryOfAddItem(String summary) {
        slidePage.enter_summaryAddItem(summary);
    }

    @And("user clicks save button")
    public void userClicksSaveButton() {
        slidePage.setButtonSave();
    }


    @Then("item {int} is verified")
    public void itemIsVerified(int arg0) throws InterruptedException {
        slidePage.verifyIem1Success();
    }
}
