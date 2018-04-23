package Exercise6_22;

public class Exercise6_22 {
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		str = "1234o1";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}

	private static boolean isNumber(String str) {

		for(int i=0; i < str.length();i++) {
			char val = str.charAt(i);
			if(!(val>= 0 && val<= 9)) {
				return false;
			}
				
		}
		return true;
	}
}
