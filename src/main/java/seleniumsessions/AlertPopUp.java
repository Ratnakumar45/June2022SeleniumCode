package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUp {

	public static void main(String[] args) throws InterruptedException {

		//one frame to another frame - later
		
		//JS Pop up
		//also called Alert pop up
		//also called model dialog popup
		
		//3 types of alert
		//1. alert()
		//2. confirm()
		//3. prompt()
		
		//at a time only 1 popup is allowed on page
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		//pop up is displayed
		
		Alert alert = driver.switchTo().alert();
		//getting the text in the alert
		String text = alert.getText();
		System.out.println(text);
		Thread.sleep(4000);

		//alert.sendKeys("testing");
		//accept the alert: its like clikcing on OK button, but not clickinh, just accepting the alert
		//alert.accept();
		
		//dismiss the alert
		alert.dismiss();
		
		
		
		
		
	}

}
