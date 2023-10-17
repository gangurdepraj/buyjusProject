package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	public WebDriver driver;
	public static String getDataFromExcelSheet(String filePath, String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String data ="";
		
		FileInputStream file = new FileInputStream(filePath);
		Workbook workBook = WorkbookFactory.create(file);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row1 = sheet.getRow(row);
		Cell cell1 = row1.getCell(cell);
		
		try 
		{
			data= cell1.getStringCellValue();
		}
		catch(IllegalStateException e)
		{
			double value = cell1.getNumericCellValue();
			data =String.format("%f", value);
			//System.out.println(data);

		}
		catch(NullPointerException e)
		{
			System.out.println("Field is empty");
		}
		System.out.println(data);
		workBook.close();
		return data;
	}
	
	public static void captureScreenShot(String TestID) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://byjus.com/");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy hh mm ss");
		Date date = new Date();
		
		File dest = new File ("test-output\\FailedTestCaseScreenshot\\failedTests" +TestID+" "+format.format(date)+".jpg");
		FileHandler.copy(src, dest);
		
				
		
			
	}
	
}
