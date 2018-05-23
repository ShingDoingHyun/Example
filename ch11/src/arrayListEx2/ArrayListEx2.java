package arrayListEx2;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {

	public static void main(String[] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()zzz";
		int lenght = source.length();
		
		List list = new ArrayList(lenght/LIMIT +10);
		for(int i=0; i<lenght; i+=LIMIT) {
			if(i+LIMIT < lenght)
				list.add(source.substring(i,i+LIMIT));
			else 
				list.add(source.substring(i));
			
		}
		
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));

	}

}
