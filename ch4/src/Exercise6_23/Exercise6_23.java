package Exercise6_23;

public class Exercise6_23 {
	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값 :" + max(data));
		System.out.println("최대값 :" + max(null));
		System.out.println("최대값 :" + max(new int[] {}));
	}

	private static String max(int[] data) {
		
		if(data == null || data.length==0)
			return "-9999999";
		
		int maxNum = 0;
		for(int i = 0;i < data.length; i++) {
			if(maxNum< data[i]) {
				maxNum = data[i];
			}
			
		}
		return maxNum+"";
	}

}
