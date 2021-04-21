package com.ijmeet.web.locatorinterfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_locators {
/*
 * This java class is created for init login page elements
 */
	
WebDriver driver;
	
	public LoginPage_locators(WebDriver ldriver)
	
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	WebElement user_email;
	
	@FindBy(id="password")
	WebElement user_password;
	
	@FindBy(how=How.XPATH, using="//div//button[@type='submit']")
	WebElement login_btn;
	
	public void enterUserEmail(String emailid)
	{
		user_email.sendKeys(emailid);
		
	}
	
	public void enterPassword(String pass)
	{
		user_password.sendKeys(pass);
		
	}
	
	public void clickOnSignIn()
	{
		login_btn.click();
	}

}
