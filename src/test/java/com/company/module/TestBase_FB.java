package com.company.module;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.company.config.Config;
import com.company.pages.Home;
import com.company.pages.Login;
import com.company.pages.Profile;

public class TestBase_FB {
	
	protected WebDriver driver;
	private String driverPath="src/test/resources/com/company/resources/drivers/";
	private String browser=Config.BROWSER;
	private String homeUrl=Config.URL;
	private Logger logger= Logger.getLogger(TestBase_FB.class);
	
	protected Login login;
	protected Home home;
	protected Profile  profile;
	
	

	
	@BeforeMethod
	public void setUp(){
		getWebDriver(browser);
		navigate(homeUrl);
		
		driver.manage().timeouts().pageLoadTimeout(Config.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		createPageObjects();
		
	}
	

	@AfterMethod
	public void tearDown(){
		try{
			//log out
			driver.quit();
		}
		catch(Throwable t){
			//log files
		}
	}
	
	public void getWebDriver(String br){
		
		if(br.equalsIgnoreCase("ff")){
			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver");
			driver=new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver");
			System.out.println("driver path from chrome driver"+driverPath+"chromedriver");
			driver= new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("safari")){
			driver= new SafariDriver();
		}
		else{
		System.setProperty("webdriver.gecko.driver", driverPath+"chromedriver");
		driver=new ChromeDriver();
		}
	}
	
	public void navigate(String url){
		driver.navigate().to(url);
	}
	
	public WebElement getWebElement(WebDriver driver, By by){
		try{
			return driver.findElement(by);
		}
		catch(Throwable t){
			logger.error("Could not find locator by:"+by, t);
		}
		
		return null;
	}
	
	public void sendAndClearKeys(By by, WebDriver driver, String toBeTyped){
		getWebElement(driver, by).sendKeys(toBeTyped);
	}
	
	public void clickElement(By by, WebDriver  driver){
		getWebElement(driver, by).click();
	}
	
	public void createPageObjects(){
		login=new Login(driver);
		home= new Home(driver);
		profile=new Profile(driver);
	}
	
	//public void scroll(WebDriver driver){
		
		//}
	//}

}
