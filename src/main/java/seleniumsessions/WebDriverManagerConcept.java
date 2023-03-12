package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");

		// .exe(100) -> chrome(100) -> 102
		// WDM - Third party library. not related to Selenium

		// chrome 100 -> system --> .exe 100
		// chrome 101 -> system --> .exe100 --> 101
		// chrome 102 -> 102.exe
		// chrome 95 --> 95.exe
		// chrome 102 --> if 102.exe -> yes->Already there so no need to download.

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(); // launch the chrome browser
		driver.get("https://www.google.com"); // enter the url
		String title = driver.getTitle(); // get the title

		System.out.println("page title is: " + title);
		
		driver.quit();
	}

}
