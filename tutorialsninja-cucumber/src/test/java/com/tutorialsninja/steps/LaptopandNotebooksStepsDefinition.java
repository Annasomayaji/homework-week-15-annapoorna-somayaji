package com.tutorialsninja.steps;

import com.tutorialsninja.browserfactory.ManageBrowser;
import com.tutorialsninja.pages.CheckOutPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.pages.laptops_notebooks_and_products.LapTopsAndNoteBooksPage;
import com.tutorialsninja.pages.laptops_notebooks_and_products.MacBookPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopandNotebooksStepsDefinition {

    private static final Logger log = Logger.getLogger(ManageBrowser.class);

    public List<Double> selectProductsBeforeFilter() {

        //Store elements in an array and use Collections sort method before filter
        List<WebElement> beforeFilterPrice = new LapTopsAndNoteBooksPage().getFilteredProductList();
        List<Double> beforeFilterPriceList = new ArrayList<>();
        String[] priceArray;
        //Split element to exclude child element text, replace $ symbol and ,(comma) with "", covert into double
        for (WebElement p : beforeFilterPrice) {
            priceArray = p.getText().split("\n");
            System.out.println(priceArray[0]); //for debug purpose
            String number = priceArray[0].replace("$", "");
            String num = number.replace(",", "");
            beforeFilterPriceList.add(Double.valueOf(num));
        }

        Collections.sort(beforeFilterPriceList);
        Collections.reverse(beforeFilterPriceList);
        return beforeFilterPriceList;
    }


    @And("User selects sort by position {string} from laptops and notebooks page")
    public void userSelectsSortByPositionFromLaptopsAndNotebooksPage(String sortByOption) {
        log.info("Selecting 'Sort By' filter option....");
        new LapTopsAndNoteBooksPage().selectFromSortByFilter(sortByOption);

    }


    public List<Double> selectProductsAfterFilter() {
        List<WebElement> afterFilterPrice = new LapTopsAndNoteBooksPage().getFilteredProductList();
        ArrayList<Double> afterFilterPriceList = new ArrayList<>();

        String[] priceArrayAfterFilter;
        //Split element to exclude child element text, replace $ symbol and ,(comma) with "", covert into double
        for (WebElement p : afterFilterPrice) {
            // System.out.println(p);
            priceArrayAfterFilter = p.getText().split("\n");
            System.out.println(priceArrayAfterFilter[0]);//for debug purpose
            String number = priceArrayAfterFilter[0].replace("$", "");
            String num = number.replace(",", "");
            afterFilterPriceList.add(Double.valueOf(num));

        }
        return afterFilterPriceList;
    }


    @Then("User can view products in the descending order of price")
    public void userCanViewProductsInTheDescendingOrderOfPrice() {
        log.info("Verifying the order of products result....");
        Assert.assertEquals(selectProductsBeforeFilter(), selectProductsAfterFilter(), "Products are not displayed in price order.");
    }

    @And("User selects the product {string}")
    public void userSelectsTheProduct(String productName) {
        log.info("Selecting a product from the filtered result....");
        new LapTopsAndNoteBooksPage().clickOnMacBook();
    }


    @Then("User can view {string} text in the product page heading")
    public void userCanViewTextInTheProductPageHeading(String headingText) {
        log.info("Verifying the product page heading....");
        Assert.assertEquals(new MacBookPage().getMacBookHeadingText(), headingText, "Navigated to wrong product page....");
    }

    @And("User clicks on Add To Cart button")
    public void userClicksOnAddToCartButton() {
        log.info("Clicking on 'Add to cart' button....");
        new MacBookPage().clickOnAddToCartButton();
    }

    @Then("User can view {string}")
    public void userCanView(String addToCartSuccessMessage) {
        log.info("Verifying add to cart success message....");
        Assert.assertTrue(new MacBookPage().getSuccessMessageText().contains(addToCartSuccessMessage), "The product is not added to cart successfully.");
    }

    @Then("User can view {string} in page heading and {string} in product name")
    public void userCanViewInPageHeadingAndInProductName(String shoppingCartHeading, String productName) {
        log.info("Verifying shopping cart heading text and product name in the cart....");
        Assert.assertTrue(new ShoppingCartPage().getShoppingCartHeadingText().contains(shoppingCartHeading), "Navigated to wrong page.");
        Assert.assertEquals(new ShoppingCartPage().getProductNameText(), productName, "Wrong product name displayed in cart.");
    }

    @And("User updates quantity to {string}")
    public void userUpdatesQuantityTo(String quantity) {
        log.info("Updating quantity....");
        new ShoppingCartPage().updateQuantity(quantity);
    }

    @And("User clicks on update tab")
    public void userClicksOnUpdateTab() {
        log.info("Updating the shopping cart....");
        new ShoppingCartPage().clickOnUpdateTab();
    }

    @Then("User can view {string}, {string} in the cart.")
    public void userCanViewInTheCart(String updateSuccessMessage, String totalPrice) {
        Assert.assertTrue(new ShoppingCartPage().getUpdateSuccessMessageText().contains(updateSuccessMessage), "Cart is not updated.");
        Assert.assertEquals(new ShoppingCartPage().getTotalText(), totalPrice, "Total is wrong");
    }


    @And("User clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        log.info(("Clicking on checkout button...."));
        new ShoppingCartPage().clickOnCheckOutButton();
    }

    @Then("User can view {string} text in the page heading")
    public void userCanViewTextInThePageHeading(String checkoutPageHeading) {
        log.info("Verifying 'Checkout' page heading....");
        Assert.assertEquals(new CheckOutPage().getCheckOutHeadingText(), checkoutPageHeading, "User is not navigated to 'Checkout' page.");
    }

    @And("User can view {string} check out option")
    public void userCanViewCheckOutOption(String newCustomerOption) {
        log.info("Verifying 'New Customer' checkout option....");
        Assert.assertEquals(new CheckOutPage().getNewCustomerHeadingText(), newCustomerOption, "'New Customer' option is not displayed.");
    }


    @Then("User can view {string} for payment required")
    public void userCanViewForPaymentRequired(String paymentRequiredWarning) {
        Assert.assertEquals(new CheckOutPage().getWarningMessageText(),paymentRequiredWarning,"No warning message displayed.");
    }

    @And("User checks out using {string} radio button")
    public void userChecksOutUsingRadioButton(String checkOutOption) {
        log.info("Checking out as Guest....");
        new CheckOutPage().clickOnRadioButton(checkOutOption);
        new CheckOutPage().clickOnContinueButton();

    }

    @And("enter following details for checkout")
    public void enterFollowingDetailsForCheckout(DataTable dataTable) {

        log.info("Entering details....");

        List<String> userDetails = dataTable.asList(String.class);
        new CheckOutPage().enterFirstName(userDetails.get(0));
        new CheckOutPage().enterLastName(userDetails.get(1));
        new CheckOutPage().enterEmail(userDetails.get(2));
        new CheckOutPage().enterPhone(userDetails.get(3));
        new CheckOutPage().enterAddress(userDetails.get(4));
        new CheckOutPage().enterCity(userDetails.get(5));
        new CheckOutPage().enterPostCode(userDetails.get(6));
        new CheckOutPage().selectCountryFromDropDown(userDetails.get(7));
        new CheckOutPage().selectRegionOrStateFromDropDown(userDetails.get(8));
        new CheckOutPage().clickOnContinueButtonInPaymentMethod();
        new CheckOutPage().enterCommentsAboutOrder(userDetails.get(9));
        new CheckOutPage().clickOnTermsAndConditionsCheckBox();
        new CheckOutPage().clickOnContinueButtonInPaymentMethod();

    }
}
