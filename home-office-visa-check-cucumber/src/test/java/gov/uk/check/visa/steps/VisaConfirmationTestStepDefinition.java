package gov.uk.check.visa.steps;

import gov.uk.check.visa.browserfactory.ManageBrowser;
import gov.uk.check.visa.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class VisaConfirmationTestStepDefinition {

    private static final Logger log= LogManager.getLogger(ManageBrowser.class);

    @Given("User has navigate to homepage")
    public void userHasNavigateToHomepage() {
    }

    @When("User clicks on start button")
    public void userClicksOnStartButton() {
        log.info("Clicking on start button....");
        new StartPage().clickOnStartNowButton();
    }

    @And("User selects {string}, {string}")
    public void userSelects(String nationality, String reason) {
        log.info("Selecting Nationality and Reason for visit....");
        new SelectNationalityPage().selectNationalityFromDropDown(nationality);
        new SelectNationalityPage().clickOnContinueButton();
        new ReasonForTravelPage().selectReasonForVisit(reason);
        new ReasonForTravelPage().clickOnContinueButton();
    }

    @Then("User can view visa requirement in {string}")
    public void userCanViewVisaRequirementIn(String requirementMessage) {
        log.info("Verifying visa requirement result....");
        new ResultPage().confirmResultMessage(requirementMessage);
    }

    @And("User selects intended stay for {string}")
    public void userSelectsIntendedStayFor(String duration) {
        log.info("Selecting duration of stay....");
        new DurationOfStayPage().selectDurationRadioButton(duration);
        new DurationOfStayPage().clickOnContinueButton();
    }

    @And("User selects {string} for work type")
    public void userSelectsForWorkType(String workType) {
        log.info("Selecting work type....");
        new WorkTypePage().selectJobType(workType);
        new WorkTypePage().clickOnContinueButton();
    }
}
