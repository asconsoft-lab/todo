package com.asconsoft.gintaa.pages;

import com.paulhammant.ngwebdriver.NgWebDriver;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import org.openqa.selenium.WebElement;

@Getter
public class OfferPage extends PageBase {

    @ByAngularPartialButtonText.FindBy(partialButtonText = "suggest an")
    private WebElement suggestAnOffer;

    public OfferPage(WebDriver driver, NgWebDriver ngDriver) {
        super(driver, ngDriver);
        PageFactory.initElements(driver, this);
    }
}