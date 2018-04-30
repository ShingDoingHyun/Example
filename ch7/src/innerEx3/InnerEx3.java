package innerEx3;

public class InnerEx3 {

	private int outerIv = 0;
	static int outerCv = 0;

	class InstanceInner {
		int iiv = outerIv;
		int iiv2 = outerCv;
	}

	static class StaticInner {
		// int siv = outerIv;
		static int scv = outerCv;
	}

	void myMethod() {
		int lv = 0;
		final int LV = 0;

		class LocalInner {
			int iiv = outerIv;
			int iiv2 = outerCv;
			// int iiv3 = lv;
			int iiv4 = LV;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
