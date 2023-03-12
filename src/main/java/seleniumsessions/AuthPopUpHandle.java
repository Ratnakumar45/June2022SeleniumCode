package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUpHandle {

	public static void main(String[] args) {

		//limitation: what if username and password having @. it will never work.
		//create dummy usernamer and psssword as it have the limitation
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String username = "admin";
		String password = "admin";
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		String msg = driver.findElement(By.xpath("//div[@id='content']//p")).getText();
		System.out.println(msg);
	}

}
