package Excercise5_13;

import java.util.Scanner;

public class Excercise5_13 {
	public static void main(String args[]) {
		String[] words = { "television", "computer", "mouse", "phone" };
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray(); // String char[] �� �� ��ȯ
			char tmp=' ';
			int num=0;
			
			for(int j=0; j<question.length;j++) {
				num = (int)(Math.random() * question.length);
				tmp = question[i];
				question[i] = question[num];
				question[num] = tmp;
			}
			
			/*
			 * (1) . �˸��� �ڵ带 �־� �ϼ��Ͻÿ� char question . �迭 �� ��� ������ ��ġ�� ���Ƿ� �ٲ۴�
			 */
			System.out.printf("Q%d. %s�� ������ �Է��ϼ���.>", i + 1, new String(question));
			String answer = scanner.nextLine();
			// trim() answer , equals word[i] ���� �� �¿� ������ ������ �� �� �� ��
			if (words[i].equals(answer.trim()))
				System.out.printf("�¾ҽ��ϴ� .%n%n");
			else
				System.out.printf("Ʋ�Ƚ��ϴ� .%n%n");
		}
	} // main��
}
