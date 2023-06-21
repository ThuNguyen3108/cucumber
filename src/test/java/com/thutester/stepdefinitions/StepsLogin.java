package com.thutester.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsLogin {
    @Given("user navigate to Login page")
    public void userNavigateToLoginPage() {
    }

    @When("^user enter email is (.+) and password is (.+)$")
    public void userEnterEmailIsEmailAndPasswordIsPassword(String user, String pass) {
    }

    @And("click login button")
    public void clickLoginButton() {
    }

    @Then("user should navigate to slide page")
    public void userShouldNavigateToSlidePage() {
    }
}
