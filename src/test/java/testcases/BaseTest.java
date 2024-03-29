package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumsessions.BrowserUtil;

public class BaseTest {

	WebDriver driver;

	@Parameters({"url", "browser"})
	@BeforeTest // setup - what exactly you setup
	public void setup(String url, String browser) {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser(browser);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(url);
	}

	@AfterTest // teardown means close the browser
	public void tearDown() {
		driver.quit();
	}

}
