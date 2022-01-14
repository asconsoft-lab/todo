package utils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertionUtils {

    public static void assertText(WebElement element, String text) {
        Assert.assertEquals(element.getText(), text);
    }

    public static void assertElementPresent(WebElement element) {
        Assert.assertTrue(element.isDisplayed() && element.isEnabled());
    }

}
