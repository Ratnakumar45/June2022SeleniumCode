package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {

	//AAA rule in unit testing
	
	
	
	//creation of dependency between 2 methods
	//unit testing says, that all tests should be independent. what if createuser not working.
	//bad practice to use dependency unnecessaary, right practice is no need to create dependency
	@Test
	public void createUser() {
		System.out.println("create user");
		//int i=9/0;
	}
	
//	@Test(dependsOnMethods = "createUser") //skipped
//	public void updateUser() {
//		System.out.println("update user");
//	}
//	
//	@Test(dependsOnMethods = "createUser")// skipped
//	public void deleteUser() {
//		System.out.println("delete user");
//	}
	
	@Test()
	public void updateUser() {
		System.out.println("update user");
		createUser();
	}
	
	@Test()
	public void deleteUser() {
		System.out.println("delete user");
		createUser();
	}

	
}
