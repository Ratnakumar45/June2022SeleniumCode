package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementHandling {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//create a webelement + perform action(click, sendKeys, select, isDisplayed, getText)
		
		//driver pls find the elenment by using ID and perform the action using sendkeys
		//1.
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		//2. Use this anytime when required
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
		
		//3. By locator approach/Object repository
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailId = driver.findElement(email);
//		WebElement pwd = driver.findElement(password);
//		
//		emailId.sendKeys("test@gmail.com");
//		pwd.sendKeys("test@123");
		
		//4: By locator + generic function
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(email).sendKeys("test@gmail.com");
//		getElement(password).sendKeys("test@123");
		
		//5. By locator + getElement + Action generic function
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(email, "test@gmail.com");
//		doSendKeys(password, "test@123");
		
		//6: By locator + Element Util --> generic functions and call those generic funtions.
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "test@gmail.com");
		eleUtil.doSendKeys(password, "test@123");
		eleUtil.doClick(loginBtn);
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		//7: By locator + brUtil + eleUtil
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	

}
