package com.asconsoft.gintaa;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppUITest {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static void init() throws IOException {
		
		//System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome-driver/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("window-size=1200x600");
		options.addArguments("--no-sandbox");
		WebDriver webDriver = new ChromeDriver(options);
		
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/application.properties");
		prop.load(fis);
		fis.close();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		
		init();
		
		//Opening Website
		driver.navigate().to(prop.getProperty("gintaa.website"));
		//Maximizing Window
		driver.manage().window().maximize();
		
		driver.findElement(By.id("identifierId")).sendKeys(prop.getProperty("gmail.account"));
		driver.findElement(By.xpath("//*[@id='identifierNext']/div/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(prop.getProperty("gmail.password"));
		driver.findElement(By.xpath("//*[@id='passwordNext']/div/button")).click();

		driver.findElement(By.xpath("//*[@id='navbarsExampleDefault']/div[3]/form/div/button/h2")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='userInfo']")).sendKeys("7878787878\n");
		Thread.sleep(120000);
		driver.findElement(By.xpath("//ng-otp-input[@class='ng-tns-c69-7']/div/input[1]")).sendKeys("787878\n");
		
	}

}
