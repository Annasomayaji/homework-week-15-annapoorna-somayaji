package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComponentsPage extends Utility {

    //Elements
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h2")
    WebElement componentsPageTitle;


    //Methods
    public String getComponentsTitleText() {
        return getTextFromElement(componentsPageTitle);
    }
}
