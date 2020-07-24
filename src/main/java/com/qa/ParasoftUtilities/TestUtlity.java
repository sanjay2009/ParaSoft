package com.qa.ParasoftUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.ParasoftBase.TestBase;

public class TestUtlity extends TestBase{
	
	static Workbook wbook;
	static Sheet sheet;
	static String path = "F:\\24July2020\\ParaBank\\src\\main\\java\\com\\qa\\ParasoftTestData\\TestData.xlsx";
	
	public static long PageLoad_timeout = 20;
	public static long Implicit_timeout = 10;
	
	public static Object[][] getTestData(String sheetname)
	{
		FileInputStream fis=null;;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet= wbook.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0; i < sheet.getLastRowNum(); i++)
		{
			for (int j =0; j < sheet.getRow(0).getLastCellNum(); j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
	}
	
	public static void takeScreenShot() throws IOException
	{
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentdir+"/screenshots/"+System.currentTimeMillis()+".png"));
	}	
			
	
}
