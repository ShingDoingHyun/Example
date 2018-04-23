package Exercise6_23;

public class Exercise6_23 {
	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("최대값:" + max(null));
		System.out.println("최대값:" + max(new int[] {})); // 크기가 0인 배열
	}

	private static int max(int[] data) {
		int tmp = 0;
		if (data == null || data.length <= 0)
			return -999999;
		else {
			for (int i = 0; i < data.length; i++) {
				if (tmp < data[i])
					tmp = data[i];
			}
			return tmp;
		}
	}
}
