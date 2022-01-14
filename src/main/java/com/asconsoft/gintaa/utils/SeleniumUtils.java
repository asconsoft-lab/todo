package com.asconsoft.gintaa.utils;

import com.asconsoft.gintaa.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils  {

    private static WebElement waitForCondition(WebDriver driver, ExpectedCondition<WebElement> condition) {
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)).until(condition);
    }
    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        return waitForCondition(driver, ExpectedConditions.elementToBeClickable(element));
    }

}
