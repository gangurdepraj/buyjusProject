package TestNGTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BrowserClass;
import pages.BYJUSOnlineLearingPrograms;
import util.Utility;

public class TestClass extends BrowserClass{
	
	private WebDriver driver;
	private BYJUSOnlineLearingPrograms _bYJUSOnlineLearingPrograms ;
	
	@Parameters("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("chrome")) 
		{
			driver = launchChrome();
		}
		
		if(browserName.equals("edge"))
		{
			driver = launchEdge();
		}
	}
	
	@BeforeClass
	public void creatingPOMObjects() 
	{
		 _bYJUSOnlineLearingPrograms = new BYJUSOnlineLearingPrograms(driver);
	}
	
	@BeforeMethod
	public void openHomePage()
	{
		driver.get("https://byjus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void bookFreeSession() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		_bYJUSOnlineLearingPrograms.sendChildName();
		_bYJUSOnlineLearingPrograms.sendMobileNumber();
		_bYJUSOnlineLearingPrograms.sendEmailAddress();
		_bYJUSOnlineLearingPrograms.selectState();
		_bYJUSOnlineLearingPrograms.clickOnContinueToSheduleButton();
	}

	@AfterClass
	public void clearObject()
	{
		_bYJUSOnlineLearingPrograms = null;
	}
	
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException
	{  //screenshot code
		if(ITestResult.FAILURE==result.getStatus())
		{
			String testID = result.getName();
			Utility.captureScreenShot( testID);
		}
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		driver= null;
		System.gc();
	}
}
