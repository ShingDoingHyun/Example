package ex;

import java.util.function.Predicate;

public class Ex {

	public static void main(String[] args) {
		 Predicate<String> isEmptyStr = s -> s.length()==0;
		 String a = "";

		 if(isEmptyStr.test(a)) // if(s.length()==0)
		      System.out.println("This is an empty String.");

	}
	



}
