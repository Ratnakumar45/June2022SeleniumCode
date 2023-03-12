package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PseudoElementHandle {

	static WebDriver driver;
	public static void main(String[] args) {

		// How to know first name is mandetory field
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// window.getComputedStyle(document.querySelector("label[for='input-firstname']"),
		// '::before').getPropertyValue('content')

//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		
//		String man_text = 
//				js.executeScript("return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content')").toString();
//
//		System.out.println(man_text);
//		
//		if(man_text.contains("*")) {
//			System.out.println("FN is mandetory field");
//			
//		}
//		else {
//			System.out.println("FN is not a mandetory field");
//		}
		
		String fn_JScript = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content')";
	    checkElementisMandatory(fn_JScript);
	}

	public static Boolean checkElementisMandatory(String jsScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String man_text = js.executeScript(jsScript).toString();

		System.out.println(man_text);

		if (man_text.contains("*")) {
			System.out.println("ele is mandetory field");
			return true;

		} else {
			System.out.println("FN is not a mandetory field");
			return false;
		}

	}

}
