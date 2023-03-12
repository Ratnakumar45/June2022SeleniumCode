package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCssSelector {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");

		//css selector: Another type of locator, we can locate the element using css selector in HTMO DOM
		
		//id--> #id
		//htmltag#id
		//class--> .class
		//htmltag.class --> preferrd way
		
		// #username
		// input#username --> preferred way
		By email = By.cssSelector("#username");
		// .login-email --> for class using (.)
		// input.login-email --> preferred way
		
		// button#loginBtn
		//button.login-submit
		
		//input#username.login-email - combine id and class
		//input.login-email#username -- any sequence
		
		//.c1.c2.c3 --- classes - cascaded css selector with classes
		//.form-control.private-form__control.login-email
		//.form-control.login-email
		//input.form-control.private-form__control.login-email -->preferred
		
		//.form-control.private-form__control.login-email#username --> .c1.c2.c3#id
		// #username.form-control.private-form__control.login-email --> #id.c1.c2.c3
		// input#username.form-control.private-form__control.login-email --> htmltag#id.c1.c2.c3
		
		//other attributes
		// htmltag[attr='value']
		// input[value='Login'] -- css
		//input[@value='Login'] -- xpath
		
		//for 2 attributes
		// htmltag[attr1='value'][attr2='value'][attr3='value']
		// input[type='submit'][value='Login']--> css - different brackets
		
		//input[@value='Login' and @type='submit'] --> xpath - same square bracket seperated by and
		
		// input[type='text'][name='email'][id='input-email']
		// input[type='text'][name='email']#input-email
		
		//Dynamic attributes in css
		// input[id*='email'] -- id contains email - in css * used for contains
		// input[placeholder*='E-Mail']
		// input[id*='email']
		
		//starts with
		// input[placeholder^='E-Mail'] -- placeholder starting with E-Mail
		
		//CSS supports ends-wth but not xpath
		//input[placeholder$='Address'] -- placeholder ending with address
		
		//parent to child
		// form#hs-login div --- gives direct+indirect child elements
		// form#hs-login > div --- gives direct child elements
		
		// select#Form_getForm_Country > option
		// select[id='Form_getForm_Country'] > option - gives direct child elements
		
		//child to parent : NA
		//backward traversing: NA in css selector
		//preceding-sibling also not available
		
		//following-sibling:
		// label[for='input-email']+input
		
		//comma in css:
		// input#username,input#password,button#loginBtn,small#password-description
		
		List<WebElement> manFieldsList = driver.findElements(By.cssSelector("input#username,input#password,button#loginBtn,small#password-description"));
		
		System.out.println(manFieldsList.size());
		if(manFieldsList.size()==4) {
			System.out.println("PASS");
		}
		
		//not in css:
		// form-control private-form__control login-email
		// form-control private-form__control login-password m-bottom-3
		
		
		// input.form-control.private-form__control:not(#password)
		// input.form-control.private-form__control:not(.login-email)
		
		
		
		                //xpath        vs      css:
	//1.syntax          complex              simple
	//2.backward:        yes                  no
    //3.text:            yes                  no
    //4.Siblings         yes                  limited - only forward
	//5.webtable:        yes                  limited
	//6.parent to child: yes                  yes
    //7.performance:     good                 good
		
		//index
		//comma
		//not
		//relative locators -- Sel 4.x
		//Shadow DOM -- 
		//SVG elements
		
		
	//comma in CSS
	}

}
