package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Dropdown: select tag is mandetory, then only we have to create object of
		// select class, pass drodown weblement of the select class construtor
		// tagname - select --> Options
		// we have to use select class in selenium
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		WebElement countryDropdown = driver.findElement(By.id("Form_getForm_Country"));

		// sendkeys supported for dropdown also, work only for select tag is available,
		// but generally prefer select class option
		// this will give guarantee for select class
		// countryDropdown.sendKeys("India");

		 //total count of countries
		Select sel = new Select(countryDropdown);
		List<WebElement> countryOptions = sel.getOptions();
		System.out.println("Total options :: " + (countryOptions.size() - 1));

		for (WebElement e : countryOptions) {
			String text = e.getText();
			System.out.println(text);
		}
		
		
		System.out.println("************************************");
		
		//Using generic method to put the options in the array list
		By countryLocator = By.id("Form_getForm_Country");
		List<String> dropdownOptionValues = getDropDownOptionsList(countryLocator);
		System.out.println(dropdownOptionValues);
		
//	    By countryLocator = By.id("Form_getForm_Country");
//		getDropDownOptionsList(countryLocator);

//		// sel.selectByIndex(5); --> static we have to use this dropdowns are fixed like
//		// month dropdown, Monday to sunday, dates etc
//
//		// preferable when dynamic dropdowns when country added
//		sel.selectByVisibleText("India");

		// there is no guarantee when value attribute is not mandetory, text will always
		// be there, hence prefer selectByVisibleText
		// sel.selectByValue("Armenia");

		// 10 dropdowns are there -> 10 times because select class is applicable only
		// specific webelement

		// By countryLocator = By.id("Form_getForm_Country");
//		doSelectDropdownByIndex(countryLocator, 20);
//		doSelectDropdownByIndex(countryLocator, 30);

//		doSelectDropdownByVisibleText(countryLocator, "India");
//		Thread.sleep(2000);
//		doSelectDropdownByValue(countryLocator, "Angola");
	}

	public static void doSelectDropdownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static void doSelectDropdownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public static void doSelectDropdownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}

	public static int getDropDownOptionsCount(By locator) {
		return getDropDownOptions(locator).size();
	}

	public static List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.length() != 0) {
				optionsTextList.add(text);
			}
		}

		return optionsTextList;
	}

}
