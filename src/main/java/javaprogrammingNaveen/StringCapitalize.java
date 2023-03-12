package javaprogrammingNaveen;

public class StringCapitalize {

	public static void main(String[] args) {

		String caps = capitalizeString("naveen automation labs");
		System.out.println(caps);
		
	    caps = capitalizeString("naveen");
		System.out.println(caps);
		
		caps = capitalizeString("n");
		System.out.println(caps);
		
		caps = capitalizeString("n n n n");
		System.out.println(caps);
		
		caps = capitalizeString("123");
		System.out.println(caps);
		
		caps = capitalizeString("123 test naveen automation");
		System.out.println(caps);
		
	}
	
	public static String capitalizeString(String str) {
		
		if(str==null) {
			System.out.println("null value");
			return str;
		}
		if(str.length()==1) {
			return str.toUpperCase();
		}
		
		String words[] = str.split("\\s");
		String result = "";
		
		for(String w : words) {
			String first = w.substring(0, 1).toUpperCase(); //N
			String restString = w.substring(1); //aveen
			
			result = result + first + restString + " "; //Naveen
		}
		
		return result.trim();
	}

}
