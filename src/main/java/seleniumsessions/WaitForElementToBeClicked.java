package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementToBeClicked {

		static WebDriver driver;
		public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.freshworks.com/");
			
			By support = By.linkText("Support");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			//An expectation for checking an element is visible and enabled such that you can click it.
			WebElement support_ele = wait.until(ExpectedConditions.elementToBeClickable(support));
			support_ele.click();
			
	}

}
