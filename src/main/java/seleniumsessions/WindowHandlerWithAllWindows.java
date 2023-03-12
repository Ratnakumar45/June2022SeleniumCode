package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlerWithAllWindows {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // parent window
		Thread.sleep(5000);

		String parentWindowId = driver.getWindowHandle();

		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[1]")).click(); // linkedin
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[2]")).click(); // fb
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[3]")).click(); // twitter
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[4]")).click(); // youtube

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		// hasNext - Returns true if the iteration has more elements.(In other words,
		// returns true if next wouldreturn an element rather than throwing an
		// exception.)

		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String title = driver.getTitle();
			System.out.println(title);
			Thread.sleep(2000);
			
			if (!windowId.equals(parentWindowId)) {
				driver.close();
			}
		}

		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());

	}

}
