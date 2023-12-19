package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.browserfactory.ManageBrowser;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class RegisterStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @And("navigates to register page")
    public void navigatesToRegisterPage() {
        log.info("Navigating to register page...");
        new HomePage().clickOnRegisterLink();
    }


    @Then("User can view {string} text")
    public void userCanViewText(String registerText) {
        log.info("Checking for 'Register' text....");
        Assert.assertEquals(new RegisterPage().getRegisterTitleText(), registerText, "The register title is not displayed.");
    }

    @When("User clicks on register button")
    public void userClicksOnRegisterButton() {
        log.info("Clicking on register button....");
        new RegisterPage().clickOnRegisterButton();
    }

    @Then("User can view error messages for mandatory fields")
    public void userCanViewErrorMessagesForMandatoryFields(DataTable dataTable) {

        log.info("Comparing error messages....");
//        create an array list to store all the actual error messages
        List<String> actualErrorMessages = new ArrayList<>();
        actualErrorMessages.add(new RegisterPage().getFirstNameErrorText());
        actualErrorMessages.add(new RegisterPage().getLastNameErrorText());
        actualErrorMessages.add(new RegisterPage().getEmailErrorText());
        actualErrorMessages.add(new RegisterPage().getPasswordErrorText());
        actualErrorMessages.add(new RegisterPage().getConfirmPasswordErrorText());

        //obtain the expected error message from data table and compare with actual using assert class
        List<String> errorMessageList = dataTable.asList(String.class);
        int index = 0;
        for (String message : errorMessageList) {
            Assert.assertEquals(actualErrorMessages.get(index), message, "Error message '" + message + "' is not displayed.");
            index++;
        }

    }


    @And("User enters email")
    public void userEntersEmail() {
        log.info("Entering email.... ");
        String email = new RegisterPage().getRandomEmail();
        new RegisterPage().enterEmail(email);
    }


    @And("User selects gender {string}")
    public void userSelectsGender(String gender) {
        log.info("Selecting gender....");
        new RegisterPage().clickOnFemaleRadioButton();
    }

    @And("User enters first name {string}")
    public void userEntersFirstName(String firstname) {
        log.info("Entering firstname....");
        new RegisterPage().enterFirstName(firstname);

    }

    @And("User enters last name {string}")
    public void userEntersLastName(String lastname) {
        log.info("Entering lastname....");
        new RegisterPage().enterLastName(lastname);
    }

    @And("User selects date {string}")
    public void userSelectsDate(String date) {
        log.info("Selecting date from drop down....");
        new RegisterPage().selectDateOfBirthDateFromDropDown(date);
    }

    @And("User selects month {string}")
    public void userSelectsMonth(String month) {
        log.info("Selecting month from drop down....");
        new RegisterPage().selectDateOfBirthMonthFromDropDown(month);
    }

    @And("User selects year {string}")
    public void userSelectsYear(String year) {
        log.info("Selecting year from drop down....");
        new RegisterPage().selectDateOfBirthYearFromDropDown(year);
    }

    @And("User enters password to register {string}")
    public void userEntersPasswordToRegister(String password) {
        log.info("Entering password....");
        new RegisterPage().enterPassword(password);
    }

    @And("User enters confirm password {string}")
    public void userEntersConfirmPassword(String confirmPassword) {
        log.info("Entering confirm password.....");
        new RegisterPage().enterConfirmPassword(confirmPassword);
    }

    @Then("USer should see the {string} message")
    public void userShouldSeeTheMessage(String successMessage) {
        log.info("Verifying the registration success message....");
        Assert.assertEquals(new RegisterPage().getRegistrationSuccessMessageText(), successMessage, "Registration is not successful.");
    }

    @And("enters all the details and registers")
    public void entersAllTheDetailsAndRegisters(DataTable dataTable) {
        log.info("Entering registration details and clicking on 'Register' button....");
        List<String> registrationDetails = dataTable.asList(String.class);
        new RegisterPage().clickOnFemaleRadioButton();
        new RegisterPage().enterFirstName(registrationDetails.get(0));
        new RegisterPage().enterLastName(registrationDetails.get(1));
        new RegisterPage().selectDateOfBirthDateFromDropDown(registrationDetails.get(2));
        new RegisterPage().selectDateOfBirthMonthFromDropDown(registrationDetails.get(3));
        new RegisterPage().selectDateOfBirthYearFromDropDown(registrationDetails.get(4));
        new RegisterPage().enterEmail(new RegisterPage().getRandomEmail());
        new RegisterPage().enterPassword(registrationDetails.get(5));
        new RegisterPage().enterConfirmPassword(registrationDetails.get(6));
        new RegisterPage().clickOnRegisterButton();
        new RegisterPage().getRegistrationSuccessMessageText();

    }


}
