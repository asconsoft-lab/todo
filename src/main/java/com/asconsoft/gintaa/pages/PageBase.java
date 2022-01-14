package com.asconsoft.gintaa.pages;

import com.asconsoft.gintaa.Constants;
import com.asconsoft.gintaa.utils.SeleniumUtils;
import com.paulhammant.ngwebdriver.NgWebDriver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
@Getter
public abstract class PageBase {

    private WebDriver driver;
    private NgWebDriver ngDriver;

    public void clickButton(WebElement element) throws InterruptedException {
        WebElement elementToUse = SeleniumUtils.waitForElementToBeClickable(driver, element);
        ElementClickInterceptedException ex = new ElementClickInterceptedException("");
        int i;
        for(i = 0 ; i < Constants.ELEMENT_CLICK_INTERCEPTED_RETRY_COUNT; i++) {
            try {
                elementToUse.click();
                break;
            } catch(ElementClickInterceptedException e) {
                ex = e;
                Thread.sleep(2000);
            }
        }
        if(i == Constants.ELEMENT_CLICK_INTERCEPTED_RETRY_COUNT) {
            throw new ElementClickInterceptedException(ex.getMessage());
        }
    }

    public void sendKeys(WebElement element, String text) throws InterruptedException {
        WebElement elementToUse = SeleniumUtils.waitForElementToBeClickable(driver, element);
        ElementClickInterceptedException ex = new ElementClickInterceptedException("");
        int i;
        for(i = 0 ; i < Constants.ELEMENT_CLICK_INTERCEPTED_RETRY_COUNT; i++) {
            try {
                elementToUse.sendKeys(text);
                break;
            } catch (ElementClickInterceptedException e) {
                ex = e;
                Thread.sleep(2000);
            }
        }
        if(i == Constants.ELEMENT_CLICK_INTERCEPTED_RETRY_COUNT) {
            throw new ElementClickInterceptedException(ex.getMessage());
        }
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

}
