package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.browserfactory.ManageBrowser;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class LoginStepDefinition {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @Given("User is on homepage")  //Don't write any code inside this because it is opening browser from Hook class
    public void userIsOnHomepage() {
        //  System.out.println("This is @Given");
        log.info("Home page displayed");
    }

    @When("User clicks on login link")
    public void userClicksOnLoginLink() {
        new HomePage().clickOnLoginLink();
        log.info("Clicked on login button");
    }

    @Then("User should navigate to login page successfully")
    public void userShouldNavigateToLoginPageSuccessfully() {
        log.info("Navigated to login page");
        Assert.assertEquals(new LoginPage().getWelcomeMessageText(), "Welcome, Please Sign In!", "User is not navigated to login page");
        log.info("Welcome message displayed.");
    }


    @And("User enters email {string}")
    public void userEntersEmail(String email) {
        new LoginPage().enterEmail(email);
        log.info("Entered email.");
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        new LoginPage().enterPassword(password);
        log.info("Entered password.");
    }

    @And("user clicks on Login Button")
    public void userClicksOnLoginButton() {
        new LoginPage().clickOnLoginButton();
        log.info("Clicked on login button.");
    }

    @Then("User should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String errorMessage) {
        System.out.println("Actual error message: "+ new LoginPage().getErrorMessageText());
        Assert.assertEquals(new LoginPage().getErrorMessageText(), errorMessage, "The error message is not displayed");
        log.info("Checking the error message...");
    }


    @Then("User is able to view the {string} link")
    public void userIsAbleToViewTheLogoutLink(String logoutText) {
        Assert.assertEquals(new HomePage().getLogOutLinkText(), logoutText, "'Logout' link is not available upon logging in.");
        log.info("Checking for Log out link....");
    }


    @And("user clicks on Logout link")
    public void userClicksOnLogoutLink() {
        new HomePage().clickOnLogoutLink();
    }

    @Then("User is able to view the Login link")
    public void userIsAbleToViewTheLoginLink() {
       Assert.assertTrue(new HomePage().isLoginLinkDisplayed(),"The login link is not displayed");

    }
}
