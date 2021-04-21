package com.ijmet.web.pages;

import org.testng.annotations.Test;

import com.ijmeet.basedriver.BaseDriver;
import com.ijmeet.web.locatorinterfaces.LoginPage_locators;

public class LoginPage_TestCase extends BaseDriver{

	String emeilid="klaxman2707@gmail.com";
	String pass="Ijmeet@20";
	String url="https://ijmeet.com/login";
	LoginPage_locators ll=new LoginPage_locators(driver);
	
	@Test
	public void loginTestcase()
	{
		navigate(url);
		ll.enterPassword(emeilid);
		ll.enterPassword(pass);
		ll.clickOnSignIn();
		
	}
}
