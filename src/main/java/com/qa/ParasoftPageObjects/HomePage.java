package com.qa.ParasoftPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ParasoftBase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(linkText="Open New Account")
	WebElement openAccount; 
	
	@FindBy(linkText="Accounts Overview")
	WebElement accountOverview;  
	
	@FindBy(linkText="Transfer Funds")
	WebElement transferFunds  ;
	
	
	@FindBy(linkText="Bill Pay")
	WebElement  billPay ;
	
	@FindBy(linkText="Find Transactions")
	WebElement findTransactions;
	
	@FindBy(linkText="Update Contact Info")
	WebElement updatecontactDetails  ;
	
	@FindBy(linkText="Request Loan")
	WebElement requestLoan;
	
	@FindBy(linkText="Log Out")
	WebElement logOut;
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/p")
	WebElement welcomeMessage;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
		
	}
	
	public String validateWelcomeMessage()
	{
		return welcomeMessage.getText();
		
	}
	
	public OpenNewAccount clickOpenNewAccount()
	{
		openAccount.click();
		return new OpenNewAccount();
	}
	
	public void accountOverview()
	{
		accountOverview.click();
	}
	public void transferFunds()
	{
		transferFunds.click();
	}
	public void billPay()
	{
		billPay.click();
	}
	public void Transactions()
	{
		findTransactions.click();
	}
	public void updatedetails()
	{
		updatecontactDetails.click();
	}
	public void requestLoan()
	{
		requestLoan.click();
	}
	public void logOut()
	{
		logOut.click();
	}

}
