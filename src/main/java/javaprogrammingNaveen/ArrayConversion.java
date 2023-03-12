package javaprogrammingNaveen;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayConversion {

	// convert array element to the joiner
	public static void main(String[] args) {

		String[] arr = { "t", "r", "v" }; // trv, t;r;v or t|r|v

		String join = String.join("|", arr); // join method will give new brand string
		System.out.println(join);

		// ====
		// using streams

		String join1 = Arrays.asList("t", "r", "y", "i", "n", "g").stream().collect(Collectors.joining(";"));

		// System.out.println(join1);
		System.out.println(joinString("", "a", "b", "c"));
		System.out.println(joinInt("|", 1, 2, 3, 4, 5));
	}

	// using string builder
	public static String joinString(String seperator, String... values) {

		StringBuilder sb = new StringBuilder();
		int end = 0;

		for (String s : values) {
			if (s != null) {
				sb.append(s);
				end = sb.length();
				sb.append(seperator);

			}
		}

		return sb.substring(0, end);
	}

	// using string builder for Integers
	public static String joinInt(String seperator, Integer... values) {

		StringBuilder sb = new StringBuilder();
		int end = 0;

		for (Integer s : values) {
			if (s != null) {
				sb.append(s);
				end = sb.length();
				sb.append(seperator);

			}
		}

		return sb.substring(0, end);
	}

}
