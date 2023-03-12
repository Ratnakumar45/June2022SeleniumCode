package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxesSelectorsHub {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		// //a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']
		
		//driver.findElement(By.xpath("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		
		selectUserTable("John.Smith");	
		
		getUserInfo("Garry.White");	
		getUserInfo("Jordan.Mathews");
	}
	
	public static void selectUserTable(String user) {
		String userTable = "//a[text()='"+user+"']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(userTable)).click();
	}
	
	public static ArrayList<String> getUserInfo(String userName) {
		List<WebElement> usersList = driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
		ArrayList<String> usersTable = new ArrayList<String>();
		System.out.println(usersList.size());
		for(WebElement e : usersList) {
			String text = e.getText();
			if(text.length()!=0) {
				System.out.println(text);
				usersTable.add(text);
			}
		}
		return usersTable;
	}
	

}
