package week2.day1;

import java.util.Iterator;

import org.junit.Test;

public class LearnString {

	@Test

	public void stringMemoryPool()

	{
		String str1 = "Welcome1";
		String str2 = "Welcome2";
		String str3 = new String("Welcome3");

		System.out.println(str1 == str2);
		System.out.println(str1 == str3);

		// compare values between two Strings use equal method
		System.out.println(str1.equals(str3));
		System.out.println(str1.equals(str2));

		// hashcode is used to print address
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());

		str1 = str1 + "Java Learning";
		System.out.println(str1.hashCode());

		String str4 = "welcome1";
		System.out.println(str2.equalsIgnoreCase(str4));
		System.out.println(str4.concat(" to String Learning"));

		// charAt Method
		System.out.println(str4.charAt(5));
		System.out.println(str1.charAt((str1.length()) - 1));

		int len = str1.length();
		for (int i = len - 1; i >= 0; i--) {
			System.out.print(str1.charAt(i));
		}
		System.out.println("\n" + str4.replace('e', 'x'));
		System.out.println("\n" + str4.replace("co", "CO"));
		System.out.println(str4.substring(3, 6));
		str4 = str4 + " to java session";
		String[] words = str4.split("");

		for (String eachWord : words) {
			System.out.print(eachWord);

		}
		System.out.println(str4.split(str4));
	}

}
