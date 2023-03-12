package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// 1. id: always be unique - I

		// 2. name: can be duplicate --> if ID is not available, then we can go for name - II
		// driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		// driver.findElement(By.name("password")).sendKeys("test@123");

		// 100 elements are there, out of 100 elements,where id = username --1 --> 
		// faster since it is unique
		// 100 elements are available, name = test --5

		// By.type --> not allowed

		// 3. className: can be duplicate most of the time for most of webelements -- III
		// selenium always goes from top to bottom where class form control is
		// available, hence it is displying in search box.
		// look and feel of the elements are exactly same, hence they use classes in
		// HTML
		//driver.findElement(By.className("form-control")).sendKeys("ratna"); --> not good locator - 3rd choice
		
		//4. LinkText: Only applicable for the links
		//two links are available, preference is always given first it is coming. selenium donesnt give any errors, first element available on page
		//Hence positioning we have to give, thats available only in XPATH and CSS selector
		//htmltag = <a>
		//anchor tag
		//driver.findElement(By.linkText("Login")).click();
		
		//5. Partial link text - again only for links
		//risk, tomorrow you have forgotten username and forgotten password - both are starting with forgotten, that time, it will click on 
		//forgotten username
		//hi this is my login link - we can use partial link text if we have long text.	
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		//driver.findElement(By.partialLinkText("my login")).click();
		
		//6. xpath: Address of the webelement on the page(DOM)
		//Its not an attribute. 
		//between ID and xpath, if ID is unique, we can go, but if we have webtable, we can't go with ID, we have to go with XPATH
		//driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Ratna Kumar");
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		//7. CSS Selector: - It is also address of element but different way
		//Its not an attribute. 
		//we can compare xpath and css but cannot compare with id, class, name
		//driver.findElement(By.cssSelector("#input-lastname")).sendKeys("testing");
		
		//8. TagName
		//html tag: it is not an attribute but html tag of that particular element
		//Element not interactable exception - some hidden elements also available having input tag name - hence not preferred.
		//used when there are headers and want to retrive that.- used only when unique tags, we will use for driver.findElements
		//for single element, element should be unique
		//driver.findElement(By.tagName("input")).sendKeys("testing");
//		String header = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(header);
		
		By header = By.tagName("h1");
		By recPayment = By.linkText("Recurring payments");
		By warningMsg = By.className("alert");
		By continueBtn = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		
		String actHeader = doGetText(header);
		
		if(actHeader.equals("Register Account")) {
			System.out.println("Correct header");
		}
		
		else {
			System.out.println("Incorrect header");
		}
		
		
		String recPaymentText = doGetText(recPayment);
		System.out.println(recPaymentText);
		
		doClick(continueBtn);
		
		String warningMsgValue = doGetText(warningMsg);
		System.out.println(warningMsgValue);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}

}
