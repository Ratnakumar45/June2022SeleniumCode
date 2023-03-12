package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SyncronizationInSelenium {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//implicitly wait(Dynamic wait) always applied globally - available for all the webelements for which driver is interacting..!
		//Specifies the amount of time the driver should wait when searching for an element if it is not immediately present. 
		//dynamic in nature
		//it can be changed anywhere and at any time in your code.
		driver.get("https://www.facebook.com");
		
		//driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement mobileNum = driver.findElement(By.name("reg_email__"));
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		
		driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
		//clickOn(driver, forgotPassword, 5);
				
		sendKeys(driver, firstName, 10, "Ratna Kumar");
		sendKeys(driver, lastName, 5, "Kotla");
		sendKeys(driver, mobileNum, 5, "9840774263");
		sendKeys(driver, password, 10, "test@123");

	}
	
	//Explicitly wait:
	//1. no explicit keyword or method
	//2. available with WebDriverWait with some ExpectedConditions
	//3. specific to element
	//4. dynamic in nature.
	//5. We should never use implicitly wait and explicitly wait together because selenium webdriver will wait for the element 
	//first because of IMPLICITLY WAIT and then EXPLICITLY WAIT will be applied 
	//Hence total sync wait will be increased for each element.
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		//creating obj of WebDriverWait class
	    new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		//creating obj of WebDriverWait class
	    new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
