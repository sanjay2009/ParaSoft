package com.qa.ParasoftPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ParasoftBase.TestBase;

public class RegisterPage extends TestBase{
	
	@FindBy(id="customer.firstName")
	WebElement firstName;
	
	@FindBy(id="customer.lastName")
	WebElement lastName;
	
	@FindBy(id="customer.address.street")
	WebElement address;
	
	@FindBy(id="customer.address.city")
	WebElement city;
	
	@FindBy(id="customer.address.state")
	WebElement state;
	
	@FindBy(id="customer.address.zipCode")
	WebElement zipcode;
	
	@FindBy(id="customer.phoneNumber")
	WebElement phoneNumber;
	
	@FindBy(id="customer.ssn")
	WebElement ssn;
	
	@FindBy(xpath="//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
	WebElement registerButton;
	
	@FindBy(id="customer.username")
	WebElement username;
	
	@FindBy(id="customer.password")
	WebElement password;
	
	@FindBy(id="repeatedPassword")
	WebElement repeatpassword;
	
	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void firstName(String fn)
	{
		firstName.sendKeys(fn);
	}
	public void lastName(String ln)
	{
		lastName.sendKeys(ln);
	}
	
	public void address(String add)
	{
		address.sendKeys(add);
	}
	
	public void city(String cty)
	{
		city.sendKeys(cty);
	}
	
	public void state(String st)
	{
		state.sendKeys(st);
	}
	
	public void zipcode(String zp)
	{
		zipcode.sendKeys(zp);
	}
	
	public void phoneNumber(String phone)
	{
		phoneNumber.sendKeys(phone);
	}
	
	public void ssnNumber(String ssnno)
	{
		ssn.sendKeys(ssnno);
	}
	
	public HomePage clickRegister()
	{
		registerButton.click();
		return new HomePage();
	}
	
	public void username(String un)
	{
		username.sendKeys(un);
	}
	
	public void password(String pw)
	{
		password.sendKeys(pw);
	}
	
	public void repeatpw(String pw1)
	{
		repeatpassword.sendKeys(pw1);
	}
	
}
