package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		driver.findElement(By.id("search_query_top")).sendKeys("Dress");

		Thread.sleep(4000);
		
		doSearch("Summer Dresses > Printed Chiffon ");

		// specific element to click in dropdown, One line also we can handle by having
		// xpath of that dropdown and click and this is preferred
		// and faster in terms of performance

		//driver.findElement(By.xpath("//li[text()='casual dress > printed ']")).click();

//		List<WebElement> suggList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
//		
//		for(WebElement e : suggList) {
//			String text = e.getText();
//			System.out.println(text);
//			
//			if(text.contains("Printed Dress")) {
//				e.click();
//				break;
//			}
//		}
	}
	
	public static void doSearch(String text) {
		By suggLocator = By.xpath("//li[text()='"+text+"']");
		driver.findElement(suggLocator).click();
	}

}
