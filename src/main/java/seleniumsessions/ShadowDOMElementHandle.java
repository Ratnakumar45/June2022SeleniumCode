package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMElementHandle {

	//Browser
	    //page -- elements
	       //iframe -- elements
	          //shadow dom(open) -- elements -- tea it will work only if shadow root is (open), if it is close, we cannot automate
	//we have to use javascript executor
	
	//purpose - for secure entities, prevent some level of automation.
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		Thread.sleep(4000);
		
		driver.switchTo().frame("pact");
		
		// document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement tea = (WebElement)js.executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#tea')");
		tea.sendKeys("masala tea");
	}

}
