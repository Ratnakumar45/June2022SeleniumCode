package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {
	
	static WebDriver driver;

	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		//Cross browser logic:
		
		String browser = "Chrome";
			
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Pls pass the right browser");
			break;
		}
		
		driver.get("https://www.google.com"); // enter the url

		String title = driver.getTitle(); // get the title

		System.out.println("page title is: " + title);
		
		String url = driver.getCurrentUrl();
		System.out.println("URL is :" +url);
		
		driver.quit();
	}

}
