package exceptionEx15;

import java.io.File;

public class ExceptionEx15 {

	public static void main(String[] args) {
		File f = createFile(args[0]);
		System.out.println(f.getName()+" 파일이 성공적으로 생성되었습니다.");
	}

	@SuppressWarnings("finally")
	public static File createFile(String fileName) {
		try {
			if(fileName==null || fileName.equals(""))
				throw new Exception("팡일 이름이 유효하지 않습니다.");
		}catch (Exception e) {
			fileName = "제목없음.txt";
		}finally {
			File f = new File(fileName);
			createNewFile(f);
			return f;
		}
	}

	public static void createNewFile(File f) {
		try {
			f.createNewFile();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
