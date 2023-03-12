package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	//Main advantage of Browser Util is --- reuseability. 
	private WebDriver driver;

	/**
	 * This method is used to initialize the driver on basis of browser name
	 * 
	 * @param browser
	 * @throws Exception 
	 */
	public WebDriver launchBrowser(String browser) {
		System.out.println("Browser name is : " + browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Pls pass the right browser");
			//throw new Exception("WRONGBROWSER");
			//break;
		}
		
		return driver;
	}

	public void launchUrl(String url) throws Exception {

		if (url == null) {
			System.out.println("URL is null");
			throw new Exception("URLISNULL");
		}

		if (url.length() == 0) {
			System.out.println("URL is blank");
			throw new Exception("URLBANKEXCEPTION");
		}
		
		//http(s)
		//http://www.google.com
		if(url.indexOf("http")!=0 && url.indexOf("https")!=0) {
			System.out.println("http(s) is missing in url");
			//throw new Exception("HTTP(s)MISSINGEXCEPTION");
		}

		driver.get(url);
	}
	
	public void launchUrl(URL url) throws Exception {
		
		String newURL = String.valueOf(url);

		if (newURL == null) {
			System.out.println("URL is null");
			throw new Exception("URLISNULL");
		}

		if (newURL.length() == 0) {
			System.out.println("URL is blank");
			throw new Exception("URLBANKEXCEPTION");
		}
		
		//http(s)
		//http://www.google.com
		if(newURL.indexOf("http")!=0 && newURL.indexOf("https")!=0) {
			System.out.println("http(s) is missing in url");
			throw new Exception("HTTP(s)MISSINGEXCEPTION");
		}

		driver.navigate().to(url);
	}

	// Wrapper function/method for the title.
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("page title ::" + title);

		if (title != null) {
			return title;
		} else {
			System.out.println("Getting null title...");
			return null;
		}
	}

	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("page url ::" + url);

		if (url != null) {
			return url;
		} else {
			System.out.println("Getting null title...");
			return null;
		}
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();
			System.out.println("Browser is closed");
		}
	}
	
	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser is closed");
		}
	}

}
