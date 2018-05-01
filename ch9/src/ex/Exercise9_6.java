package ex;

class Exercise9_6 {
	public static String fillZero(String src, int length) {

		if (src == null || src.length() == length)
			return "";
		else if (length <= 0)
			return "";
		else if (src.length() > length)
			return src.substring(0, length);

		char[] srcArr = new char[length];
		
		for (int i = 0; i < length; i++) {		//try-catch���� Ȱ���� �Ѱ��� �������� �۵�
			try {
				srcArr[i] = src.charAt(i - src.length());
			}catch (Exception e) {
				srcArr[i] = '0';
			}
			
		}
		
//		for (int i = 0; i < length; i++) {		//�Ϲ����� �迭 �ʱ�ȭ �� �ٸ� �������� ���� �ִ´�.
//			srcArr[i] = '0';
//		}
//		for (int i = 0; i < src.length(); i++) {
//			srcArr[i + src.length()] = src.charAt(i);
//		}
		return new String(srcArr);
		
/* 
	(1) fillZero�޼��带 �ۼ��Ͻÿ�.
		1. src�� ���̰ų� src.length()�� length�� ������ src�� �״�� ��ȯ�Ѵ�.
		2. length�� ���� 0���� ���ų� ������ �� ���ڿ�("")�� ��ȯ�Ѵ�.
		3. src�� ���̰� length�� ������ ũ�� src�� length��ŭ �߶� ��ȯ�Ѵ�.
		4. ���̰� length�� char�迭�� �����Ѵ�.
		5. 4���� ������ char�迭�� '0'���� ä���.
		6. src���� ���ڹ迭�� �̾Ƴ��� 4���� ������ �迭�� �����Ѵ�.
		7. 4���� ������ �迭�� String�� �����ؼ� ��ȯ�Ѵ�.

*/
	}

	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10));
		System.out.println(fillZero(src, -1));
		System.out.println(fillZero(src, 3));
	}
}

/*
�޼���� : fillZero
�� �� : �־��� ���ڿ�(����)�� �־��� ������ ���ڿ��� �����, ���� �� ������ '0'����
ä���.
���� �־��� ���ڿ��� null�̰ų� ���ڿ��� ���̰� length�� ���� ������ �״��
��ȯ�Ѵ�.
���� �־��� length�� ���� 0���� ���ų� ���� ���̸�, �� ���ڿ�("")�� ��ȯ�Ѵ�.
��ȯŸ�� : String
�Ű����� : String src - ��ȯ�� ���ڿ�
int length - ��ȯ�� ���ڿ��� ����
*/