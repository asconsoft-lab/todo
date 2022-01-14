package com.asconsoft.gintaa.pages;

import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage extends PageBase {

    @ByAngularPartialButtonText.FindBy(partialButtonText = "Login")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@name='userInfo']")
    private WebElement loginUserInfo;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "save & next")
    private WebElement saveNNext;

    @FindBy(xpath = "//ng-otp-input/div/input[1]")
    private WebElement loginOtpInput;

    @FindBy(xpath = "//a[@href='/profile/edit']")
    private WebElement editButton;

    @FindBy(xpath = "//mat-radio-button[@value='Female']")
    private WebElement genderButton;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "add new address")
    private WebElement saveNewAddress;

    @FindBy(xpath = "//*[text()=' gps_fixed ']")
    private WebElement inputAddress;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "Next")
    private WebElement addNextButton;

    public LoginPage(WebDriver driver, NgWebDriver ngDriver) {
        super(driver, ngDriver);
        PageFactory.initElements(driver, this);
    }
}
