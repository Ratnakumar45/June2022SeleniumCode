package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandlingWithoutSelect {

	static WebDriver driver;

	public static void main(String[] args) {

		// Without using select class
		// find specific value from dropdwn like India
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

//		List<WebElement> optionsList = driver.findElements(By.xpath("//select/option"));
//
//		System.out.println(optionsList.size());
//
//		for (WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
		
		By country = By.xpath("//select/option");
		doSelectValueFromDropdown(country, "Germany");

	}
	
	//This is not better because it will keep checking text = abc, then we are clicking on it
	//selectByVisibleText is very fast
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doSelectValueFromDropdown(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);

		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
