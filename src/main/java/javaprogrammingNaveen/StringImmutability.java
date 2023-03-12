package javaprogrammingNaveen;

public class StringImmutability {

	public static void main(String[] args) {

		//String literals - SCP - Heap
		String x = "abc"; //-->store in SCP
		String y = "abc";
		
		x = x.concat(y); //new generated string stored in heap memory
		System.out.println(x);
		//System.out.println(z);
	}

}
