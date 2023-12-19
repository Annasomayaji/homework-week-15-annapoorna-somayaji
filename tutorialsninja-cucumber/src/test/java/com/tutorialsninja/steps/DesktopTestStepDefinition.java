package com.tutorialsninja.steps;

import com.tutorialsninja.browserfactory.ManageBrowser;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.pages.desktops_and_products.DesktopsPage;
import com.tutorialsninja.pages.desktops_and_products.DesktopsProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopTestStepDefinition {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    public List<String> selectProductsBeforeFilter() {

        //Create an array and store all products before sorting and sort them using Collections sort method
        List<WebElement> productsBeforeFilterList = new DesktopsPage().getFilteredProductList();
        ArrayList<String> productsBeforeFilter = new ArrayList<>();
        for (WebElement product : productsBeforeFilterList) {
            productsBeforeFilter.add(product.getText());
        }
        Collections.sort(productsBeforeFilter, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(productsBeforeFilter);
        return productsBeforeFilter;
    }

    @And("User selects sort by position {string}")
    public void userSelectsSortByPosition(String sortByOption) {
        //        1.3 Select Sort By position "Name: Z to A"
        log.info("Selecting option from 'Sort By' drop down....");
        new DesktopsPage().selectSortByName(sortByOption);
    }

    public List<String> selectProductsAfterFilter() {

        //Create an array and store all products before sorting and sort them using Collections sort method
        List<WebElement> productsAfterFilterList = new DesktopsPage().getFilteredProductList();
        ArrayList<String> productsAfterFilter = new ArrayList<>();
        for (WebElement product : productsAfterFilterList) {
            productsAfterFilter.add(product.getText());
        }
        Collections.sort(productsAfterFilter, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(productsAfterFilter);
        return productsAfterFilter;
    }

    @Then("User can view products displayed in alphabetical order.")
    public void userCanViewProductsDisplayedInAlphabeticalOrder() {
        log.info("Verifying the order of products displayed....");
        Assert.assertEquals(selectProductsBeforeFilter(), selectProductsAfterFilter(), "The products are not displayed in alphabetical order.");

    }

    @When("User mouse hovers and clicks {string} tab and clicks")
    public void userMouseHoversAndClicksTabAndClicks(String menuTab) {
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

    @And("User select {string}")
    public void userSelect(String dropDownOption) {

        log.info("Selecting '" + dropDownOption + "' from drop down....");
        // System.out.println("Selecting: " + dropDownOption);
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

    @And("User selects {string} from currency drop down")
    public void userSelectsFromCurrencyDropDown(String currency) {
        log.info("Selecting currency from drop down....");
        new HomePage().moveMouseAndClickOnCurrencyDropDown();
        List<WebElement> allCurrencies = new HomePage().getCurrencyListFromDropDown();
        for (WebElement element : allCurrencies) {
            if (element.getText().equalsIgnoreCase(currency)) {
                element.click();
                break;
            }
        }

    }

    @And("User selects {string} from product list")
    public void userSelectsFromProductList(String product) {
        log.info("Selecting the required product from the resulting products....");
        List<WebElement> allProducts = new DesktopsPage().getAllProducts();
        for (WebElement element : allProducts) {
            if (element.getText().equalsIgnoreCase(product)) {
                System.out.println("Matching product: " + element.getText());//debug purpose
                element.click();
                break;
            }
        }
    }

    @Then("User can view {string} text")
    public void userCanViewText(String product) {
        log.info("Verifying the product name in the heading....");
        Assert.assertEquals(new DesktopsProductsPage().getProductNameHeadingText(), product, "The product displayed is not correct.");
    }


    @And("User selects {string} from Quantity")
    public void userSelectsFromQuantity(String quantity) {
        log.info("Entering quantity....");
        new DesktopsProductsPage().enterQuantity(quantity);
    }


    @And("User clicks on Add to cart button")
    public void userClicksOnAddToCartButton() {
        log.info("Clicking on add to cart button....");
        new DesktopsProductsPage().clickOnAddToCartButton();
    }


    @Then("User can view {string} message")
    public void userCanViewMessage(String successMessage) {
        log.info("Verifying 'Add to cart success' message....");
        Assert.assertTrue(new DesktopsProductsPage().getProductAddedSuccessMessageText().contains(successMessage), "Product not added.");
    }

    @And("User clicks on {string} link into success message")
    public void userClicksOnLinkIntoSuccessMessage(String shoppingCartLink) {
        log.info("Clicking on 'Shopping cart' link in success message....");
        new DesktopsProductsPage().clickOnShoppingCartLinkInSuccessMessage();
    }

    @Then("User can view {string} ,{string},{string},{string}")
    public void userCanView(String shoppingCartHeading, String productName, String model, String price) {
        log.info("Verifying product details in the cart....");
        Assert.assertTrue(new ShoppingCartPage().getShoppingCartHeadingText().contains(shoppingCartHeading), "Navigated to wrong page.");
        Assert.assertEquals(new ShoppingCartPage().getProductNameText(), productName, "Wrong product in the cart.");
        Assert.assertEquals(new ShoppingCartPage().getModelNameText(), model, "Wrong model in the cart");
        Assert.assertEquals(new ShoppingCartPage().getTotalText(), price, "Total is wrong.");
    }


}
