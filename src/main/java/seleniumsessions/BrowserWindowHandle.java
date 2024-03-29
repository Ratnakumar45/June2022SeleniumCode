package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {

	public static void main(String[] args) throws InterruptedException {

		// target=_blank - it will open in new window
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.crmpro.com/index.html");
		Thread.sleep(4000);
		
		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(2000);
		
		//set? - not order based collection. 
		Set<String> handles = driver.getWindowHandles();
		
		//help me to fetch the value which have no order.
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window id is: " +parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("child window id is: " +childWindowId);
		
		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);	
		System.out.println("child window title is: " +driver.getTitle());
		
		driver.findElement(By.name("email")).sendKeys("ratna1.kumar@gmail.com");
		
		//close child window
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title is: " +driver.getTitle());
		
		driver.quit();
	}

}
