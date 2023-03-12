package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntervalPollingTime {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/"); // parent window
		
		By ytLink = By.xpath("(//div[@class='orangehrm-login-footer-sm11']/a)[4]");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.waitForElementVisible(ytLink, 10).click();
		//(tried for 10 seconds with 500 milliseconds interval)
		
		//default interval time or polling time - 500 millisecond interval
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ytLink)).click();
		
	}

}
