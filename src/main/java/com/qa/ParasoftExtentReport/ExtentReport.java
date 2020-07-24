package com.qa.ParasoftExtentReport;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance()
	{
		if (extent == null)
		{
			extent = new ExtentReports(System.getProperty("user.dir")+"extent.html", true, DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File("F:\\24July2020\\ParaBank\\src\\main\\java\\com\\qa\\ParasoftUtilities\\ReportsConfig.xml"));
			
		}
		return extent;
	}
}
