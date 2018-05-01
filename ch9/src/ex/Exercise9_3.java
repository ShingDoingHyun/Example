package ex;

class Exercise9_3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";

		fullPath = fullPath.replace("\\\\", "\\");	// \\을 \으로 변경 ""안에 \는 2번 써야 됨    
		int lastPath = fullPath.lastIndexOf("\\");	// 마직막 \이 어디인지 구함
		path = fullPath.substring(0, lastPath);		// 처음부터 마직막 \이 나오는 곳까지 잘라냄
		fileName = fullPath.substring(lastPath + 1);// 마지막 \ 부터 끝까지 잘라냄. 잘라낼 때 마지막 부분이 포함 되기 때문에 +1

		System.out.println("fullPath:" + fullPath);
		System.out.println("path:" + path);
		System.out.println("fileName:" + fileName);
	}
}