package ex;

class Exercise9_3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";

		fullPath = fullPath.replace("\\\\", "\\");	// \\�� \���� ���� ""�ȿ� \�� 2�� ��� ��    
		int lastPath = fullPath.lastIndexOf("\\");	// ������ \�� ������� ����
		path = fullPath.substring(0, lastPath);		// ó������ ������ \�� ������ ������ �߶�
		fileName = fullPath.substring(lastPath + 1);// ������ \ ���� ������ �߶�. �߶� �� ������ �κ��� ���� �Ǳ� ������ +1

		System.out.println("fullPath:" + fullPath);
		System.out.println("path:" + path);
		System.out.println("fileName:" + fileName);
	}
}