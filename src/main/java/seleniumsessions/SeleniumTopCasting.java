package seleniumsessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTopCasting {

	public static void main(String[] args) {

		//1. chrome/FF/Safari/edge
		//Valid but Applicable only for chrome driver only.
		//ChromeDriver driver = new ChromeDriver();
		
		//2.Valid one
		//to run the test cases locally
//		WebDriver driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		driver = new SafariDriver();
//		driver = new EdgeDriver();
		
		//Valid but not useful
		//SearchContext driver = new ChromeDriver();
		
		//4. valid and useful but not preferred as other browser may come and tell it cant use RWD methods.
		//RemoteWebDriver driver = new ChromeDriver();
		
		//5. WD - RWD - Valid and useful
		//to run test cases on remote machine - cloud, server, grid AWS
		//WebDriver driver = new RemoteWebDriver(new URL("https://192.190.10.11/wb/hub"), capabilities);
		
		//6. SC - RWD: Valid according to java but not useful
		
		
		
		
		
	}

}
