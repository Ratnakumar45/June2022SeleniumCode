package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.netty.util.internal.SystemPropertyUtil;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		//Open browser : chrome
		//launch url: google.com
		//title: get the title of the page
		//verify the title: act vs exp
		//close the browser
		
		//download chromedriver.exe and configure it.
		
		//Automation steps
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch the chrome browser
		
		driver.get("https://www.google.com"); //enter the url
		
		String title = driver.getTitle(); //get the title
		
		System.out.println("page title is: " +title);
		
		//verification point: act vs exp
		if(title.equals("Google")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		String url = driver.getCurrentUrl();
		System.out.println("URL is :" +url);
		
		String source = driver.getPageSource();
		//System.out.println(source);
		
		if(source.contains("Copyright The Closure Library Authors.")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		//close the browser
		
		driver.quit();
		//driver.close();

	}

}
