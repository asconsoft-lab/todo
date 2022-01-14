package com.asconsoft.gintaa.pages;
import org.openqa.selenium.By;
import com.asconsoft.gintaa.base.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.AssertionUtils;
import java.io.File;

public class TestSuite extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ProductListingPage productListingPage;
    OfferPage offerPage;
    MyOffersPage myOffersPage;

    public TestSuite(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {

        initialize();

        loginPage = new LoginPage(driver, ngDriver);
        homePage = new HomePage(driver, ngDriver);
        productListingPage = new ProductListingPage(driver, ngDriver);
        offerPage = new OfferPage(driver, ngDriver);
        myOffersPage = new MyOffersPage(driver, ngDriver);

        //Google Authentication
        System.out.println("------Google Auth Page Opened, Signing in------");
        Thread.sleep(100);
        driver.findElement(By.id("identifierId")).sendKeys(prop.getProperty("gmail.account"));
        Thread.sleep(100);
        driver.findElement(By.xpath("//*[@id='identifierNext']/div/button")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(prop.getProperty("gmail.password"));
        driver.findElement(By.xpath("//*[@id='passwordNext']/div/button")).click();

        System.out.println("------Google Auth Success------");

    }

    public void login(String userId, String password) throws InterruptedException {
        System.out.println("------Starting Gintaa Login------");
        loginPage.clickButton(loginPage.getLoginButton());
        loginPage.sendKeys(loginPage.getLoginUserInfo(), userId + "\n");
        Thread.sleep(50000); //wait for captcha
        loginPage.sendKeys(loginPage.getLoginOtpInput(), password + "\n");
        System.out.println("------Gintaa Login Success------");
    }

    @Test(enabled = false, priority = 0)
    public void myProfileTest() throws InterruptedException {

        login("7878787878", "123653");

        AssertionUtils.assertText(homePage.getLoggedInUserName(), "Automation");

        loginPage.sendKeys(homePage.getUserIcon(), Keys.ENTER.toString());
        Thread.sleep(4000);
        loginPage.clickButton(homePage.getMyAccount());
        Thread.sleep(4000);

    }

    @Test(priority = 1)
    public void createListing() throws InterruptedException {

        File file = new File("src/main/resources/images/UploadImage.png");
        login("7878787878", "123653");
        System.out.println("------Pressing Create Listing------");
        homePage.clickButton(homePage.getCreateListingButton());
        homePage.clickButton(homePage.getAsIndividualButton());
        System.out.println("------Opened Create Listing------");
        System.out.println(System.getProperty("user.dir"));
        System.out.println("------Uploading Listing Picture------");
        Thread.sleep(4000); // wait for uploading picture manually
        //productListingPage.getUploadCoverImage().sendKeys("./src/main/resources/images/UploadImage.png");
        productListingPage.getUploadCoverImage().sendKeys(file.getAbsolutePath());
        Thread.sleep(10000);
        System.out.println("------Picture Uploaded------");
        productListingPage.clickButton(productListingPage.getCategory());
        productListingPage.clickButton(productListingPage.getFirstSuggestedCategory());
        productListingPage.clickButton(productListingPage.getMoney());
        productListingPage.sendKeys(productListingPage.getProductPrice(), "12000" );
        productListingPage.sendKeys(productListingPage.getQuantity(), "\\b100" );
        productListingPage.sendKeys(productListingPage.getSellingPrice(), "10000");
        productListingPage.clickButton(productListingPage.getConditionNew());
        productListingPage.clickButton(productListingPage.getNextButton());
        productListingPage.clickButton(productListingPage.getAddFeatures());
        productListingPage.sendKeys(productListingPage.getFeatureName(), "XYZ");
        productListingPage.sendKeys(productListingPage.getFeatureValue(), "111");
        productListingPage.clickButton(productListingPage.getAddFeatureButton());
        productListingPage.clickButton(productListingPage.getSubmitButton());
        Thread.sleep(10000);

    }

    @Test(priority = 2)
    public void createOffer() throws InterruptedException {

        login("9898989898", "234567");
        Thread.sleep(10000);
        System.out.println("------Getting Recent Listing------");
        homePage.clickButton(homePage.getRecentListingElement());
        //Thread.sleep(10000);
        productListingPage.clickButton(productListingPage.getSuggestAnOfferButton());
        //Thread.sleep(10000);
        offerPage.clickButton(offerPage.getSuggestAnOffer());
        //Thread.sleep(6000);
        homePage.clickButton(homePage.getOfferButton());
        //Thread.sleep(6000);
        AssertionUtils.assertText(myOffersPage.getOfferState(), "Outgoing");
        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
