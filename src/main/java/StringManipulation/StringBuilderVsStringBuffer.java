package StringManipulation;

public class StringBuilderVsStringBuffer {

	public static void main(String[] args) {

		//Mutable
		StringBuilder sb = new StringBuilder("hello");
		
		sb.append("selenium");
		
		System.out.println(sb);
		System.out.println(sb.reverse());
		
		//cannot create string literal, only stores in heap memory not in SCP
		StringBuffer sb1 = new StringBuffer("hello");
		sb1.append("testing");
		System.out.println(sb1);
		
		//immutable objects, cannot make any changes to this hello
		String x = "hello";
		x.concat("world");
		System.out.println(x);

		
	}

}
