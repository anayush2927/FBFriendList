package com.company.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.company.config.Config;
import com.company.module.TestBase_FB;

public class Login extends TestBase_FB{
	//locators
		By email_L=By.id("email");
		By password_L=By.id("pass");
		By login_L=By.id("loginbutton");
		
		public Login(WebDriver driver){
			this.driver=driver;
		}
		
		public void loginFn(String email, String password){
			
			sendAndClearKeys(email_L, driver, email);
			sendAndClearKeys(password_L, driver, password);
			clickElement(login_L, driver);
		}
	
	
	

}
