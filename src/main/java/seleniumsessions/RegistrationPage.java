package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	public static void main(String[] args) throws Exception {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		
		eleUtil.doSendKeys(firstName, "Ratna Kumar");
		eleUtil.doSendKeys(lastName, "Kotla");
		eleUtil.doSendKeys(email, "ratna1.kumar@gmail.com");
		eleUtil.doSendKeys(telephone, "9840774263");
		eleUtil.doSendKeys(password, "ratna@123");
		eleUtil.doSendKeys(confirmPassword, "ratna@123");
		
		brUtil.quitBrowser();
		
	}

}
