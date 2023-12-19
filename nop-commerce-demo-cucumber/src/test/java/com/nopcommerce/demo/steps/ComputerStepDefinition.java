package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.browserfactory.ManageBrowser;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;


public class ComputerStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @And("User clicks on {string} navigation tab")
    public void userClicksOnNavigationTab(String navigationTab) {
        log.info("Clicking on 'Computer' navigation tab....");
        {
            new HomePage().clickOnComputerLink();
        }
    }

    @Then("User should see {string} in page title")
    public void userShouldSeeInPageTitle(String pageTitleText) {
        log.info("Verifying the 'Computer' page title....");
        Assert.assertEquals(new ComputerPage().getComputersPageTitleText(), pageTitleText, "User is not navigated to 'Computer' page.");
    }

    @When("User clicks on {string} tab")
    public void userClicksOnTab(String dropDownOption) {
        log.info("Clicking on computer drop down option....");
        if (dropDownOption.equalsIgnoreCase("Desktops")) {
            new ComputerPage().clickOnDesktopsLink();
        } else if (dropDownOption.equalsIgnoreCase("Notebooks")) {
            //Write here to click on Notebooks drop down
        } else {
            //Write here to click on Software drop down
        }
    }


    @Then("User should see {string} in page title upon navigating")
    public void userShouldSeeInPageTitleUponNavigating(String pageTitleText) {
        log.info("Verifying page title....  ");
        if (pageTitleText.equalsIgnoreCase("Desktops")) {
            Assert.assertEquals(new DesktopsPage().getDesktopPageTitleText(), pageTitleText, "User is not navigated to desktops page.");
        } else if (pageTitleText.equalsIgnoreCase("Notebooks")) {
            //Write here to assert notebooks page title
        } else {
            //Write here to assert Software page title
        }
    }


    @And("User clicks on {string} product name")
    public void userClicksOnProductName(String productName) {
        log.info("Clicking on Build Your Own Computer product....");
        new DesktopsPage().clickOnBuildYourOwnComputer();
    }


    @And("User selects product requirements {string},{string},{string},{string},{string} for Build your own computer")
    public void userSelectsProductRequirementsForBuildYourOwnComputer(String processor, String ram, String hdd, String os, String software) {
        log.info("Selecting product specifications....");
        new BuildYourOwnComputerPage().selectProcessorDropDownByVisibleText(processor);
        new BuildYourOwnComputerPage().selectRamDropDownByVisibleText(ram);
        new BuildYourOwnComputerPage().clickOnHddRadioButton(hdd);
        new BuildYourOwnComputerPage().clickOnOsRadioButton(os);
        new BuildYourOwnComputerPage().selectSoftwareCheckBox(software);
    }

    @And("User clicks on Add to Cart button")
    public void userClicksOnAddToCartButton() {
        log.info("Clicking on add to cart button....");
        new BuildYourOwnComputerPage().clickOnAddToCartButton();
    }

    @Then("User can view success message {string}")
    public void userCanViewSuccessMessage(String addedToCartSuccessMessage) {
        log.info("Verifying added to cart success message....");
        Assert.assertEquals(new BuildYourOwnComputerPage().getProductAddedToCartMessage(),addedToCartSuccessMessage,"Product is not added to cart.");
    }
}
