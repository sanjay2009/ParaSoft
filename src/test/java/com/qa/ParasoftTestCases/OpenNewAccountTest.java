package com.qa.ParasoftTestCases;

import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ParasoftBase.TestBase;
import com.qa.ParasoftPageObjects.HomePage;
import com.qa.ParasoftPageObjects.LaunchPage;
import com.qa.ParasoftPageObjects.OpenNewAccount;

public class OpenNewAccountTest extends TestBase{
	
	LaunchPage lp;
	HomePage homepage;
	OpenNewAccount newAccount;
	
	public OpenNewAccountTest()
	{
		super();
	}
	
	@BeforeMethod
	public void signup()
	{
		initialization();
		lp = new LaunchPage();
		homepage = lp.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOpenNewAccount();
	}
	
	
	@Test()
	public void createNewAccount()
	{
		newAccount = new OpenNewAccount();
		try {
		newAccount.accountType();
		newAccount.minAmount();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Check Account type and Account number selected");
		}
		newAccount.clickOpenAccountButton();
		
		
		String aid= newAccount.accountNumber();
		System.out.println("Account number is :"+aid);
		homepage.logOut();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
