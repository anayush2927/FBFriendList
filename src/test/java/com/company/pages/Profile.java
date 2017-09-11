package com.company.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.company.config.Config;
import com.company.module.TestBase_FB;

public class Profile extends TestBase_FB{

	By friends_L= By.xpath("//a[text()='Friends']");
	By links_L=By.xpath("//a[contains(@data-gt,'eng_type')]");
	
	public Profile(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void friendList(){
		//driver.manage().timeouts().pageLoadTimeout(Config.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		clickElement(friends_L, driver);
		for(int i=0; i<6; i++){
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)");
		}
		List <WebElement> friends= driver.findElements(links_L);
		int n=friends.size();
		System.out.println("Number of Friends:"+n);
		
		for(int j=0; j<n;j++){
			System.out.println((j+1)+" "+ friends.get(j).getText());
		}
	}
	
	
}
