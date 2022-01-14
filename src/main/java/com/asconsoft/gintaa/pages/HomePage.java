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
public class HomePage extends PageBase {

    @FindBy(xpath = "//*[@id=\"navbarsExampleDefault\"]/div[3]/div[1]/div/a/div/h2")
    private WebElement loggedInUserName;

    @FindBy(xpath = "//a[@data-toggle='dropdown']")
    private WebElement userIcon;

    @FindBy(xpath = "//a[text()='My account']")
    private WebElement myAccount;

    @FindBy(css = ".create_float_listing")
    private WebElement createListingButton;
    
    @FindBy(xpath = "//h3[contains(text(),'As individual')]")
    private WebElement asIndividualButton;

    @FindBy(xpath = "//app-webhome-recent-offers//owl-stage/div/div/div[1]/app-offer-card-default/div/div[1]/div[1]/img")
    private WebElement recentListingElement; //here it will click on the first element of recently listed items

    @FindBy(xpath = "//h1[contains(text(),'Offers')]")
    private WebElement offerButton;

    public HomePage(WebDriver driver, NgWebDriver ngDriver) {
        super(driver, ngDriver);
        PageFactory.initElements(driver, this);
    }
}
