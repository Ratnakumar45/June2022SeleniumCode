package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {

		//explicit wait
		//it will apply on specific element, not for all the elements
		//its not a global wait
		//it can be used for non webelements also: title, url, alerts also
		//polling/interval mechanism
		
		   //1. WebDriver wait
		   //2. fluent wait
		
		//class WebDriverWait--> extends->child of Fluent wait ->Imp-> Wait(I) - until() method
		
		//FluentWait(c) -> until()- @override+other methods
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By pwd = By.id("input-password");
		By logoImage = By.cssSelector("img.img-responsive");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement email_el = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
//		email_el.sendKeys("ratna@gmail.com");
//		
//		driver.findElement(pwd).sendKeys("test@123");
//		
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement logo_ele = wait1.until(ExpectedConditions.presenceOfElementLocated(logoImage));
//		boolean flag = logo_ele.isDisplayed();
//		System.out.println(flag);
		//boolean flag = driver.findElement(logoImage).isDisplayed();
		//System.out.println(flag);
		
		waitForElementPresence(emailId, 10).sendKeys("test@gmail.com");
		getElement(pwd).sendKeys("test@123");
		waitForElementPresence(logoImage, 5);
		if(waitForElementPresence(logoImage, 5).isDisplayed()) {
			System.out.println("logo image is present");
		}
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	//An expectation for checking that an element is present on the DOM of a page. 
	//This does notnecessarily mean that the element is visible.

	//Another way of creating webelement using the explicit wait
	public static WebElement waitForElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	
	/*An expectation for checking that an element is present on the DOM of a page and visible.Visibility means that the element is 
	 * not only displayed but also has a height and width that isgreater than 0.
	 * 
	 */
	public static WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}

	
	

}
