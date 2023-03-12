package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
//		WebElement sourceEle = driver.findElement(By.id("draggable"));
//		WebElement targetEle = driver.findElement(By.id("droppable"));
//		
		//Actions act = new Actions(driver);
//		act.clickAndHold(sourceEle)
//		.moveToElement(targetEle)
//		        .release()
//		            .build()
//		                .perform(); //builder pattern - each method returning the current class object, chain of methods.
		
		//act.dragAndDrop(sourceEle, targetEle).build().perform();
		
		By drag = By.id("draggable");
		By drop = By.id("droppable");
		doDragAndDrop(drag, drop);
		
	}
	
	public static void doDragAndDrop(By draggableLocator, By droppableLocator) {
		WebElement sourceEle = getElement(draggableLocator);
		WebElement targetEle = getElement(droppableLocator);
		Actions act = new Actions(driver);
		act.dragAndDrop(sourceEle, targetEle).build().perform();
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}
