package pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Utility;

public class BYJUSOnlineLearingPrograms {
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement online;
	
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	private WebElement childName;

	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobileNumber ;

	@FindBy(xpath="//input[@name='email']")
	private WebElement emailAdderss ;

	@FindBy(xpath="//select[@name='state']")
	private WebElement state ;
	private WebDriver driver;

	@FindBy(xpath="//button[text()='Schedule a Free Class']")
	private WebElement continueToSheduleButton;

	public BYJUSOnlineLearingPrograms(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnOnline() {
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//	wait.until(ExpectedConditions.elementToBeClickable(online));
	online.click();
	}
	public void sendChildName() throws EncryptedDocumentException, IOException {
		String excelNameData= Utility.getDataFromExcelSheet("src\\test\\resources\\DataResource\\Buyjus data.xlsx", "praj", 1, 0);
		childName.sendKeys(excelNameData);
	}

	public void sendMobileNumber() throws EncryptedDocumentException, IOException {
		String excelNameData= Utility.getDataFromExcelSheet("src\\test\\resources\\DataResource\\Buyjus data.xlsx", "praj", 1, 1);

		mobileNumber.sendKeys(excelNameData);
	}

	public void sendEmailAddress() throws EncryptedDocumentException, IOException {
		String excelNameData= Utility.getDataFromExcelSheet("src\\test\\resources\\DataResource\\Buyjus data.xlsx", "praj", 1, 2);

		emailAdderss.sendKeys(excelNameData);
	}

	public void selectState() throws InterruptedException {
		Select s = new Select(state);
		s.selectByVisibleText("Maharashtra");
		//Thread.sleep(1000);
	}

	public void clickOnContinueToSheduleButton() throws InterruptedException {
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click()", continueToSheduleButton);//ElementNotInteractableException
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(continueToSheduleButton));//no such window exception
		
		continueToSheduleButton.click();
		
	}


}
