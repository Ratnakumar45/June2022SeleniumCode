package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessIncognitoConcept {

	public static void main(String[] args) {

		//headless - no browser
		//testing is happening in the background
		//slightly fast than the normal mode
		//disadvantage - might not work for complex application- like JS Pop up
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions co = new ChromeOptions();
		//co.setHeadless(true);
		//co.addArguments("--headless");
		
		//open browser in incognito mode
		co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
		
	}

}
