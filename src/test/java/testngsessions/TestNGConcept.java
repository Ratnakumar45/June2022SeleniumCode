package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGConcept {

	//Global pre conditions
	//specific test pre conditions
	//test steps
	    //data
	    //assert -- exp vs act
	    //status
	//post steps - close the browser, delete the user from system or DB
	
	//Annonations is the special keyword which starts with @
	
	/**
	 *  BS -- connectWithDB
        BT -- createTestUser
        BC -- launchBrowser
       
       BM -- login to application
       add to cart test
       AM -- logout
       
       BM -- login to application
       payment test
       AM -- logout
             
       BM -- login to application
       search test
       AM -- logout
      
        AC -- closeBrowser
        AT -- delete user
        AS -- disconnect with DB
	 */
		
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS -- connectWithDB");
	}
	
	@BeforeTest
	public void createTestUser() {
		System.out.println("BT -- createTestUser");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC -- launchBrowser");
	}
	
	@BeforeMethod  //this method will be executed each and every before test method.
	public void login() {
		System.out.println("BM -- login to application");
	}
	
	@Test
	public void searchTest() {
		System.out.println("search test");
	}
	
	@Test //will executed based upon the alphabetic order
	public void addToCartTest() {
		System.out.println("add to cart test");
	}
	
	@Test
	public void paymentTest() {
		System.out.println("payment test");
	}
	
	@AfterMethod //this method will be executed each and every before test method.
	public void logout() {
		System.out.println("AM -- logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -- closeBrowser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- delete user");
	}
	
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS -- disconnect with DB");
	}
}
