package ex;

class Exercise9_4 {
	static void printGraph(int[] dataArr, char ch) {
		//���� for���� ���� �迭�� ����ŭ ������.
		//���� for���� �迭�� ũ�⸸ŭ ������.
		//�ݺ��� ������ �迭�� ���� ����Ѵ�.
		//���� �������� �Ѿ��.
		for(int i=0;i < dataArr.length ;i++) {	//�迭�� ũ��
			for(int j=0;j< dataArr[i];j++) {	//�迭�� ��
				System.out.print(ch);			//��� ���
			}
			System.out.println(dataArr[i]);		//�迭�� ��
		}
		/*
		 * (1) printGraph�޼��带 �ۼ��Ͻÿ�.
		 */
	}

	public static void main(String[] args) {
		printGraph(new int[] { 3, 7, 1, 4 }, '*');
	}
}

/*
�޼���� : printGraph
�� �� : �־��� �迭�� ��� ����ŭ �־��� ���ڸ� ���η� ����� ��, ���� ����Ѵ�.
��ȯŸ�� : ����
�Ű����� : int[] dataArr - ����� �׷����� ������
char ch - �׷����� ����� ����.
*/
