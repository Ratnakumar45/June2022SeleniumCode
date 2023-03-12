package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrame {

	static WebDriver driver;

	public static void main(String[] args) {

		//Have to see number of frames, nested frames
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(2);
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.name("main")));
		//Purpose of the frame- to secure the webelements(UI Data) like banking application, not directly available on the page
		
		//frame and iframe- frame is deprecated from market ui developers dont use, new concept is iframe
		//frame or iframe - same method we have to use
		
		//If we get no such element exception, see whether frame present or not
		//frame is also a type of webelement, html tag - frame
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);

	}

}
