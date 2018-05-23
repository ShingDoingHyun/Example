package bufferedReaderEx1;

import java.io.*;

public class BufferedReaderEx1 {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("C:\\java\\sdh\\ch15\\src\\bufferedReaderEx1\\BufferedReaderEx1.java");
			BufferedReader br = new BufferedReader(fr);
			System.out.println("123");
			String line="";
			for(int i=1;(line=br.readLine())!=null;i++) {
				if(line.indexOf(";")!=-1)
					System.out.println(i+":"+line);
				
			}
			br.close();
		}catch (Exception e) {
			System.out.println("123");
			// TODO: handle exception
		}
	}

}
