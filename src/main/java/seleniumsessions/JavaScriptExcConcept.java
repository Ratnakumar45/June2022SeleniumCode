package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExcConcept {

	public static void main(String[] args) throws InterruptedException {

		//whenever we are using browser, browser cannot understand java or python, it understand only javascript
		//browser - JS
		//CD - RWD- impl- WebdriverInterface, same RWD imp JSE - method execute script()
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		
//		js.executeScript("alert('hello java')");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		//jsUtil.generateAlert("hello CRM");
		//jsUtil.refreshBrowserByJS();
		
//		String text = jsUtil.getPageInnerText();
//		System.out.println(text);
		
		//System.out.println(jsUtil.getTitleByJS());
		
		//selenium - .click, if it not working actions class, actions.click- we have to use(overlapping) itwill move to element and click on middle of ele
		//js - click can be used in JSE
		//1. normal click
		//2. actions click
		//3. js click
		//WebElement signup = driver.findElement(By.xpath("//input[@value='Login']"));
//		jsUtil.clickElementByJS(signup);
		
		//jsUtil.flash(signup);
		
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(2000);
//		jsUtil.scrollPageDown();
		
		//WebElement animals = driver.findElement(By.xpath("//span[text()='Stuffed Animals & Toys under $10']"));
		//jsUtil.scrollIntoView(animals);
		
		//jsUtil.drawBorder(animals);
		
		jsUtil.sendKeysUsingWithId("twotabsearchtextbox", "One Plus 10 pro");
		
	}

}
