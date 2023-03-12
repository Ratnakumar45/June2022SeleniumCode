package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomConcept {

	public static void main(String[] args) {

		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String zoomChrome = "document.body.style.zoom = '400%'";
		
		String zoomFirefox = "document.body.style.MozTransform = 'scale(0.5)'";
		js.executeScript(zoomChrome);
		
	}

}
