package standardIOEx3;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx3 {

	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("test.txt");
			ps = new PrintStream(fos);
			System.setOut(ps);
		} catch (Exception e) {
			System.err.println("File not found.");
			// TODO: handle exception
		}
		System.out.println("Hello by System.out");
		System.err.println("Hello by System.err");
	}

}
