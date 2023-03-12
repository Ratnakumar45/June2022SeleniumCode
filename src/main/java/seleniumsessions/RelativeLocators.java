package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

public class RelativeLocators {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// find the particular ele and around this ele,
		// you can go left, right, above, below, near
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.aqi.in/dashboard/canada");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		Thread.sleep(3000);

//		WebElement ele = driver.findElement(By.linkText("Whistler, Canada"));
//
//		// right of ele --> tagname(p)
//		String rightIndex = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
//		System.out.println(rightIndex);
//
//		// left of ele:
//		String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
//		System.out.println(leftRank);
//
//		// below of ele:
//		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
//		System.out.println(belowCity);
//
//		// above of ele:
//		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
//		System.out.println(aboveCity);
//
//		// near of ele:
//		String nearEle = driver.findElement(with(By.tagName("p")).near(ele)).getAttribute("class");
//		System.out.println(nearEle);
//	}
		
	}
	
	

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static String getCityRelativeDetails(By cityDetails) {
		WebElement ele = getElement(cityDetails);
		// right of ele --> tagname(p)
		String rightIndex = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		return rightIndex;
	}

}
