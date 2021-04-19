package com.ijmet.web.pages;

import org.openqa.selenium.WebDriver;

import com.ijmeet.basedriver.BaseDriver;
import com.ijmeet.web.locatorinterfaces.HomePageLocator;

public class HomePage extends BaseDriver implements HomePageLocator {

	protected WebDriver driver;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	}
	
	public void verifyHomePageTitle(){
		if (!driver.getTitle().equals("Home Page of logged in user")) {
		      throw new IllegalStateException("This is not Home Page of logged in user," +
		            " current page is: " + driver.getCurrentUrl());
		    }
	}
	
}
