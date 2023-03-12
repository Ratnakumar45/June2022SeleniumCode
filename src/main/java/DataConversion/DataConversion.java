package DataConversion;

public class DataConversion {

	public static void main(String[] args) {

		//1. String to int: 
		String x = "100";
		System.out.println(x+20);
		
		//wrapper classes:
		//on top of every primitive data type, java have created wrapper class
		//int -> Integer
		
		//parse means conversion
		int i = Integer.parseInt(x); //100
		System.out.println(i+20);
		
//		String y = "100test"; //we cannot use parse int with alpha numeric value
//	    System.out.println(y+20);
//	    int j = Integer.parseInt(y);
	    //System.out.println(j); //Number format exception
		
		//2. String to double:
		String t = "12.33";
		System.out.println(t+20);
		
		//double --> Double
		double t1 = Double.parseDouble(t);
		System.out.println(t1+20);
		
		
		//3. int to String
		
		int pop = 1000;
		System.out.println(pop+20);
		
		int totalBill = pop + 50 -10;
		System.out.println(totalBill);
		
		String amount = String.valueOf(totalBill); //"140"
		System.out.println(amount+10);
		
		//Double to string:
		
		double avg = 12.33;
		String newAvgValue = String.valueOf(avg);
		System.out.println(newAvgValue+1000);
		
		//String to boolean:
	    String headless = "true";
	    boolean flag = Boolean.parseBoolean(headless);
	    if(Boolean.parseBoolean(headless)) {
	    	System.out.println("run in headless mode");
	    }
	    else {
	    	System.out.println("run in normal mode");
	    }
	    
	    
	    //boolean to string:
	    boolean test = true;
	    String p = String.valueOf(test);
	    System.out.println(p+20);
		
	}

}
