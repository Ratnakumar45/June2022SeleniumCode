package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisplayed {

	static WebDriver driver;

	public static void main(String[] args) {

		//Webelement + isDisplayed() -> Boolean - true or false
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
//		Boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
//		if(flag) {
//			System.out.println("ele is displayed");
//		}
//		else {
//			System.out.println("ele is not displayed");
//		}
		
		By searchField = By.id("twotabsearchtextbox");
		if(DoEleIsDisplayed(searchField)) {
			System.out.println("Ele is displayed");
			doSendKeys(searchField, "iphone");
		}
		else {
			System.out.println("Ele is not displayed");
		}
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean DoEleIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

}
