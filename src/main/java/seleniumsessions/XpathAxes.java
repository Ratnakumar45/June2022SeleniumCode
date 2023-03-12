package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// If you want to handle complex usecases like webtable
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/index.html");

		driver.findElement(By.name("username")).sendKeys("newautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(3000);

		driver.switchTo().frame("mainpanel");

		// Whatever visible on page. selenium always picks that, here contacts is in
		// Capital. hence we have to write CONTACTS
		// preference is always given whatever visible on the page.
		driver.findElement(By.linkText("CONTACTS")).click();

		Thread.sleep(3000);

//		String con_xpath = "//a[text()='Romi singh']/parent::td/preceding-sibling::td/input[@type='checkbox']";
//		driver.findElement(By.xpath(con_xpath)).click();

//		selectContact("Romi singh");
//		selectContact("Ali khan");

		// a[text()='Ali khan']/parent::td/following-sibling::td --- 1 of 6

//		List<WebElement> contactList = driver
//				.findElements(By.xpath("//a[text()='Ali khan']/parent::td/following-sibling::td"));
//
//		for (WebElement e : contactList) {
//			String text = e.getText();
//			if (text.length() != 0) {
//				System.out.println(text);
//			}
//		}
		
		getUserInfo("Ali khan");
		
		System.out.println("=====================");
		
		getUserInfo("Romi singh");

	}

	public static ArrayList<String> getUserInfo(String username) {
		List<WebElement> contactList = driver.findElements(By.xpath("//a[text()='" + username + "']/parent::td/following-sibling::td"));

//		for (WebElement e : contactList) {
//			String text = e.getText();
//			if (text.length() != 0) {
//				System.out.println(text);
//			}
//		}
		ArrayList<String> contactValues = new ArrayList<String>();
		// index based for loop to remove pipes.
		for (int i = 0; i < contactList.size() - 1; i++) {
			String text = contactList.get(i).getText();
			System.out.println(text);
			contactValues.add(text);
		}

		return contactValues;
	}

	public static void selectContact(String username) {
		String con_xpath = "//a[text()='" + username + "']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(con_xpath)).click();
	}

}
