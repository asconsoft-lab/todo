package com.asconsoft.gintaa.base;

import com.asconsoft.gintaa.Constants;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    protected static WebDriver driver;
    protected static NgWebDriver ngDriver;
    protected static Properties prop;

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/resources/application.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialize() {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--window-size=1200,600");
        //options.addArguments("--remote-debugging-port=9222");
        options.addArguments("user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36");
        //options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36");
		options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);

        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        ngDriver = new NgWebDriver(jsDriver);
        ngDriver.waitForAngularRequestsToFinish();

        //driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));

        //Opening Gintaa Website
        System.out.println("------Opening gintaa site------");
        driver.get(prop.getProperty("gintaa.website"));
    }
}
