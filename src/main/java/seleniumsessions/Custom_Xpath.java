package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		
		// Xpath - Address of the element in DOM.
		// 1. Absolute Xpath: exact hierarchy by haerarchy have to reach:
		// /html/body/header/div/div/div[2]/div/input and risky if they introduced
		// one more DIV, then entire xpath will be changed, test cases will get failed.
		// 2. Relative/Custom Xpath:

		// htmltag[@attr='value']
		// input[@name='email']

		//By emailId = By.xpath("//input[@name='email']");

		// Multiple attributes

		// htmltag[@attr1='value' and @attr2='value']
		// input[@name='email' and @type='text']
		// input[@name='email' and @type='text' and @id='input-email']
		// input[@type='text' and @placeholder='E-Mail Address']
		// input[@class='form-control' and @type='text'] --> And - both should be
		// satisfied

		// input[@class='form-control' or @type='text'] --> Or - either of them should
		// be satisfied

		// if id and xpath, go always with id, if ID is not available then use XPATH

		// text() function
		// htmltag[text()='value']
		// h2[text()='Returning Customer']
		// a[text()='Register']

		// text() with one attr:
		// htmltag[@attr='value' and text()='value']
		// a[@class='list-group-item' and text()='Wish List']
		// a[text()='Wish List' and @class='list-group-item']

		// text() with two attr:
		// htmltag[@attr1='value' and @attr2='' and text()='value']

		// contains() with attr:
		// htmltag[contains(@attr, 'value')]
		// input[contains(@id, 'email')] - contains specific value or not
		// input[contains(@id, 'password')]

		// main purpose of contains -
		// dynamic attr:
		// <input id = 'firstname_123'>
		// <input id = 'firstname_456'>
		// <input id = 'firstname_12344'> - this case we use contains with ID

		// input[contains(@id, 'firstname_')]

		// contains() with text():
		// htmltag[contains(text(), 'value')]
		// h2[contains(text(), 'Returning')]

		// h1[text()='Love your software'] --normal scenario with text
		// h1[contains(text(), 'software')] -- contains with text
		// p[contains(text(), 'easy-to-use')] -- contains with text

		// h1[text()='Love your software']
		// h1[contains(text(), 'Love your software')]
		// major diff is we have to use comma(,) when we use contains, when we use with
		// text, it should be equal to(=)
		// a[contains(text(), 'Directors')] - entire text as well as partial text
		// a[text()='Board of Directors'] - but for text(), exact text
		// a[contains(text(), 'Amazon')]

		// contains() with text() and contains with attr:
		// htmltag[contains(@attr, 'value') and contains(text(), 'value')]
		// htmltag[contains(text(), 'value') and contains(@attr, 'value')]
		// a[contains(text(), 'About Amazon') and contains(@class, 'nav_a')]

		// contains with text() and attr(without contains):
		// htmltag[contains(text(), 'value') and @attr = 'value']
		// a[contains(text(), 'About Amazon') and @class= 'nav_a']
		// a[contains(text(), 'About') and @class= 'nav_a'] - this is also right xpath

		// contains with attr1 and attr2(without contains)
		// htmltag[contains(@attr1, 'value') and @attr2='value']
		// input[contains(@id, 'twotabsearchtextbox') and @name='field-keywords'] or
		// input[contains(@name, 'keywords') and @id='twotabsearchtextbox']
		// input[contains(@name, 'keywords') and @id='twotabsearchtextbox' and @value]

		// a[contains(@href, 'nav_cs_gc')]
		// a[contains(@href, 'route=account/login')] - how many login links are
		// available. can also use href for starts-with, but doesnt make sense

		// starts-with():
		// htmltag[starts-with(@attr, 'value')]
		// input[starts-with(@name, 'field')]
		// a[starts-with(text(), 'Fresh')] //freshworks

		// ends-with() in xpath - NA, removed from XPATH functions, no concept of
		// ends-with an deprecated.

		//index: 
		//XPATH is the HTML DOM properety to findout the element, its not about only for selenium, it can be used anywhere
		//capture in a group with bracket, all 6 elements in group and then apply the index
		// (//input[@class='form-control'])[6]
		//By confirmPassword = By.xpath("(//input[@class='form-control'])[6]");
		// (//input[@class='form-control'])[position()=1]
		// (//input[@class='form-control'])[last()] -- last element in the capture group
		// (//input[@class='form-control'])[last()-1] -- last but one in the capture group
		
		//for amazon help link in footer
		// (//div[@class='navFooterVerticalRow navAccessibility']//a)[last()] - last element in the footer using capture group

		//invalid xpath or locator
		//driver.findElement(By.xpath("/////input[#$#@id='username']")).sendKeys("test@gmail.com");
		
		//org.openqa.selenium.InvalidSelectorException: invalid selector: Unable to locate an element with the xpath expression /////input[#$#@id='username'] because of the following error:
		//if your syntax is wrong for xpath
		
		
		//form-control private-form__control login-email
		//form-control private-form__control login-password m-bottom-3
		
		//Invalid
		//org.openqa.selenium.InvalidSelectorException: Compound class names not permitted, we cannot use multiple classes in by classname
		//driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("test@gmail.com");
		
		//Valid
		//In xpath we can write any number of classes, it doesnt matter in xpath, compound classes are allowed. 
		//driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("test@gmail.com"); 
		
		//Valid
		//if using className, only one single class is allowed
//		driver.findElement(By.className("login-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.className("login-password")).sendKeys("test@123");
		
		//This is also invalid, only one class name is allowed
		//driver.findElement(By.className("private-form__control login-email"));
		
		//valid
		driver.findElement(By.cssSelector(".form-control.private-form__control.login-email")).sendKeys("test@gmail.com");
		
		//Invalid
		//driver.findElement(By.cssSelector("form-control private-form__control login-email")).sendKeys("test@gmail.com");
		
		//Xpath - entire class value have to pick. class will consider all these 3 classes together.
		//Valid xpath but it will give NoSuchElementException
		//driver.findElement(By.xpath("//input[@class='private-form__control login-email']")).sendKeys("test@gmail.com");
		
		
		//div[@class='private-form_input-wrapper']/input[@id='username']

		//div[@class='private-form_input-wrapper']/child::input[@id='username'] -- immediate child

		//input[@id='username']/parent::div - traverse to parent

		//input[@id='username']/../../../../../../../../../.. ---> Backward traversing in XPATH, Go to immediate parent
		
		//*[@id='username'] - out of this entire HTML DOM, give me where id=username
		//*[@id] --> 13 out of 200
		//input[@id] --> 3 out of 200
		//without star, it will be faster, because we are searching for input tag
		//input[@id='username'] --> xpath faster, * will make xpath slow.
	}
	

}
