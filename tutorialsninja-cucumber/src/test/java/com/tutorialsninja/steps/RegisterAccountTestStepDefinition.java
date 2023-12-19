package com.tutorialsninja.steps;

import com.tutorialsninja.browserfactory.ManageBrowser;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.account.AccountPage;
import com.tutorialsninja.pages.account.LoginPage;
import com.tutorialsninja.pages.account.LogoutPage;
import com.tutorialsninja.pages.account.ReturningCustomerPage;
import com.tutorialsninja.pages.register_and_registersuccess.RegisterPage;
import com.tutorialsninja.pages.register_and_registersuccess.RegisterSuccessPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class RegisterAccountTestStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @When("User clicks on My Account link")
    public void userClicksOnMyAccountLink() {
        log.info("Clicking on 'My Account' link....");
        new HomePage().clickOnMyAccountLink();
    }

    @And("User selects {string} from the drop down")
    public void userSelectsFromTheDropDown(String dropDownOption) {
        log.info("Selecting from drop down option....");
        List<WebElement> allMyAccountOptions = new HomePage().getMyAccountOptions();
        for (WebElement e : allMyAccountOptions) {
            System.out.println("Options in dropdown: " + e.getText());//Debug purpose
            if (e.getText().equalsIgnoreCase(dropDownOption)) {
                e.click();
                break;
            }
        }

    }

    @Then("User should be able to view {string} heading in the navigated page")
    public void userShouldBeAbleToViewHeadingInTheNavigatedPage(String pageHeading) {
        log.info("Verifying the page heading....");
        Assert.assertEquals(new RegisterPage().getRegisterPageHeadingText(), pageHeading, "Navigated to wrong page.");
    }

    @Then("User should be able to view {string} sub heading in the navigated page")
    public void userShouldBeAbleToViewSubHeadingInTheNavigatedPage(String pageSubHeading) {
        log.info("Verifying the page  sub heading....");
        Assert.assertEquals(new LoginPage().getReturningCustomerHeadingText(), pageSubHeading, "Navigated to wrong page.");
    }

    @And("User enters the following details in the register account page and submits")
    public void userEntersTheFollowingDetailsInTheRegisterAccountPageAndSubmits(DataTable dataTable) {
        log.info("Entering registration details....");
        List<String> userAccountDetails = dataTable.asList(String.class);
        new RegisterPage().enterFirstName(userAccountDetails.get(0));
        new RegisterPage().enterLastName(userAccountDetails.get(1));
        String randomEmail = new RegisterPage().getRandomString() + "annu@gmail.com";
        new RegisterPage().enterEmail(randomEmail);
        new RegisterPage().enterPhone(userAccountDetails.get(2));
        new RegisterPage().enterPassword(userAccountDetails.get(3));
        new RegisterPage().enterConfirmPassword(userAccountDetails.get(4));
        new RegisterPage().clickOnNewsLetterRadioButton(userAccountDetails.get(5));
        new RegisterPage().clickOnPrivacyPolicyCheckBox();
        log.info("Clicking on continue button....");
        new RegisterPage().clickOnContinueButton();
    }

    @Then("User can view {string} message in Account Success page")
    public void userCanViewMessageInAccountSuccessPage(String accountCreatedSuccessMessage) {
        log.info("Verifying 'account created' message....");
        Assert.assertEquals(new RegisterSuccessPage().getRegisterSuccessMessageText(), accountCreatedSuccessMessage, "Account is not created successfully.");
    }

    @And("User clicks on Continue button on account Register Success page")
    public void userClicksOnContinueButtonOnAccountRegisterSuccessPage() {
        log.info("Clickin on Continue button in Register Success page....");
        new RegisterSuccessPage().clickOnContinueButton();
    }

    @Then("User can view {string} text in the heading")
    public void userCanViewTextInTheHeading(String logoutHeading) {
        log.info("Verifying logout heading....");
        Assert.assertEquals(new LogoutPage().getLogOutHeadingText(), logoutHeading, "User is navigated to wrong page.");
    }

    @And("User logs in with the following credentials")
    public void userLogsInWithTheFollowingCredentials(DataTable dataTable) {
        log.info("Logging into account....");
        List<String> loginCredentials = dataTable.asList(String.class);
        new ReturningCustomerPage().enterEmail(loginCredentials.get(0));
        new ReturningCustomerPage().enterPassword(loginCredentials.get(1));
        new ReturningCustomerPage().clickOnLoginButton();
    }

    @Then("User is able to view {string} text")
    public void userIsAbleToViewText(String accountHeading) {
        log.info("Verifying page heading after log in....");
        Assert.assertEquals(new AccountPage().getMyAccountHeadingText(), accountHeading, "User is not logged in.");
    }

    @And("User selects {string} from My Account")
    public void userSelectsFromMyAccount(String accountOption) {
        log.info("Selecting drop down option from My Account....");
        new HomePage().clickOnMyAccountLink();

    }

    @Then("User is able to view {string} heading")
    public void userIsAbleToViewHeading(String accountLogoutText) {
        log.info("Verifying Account Logout text....");
        Assert.assertEquals(new LogoutPage().getLogOutHeadingText(), accountLogoutText, "The logout is not successful.");
        new LogoutPage().clickOnContinueButton();
    }
}
