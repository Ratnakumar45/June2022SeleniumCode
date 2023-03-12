package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {

		//ImplicitWait: A global wait
		//1. Global wait
		//2. it will be applied on all the webelements by default
		//3. it will always applied after the drivr declaration
		//4. Not recommended as it impact the performance of the script
		//5. it doesnot support non web elements -i cannot wait for title, url, alerts of the page
		
		//we never use imp wait in framework, it just impacting the performance of the script
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		WebElement emailId = driver.findElement(By.id("input-email11"));
		emailId.sendKeys("naveen@gmail.com");
		
		//login page: 10 sec
		//e1 - 5 sec--> 10-5 --> 5 sec(ignored)
		//e2 - 0 sec--> 10-0--> 10 sec(ignored)
		//e3
		
		//home page: i want to apply only for 5 sec, we override to 5 sec
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//e4
		//e5
		//e6
		
		//login page: 10 sec:
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//registration page 0 sec: nullify imp wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		


	}

}
