package com.asconsoft.gintaa.pages;

import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MyOffersPage extends PageBase {

    @FindBy(xpath = "//app-my-deal-list/div[2]/div/div[1]//h2/span")
    private WebElement offerState;

    public MyOffersPage(WebDriver driver, NgWebDriver ngDriver) {
        super(driver, ngDriver);
        PageFactory.initElements(driver, this);
    }
}