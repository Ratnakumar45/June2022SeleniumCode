package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSessionId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch the chrome browser //123
		driver.get("https://www.google.com"); //enter the url //123 //f8d13b86a22c8bb66ddfc54811f2cd8f
		
		String title = driver.getTitle(); //get the title	//123
		System.out.println("page title is: " +title); //Google //123
		
		//close the browser	
		//driver.quit(); //123
		driver.close();
		//driver.get("https://www.google.com");
		
		driver = new ChromeDriver(); //456
		driver.get("https://www.google.com");//456
		System.out.println(driver.getTitle());//456
//		
		driver.quit();//456

	}

}
