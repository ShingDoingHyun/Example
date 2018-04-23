package Exercise6_20;

public class Exercise6_20 {
	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

	private static int[] shuffle(int[] original) {

		for (int shuffle = 0; shuffle <= 100; shuffle++) {
			for (int i = 0; i < original.length; i++) {
				int rand = (int) (Math.random() * 9);

				int tmp = original[i];
				original[i] = original[rand];
				original[rand] = tmp;

			}
		}

		return original;
	}
}
