package com.qa.ParasoftBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.ParasoftUtilities.TestUtlity;
import com.qa.ParasoftUtilities.WebEventlistener;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	static WebEventlistener eventlistener;
	
	
	public TestBase()
	{
		
		try{
			prop = new Properties();
				
		String path = System.getProperty("user.dir")+
				"/src/main/java/com/qa/ParasoftConfig/config.properties";
		
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		}
		catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
		
		
	}
	
	public static void initialization() 
	{
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "F:\\24July2020\\ParaBank\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "F:\\24July2020\\ParaBank\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	else if (browserName.equals("firefox"))
	{
		System.setProperty("webdriver.ie.driver", "F:\\24July2020\\ParaBank\\drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	else
	{
		System.out.println("Select right browser");
	}
	
	
	e_driver = new EventFiringWebDriver(driver);
	eventlistener = new WebEventlistener();
	e_driver.register(eventlistener);
	driver = e_driver;
	
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TestUtlity.PageLoad_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtlity.Implicit_timeout, TimeUnit.SECONDS);
	
		
	}

}
