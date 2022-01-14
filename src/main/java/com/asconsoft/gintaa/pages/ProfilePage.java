package com.asconsoft.gintaa.pages;

import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ProfilePage extends PageBase {

    @ByAngularPartialButtonText.FindBy(partialButtonText = "add new address")
    private WebElement addNewAddressButton;

    public ProfilePage(WebDriver driver, NgWebDriver ngDriver) {
        super(driver, ngDriver);
        PageFactory.initElements(driver, this);
    }
}
