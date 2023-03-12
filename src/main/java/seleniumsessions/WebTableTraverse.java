package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTraverse {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		int rowCount = getRowCount();
		System.out.println("rows = " + rowCount);

		int colCount = getColumnCount();
		System.out.println("columns = " + colCount);

		// first column data
		// table[@id="customers"]/tbody/tr[2]/td[1]
		// table[@id="customers"]/tbody/tr[3]/td[1]
		//
		//
		// table[@id="customers"]/tbody/tr[7]/td[1]

//		String beforeXpath = "//table[@id='customers']/tbody/tr[";
//		String afterXpath = "]/td[1]";
//
//		// i - representing row
//		for (int i = 2; i <= getRowCount() + 1; i++) {
//
//			String actXpath = beforeXpath + i + afterXpath;
//			// System.out.println(actXpath);
//			String text = driver.findElement(By.xpath(actXpath)).getText();
//			System.out.println(text);
//		}
//
//		System.out.println("--------------------------");
//
//		// second column data
//		// table[@id="customers"]/tbody/tr[2]/td[2]
//		// table[@id="customers"]/tbody/tr[7]/td[2]
//
//		String cont_beforeXpath = "//table[@id='customers']/tbody/tr[";
//		String cont_afterXpath = "]/td[2]";
//
//		// i - representing row
//		for (int i = 2; i <= getRowCount() + 1; i++) {
//
//			String actXpath = cont_beforeXpath + i + cont_afterXpath;
//			// System.out.println(actXpath);
//			String text = driver.findElement(By.xpath(actXpath)).getText();
//			System.out.println(text);
//		}
//		
//		System.out.println("----------------------------");
//
//		// third column data
//		//table[@id="customers"]/tbody/tr[2]/td[3]
//		//*[@id="customers"]/tbody/tr[7]/td[3]
//
//		String country_beforeXpath = "//table[@id='customers']/tbody/tr[";
//		String country_afterXpath = "]/td[3]";
//
//		// i - representing row
//		for (int i = 2; i <= getRowCount() + 1; i++) {
//
//			String actXpath = country_beforeXpath + i + country_afterXpath;
//			// System.out.println(actXpath);
//			String text = driver.findElement(By.xpath(actXpath)).getText();
//			System.out.println(text);
//		}
		
//		getColumnData(1);
//		getColumnData(2);
//		ArrayList<String> countryList = getColumnData(3);
//		if(countryList.contains("Canada")) {
//			System.out.println("PASS");
//		}
		
		getRowData(7, 3);
	}
	
	//table[@id="customers"]/tbody/tr[2]/td[1]
	//table[@id="customers"]/tbody/tr[2]/td[3]
	
	
	public static void getRowData(int rowNumber, int colCount) {
		System.out.println("------------------");

		for(int j=1; j<=colCount; j++) {
			String xpath = "//table[@id='customers']/tbody/tr["+rowNumber+"]/td["+j+"]";
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
	}
	
	
	public static ArrayList<String> getColumnData(int colNumber) {
		
		System.out.println("------------------");
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td["+colNumber+"]";

		ArrayList<String> colValuesList = new ArrayList<String>();
		// i - representing row
		for (int i = 2; i <= getRowCount() + 1; i++) {

			String actXpath = beforeXpath + i + afterXpath;
			// System.out.println(actXpath);
			String text = driver.findElement(By.xpath(actXpath)).getText();
			System.out.println(text);
			colValuesList.add(text);
		}
		
		return colValuesList;
	}

	public static int getColumnCount() {
		int columns = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		return columns;
	}

	public static int getRowCount() {
		int rows = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		return rows - 1;
	}

}
