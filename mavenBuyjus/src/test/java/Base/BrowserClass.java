package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserClass {
	public static WebDriver launchChrome()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver launchEdge()
	{
		System.setProperty("webdriver.driver.edge", "src\\test\\resources\\BrowserFile\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}
}
