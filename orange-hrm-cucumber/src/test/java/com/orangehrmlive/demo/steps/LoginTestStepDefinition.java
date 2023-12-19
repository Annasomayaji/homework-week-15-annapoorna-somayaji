package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.browserfactory.ManageBrowser;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class LoginTestStepDefinition {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @When("User logins with valid email and password")
    public void userLoginsWithValidEmailAndPassword(DataTable dataTable) {
        log.info("Logging to the application....");
        List<String> credentials = dataTable.asList(String.class);
        new LoginPage().loginToApplication(credentials.get(0), credentials.get(1));

    }

    @Then("User is able to view {string} message")
    public void userIsAbleToViewMessage(String dashboardMessage) {
        log.info("Verifying the dashboard message....");
        Assert.assertEquals(new HomePage().getDashboardTitleText(), dashboardMessage, "User is not logged in.");
    }


    @Then("User can view the logo on the homepage")
    public void userCanViewTheLogoOnTheHomepage() {
        log.info("Verifying the logo on homepage....");
        Assert.assertTrue(new LoginPage().getLogoElement().isDisplayed(), "Logo is not displayed.");
    }


    @And("User logs out by clicking {string}")
    public void userLogsOutByClicking(String logout) {
        log.info("Clicking on logout option from user profile....");
        new HomePage().clickOnUserProfileLogo();
        new HomePage().clickOnDropDownOptions(logout);
    }

    @Then("User can view {string} panel")
    public void userCanViewPanel(String loginText) {
        log.info("Verifying Login panel heading....");
        Assert.assertEquals(new LoginPage().getLoginPanelHeadingText(), loginText, "User is not logged out successfully.");

    }
//
//
//    @When("User enters {string} in username field")
//    public void userEntersInUsernameField(String userName) {
//        log.info("Entering username....");
//        new LoginPage().enterUserName(userName);
//    }

//    @And("User enters {string} in password field")
//    public void userEntersInPasswordField(String password) {
//        log.info("Entering password....");
//        new LoginPage().enterPassword(password);
//    }

    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        log.info("Clicking on Login button....");
        new LoginPage().clickOnLoginButton();

    }

    @Then("User can view {string} error message")
    public void userCanViewErrorMessage(String errorMessage) {
        log.info("Verifying error message....");
        Assert.assertEquals(new LoginPage().getErrorMessageForUserNameRequiredField(), errorMessage, "Error message not displayed for username field.");
        Assert.assertEquals(new LoginPage().getErrorMessageForPasswordRequiredField(), errorMessage, "Error message not displayed for username field.");
    }


    @And("User enters {string} in username field")
    public void userEntersInUsernameField(String userName) {
        log.info("Entering username....");
        new LoginPage().enterUserName(userName);
    }

    @And("User enters {string} in password field")
    public void userEntersInPasswordField(String password) {
        log.info("Entering Password....");
        new LoginPage().enterPassword(password);
    }

    @Then("User can view {string} error message for {string} and {string}")
    public void userCanViewErrorMessageForAnd(String errorMessage, String userName, String password) {
        log.info("Verifying error messages for invalid credentials....");
        if (userName.isEmpty() && password.isEmpty()) {
            Assert.assertEquals(new LoginPage().getErrorMessageForUserNameRequiredField(), errorMessage, "Error message for blank username is not displayed.");
            Assert.assertEquals(new LoginPage().getErrorMessageForPasswordRequiredField(), errorMessage, "Error message for blank password is not displayed.");
        } else if (userName.isEmpty()) {
            Assert.assertEquals(new LoginPage().getErrorMessageForUserNameRequiredField(), errorMessage, "Error message for blank username is not displayed.");
        } else if (password.isEmpty()) {
            Assert.assertEquals(new LoginPage().getErrorMessageForPasswordRequiredField(), errorMessage, "Error message for blank password is not displayed.");
        }else
            Assert.assertEquals(new LoginPage().getErrorMessageForInvalidCredentials(),errorMessage,"Error message for invalid username and password is not displayed.");
    }
}
