package com.tutorialsninja.steps;

import com.tutorialsninja.browserfactory.ManageBrowser;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.desktops_and_products.DesktopsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TopMemuTestStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @Given("User navigates to homepage")
    public void userNavigatesToHomepage() {  //the home page opens from Hooks class
        log.info("Opening homepage....");
    }

    @When("User mouse hovers and clicks on {string} tab and clicks")
    public void userMouseHoversAndClicksOnTabAndClicks(String menuTab) {
        log.info("Clicking on " + menuTab + " tab on top menu....");
        switch (menuTab) {
            case "Desktops":
                new HomePage().mouseHoverAndClickOnDesktops();
                break;
            case "Laptops & Notebooks":
                new HomePage().mouseHoverAndClickOnLapTopsAndNoteBooks();
                break;
            case "Components":
                new HomePage().moveMouseAndClickOnComponents();
                break;
        }

    }

    @And("User selects {string}")
    public void userSelects(String dropDownOption) {
        log.info("Selecting '" + dropDownOption + "' from drop down....");
                System.out.println("Selecting: " + dropDownOption);
        List<WebElement> allOptions = new HomePage().showAllOptionsFromTopNav();
        try {
            for (WebElement e : allOptions) {
                if (e.getText().equals(dropDownOption)) {
                    e.click();
                }
            }
        } catch (StaleElementReferenceException e) {

        }
    }


    @Then("User can see {string} text in the page")
    public void userCanSeeTextInThePage(String pageHeading) {
        log.info("Verifying page title on Desktops page....");
        Assert.assertEquals(new DesktopsPage().getDeskTopTitleText(), pageHeading, "The user is navigated to incorrect page.");
    }


}
