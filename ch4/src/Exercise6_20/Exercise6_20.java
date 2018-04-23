package Exercise6_20;

public class Exercise6_20 {
	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

	public static int[] shuffle(int[] original) {
		// TODO Auto-generated method stub
		if(original==null || original.length==0)
			return original;
		
		int tmp = 0;
		int num = 0;
		for(int i = 0; i < original.length; i++) {
			tmp = original[i];
			num = (int) (Math.random() * original.length);
			original[i] = original[num];
			original[num] = tmp;
		}
		
		return original;
	}

}
