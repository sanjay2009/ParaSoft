package com.qa.ParasoftPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ParasoftBase.TestBase;

public class LaunchPage extends TestBase{
	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]/form/div[3]/input")
	WebElement loginButton;
	
	@FindBy(linkText="Forgot login info?")
	WebElement forgotloginLink;
	
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	public LaunchPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String LaunchPageTitle()
	{
		return driver.getTitle();
		
	}
	public HomePage enterCredentials(String un, String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		loginButton.click();
		return new HomePage();
	}
	
	public RegisterPage clickRegister()
	{
		registerLink.click();
		return new RegisterPage();
	}
	
	public void clickForgotlogin()
	{
		forgotloginLink.click();
	}
}
