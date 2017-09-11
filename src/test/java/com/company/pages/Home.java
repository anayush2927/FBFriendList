package com.company.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.config.Config;
import com.company.module.TestBase_FB;

public class Home extends TestBase_FB{
By profile_L= By.className("_5afe");
	
	public Home(WebDriver driver){
		this.driver=driver;
	}
	
	public void openProfile(){
		//driver.manage().timeouts().pageLoadTimeout(Config.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Config.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		clickElement(profile_L, driver);
	}
}
