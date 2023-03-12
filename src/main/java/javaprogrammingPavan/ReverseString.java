package javaprogrammingPavan;

public class ReverseString {

	public static void main(String[] args) {

		//1. using String concatenation operator
		
		String str = "ABCD";
		String rev = "";
		
		/*
		 * int len = str.length(); //4
		 * 
		 * //Returns the char value at the specified index. An index ranges from 0 to
		 * length() - 1. //The first char value of the sequence is at index 0, the next
		 * at index 1,and so on, as for array indexing. //str.charAt(0);
		 * 
		 * for(int i=len-1; i>=0; i--)//3, 2, 1, 0 { rev=rev+str.charAt(i); //DCBA
		 * 
		 * } System.out.println("Reversed String is " +rev);
		 */
		
		
		//2. using character array
		
		/*char a[]=str.toCharArray();
		int len = a.length;
		
		for(int i = len-1; i>=0; i--)
		{
			rev=rev+a[i];
		}
		
		System.out.println("Reversed character string is " +rev);*/
		
		//3. using String buffer class
		
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
	}

}
