package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MazimizeFullScreen {

	public static void main(String[] args) throws Exception {

		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//Maximize
		//driver.manage().window().maximize();
		//driver.manage().window().minimize();
		
		//driver.manage().window().fullscreen();
		
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://www.google.com");
	}

}
