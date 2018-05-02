package scannerEx2;

import java.io.File;
import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("C:\\java\\Example\\ch9\\src\\data2.txt"));//파일의 경로는 파일에서 alt+enter 누르면 나온다!
		int sum=0;
		int cnt=0;
		
		while(sc.hasNextInt()) {
			sum += sc.nextInt();
			cnt++;
		}
		System.out.println("sum="+sum);
		System.out.println("average"+(double)sum/cnt);
	}

}
