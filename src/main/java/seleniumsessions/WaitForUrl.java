package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrl {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/"); // parent window
		
		By ytLink = By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[4]");
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.waitForElementVisible(ytLink, 10).click();
		
		//window switch code

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		if(wait.until(ExpectedConditions.urlContains("OrangeHRMInc"))) {
			System.out.println(driver.getCurrentUrl()); 
		}
	}
	
	public static String waitForUrl(int timeout, String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl(); 
		}
		else {
			return null;
		}
	}
	
	public static String waitForUrlIs(int timeout, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl(); 
		}
		else {
			return null;
		}
	}

}
