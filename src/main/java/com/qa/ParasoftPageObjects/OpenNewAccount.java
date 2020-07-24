package com.qa.ParasoftPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.ParasoftBase.TestBase;

public class OpenNewAccount extends TestBase{
	
//	@FindBy(xpath="//*[@id=\"type\"]")
//	WebElement accountdropdown;
	
	@FindBy(xpath="//*[@id=\"fromAccountId\"]")
	WebElement minAmount;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]/div/div/form/div/input")
	WebElement newaccountbutton;
	
	@FindBy(xpath="//*[@id=\"newAccountId\"]")
	WebElement accountId;
	
	public OpenNewAccount()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void accountType()
	{
		
		
		Select account = new Select( driver.findElement(By.xpath("//*[@id=\"type\"]")));
		account.selectByIndex(1);
		
	}
	
	public void minAmount()
	{
		Select amount = new Select(driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]")));
		amount.selectByIndex(0);
	}
	
	public void clickOpenAccountButton()
	{
		newaccountbutton.click();
	}
	
	public String accountNumber()
	{
		return accountId.getText();
	}

}
