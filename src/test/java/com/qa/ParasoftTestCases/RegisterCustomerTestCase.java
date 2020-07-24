package com.qa.ParasoftTestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ParasoftBase.TestBase;
import com.qa.ParasoftPageObjects.HomePage;
import com.qa.ParasoftPageObjects.LaunchPage;
import com.qa.ParasoftPageObjects.RegisterPage;
import com.qa.ParasoftUtilities.TestUtlity;

public class RegisterCustomerTestCase extends TestBase{
	
	LaunchPage lp;
	HomePage hp;
	String sheetname = "sheet1";
	
	public RegisterCustomerTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void signup()
	{
		initialization();
		lp = new LaunchPage();
		//hp = lp.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(dataProvider = "getParaSoftTestData")
	public void clickRegisterTest(String fname, String lname, String address, String city, String state, 
			String zipcode, String phone, String ssnum, String un, String pw, String rpw)
	{
		lp.clickRegister();
		RegisterPage rp = new RegisterPage();
		rp.firstName(fname);
		rp.lastName(lname);
		rp.address(address);
		rp.city(city);
		rp.state(state);
		rp.zipcode(zipcode);
		rp.phoneNumber(phone);
		rp.ssnNumber(ssnum);
		rp.username(un);
		rp.password(pw);
		rp.repeatpw(rpw);
		rp.clickRegister();
		String wmessage = hp.validateWelcomeMessage();
		System.out.println("New User created with message: "+wmessage);
		hp.logOut();
				
	}
	
	@DataProvider
		
	public Object[][] getParaSoftTestData()
	{
		Object data[][] = TestUtlity.getTestData(sheetname);
		return data;
	}

	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
