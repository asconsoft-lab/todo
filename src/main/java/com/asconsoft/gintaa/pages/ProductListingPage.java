package com.asconsoft.gintaa.pages;

import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ProductListingPage extends PageBase {

    @FindBy(xpath = "//h2[contains(text(),'cover photo ')]/parent::div/preceding-sibling::div/input")
    private WebElement uploadCoverImage;

    @FindBy(xpath = "//input[@placeholder='Category']")
    private WebElement category;

    @FindBy(xpath = "//input[@placeholder='Category']/parent::div/div[2]/div/div[3]/div/div/div/div[1]/h3")
    private WebElement firstSuggestedCategory;

    @FindBy(xpath = "//mat-radio-button[@id='Money']")
    private WebElement money;

    @FindBy(xpath = "//input[@formcontrolname='unitOfferValuation']")
    private WebElement productPrice;

    @FindBy(xpath = "//input[@formcontrolname='quantity']")
    private WebElement quantity;

    @FindBy(xpath = "//input[@formcontrolname='price']")
    private WebElement sellingPrice;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "New")
    private WebElement conditionNew;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "next")
    private WebElement nextButton;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "add features")
    private WebElement addFeatures;

    @FindBy(xpath = "//input[@placeholder='Enter feature name']")
    private WebElement featureName;

    @FindBy(xpath = "//input[@placeholder='Enter feature value']")
    private WebElement featureValue;

    @ByAngularButtonText.FindBy(buttonText = "add")
    private WebElement addFeatureButton;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "submit")
    private WebElement submitButton;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "suggest an")
    private WebElement suggestAnOfferButton;

    public ProductListingPage(WebDriver driver, NgWebDriver ngDriver) {
        super(driver, ngDriver);
        PageFactory.initElements(driver, this);
    }
}
