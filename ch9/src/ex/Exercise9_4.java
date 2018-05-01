package ex;

class Exercise9_4 {
	static void printGraph(int[] dataArr, char ch) {
		//가로 for문은 받은 배열의 값만큼 돌린다.
		//세로 for문은 배열의 크기만큼 돌린다.
		//반복이 끝나고 배열의 값을 출력한다.
		//다음 라인으로 넘어간다.
		for(int i=0;i < dataArr.length ;i++) {	//배열의 크기
			for(int j=0;j< dataArr[i];j++) {	//배열의 값
				System.out.print(ch);			//모양 출력
			}
			System.out.println(dataArr[i]);		//배열의 값
		}
		/*
		 * (1) printGraph메서드를 작성하시오.
		 */
	}

	public static void main(String[] args) {
		printGraph(new int[] { 3, 7, 1, 4 }, '*');
	}
}

/*
메서드명 : printGraph
기 능 : 주어진 배열에 담긴 값만큼 주어진 문자를 가로로 출력한 후, 값을 출력한다.
반환타입 : 없음
매개변수 : int[] dataArr - 출력할 그래프의 데이터
char ch - 그래프로 출력할 문자.
*/
