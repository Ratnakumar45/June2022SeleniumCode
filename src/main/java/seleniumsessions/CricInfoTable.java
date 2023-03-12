package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://www.espncricinfo.com/series/south-africa-in-australia-2022-23-1317472/australia-vs-south-africa-2nd-test-1317493/full-scorecard");

		Thread.sleep(4000);

//		String wkt_xpath = "//span[text()='Sarel Erwee']/ancestor::td/following-sibling::td";
//
//		String wkTakerName = driver.findElement(By.xpath(wkt_xpath)).getText();
//		System.out.println(wkTakerName);

//		getWckTakerName("Theunis de Bruyn");
//		getWckTakerName("Temba Bavuma");

//		List<WebElement> scoreList = driver
//				.findElements(By.xpath("//span[text()='Sarel Erwee']/ancestor::td/following-sibling::td"));
//		for (WebElement e : scoreList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		
//		getScoreList("Khaya Zondo");
//		getScoreList("Marco Jansen");
		
		getBowlerNameList("Lungi Ngidi");
	}

	public static ArrayList<String> getScoreList(String name1) {
		List<WebElement> scoreList = driver.findElements(By.xpath("//span[text()='" + name1 + "']/ancestor::td/following-sibling::td"));
		ArrayList<String> scoreListGroup = new ArrayList<String>();
		for (WebElement e : scoreList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(text);
				scoreListGroup.add(text);
			}
		}
		return scoreListGroup;
	}

	public static String getWckTakerName(String name) {
		String wkt_xpath = "//span[text()='" + name + "']/ancestor::td/following-sibling::td";

		String wkTakerName = driver.findElement(By.xpath(wkt_xpath)).getText();
		System.out.println(wkTakerName);
		return wkTakerName;
	}
	
	
	public static ArrayList<String> getBowlerNameList(String bowName) {
		String bow_xpath = "//th[text()='BOWLING']//ancestor::thead/following-sibling::tbody//span[text()='"+bowName+"']/ancestor::td/following-sibling::td";
		
		List<WebElement> bowList = driver.findElements(By.xpath(bow_xpath));
		ArrayList<String> bowListGroup = new ArrayList<String>();
		for (WebElement e : bowList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(text);
				bowListGroup.add(text);
			}
		}
		return bowListGroup;
		
	}

}
