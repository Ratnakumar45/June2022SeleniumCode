package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumException {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php");

		// WE + Action

//			WebElement ele = driver.findElement(By.name("search11"));
//			ele.sendKeys("mackbook pro");
		// NoSuchElementException
		// ElementNotFoundException - not even exists in selenium. Its java exception
		// While creating the element, we will be getting the exception

		// which exception thrown here when we use findElements, we will get 0. , always
		// give list of webelemtn with empty list, size of list is 0
		// returns an empty list, size of empty list is 0.
//			List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//naveen"));
//			System.out.println(footerLinks.size());

//		List<WebElement> list = driver.findElements(By.name("search"));
//		System.out.println(list.size());
//
//		if (list.size() == 1) {
//			System.out.println("single search ele is present on the page");
//		} else {
//			System.out.println("no search or multiple search present on the page");
//		}

		// Dont use this, as it will pick first search element displayed on page is
		// there or not.
//		boolean flag = driver.findElement(By.name("search")).isDisplayed();
//		if (flag) {
//			System.out.println("single search ele is present on the page");
//		}

	}
	
	//checks only when single element present on the page
	public static boolean isSingleElementPresent(By locator) {
		List<WebElement> list = driver.findElements(locator);
		System.out.println(list.size());
		if (list.size() == 1) {
			System.out.println("single search ele is present on the page");
			return true;
			
		} else {
			System.out.println("no search or multiple search present on the page");
			return false;
		}
	}

}
