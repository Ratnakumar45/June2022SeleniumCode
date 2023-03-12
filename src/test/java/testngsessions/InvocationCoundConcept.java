package testngsessions;

import org.testng.annotations.Test;

public class InvocationCoundConcept {

	//call this method 10 times then we have to use invocation count = 10
	@Test(invocationCount = 10)
	public void paymentTest() {
		System.out.println("paymentTest");
	}
}
