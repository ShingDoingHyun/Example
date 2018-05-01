package ex;

class Exercise9_7 {
	
	private static boolean contains(String src, String target) {
		
		return src.contains(target);
	}

	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
	}

}